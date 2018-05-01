package postpc.huji.selfchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class WhatsappFragment extends Fragment {

    public static final String INPUT_TEXT = "INPUT_TEXT";
    private static final String TAG = WhatsappFragment.class.getName();
    String input = "NO MESSAGE SHARED";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.whatsapp_share_fragment, container, false);
        Button button = view.findViewById(R.id.whatsapp_button);
        button.setOnClickListener(radio_listener);
        if (getArguments() != null)
            input = getArguments().getString(INPUT_TEXT);
        return view;
    }

    View.OnClickListener radio_listener = new View.OnClickListener(){
        public void onClick(View v) {
            Log.d(TAG, input);
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, input);
            try {
                startActivity(whatsappIntent);
            } catch (android.content.ActivityNotFoundException ex) {
               Log.e(TAG, "Whatsapp has not been installed.");
            }
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
        }
    };
}
