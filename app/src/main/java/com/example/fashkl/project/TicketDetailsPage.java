package com.example.fashkl.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fashkl.project.DataWareHouse.TicketDetails;
import com.example.fashkl.project.DataWareHouse.bookingLab;

public class TicketDetailsPage extends AppCompatActivity {

    private EditText TKuserIdFld, TKtoFld, TKfromFld, TKtypeFld, TKdateFld;
    private Button TKClearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details_page);


        TKuserIdFld = (EditText) findViewById(R.id.TKuserIdFld);
        TKtoFld = (EditText) findViewById(R.id.TKtoFld);
        TKfromFld = (EditText) findViewById(R.id.TKformFld);
        TKtypeFld = (EditText) findViewById(R.id.TKtypeFld);
        TKdateFld = (EditText) findViewById(R.id.TKdateFld);

        TKClearBtn = (Button) findViewById(R.id.TKclearBtn);

        TicketDetails details = (TicketDetails) getIntent().getSerializableExtra("ticketdetails");

        if (details != null) {
            TKuserIdFld.setText(details.getTicketId() + "");
            TKtoFld.setText(details.getToStation());
            TKfromFld.setText(details.getFromStation());
            TKtypeFld.setText(details.getType());
            TKdateFld.setText(details.getDate());
        }

        TicketDetails viewDetails = (TicketDetails) getIntent().getSerializableExtra("TicDeatils");

//        final int kId=viewDetails.getTicketId();

        if (viewDetails != null) {
            TKuserIdFld.setText(viewDetails.getTicketId() + "");
            TKtoFld.setText(viewDetails.getToStation());
            TKfromFld.setText(viewDetails.getFromStation());
            TKtypeFld.setText(viewDetails.getType());
            TKdateFld.setText(viewDetails.getDate());
        }

        TKClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingLab.get(TicketDetailsPage.this).deletTicket(Integer.parseInt(TKuserIdFld.getText().toString()));
                Toast.makeText(TicketDetailsPage.this, "Deleted Sucessfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
