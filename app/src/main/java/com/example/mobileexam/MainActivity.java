package com.example.mobileexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobileexam.Entrenaments;
import com.example.mobileexam.R;

public class MainActivity extends AppCompatActivity {

    private Button btnFragmentA, btnFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (savedInstanceState == null) {
            showFragment(new Entrenaments());
        }
    }

    public void showFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerlayout, fragment);


        fragmentTransaction.addToBackStack(null);


        fragmentTransaction.commit();
    }
}
