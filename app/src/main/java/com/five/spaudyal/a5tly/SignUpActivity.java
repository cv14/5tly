package com.five.spaudyal.a5tly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //button for signing up for the app
    private Button signUpBtn;

    //variable to store checkbox information
    private CheckBox acceptTerms;

    //variable to take you back to login Screen
    private TextView linkLogin;

    //variable to show and close terms and conditions
    private TextView termsAndCondtions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //method that enables signup button if terms are accepted
        enableSignUp();

        //method that takes you back to the login screen if clicked on.
        goBackLogIn();


        //method pops up terms and condtions if clicked
        openTerms();




    }

    //method pops up terms and condtions if clicked
    protected void openTerms(){
        termsAndCondtions = findViewById(R.id.terms_and_condtions);
        termsAndCondtions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(termsAndCondtions);
            }
        });
    }

    //helper method for doing pop up window
    protected void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_terms, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
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
