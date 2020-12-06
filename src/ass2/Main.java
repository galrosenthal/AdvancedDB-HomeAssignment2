package ass2;

import ass2.hib.Mediaitems;
import ass2.hib.Users;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
//        /** insertToLog Tests**/
//        startTest("insertToLog");
//        Assignment.insertToLog("5");
//        Assignment.insertToLog("32");
//
//        /** getUser Tests**/
//        startTest("getUser");
//        Users u = Assignment.getUser("32");
//        System.out.println(u);
//        u = Assignment.getUser(null);
//        assertNull(u);
//
//        /** getUsers Tests**/
//        startTest("getUsers");
//        List<Users> all = Assignment.getUsers();
//        System.out.println(all);
//
//        /** isExistUsernam Tests**/
//        startTest("isExistUsername");
//        assertTrue(Assignment.isExistUsername("gal"));
//        assertFalse(Assignment.isExistUsername("gal54321"));
//
//        /** isExistUsernam and insertUser Tests**/
//        startTest("insertUser");
//        if (!Assignment.isExistUsername("gal54321")) {
//            String userid = Assignment.insertUser("gal54321", "Aa123456", "gal", "r",
//                    "01", "11", "1993");
//            Users u1 = Assignment.getUser(userid);
//
//            assertTrue(u1 != null);
//        }
//
//        /** getNumberOfRegisteredUsers Tests **/
//        startTest("getNumberOfResgitredUsers");
//        System.out.println(Assignment.getNumberOfRegistredUsers(4));
//        System.out.println(Assignment.getNumberOfRegistredUsers(2));
//
//        /** getHistory Tests **/
//        startTest("getHistory");
//        assertEquals(2, Assignment.getHistory("32").size());
//        assertEquals(0, Assignment.getHistory("5").size());
//        assertEquals(0, Assignment.getHistory("1853").size());
//
//        /** getTopNItems Tests **/
//        startTest("getTopNItems");
//        int num_of_items = 9;
//        List<Mediaitems> ret = Objects.requireNonNull(Assignment.getTopNItems(num_of_items));
//        assertEquals(num_of_items, ret.size());
//        System.out.println(ret);
//
//        /** validateUser Tests **/
//        startTest("validateUser");
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
//
//
//        /** validateAdministrator Tests **/
//        startTest("validateAdministrator");
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
//
//        /** insertToHistory Tests **/
//        startTest("insertToHistory");
//        Assignment.insertToHistory("32", "5"); // should print "The insertion to history table was successful <server time>"
//        Assignment.insertToHistory("2", "5"); // should not print
//        Assignment.insertToHistory("32", "19235"); // should not print
    }

    private static void startTest(String testName) {
        System.out.println("########################################");
        System.out.println("######     " + testName + "      #######");
        System.out.println("########################################");
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
