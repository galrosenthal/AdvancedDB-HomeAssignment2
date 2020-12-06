package ass2.hib;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ADMINISTRATORS {
    private long adminId;
    private String username;
    private String password;

    @Id
    @Column(name = "AdminID", nullable = false, precision = 0)
    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
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

    @Override
    public String toString() {
        return "ADMINISTRATORS{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ADMINISTRATORS that = (ADMINISTRATORS) o;
        return adminId == that.adminId &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }



    @Override
    public int hashCode() {
        return Objects.hash(adminId, username, password);
    }
}
