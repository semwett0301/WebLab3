package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerBean implements Serializable {
    private String date;
    private String time;

    public TimerBean() {
        Date date_and_time = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        this.date = date.format(date_and_time);
        this.time = time.format(date_and_time);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
