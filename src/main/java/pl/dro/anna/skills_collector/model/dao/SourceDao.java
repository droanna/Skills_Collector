package pl.dro.anna.skills_collector.model.dao;

import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.entities.Skill;
import pl.dro.anna.skills_collector.model.entities.Source;

import java.util.Set;
import java.util.stream.Collectors;


public class SourceDao extends BaseDao {

    public SourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public Source get(Long id) {
        return super.produceInTransaction(session -> session.get(Source.class, id));
    }


    public void save(Source source) {
        super.executeInTransaction(session -> session.save(source));
    }

    public void update(Source source) {
        super.executeInTransaction(session -> session.update(source));
    }

    public void delete(Source source) {
        super.executeInTransaction(session -> session.delete(source));
    }

    public Set<Source> getAllByUsername(String username) {

        return super.produceInTransaction(
                session -> session
                        .createQuery("SELECT s FROM User u JOIN u.knownSources s WHERE u.username = :username", Source.class)
                        .setParameter("username", username)
                        .getResultStream()
                        .collect(Collectors.toSet()));
    }

    public Set<Skill> getAllSkillsConnectedWithSource(String name) {
        return super.produceInTransaction(
                session -> session
                        .createQuery("SELECT s From Source source join source.attachedSkills s where source.name = :name", Skill.class)
                        .setParameter("name", name)
                        .getResultStream()
                        .collect(Collectors.toSet()));
    }

    public Set<Source> getAllUnknownSources(String username) {
        return super.produceInTransaction(
                session -> session
                        .createQuery("SELECT s FROM Source s", Source.class)
                        .getResultStream()
                        .filter(source -> !getAllByUsername(username).contains(source))
                        .collect(Collectors.toSet()));
    }
}
