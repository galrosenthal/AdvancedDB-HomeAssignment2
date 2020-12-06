package ass2.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(LoginLogPK.class)
public class LoginLog {
    private long userid;
    private Timestamp logintime;

    @Id
    @Column(name = "USERID", nullable = false, precision = 0)
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "LOGINTIME", nullable = false)
    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLog loginLog = (LoginLog) o;
        return userid == loginLog.userid &&
                Objects.equals(logintime, loginLog.logintime);
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "userid=" + userid +
                ", logintime=" + logintime +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, logintime);
    }
}
