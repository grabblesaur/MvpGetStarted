package com.example.bayar.mvpgetstarted.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bayar.mvpgetstarted.R;
import com.example.bayar.mvpgetstarted.view.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMainFragment();
    }

    private void showMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, UserFragment.newInstance(), UserFragment.class.getSimpleName())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
