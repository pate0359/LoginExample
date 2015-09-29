package com.algonquincollege.nigi.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Login button
        Button loginButton = (Button) findViewById( R.id.btnLogin );
        // register an anonymous inner class as the event handler for the loginButton
        loginButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Login Clicked()", Toast.LENGTH_SHORT).show();

                EditText userName=(EditText) findViewById(R.id.username);
                String strUsername=userName.getText().toString();
                if ( strUsername.isEmpty()) //Check for empty string
                {
                    //userName.setError("Please enter your username.");
                    Toast.makeText(getApplicationContext(), "Please enter your username.", Toast.LENGTH_LONG).show();
                    userName.setFocusable(true);
                    return;
                }

                if (strUsername.length() != 8) //Check for username length
                {
                    if (strUsername.length() < 8)
                    {
                        //userName.setError("Username is too short. It must be exactly 8 characters long.");
                        Toast.makeText(getApplicationContext(), "Username is too short. It must be exactly 8 characters long.", Toast.LENGTH_LONG).show();
                    }else
                    {
                        //userName.setError("Username is too long. It must be exactly 8 characters long.");
                        Toast.makeText(getApplicationContext(), "Username is too long. It must be exactly 8 characters long.", Toast.LENGTH_LONG).show();
                    }

                    userName.setFocusable(true);
                    return;
                }

                if(!Character.isLowerCase(strUsername.charAt(0)) || !Character.isLowerCase(strUsername.charAt(1))) // Check for first 2 positions.
                {
                    //userName.setError("First 2 characters must be lower case alphabetical characters.");
                    Toast.makeText(getApplicationContext(), "First 2 characters must be lower case alphabetical characters.", Toast.LENGTH_LONG).show();
                    userName.setFocusable(true);
                    return;
                }

                //Check for non-alphabetical character in username
                Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                boolean hasSpecialChar = p.matcher(strUsername).find();
                //Toast.makeText(getApplicationContext(), "Special characters - "+hasSpecialChar, Toast.LENGTH_LONG).show();

                if (hasSpecialChar)
                {
                    //userName.setError("Special characters are not allowed in username.");
                    Toast.makeText(getApplicationContext(), "Special characters are not allowed for username.", Toast.LENGTH_LONG).show();
                    userName.setFocusable(true);
                    return;
                }

                EditText userPassword=(EditText) findViewById(R.id.userPassword);
                String strPassword=userPassword.getText().toString();
                if ( strPassword.isEmpty())
                {
                    userPassword.setFocusable(true);
                    //userPassword.setError("Enter your Password");
                    Toast.makeText(getApplicationContext(), "Enter your Password.", Toast.LENGTH_LONG).show();
                    return;
                }

                //Check password length
                if (strPassword.length() < 5)
                {
                    //userPassword.setError("Password must be minimum 5 characters in length.");
                    Toast.makeText(getApplicationContext(), "Password must be minimum 5 characters in length.", Toast.LENGTH_LONG).show();
                    userPassword.setFocusable(true);
                    return;
                }

                CheckBox checkBox=(CheckBox) findViewById( R.id.rememberMe );
                boolean isChecked=checkBox.isChecked();

                //Toast.makeText(getApplicationContext(), "Login button :: onClick( )", Toast.LENGTH_SHORT).show( );
                Toast.makeText(getApplicationContext(), "Username : "+strUsername+"\nPassword : " +strPassword+"\nRemember Me : "+isChecked, Toast.LENGTH_LONG).show( );
            }
        });

        //Forgot password
        Button forgotPasswordButton = (Button) findViewById( R.id.btnForgotPassword );
        forgotPasswordButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Forgot My Password? :: onClick()", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
