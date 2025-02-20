package ass2.hib;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="USERS")
public class Users {
    private long userid;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp dateOfBirth;
    private Timestamp registrationDate;

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "USERID", nullable = false, precision = 0)
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 200)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 200)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "DATE_OF_BIRTH", nullable = true)
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "REGISTRATION_DATE", nullable = true)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userid == users.userid &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(dateOfBirth, users.dateOfBirth) &&
                Objects.equals(registrationDate, users.registrationDate);
    }

    @Override
    public String toString() {
        return "USERS{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, password, firstName, lastName, dateOfBirth, registrationDate);
    }
}
