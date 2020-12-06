package ass2;

import ass2.Assignment;
import ass2.hib.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();


            ourSessionFactory = configuration.configure("ass2\\hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args){
        Assignment.insertToLog("5");
        Assignment.insertToLog("32");
        Users u = Assignment.getUser("32");
        System.out.println(u);
        List<Users> all = Assignment.getUsers();
        System.out.println(all);

//        System.out.println(Assignment.getNumberOfRegistredUsers(4));
//        System.out.println(Assignment.getNumberOfRegistredUsers(0));

//        assertTrue(Assignment.isExistUsername("gal"));
//        assertFalse(Assignment.isExistUsername("gal5432"));

        if (!Assignment.isExistUsername("gal5432")) {
            String userid = Assignment.insertUser("gal54321", "Aa123456", "gal", "r",
                    "01", "11", "1993");
            Users u1 = Assignment.getUser(userid);

            assertTrue(u1 != null);
        }
        System.out.println(Assignment.getNumberOfRegistredUsers(4));
        System.out.println(Assignment.getNumberOfRegistredUsers(2));

        assertEquals(2, Assignment.getHistory("32").size());
        assertEquals(0, Assignment.getHistory("5").size());
        assertEquals(0, Assignment.getHistory("1853").size());

    }

    private static void assertFalse(boolean result) {
        System.out.println(!result);
    }

    private static void assertTrue(boolean result) {
        System.out.println(result);



    }

    private static void assertEquals(int expected, int result) {
        System.out.println(expected == result);
    }
}
