package ass2;

import ass2.Assignment;
import ass2.hib.Mediaitems;
import ass2.hib.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Objects;

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
        /** insertToLog Tests**/
//        Assignment.insertToLog("5");
//        Assignment.insertToLog("32");

        /** getUser Tests**/
//        Users u = Assignment.getUser("32");
//        System.out.println(u);
//        u = Assignment.getUser(null);
//        assertNull(u);

        /** getUsers Tests**/
//        List<Users> all = Assignment.getUsers();
//        System.out.println(all);

        /** isExistUsernam Tests**/

//        assertTrue(Assignment.isExistUsername("gal"));
//        assertFalse(Assignment.isExistUsername("gal5432"));

        /** isExistUsernam and insertUser Tests**/
//        if (!Assignment.isExistUsername("gal5432")) {
//            String userid = Assignment.insertUser("gal54321", "Aa123456", "gal", "r",
//                    "01", "11", "1993");
//            Users u1 = Assignment.getUser(userid);
//
//            assertTrue(u1 != null);
//        }

        /** getNumberOfRegisteredUsers Tests **/
//        System.out.println(Assignment.getNumberOfRegistredUsers(4));
//        System.out.println(Assignment.getNumberOfRegistredUsers(2));

        /** getHistory Tests **/
//        assertEquals(2, Assignment.getHistory("32").size());
//        assertEquals(0, Assignment.getHistory("5").size());
//        assertEquals(0, Assignment.getHistory("1853").size());

        /** getTopNItems Tests **/
//        int num_of_items = 9;
//        List<Mediaitems> ret = Objects.requireNonNull(Assignment.getTopNItems(num_of_items));
//        assertEquals(num_of_items, ret.size());
//        System.out.println(ret);

        /** validateUser Tests **/
//        String usernameTestValid = "gal";
//        String passwordTestValid = "412rfaddsf";
//        assertEquals("32", Assignment.validateUser(usernameTestValid, passwordTestValid));
//
//        passwordTestValid = "asdf";
//        assertEquals("Not Found", Assignment.validateUser(usernameTestValid, passwordTestValid));
//
//
//        usernameTestValid = "gal41231";
//        assertEquals("Not Found", Assignment.validateUser(usernameTestValid, passwordTestValid));


        /** validateAdministrator Tests **/
//        String usernameAdminTestValid = "ga";
//        String passwordAdminTestValid = "dsaf";
//        assertEquals("3", Assignment.validateAdministrator(usernameAdminTestValid, passwordAdminTestValid));
//
//        passwordAdminTestValid = "asdf";
//        assertEquals("Not Found", Assignment.validateAdministrator(usernameAdminTestValid, passwordAdminTestValid));
//
//
//        usernameAdminTestValid = "gal41231";
//        assertEquals("Not Found", Assignment.validateAdministrator(usernameAdminTestValid, passwordAdminTestValid));

        /** insertToHistory Tests **/
//        Assignment.insertToHistory("32", "5"); // should print "The insertion to history table was successful <server time>"
//        Assignment.insertToHistory("2", "5"); // should not print
//        Assignment.insertToHistory("32", "19235"); // should not print
    }

    private static void assertNull(Object u) {
        System.out.println(u == null);
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
    private static void assertEquals(String expected, String result) {
        System.out.println(expected.equals(result));
    }
}
