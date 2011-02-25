package war.webapp.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "day_duty")
public class DayDuty extends BaseObject implements Serializable {
    private static final long serialVersionUID = 1842676162177859911L;

    private Long id;
    private Calendar date;
    private User firstUser;
    private User secondUser;
    private Integer floor;

    public DayDuty() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getDate() {
        return date;
    }

    @ManyToOne
    @JoinColumn(name = "first_user")
    public User getFirstUser() {
        return firstUser;
    }

    @ManyToOne
    @JoinColumn(name = "second_user")
    public User getSecondUser() {
        return secondUser;
    }

    @Column
    public Integer getFloor() {
        return floor;
    }

    @Transient
    public Integer getStudyWeek() {
        int[] daysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int totalDaysFromFirstSeptember = -1;
        for (int i = 8; i < date.get(Calendar.MONTH); ++i) {
            totalDaysFromFirstSeptember += daysInMonth[i];
        }
        if (date.get(Calendar.MONTH) >= 0 && date.get(Calendar.MONTH) < 8) {
            totalDaysFromFirstSeptember += 122;
            for (int i = 0; i < date.get(Calendar.MONTH); ++i) {
                totalDaysFromFirstSeptember += daysInMonth[i];
            }
        }
        totalDaysFromFirstSeptember += date.get(Calendar.DAY_OF_MONTH);
        return (totalDaysFromFirstSeptember / 7) % 4 + 1;
    }

    @Transient
    public int getDayOfMonth() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    @Transient
    public int getDayOfWeek() {
        return date.get(Calendar.DAY_OF_WEEK);
    }

    @Transient
    public Boolean isFirstEmpty() {
        return firstUser == null;
    }

    @Transient
    public Boolean isSecondEmpty() {
        return secondUser == null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DayDuty)) {
            return false;
        }

        final DayDuty dutyUser = (DayDuty) o;

        return date.equals(dutyUser.getDate()) && firstUser.equals(dutyUser.getFirstUser())
                && secondUser.equals(dutyUser.getSecondUser());
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (date != null ? date.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("date", date.toString())
                .append("first_shift", firstUser).append("second_shift", secondUser).toString();
    }

}
