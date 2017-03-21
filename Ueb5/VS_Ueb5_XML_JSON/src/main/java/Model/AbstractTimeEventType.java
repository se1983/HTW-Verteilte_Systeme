package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Erstellt von  sebsch on 30.12.16.
 */
abstract class AbstractTimeEventType {

    private Date date;
    private String time;

    public AbstractTimeEventType(){

    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
