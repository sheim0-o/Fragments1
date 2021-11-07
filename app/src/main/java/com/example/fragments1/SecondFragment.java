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

public class SecondFragment extends Fragment {
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    public interface SecondFragmentReceiver { void secondReceive(String data); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        receiveData = view.findViewById(R.id.secondData);
        dataToSend  = view.findViewById(R.id.secondText);
        sendData    = view.findViewById(R.id.secondPost);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(secondReceiver != null)
                {
                    String text = dataToSend.getText().toString();
                    secondReceiver.secondReceive(text);
                }
            }
        });

        return view;
    }

    void dataReceived(String data)
    {
        receiveData.setText(data);
    }

    private SecondFragmentReceiver secondReceiver;

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SecondFragmentReceiver) {
            secondReceiver = (SecondFragmentReceiver) context;
        }
    }

    public void onDetach() { super.onDetach(); }
}
