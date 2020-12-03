import hib.LoginLog;
import hib.LoginLogPK;
import hib.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
     * @param userid - the userid to log its login
     */
    public static void insertToLog (String userid){


        // If userid does not exists returns null
        Users u = getUser(userid);


        if(u != null){
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
     * @param userid - the id to retrieve from the DB
     * @return Object of type Users if the user exists and null otherwise
     */
    public static Users getUser (String userid){
        Users u = null;
        // Check if userid exists in Users
        try (Session s = getSession()){
            u = (Users) s.get(Users.class, Long.parseLong(userid));
        }

        return u;
    }

    /**
     * This function is getting all users in the DB
     * @return list of all the users in the db
     */
    public static List<Users> getUsers (){
        List<Users> allUsers = new ArrayList<>();
        try (Session s = getSession())
        {
            String q = "from Users";
            Query query = s.createQuery(q);
            for (Object o :
                    query.list()) {
                allUsers.add((Users)o);
            }
        }

        return allUsers;
    }



}
