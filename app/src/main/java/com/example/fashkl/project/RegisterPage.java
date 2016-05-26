package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fashkl.project.DataWareHouse.Registeration;
import com.example.fashkl.project.DataWareHouse.RegisteratoinLab;

//import com.example.fashkl.project.ProjectDataBase.*;

///////////////////////////////////////////////////////////////////

public class RegisterPage extends AppCompatActivity {
    public static final String userDetails = "com.example.fashkl.project.userDetails";
    private EditText RuserIdFld,
            RnameFld, RpasswordFld,
            RageFld, RadrssFld,
            RmobileNoFld, RcardNoFld;

    private Button RsubmitBtn;

    public boolean isValid(String s) {
        return (!s.trim().isEmpty());
    }

    public boolean userIdIsValid(String s) {
        return (s.length() >= 5 && isValid(s));
    }

    public boolean passIsValid(String s) {
        return (s.length() >= 5 && isValid(s));
    }


    public int C2I(String st) {
        return Integer.parseInt(st);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        RuserIdFld = (EditText) findViewById(R.id.RuserIdFld);
        RnameFld = (EditText) findViewById(R.id.RnameFld);
        RpasswordFld = (EditText) findViewById(R.id.RpasswordFld);
        RadrssFld = (EditText) findViewById(R.id.RaddressFld);
        RageFld = (EditText) findViewById(R.id.RageFld);
        RmobileNoFld = (EditText) findViewById(R.id.RmobileNoFld);
        RcardNoFld = (EditText) findViewById(R.id.RcardNoFld);
        RsubmitBtn = (Button) findViewById(R.id.RsubmitBtn);

        RsubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userIdIsValid(RuserIdFld.getText().toString())
                        && isValid(RnameFld.getText().toString())
                        && passIsValid(RpasswordFld.getText().toString())
                        && isValid(RadrssFld.getText().toString())
                        && isValid(RageFld.getText().toString())
                        && isValid(RmobileNoFld.getText().toString())
                        && isValid(RcardNoFld.getText().toString())) {

                    //geting te date and put it into model
                    Registeration register = new Registeration();
                    register.setUuid(C2I(RuserIdFld.getText().toString()));
                    register.setUserName(RnameFld.getText().toString());
                    register.setPassword(RpasswordFld.getText().toString());
                    register.setAddress(RadrssFld.getText().toString());
                    register.setAge(C2I(RageFld.getText().toString()));
                    register.setMobileNo(C2I(RmobileNoFld.getText().toString()));
                    register.setCardNo(C2I(RcardNoFld.getText().toString()));

                    Intent intent = new Intent(v.getContext(), SelectPage.class);
                    intent.putExtra(userDetails, register);
                    Toast.makeText(RegisterPage.this, register.getUserName(), Toast.LENGTH_SHORT).show();
                    boolean b = RegisteratoinLab.get(RegisterPage.this).insert(register);
                    if (b == true) {
                        Toast.makeText(RegisterPage.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(v.getContext(), "Data Already Registered \n try again!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(v.getContext(), "please Fill Fields Right", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}

