package beans;

import java.io.Serializable;

public class NavigationBean implements Serializable {
    public String toMain() {
        return "to_main";
    }

    public String toStart() {
        return "to_start";
    }
}
