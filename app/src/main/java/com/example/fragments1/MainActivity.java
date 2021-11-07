package com.example.fragments1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentReceiver, SecondFragment.SecondFragmentReceiver {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        firstFragment = (FirstFragment) manager.findFragmentByTag("First");
        secondFragment = (SecondFragment) manager.findFragmentById(R.id.fragmentSecond);
    }

    public void firstReceive(String data) {
        secondFragment.dataReceived(data);
    }

    public void secondReceive(String data) {
        firstFragment.dataReceived(data);
    }
}
