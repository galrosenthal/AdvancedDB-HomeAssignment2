import hib.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Assignment {

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


    /**
     * This function is getting a userid
     * checks if it exists in the DB
     * if it does
     * it inserts a new <i>LoginLog</i> to the DB
     *
     * @param userid - the userid to log its login
     */
    public static void insertToLog(String userid) {


        // If userid does not exists returns null
        Users u = getUser(userid);


        if (u != null) {
            try (Session session = getSession()) {

                LocalDateTime time = LocalDateTime.now();
                long id = Long.MIN_VALUE;

                id = Long.parseLong(userid);

                if (id != Long.MIN_VALUE) {

                    Transaction tx = session.beginTransaction();
                    // Create New User Login log
                    LoginLog newUserLogin = new LoginLog();
                    newUserLogin.setUserid(id);
                    newUserLogin.setLogintime(Timestamp.valueOf(time));

                    // Insert it to the DB
                    LoginLogPK newUserID = (LoginLogPK) session.save(newUserLogin);

                    //Commit The transaction
                    tx.commit();
                    System.out.println("The insertion to log table was successful " + time);
                }
            }
        }
    }

    /**
     * This function is getting a userid
     * converts it to long
     * and tries to retrieve it from the table Users
     * if the userid does exists it return a new Object of type <i>Users</i>
     * else it return null
     *
     * @param userid - the id to retrieve from the DB
     * @return Object of type Users if the user exists and null otherwise
     */
    public static Users getUser(String userid) {
        Users u = null;
        // Check if userid exists in Users
        try (Session s = getSession()) {
            u = (Users) s.get(Users.class, Long.parseLong(userid));
        }

        return u;
    }


    /**
     * 1.2.3
     *
     * @param username
     * @return whether the username already exist for a different user
     */
    public static boolean isExistUsername(String username) {
        Users u = null;
        try (Session s = getSession()) {
            String q = "select u.userid from Users u where u.username = '" + username + "'";
            Query query = s.createQuery(q);

            return query.list().size() == 1;
        }
    }


    /**
     * 1.2.4
     *
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param day_of_birth
     * @param month_of_birth
     * @param year_of_birth
     * @return the userid or null if input data is not valid or username is exist
     */
    public static String insertUser(String username, String password, String first_name, String last_name, String day_of_birth, String month_of_birth, String year_of_birth) {
        if (username == null || isExistUsername(username)) {
            return null;
        } else {
            LocalDateTime time = LocalDateTime.now();
            if (Integer.parseInt(year_of_birth) > time.getYear() || Integer.parseInt(day_of_birth) < 1 ||
                    Integer.parseInt(day_of_birth) > 31 || Integer.parseInt(month_of_birth) < 1 ||
                    Integer.parseInt(month_of_birth) > 12 || password == null || first_name == null || last_name == null)
                return null;
            else {
                if (Integer.parseInt(day_of_birth) < 10 && day_of_birth.length() == 1){
                    day_of_birth = "0" + day_of_birth;
                }
                try (Session session = getSession()) {
                    SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy");
                    String bDay = day_of_birth + "-" + month_of_birth + "-" + year_of_birth;

                    Date d = formatter2.parse(bDay);
                    Timestamp bDayStamp = new Timestamp(d.getTime());
                    Users user = new Users();

                    user.setDateOfBirth(bDayStamp);
                    user.setFirstName(first_name);
                    user.setLastName(last_name);
                    user.setPassword(password);
                    user.setRegistrationDate(Timestamp.valueOf(time));
                    user.setUsername(username);

                    Transaction tx = session.beginTransaction();
                    // Insert it to the DB
                    Long userid = (Long) session.save(user);

                    //Commit The transaction
                    tx.commit();
                    return Long.toString(userid);
                }
                catch (Exception e){
                    return null;
                }
            }
        }
    }


    /**
     * 1.2.5
     *
     * @param top_n
     * @return the top items from mediaitems table sorted by "mid" in ascending order
     */
    public static List<Mediaitems> getTopItems(int top_n) {
        if (top_n < 0) {
            System.out.println("Cannot search for negative number of mediaitems");
            return null;
        }
        try (Session s = getSession()) {


            String q = "select items from Mediaitems items where rownum<=" + top_n + "order by mid";
            Query query = s.createQuery(q);

            List<Mediaitems> mediaitems = (List<Mediaitems>) query.list().get(0);
            return mediaitems;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 1.2.6
     * The function compares received values with existing in the data base (in users table).
     *
     * @param username
     * @param password
     * @return USERID if the values are equal to the values in the table otherwise NULL.
     */
    public static String validateUser(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        Users u = null;
        try (Session s = getSession()) {
            String q = "select u.userid from Users u where u.username = '" + username + "'";
            Query query = s.createQuery(q);
            u = (Users) query.list().get(0);
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return String.valueOf(u.getUserid());
            } else {
                return null;
            }
        }
    }

    /**
     * 1.2.7
     * The function compares received values with existing in the data base (in administrators table).
     *
     * @param username
     * @param password
     * @return ADMINID if the values are equal to the values in the table otherwise NULL.
     */
    public static String validateAdministrator(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        ADMINISTRATORS u = null;
        try (Session s = getSession()) {
            String q = "select u.adminId from ADMINISTRATORS u where u.username = '" + username + "'";
            Query query = s.createQuery(q);
            u = (ADMINISTRATORS) query.list().get(0);
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return String.valueOf(u.getAdminId());
            } else {
                return null;
            }
        }
    }

    /**
     * 1.2.8
     * The function insert the row to the History table with current server time.
     *
     * @param userid
     * @param mid
     */
    public static void insertToHistory(String userid, String mid) {
        if (userid == null || mid == null) {
            return;
        }
        History h= new History();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        h.setUserid(Long.parseLong(userid));
        h.setViewtime(now);
        h.setMid(Long.parseLong(mid));
        try (Session s = getSession()) {
            Transaction tx = s.beginTransaction();
            // Insert it to the DB
            s.save(h);
            //Commit The transaction
            tx.commit();
        }
    }

    /**
     * This function is getting all users in the DB
     *
     * @return list of all the users in the db
     */
    public static List<Users> getUsers() {
        List<Users> allUsers = new ArrayList<>();
        try (Session s = getSession()) {
            String q = "from Users";
            Query query = s.createQuery(q);
            for (Object o :
                    query.list()) {
                allUsers.add((Users) o);
            }
        }

        return allUsers;
    }

    /**
     * This function is getting the number of days to look back for new registered users,
     * if the n is smaller than 0 returns 0
     * else, it counts every registered user in the last n days (From the current time that the function is called)
     *
     * @param n - the number of days to look back
     * @return the number of registered user in the last n days
     */
    public static int getNumberOfRegistredUsers(int n) {
        if (n < 0) {
            System.out.println("Cannot search for negative days");
            return 0;
        }
        try (Session s = getSession()) {

            Timestamp now = new Timestamp(System.currentTimeMillis());
            LocalDateTime minusNdays = now.toLocalDateTime().minusDays(n);

            String q = "select count(*) from Users u where u.registrationDate >= :minusNdays";
            Query query = s.createQuery(q);
            query.setTimestamp("minusNdays", Timestamp.valueOf(minusNdays));

            Long count = (Long) query.list().get(0);
            return Integer.parseInt(count.toString());
        } catch (Exception e) {
            return 0;
        }
    }

}
