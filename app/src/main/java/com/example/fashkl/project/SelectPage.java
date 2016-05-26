package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.example.fashkl.project.DataWareHouse.Registeration;
import com.example.fashkl.project.DataWareHouse.RegisteratoinLab;
import com.example.fashkl.project.DataWareHouse.UserDetails;

public class SelectPage extends AppCompatActivity {
    public static final String userDetails = "com.example.fashkl.project.userDetails";
    public static final String userId = "com.example.fashkl.project.userId";
    public static final String userBalance = "com.example.fashkl.project.userbalance";
    public static final String s = "com.example.fashkl.project.userbalance.s";
    public static final String s1 = "com.example.fashkl.project.userbalance.s1";
    public static final int REQUEST = 0;
    public static final int REQUEST1 = 1;
    private String[] options;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private EditText duserIdFld, dnameFld, dageFld, dadrssFld, dmobileNoFld, dbalance;
    Intent selectInent, bookingInent, viewingIntent, balanceIntent, logoutIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);


        selectInent = new Intent(this, SelectPage.class);
        bookingInent = new Intent(this, BookTicketPage.class);
        viewingIntent = new Intent(this, ViewTicketPage.class);
        balanceIntent = new Intent(this, AddBalancePage.class);
        logoutIntent = new Intent(this, HomePage.class);


        duserIdFld = (EditText) findViewById(R.id.DuserIdFld);
        dnameFld = (EditText) findViewById(R.id.DnameFld);
        dadrssFld = (EditText) findViewById(R.id.DaddressFld);
        dageFld = (EditText) findViewById(R.id.DageFld);
        dmobileNoFld = (EditText) findViewById(R.id.DmobileNoFld);
        dbalance = (EditText) findViewById(R.id.DbalanceFld);


//        options = getResources().getStringArray(R.array.options);
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, options);
//        spinner.setAdapter(adapter);

        spinner = (Spinner) findViewById(R.id.optionsSpinner);


        final UserDetails data = (UserDetails) getIntent().getSerializableExtra("userDlog");
        if (data != null) {
//            Log.v("Tag3","Data Is Full");


            duserIdFld.setText(data.getUserID() + "");
            dnameFld.setText(data.getName());
            dadrssFld.setText(data.getAddress());
            dageFld.setText(data.getAge() + "");
            dmobileNoFld.setText(data.getMobileNo() + "");
            dbalance.setText(data.getBalance() + "");

        }


        final Registeration userDeatils = (Registeration) getIntent().getSerializableExtra(userDetails);

        update();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getSelectedItemPosition()) {

                    case 2:
                        try {
                            bookingInent.putExtra(userId, userDeatils.getUuid());
                            UserDetails userdetailsc = RegisteratoinLab.get(SelectPage.this).findUserDetails(userDeatils.getUuid());
                            bookingInent.putExtra(userBalance, userdetailsc.getBalance());
                        } catch (Exception e) {
                            bookingInent.putExtra(userId, data.getUserID());
                            UserDetails userdetailsc = RegisteratoinLab.get(SelectPage.this).findUserDetails(data.getUserID());
                            bookingInent.putExtra(userBalance, userdetailsc.getBalance());

                        }
                        startActivityForResult(bookingInent, REQUEST);
                        break;
                    case 3:
                        startActivity(viewingIntent);
                        break;
                    case 4:
                        startActivityForResult(balanceIntent,REQUEST1);
                        break;
                    case 5:
                        finish();
//                        startActivity(logoutIntent);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               // Toast.makeText(SelectPage.this, "PLZ, select one item", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        } else {
            if (requestCode == REQUEST) {
                Double balance = (Double) data.getSerializableExtra(s);
               // Toast.makeText(SelectPage.this, balance + "", Toast.LENGTH_SHORT).show();
                dbalance.setText((balance) + "");
            }else  if (requestCode==REQUEST1){
                Double balance=(Double) data.getSerializableExtra(s1);
                dbalance.setText((balance)+"");
            }
        }
    }

    private void update() {
        Registeration userDeatils = (Registeration) getIntent().getSerializableExtra(userDetails);
        if (userDeatils != null) {
            duserIdFld.setText(userDeatils.getUuid() + "");
            dnameFld.setText(userDeatils.getUserName());
            dadrssFld.setText(userDeatils.getAddress());
            dageFld.setText(userDeatils.getAge() + "");
            dmobileNoFld.setText(userDeatils.getMobileNo() + "");
            dbalance.setText(userDeatils.getCardNo() + "");
           // Toast.makeText(SelectPage.this, userDeatils.getCardNo() + "", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
