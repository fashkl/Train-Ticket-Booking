package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fashkl.project.DataWareHouse.RegisteratoinLab;

import static com.example.fashkl.project.DataWareHouse.DataBaseHelper.C2I;

public class AddBalancePage extends AppCompatActivity {
    public static final String s1 = "com.example.fashkl.project.userbalance.s1";
    private EditText buserIdFld, bbalanceFld, bcardNoFld, bamountFld;
    private Button dsubmitBtn;

    private boolean isUserIdValid(String userId) {
        return (userId.length() >= 5 && !userId.trim().isEmpty());
    }

    private boolean isamountValid(String amont) {
        return (!amont.trim().isEmpty() && Double.parseDouble(amont) > 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance_page);

        buserIdFld = (EditText) findViewById(R.id.BuserIdFld);
        bbalanceFld = (EditText) findViewById(R.id.BbalanceFld);
//        bcardNoFld=(EditText) findViewById(R.id.BcardNoFld);
        bamountFld = (EditText) findViewById(R.id.BamountFld);

        dsubmitBtn = (Button) findViewById(R.id.BsubmitBtn);

        dsubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                if (isUserIdValid(buserIdFld.getText().toString()) &&
                        isamountValid(bamountFld.getText().toString())) {
                    int id = C2I(buserIdFld.getText().toString());
                    double amount = Double.parseDouble(bamountFld.getText().toString());

                       double num = RegisteratoinLab.get(AddBalancePage.this).getBalance(id);


                    boolean up = RegisteratoinLab.get(AddBalancePage.this).update(id, (amount+num));
                    Toast.makeText(AddBalancePage.this, ""+(amount+num), Toast.LENGTH_SHORT).show();
                    if (up == true) {

                        Toast.makeText(AddBalancePage.this, "Balanced Updated Succefully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent.putExtra(s1,(amount+num));
                        setResult(RESULT_OK,intent);
                        finish();
                    } else {
                        Toast.makeText(AddBalancePage.this, "sorry try again", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddBalancePage.this, "Sorry, Enter Correct Data", Toast.LENGTH_SHORT).show();
                }


            }catch (Exception e){
                    Toast.makeText(AddBalancePage.this, "YOur id not found Please Registration With New Id ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
