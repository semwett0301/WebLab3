package wrappers;

import utils.AreaChecker;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="RESULTS")
public class Result implements Serializable {
    private Double x;
    private Double y;
    private Double r;
    private Boolean enter;
    private String sessionid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;




    public Result(double x, double y, double r, boolean enter, String sessionId) {
        this.sessionid = sessionId;
        this.x = x;
        this.y = y;
        this.r = r;
        this.enter = enter;
    }

    public Result() {

    }

    public String enterToString() {
        if (enter) return "Да";
        return "Нет";
    }

    public double getX() {
        return x;
    }

    public boolean isEnter() {
        return enter;
    }

    public double getR() {
        return r;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public String getSessionId() {
        return sessionid;
    }

    public void setSessionId(String sessionId) {
        this.sessionid = sessionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getXSvg() {
        double last_r = LastR.getLast_R();
        return String.valueOf(x / last_r * 100 + 150);
    }

    public String getYSvg() {
        double last_r = LastR.getLast_R();
        return String.valueOf(150 - y / last_r * 100);
    }

    public String getChooseColor() {
        if (AreaChecker.checkArea(x,y, LastR.getLast_R())) return "green";
        return "red";
    }
}
