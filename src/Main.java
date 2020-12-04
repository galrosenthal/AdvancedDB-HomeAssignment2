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

    public static void main(String[] args){
//        Assignment.insertToLog("5");
//        Assignment.insertToLog("32");
//        Users u = Assignment.getUser("32");
//        System.out.println(u);
//        List<Users> all = Assignment.getUsers();
//        System.out.println(all);

//        System.out.println(Assignment.getNumberOfRegistredUsers(4));
//        System.out.println(Assignment.getNumberOfRegistredUsers(0));

        assertEquals(2, Assignment.getHistory("32").size());
        assertEquals(0, Assignment.getHistory("5").size());
        assertEquals(0, Assignment.getHistory("1853").size());

    }

    private static void assertEquals(int expected, int result) {
        System.out.println(expected == result);
    }
}
