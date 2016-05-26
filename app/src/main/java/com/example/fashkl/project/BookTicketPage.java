package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.fashkl.project.DataWareHouse.*;


public class BookTicketPage extends AppCompatActivity {
    public static final String userId = "com.example.fashkl.project.userId";
    public static final String userBalance = "com.example.fashkl.project.userbalance";
    public static final String s = "com.example.fashkl.project.userbalance.s";

    private Spinner bkLineTypeSpnr, bkFromStationSpnr, bkToStationSpnr;
    private RadioGroup bkJournyTypeRB;
    private RadioButton bksingle, bkreturn;
    private EditText BkCostFld, bkTotalFld, bkBalanceFld;
    private Button bkBookBtn;
    private BookingTicket booking;
    private Bundle bundle;
    private Registeration registeration;
    private TicketDetails ticketDetails;
    private Intent ticketDIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket_page);
        registeration = new Registeration();
        ticketDetails = new TicketDetails();

        //iniaite the Spinners view
        bkLineTypeSpnr = (Spinner) findViewById(R.id.BKlineTypeSpnr);
        bkLineTypeSpnr.setPrompt("--Select Line--");
//        bkLineTypeSpnr.setPopupBackgroundDrawable(R.drawable.bicycles);

        bkFromStationSpnr = (Spinner) findViewById(R.id.BKfromStationSpnr);
        bkFromStationSpnr.setPrompt("--Select Station--");

        bkToStationSpnr = (Spinner) findViewById(R.id.BKtostationSpnr);
        bkToStationSpnr.setPrompt("--Select Station--");


        //initiate the RadioGroup
        bkJournyTypeRB = (RadioGroup) findViewById(R.id.BkjournyTypeRB);


        //iniaite the EditTexts
        bkTotalFld = (EditText) findViewById(R.id.BktotalFld);
        bkBalanceFld = (EditText) findViewById(R.id.BkbalabnceFld);
        BkCostFld = (EditText) findViewById(R.id.BkCostFld);

        //initiate
        booking = new BookingTicket();

        //
        bkBookBtn = (Button) findViewById(R.id.BKBookBtn);

        bkLineTypeSpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (parent.getSelectedItemPosition()) {
                    case 0:
                        booking.setLineType(null);
                        break;
                    case 1:
                        booking.setLineType(parent.getItemAtPosition(position).toString());
                        break;
                    case 2:
                        booking.setLineType(parent.getItemAtPosition(position).toString());
                        break;
                    case 3:
                        booking.setLineType(parent.getItemAtPosition(position).toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bkFromStationSpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getSelectedItemPosition()) {
//                    case 0:
//                        booking.setFromStation(null);
//                        break;
                    case 1:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                    case 2:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 3:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 4:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 5:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 6:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 7:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 8:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                    case 9:
                        booking.setFromStation(parent.getItemAtPosition(position).toString());
                        booking.setF1(position);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bkToStationSpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getSelectedItemPosition()) {
//                    case 0:
//                        booking.setToStation(null);
////                        booking.setF2(position);
//                        break;
                    case 1:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 2:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 3:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 4:
                        Toast.makeText(BookTicketPage.this, position + "", Toast.LENGTH_SHORT).show();
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 5:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 6:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 7:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 8:
                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));
                        BkCostFld.setText(booking.getCost() + "");
                        break;
                    case 9:

                        booking.setToStation(parent.getItemAtPosition(position).toString());
                        booking.setF2(position);
                        booking.setCost(Math.abs(booking.getF1() - booking.getF2()));

                        BkCostFld.setText(booking.getCost() + "");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bkJournyTypeRB.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bksingle = (RadioButton) findViewById(R.id.BksingleRBtn);
                bkreturn = (RadioButton) findViewById(R.id.BkreturnRBtn);

                if (bksingle.isChecked()) {
                    booking.setJournyType("Single");
                    booking.setTotal(booking.getCost());
                    //setting cost to the edittext widget
                    bkTotalFld.setText(booking.getTotal() + "");
                    bundle = getIntent().getExtras();
                    double balence = bundle.getDouble(userBalance);
                    if (checkBalance(balence, booking.getTotal())) {
                        Double finalBalance = balence - booking.getTotal();
                        bkBalanceFld.setText(finalBalance + "");
                        bkBookBtn.setEnabled(true);
                    } else {
                        bkBookBtn.setEnabled(false);
                    }

                } else {
                    booking.setJournyType("Return");
                    booking.setTotal(booking.getCost() * 2);
                    //setting cost to the edittext widget
                    bkTotalFld.setText(booking.getTotal() + "");
                    bundle = getIntent().getExtras();
                    int uuid = bundle.getInt(userId);
                    double balence = bundle.getDouble(userBalance);
                    if (checkBalance(balence, booking.getTotal())) {
                        Double finalBalance = balence - booking.getTotal();
                        bkBalanceFld.setText(finalBalance + "");
                        bkBookBtn.setEnabled(true);
                    } else {
                        bkBookBtn.setEnabled(false);
                    }

                }
            }
        });

        bkBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ticketDIntent = new Intent(v.getContext(), TicketDetailsPage.class);

                bundle = getIntent().getExtras();
                int uuid = bundle.getInt(userId);
                double balence = bundle.getDouble(userBalance);
                Double finalBalance = balence - booking.getTotal();
                bkBalanceFld.setText(finalBalance + "");

                Intent intent = getIntent();

                Toast.makeText(BookTicketPage.this, RegisteratoinLab.get(BookTicketPage.this).update(uuid, finalBalance) ? "done" : "doesnot", Toast.LENGTH_SHORT).show();
                booking.setBalance(finalBalance);
                Toast.makeText(BookTicketPage.this, booking.getBalance() + "ff", Toast.LENGTH_SHORT).show();
                final int EvryID = booking.getTicketId();
                // booking.setBalance(RegisteratoinLab.get(BookTicketPage.this).getBalance(uuid) - booking.getTotal());

                setResult(RESULT_OK, intent);
                intent.putExtra(s, booking.getBalance());
                ///setting ticket details
                ticketDetails.setTicketId(EvryID);
                ticketDetails.setToStation(booking.getToStation());
                ticketDetails.setFromStation(booking.getFromStation());
                ticketDetails.setType(booking.getLineType());
                ticketDetails.setDate(booking.getDate());

                ticketDIntent.putExtra("ticketdetails", ticketDetails);

                boolean b = bookingLab.get(BookTicketPage.this).insert(booking);
                if (b == true) {
                    Log.v("TagTag \t", "ID\t" + EvryID + "\tInserted");
                    startActivity(ticketDIntent);
                    finish();
                } else {
                    Toast.makeText(v.getContext(), "Data Already Registered \n try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkBalance(double balance, double total) {
        if (balance > total) {
            return true;
        } else {
            Toast.makeText(BookTicketPage.this, "Your Balance Is not engoht", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
