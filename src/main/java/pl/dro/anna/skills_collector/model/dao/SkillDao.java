package pl.dro.anna.skills_collector.model.dao;
import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.entities.Skill;

public class SkillDao extends BaseDao {

    protected SkillDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public Skill get(Long id) {
        return super.produceInTransaction(session -> session.get(Skill.class, id));
    }

    public void save(Skill skill) {
        super.executeInTransaction(session -> session.save(skill));
    }

    public void update(Skill skill) {
        super.executeInTransaction(session -> session.update(skill));
    }

    public void delete(Skill skill) {
        super.executeInTransaction(session -> session.delete(skill));
    }

}
