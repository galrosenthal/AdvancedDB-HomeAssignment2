package ass2.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(HistoryPK.class)
public class History {
    private long userid;
    private long mid;
    private Timestamp viewtime;

    @Id
    @Column(name = "USERID", nullable = false, precision = 0)
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "MID", nullable = false, precision = 0)
    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    @Id
    @Column(name = "VIEWTIME", nullable = false)
    public Timestamp getViewtime() {
        return viewtime;
    }

    public void setViewtime(Timestamp viewtime) {
        this.viewtime = viewtime;
    }

    @Override
    public String toString() {
        return "History{" +
                "userid=" + userid +
                ", mid=" + mid +
                ", viewtime=" + viewtime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return userid == history.userid &&
                mid == history.mid &&
                Objects.equals(viewtime, history.viewtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, mid, viewtime);
    }
}
