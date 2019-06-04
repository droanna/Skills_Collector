package pl.dro.anna.skills_collector.model.dao;
import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.entities.Source;


public class SourceDao extends BaseDao {

    protected SourceDao(SessionFactory sessionFactory) {
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

}
