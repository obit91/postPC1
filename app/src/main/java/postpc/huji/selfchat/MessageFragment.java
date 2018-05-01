package postpc.huji.selfchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MessageFragment extends Fragment {

    public static final String INPUT_TEXT = "INPUT_TEXT";
    private static final String INIT_TEXT = "Current Chat Session";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment, container, false);
        TextView textView = view.findViewById(R.id.fragment_message_text);
        if (getArguments() != null) {
            String input = getArguments().getString(INPUT_TEXT);
            textView.setText(input);
            Log.e("BLA BLA", INPUT_TEXT);
        } else {
            textView.setText(INIT_TEXT);
        }
        return view;
    }
}
