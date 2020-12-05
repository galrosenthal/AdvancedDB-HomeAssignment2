import hib.Users;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();


            ourSessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }

    public static void main(String[] args){
//        Assignment.insertToLog("5");
//        Assignment.insertToLog("32");
//        Users u = Assignment.getUser("32");
//        System.out.println(u);
//        List<Users> all = Assignment.getUsers();
//        System.out.println(all);

//        System.out.println(Assignment.getNumberOfRegistredUsers(4));
//        System.out.println(Assignment.getNumberOfRegistredUsers(0));

//        assertTrue(Assignment.isExistUsername("gal"));
//        assertFalse(Assignment.isExistUsername("gal5432"));

        String userid = Assignment.insertUser("gal5432", "Aa123456", "gal", "r",
                "1", "11", "1993");
        assertTrue(Assignment.isExistUsername("gal5432"));
        Users u = Assignment.getUser(userid);
        assertTrue(u != null);

    }

    private static void assertFalse(boolean result) {
        System.out.println(!result);
    }

    private static void assertTrue(boolean result) {
        System.out.println(result);
    }
}
