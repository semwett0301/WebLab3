import beans.DataManagerBean;
import utils.AreaChecker;
import wrappers.LastR;
import wrappers.Result;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

public class ManagerBean implements Serializable {
    private double x;
    private double y;
    private double r;

    private List<Result> allResults;
    private DataManagerBean dataManagerBean;
    private String sessionId;

    private static double lastR;

    public ManagerBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        sessionId = session.getId();

        try {
            allResults = dataManagerBean.synchronize(sessionId);
        } catch (NullPointerException e) {
            allResults = new ArrayList<>();
        }


    }

    public static double getLastR() {
        return lastR;
    }

    public static void setLastR(double lastR) {
        ManagerBean.lastR = lastR;
    }

    public void toAction() {
            Result tmpResult = new Result(x, y, r, AreaChecker.checkArea(x, y, r), sessionId);
            dataManagerBean.addNewValue(tmpResult);
            allResults.add(tmpResult);
            LastR.setLast_R(r);
    }

    public void clearTable() {
            dataManagerBean.clearTable(sessionId);
            allResults.clear();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public List<Result> getAllResults() {
        return allResults;
    }

    public void setAllResults(List<Result> allResults) {
        this.allResults = allResults;
    }

    public DataManagerBean getDataManagerBean() {
        return dataManagerBean;
    }

    public void setDataManagerBean(DataManagerBean dataManagerBean) {
        this.dataManagerBean = dataManagerBean;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
