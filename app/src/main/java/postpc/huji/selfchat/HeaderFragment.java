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


public class HeaderFragment extends Fragment {

    public static final String INPUT_TEXT = "INPUT_TEXT";
    public static final String REMOVE_POS = "REMOVE_POS";
    private static final String TAG = HeaderFragment.class.getName();
    String input = "NO MESSAGE SHARED";
    Integer removeId = null;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.whatsapp_share_fragment, container, false);
        Button whatsAppButton = view.findViewById(R.id.whatsapp_button);
        whatsAppButton.setOnClickListener(whatsappListener);
        Button deleteButton = view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(deleteListener);
        if (getArguments() != null) {
            input = getArguments().getString(INPUT_TEXT);
            removeId = getArguments().getInt(REMOVE_POS);
        }
        return view;
    }

    View.OnClickListener whatsappListener = new View.OnClickListener(){
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
            getActivity().onBackPressed();
        }
    };

    View.OnClickListener deleteListener = new View.OnClickListener(){
        public void onClick(View v) {
            Log.d(TAG, "DELETE CLICKED");
            ((MainActivity) getActivity()).removeMessage(removeId);
            getActivity().onBackPressed();
        }
    };
}
