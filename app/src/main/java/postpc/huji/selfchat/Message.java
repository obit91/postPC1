package postpc.huji.selfchat;

/**
 * Created by User on 4/16/2018.
 */

public class Message {

    private String mName, mText, mTimeStamp;

    public Message(String mName, String mText) {
        this.mName = mName;
        this.mText = mText;
        this.mTimeStamp = Utils.generateTimeStamp();
    }

    public String getName() {
        return mName;
    }

    public String getText() {
        return mText;
    }

    public String getTimeStamp() {
        return mTimeStamp;
    }
}

