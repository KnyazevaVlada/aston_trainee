import com.vlknyazeva.hibernate.dao.ChildDAO;
import com.vlknyazeva.hibernate.dao.SectionDAO;
import com.vlknyazeva.hibernate.entity.Child;
import com.vlknyazeva.hibernate.entity.Section;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Transaction tx = session.beginTransaction();


            ChildDAO childDao = new ChildDAO(sessionFactory);
            SectionDAO sectionDao = new SectionDAO(sessionFactory);

            Child child = new Child();
            child.setName("John");
            child.setSurname("Malovich");

            Section section1 = new Section();
            section1.setName("Math");

            Section section2 = new Section();
            section2.setName("Art");

            child.getSections().add(section1);
            child.getSections().add(section2);

            childDao.saveOrUpdateChild(child);
            tx.commit();

            System.out.println(child);
        } finally {
            session.close();
        }
    }
}