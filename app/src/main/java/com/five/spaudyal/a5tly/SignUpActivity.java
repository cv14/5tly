package com.five.spaudyal.a5tly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //button for signing up for the app
    private Button signUpBtn;

    //variable to store checkbox information
    private CheckBox acceptTerms;

    //variable to take you back to login Screen
    private TextView linkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //method that enables signup button if terms are accepted
        enableSignUp();

        //method that takes you back to the login screen if clicked on.
        goBackLogIn();


    }

    //this takes you back to the login screen if clicked.
    protected void goBackLogIn(){
        linkLogin = findViewById(R.id.link_login);
        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginLayout();
            }
        });
    }



    //method that enables signup button if terms are accepted
    protected void enableSignUp(){
        //code to enable the signUp button if checkbox is checked.
        signUpBtn = findViewById(R.id.btn_signup);
        acceptTerms = findViewById(R.id.terms_check_box);

        acceptTerms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is acceptTerms checked?
                if (((CheckBox) v).isChecked()) {
                    signUpBtn.setEnabled(true);
                }else{
                    signUpBtn.setEnabled(false);
                }

            }
        });
    }

    //method to open LoginLayout
    protected void openLoginLayout(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
