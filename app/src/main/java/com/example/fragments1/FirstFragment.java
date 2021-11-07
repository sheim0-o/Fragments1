package com.example.fragments1;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    public interface FirstFragmentReceiver {
        void firstReceive(String data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        receiveData = view.findViewById(R.id.firstData);
        dataToSend = view.findViewById(R.id.firstText);
        sendData = view.findViewById(R.id.firstPost);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstReceiver != null)
                {
                    String text = dataToSend.getText().toString();
                    firstReceiver.firstReceive(text);
                }
            }
        });
        return view;
    }

    void dataReceived(String data)
    {
        receiveData.setText(data);
    }

    private FirstFragmentReceiver firstReceiver;

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentReceiver) {
            firstReceiver = (FirstFragmentReceiver) context;
        }
    }

    public void onDetach() { super.onDetach(); }
}
