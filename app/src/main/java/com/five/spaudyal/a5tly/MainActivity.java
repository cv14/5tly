package com.five.spaudyal.a5tly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity {
    //variable declaraions
    //signUpText for opening up the sign up Page
    private Button signUpText;

    //gSignIn for google sign in button
    private SignInButton gSignIn;

    //emailLogBtn for email_login_button
    private Button emailLogBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //default code to launch screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code to change the text of google sign in button
        gSignIn =  findViewById(R.id.sign_in_button);
        setGooglePlusButtonText(gSignIn, " Continue with Google ");

        //code to that signs you in once email_login_button is clicked
        emailLogBtn = findViewById(R.id.email_login_button);
        emailLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSwipeScreen();
            }
        });

        //code to open sign up page once clicked on the signup textView
        signUpText = findViewById(R.id.link_signup);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openSignUpPage();
            }
        });


    }


    //method that opens up the swipeSceen
    protected void openSwipeScreen(){
        Intent intent = new Intent(this, SwipeActivity.class);
        startActivity(intent);
    }

    //method that opens up signup Page
    protected void openSignUpPage(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    //method that changes the text of the google sign in button
    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                return;
            }
        }
    }


}
