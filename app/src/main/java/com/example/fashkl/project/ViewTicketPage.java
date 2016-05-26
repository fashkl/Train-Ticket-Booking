package com.example.fashkl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import com.example.fashkl.project.DataWareHouse.TicketDetails;
import com.example.fashkl.project.DataWareHouse.bookingLab;

public class ViewTicketPage extends AppCompatActivity {

    private AutoCompleteTextView searchAutoComp;
    private Button searchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ticket_page);


        searchAutoComp = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        searchBtn = (Button) findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchAutoComp.getText().toString().trim().isEmpty()) {
                    Toast.makeText(v.getContext(), "please fill the feild", Toast.LENGTH_LONG).show();
                } else {

                    int tkid = Integer.parseInt(searchAutoComp.getText().toString().trim());

                    TicketDetails details = bookingLab.get(ViewTicketPage.this).findTicket(tkid);
//                    if (bookingLab.get(ViewTicketPage.this).getflag()) {
////                        Toast.makeText(ViewTicketPage.this, "TicketId not found ", Toast.LENGTH_SHORT).show();
//                    } else {
//
//                    }
                    if (details != null) {
//                        Toast.makeText(ViewTicketPage.this, details.getTicketId()+"\n"+details.getFromStation(), Toast.LENGTH_SHORT).show();
                        Intent ticketDetailPage = new Intent(v.getContext(), TicketDetailsPage.class);
                        ticketDetailPage.putExtra("TicDeatils", details);
                        startActivity(ticketDetailPage);
                        finish();
                    } else {
                        Toast.makeText(ViewTicketPage.this, "Sorry :) Not Found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
