package com.example.fashkl.project.DataWareHouse;

import java.io.Serializable;
import com.example.fashkl.project.DataWareHouse.*;

/**
 * Created by fashkl on 06/05/16.
 */
public class TicketDetails implements Serializable{
    private int ticketId;
    private String toStation;
    private String fromStation;
    private String type;
    private String date;


    public TicketDetails() {
    }

    public TicketDetails(int ticketId, String toStation, String fromStation, String type, String date) {
        this.ticketId = ticketId;
        this.toStation = toStation;
        this.fromStation = fromStation;
        this.type = type;
        this.date = date;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date=date;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getToStation() {
        return toStation;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
