package com.wizzpass.phaseonechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnAboutALC)
    Button aboutALC;

    @BindView(R.id.btnMyProfile)
    Button myProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void goToAboutALC(View view) {

        startActivity(new Intent(MainActivity.this, AboutALCActivity.class));
    }

    public void goToMyProfile(View view) {

        startActivity(new Intent(MainActivity.this, MyProfileActivity.class));
    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }
}
