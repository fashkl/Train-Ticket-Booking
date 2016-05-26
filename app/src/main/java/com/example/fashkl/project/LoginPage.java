package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.fashkl.project.DataWareHouse.RegisteratoinLab;
import com.example.fashkl.project.DataWareHouse.UserDetails;

import static com.example.fashkl.project.DataWareHouse.DataBaseHelper.C2I;


public class LoginPage extends AppCompatActivity {

    private Button registerBtn, btnLinkToRegisterScreen;
    private EditText passwordFld;
    private AutoCompleteTextView userNameFld;
    private String[] loop;
    private ArrayAdapter<String> adapter;
    public Intent selectPageIntent, registerPageIntent;


    private boolean isUserIdValid(String userId) {
        return (userId.length() >= 5 && !userId.trim().isEmpty());
    }


    private boolean isPasswordValid(String password) {
        return (password.length() >= 5 && !password.trim().isEmpty());
    }

    public void reset(EditText ed) {
        ed.setText(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        userNameFld = (AutoCompleteTextView) findViewById(R.id.userIdFldd);
        passwordFld = (EditText) findViewById(R.id.passwordFldd);
        registerBtn = (Button) findViewById(R.id.loginRegistBtnd);
        btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        selectPageIntent = new Intent(this, SelectPage.class);
        registerPageIntent = new Intent(this, RegisterPage.class);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isUserIdValid(userNameFld.getText().toString()) &&
                        isPasswordValid(passwordFld.getText().toString())) {

                    int Id = C2I(userNameFld.getText().toString().trim());
                    String pass = passwordFld.getText().toString().trim();


                    UserDetails userdetails = RegisteratoinLab.get(LoginPage.this).findUserDetails(Id);
                    if (RegisteratoinLab.get(LoginPage.this).getflage()) {
                        Toast.makeText(LoginPage.this, "User not found  ", Toast.LENGTH_SHORT).show();
                    } else {

                    }
                    if (userdetails != null) {

                        int id = userdetails.getUserID();
                        String pas = userdetails.getPassword();

                        if (id == Id && pas.equals(pass)) {
                         //   Toast.makeText(v.getContext(), "FOUND", Toast.LENGTH_LONG).show();

                            selectPageIntent.putExtra("userDlog", userdetails);
                            startActivity(selectPageIntent);
                            reset(userNameFld);
                            reset(passwordFld);
                        } else {
                            Log.v("TagEmp", "userdetails is Empty");
                            Toast.makeText(v.getContext(), "Not FOUND, plz try again", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(LoginPage.this, "Sorry Incorrect Data", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(getApplicationContext(),
                            "must be 6 digits UserId & 4 password ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerPageIntent);
                finish();
            }
        });

    }


}
