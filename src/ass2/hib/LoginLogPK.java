package ass2.hib;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class LoginLogPK implements Serializable {
    private long userid;
    private Timestamp logintime;

    @Column(name = "USERID", nullable = false, precision = 0)
    @Id
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Column(name = "LOGINTIME", nullable = false)
    @Id
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
        LoginLogPK that = (LoginLogPK) o;
        return userid == that.userid &&
                Objects.equals(logintime, that.logintime);
    }

    @Override
    public String toString() {
        return "LoginLogPK{" +
                "userid=" + userid +
                ", logintime=" + logintime +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, logintime);
    }
}
