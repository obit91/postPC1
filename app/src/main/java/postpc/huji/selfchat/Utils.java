package postpc.huji.selfchat;

import java.text.DateFormat;

public class Utils {

    static String generateTimeStamp() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.DEFAULT);
        return df.format(System.currentTimeMillis());
    }

}
