package postpc.huji.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View mButton;
    private TextView mInput;
    private List<Message> mMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.submit_button);
        mInput = findViewById(R.id.input);

        initRecyclerView();

        mButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (mInput.getText().length() > 0) {
                    Message newMsg = new Message("אוהד", mInput.getText().toString());
                    mMessages.add(newMsg);
                    mAdapter.notifyDataSetChanged();
                    mInput.setText(null);
                }
            }
        });

    }

    private void initRecyclerView() {
        mMessages = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(mMessages);
        mRecyclerView.setAdapter(mAdapter);
    }
}