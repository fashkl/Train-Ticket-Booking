package com.example.fashkl.project.DataWareHouse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by fashkl on 06/05/16.
 */
public class BookingTicket {
    private int ticketId;
    private String lineType;
    private String fromStation;
    private String toStation;
    private double cost;
    private String journyType;
    private double total;
    private double balance;
    private String date;

    private int f1;
    private int f2;

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }


    public void setF1(int f1) {
        this.f1 = f1;
    }
    //    BookingTicket bookingTicket=new BookingTicket();

    public int getF1() {
        return f1;
    }


    //generate Random TicketId for every new Booking -----> 5 digits
//    public static int generateTicketId() {
//        String j=""+((int) (Math.random() * 10))+((int) (Math.random() * 10))+
//                ((int) (Math.random() * 10))+ ((int) (Math.random() * 10))+
//                ((int) (Math.random() * 10));
//        return Integer.parseInt(j);
//    }

    public static int randInt() {
        int min = 10000;
        int max = 99999;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static String CurDate() {
        DateFormat df = new SimpleDateFormat("dd/ MM/ yyyy ");
        Calendar calendar = Calendar.getInstance();
        String c = df.format(calendar.getTime());
        return c;
    }

    public BookingTicket() {
        this.ticketId = randInt();
        this.date = CurDate();
    }

    public BookingTicket(String lineType, String fromStation, String toStation,
                         double cost, String journyType, double total, double balance) {
        this.ticketId = randInt();
        this.lineType = lineType;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.cost = cost;
        this.journyType = journyType;
        this.total = total;
        this.balance = balance;
        this.date = CurDate();
    }

    /*public void setTicketId(int ticketId) {
        this.ticketId =ticketId;
    }*/

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setJournyType(String journyType) {
        this.journyType = journyType;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = CurDate();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTicketId() {
        return this.ticketId;
    }

    public String getLineType() {
        return lineType;
    }

    public String getToStation() {
        return toStation;
    }

    public String getFromStation() {
        return fromStation;
    }

    public double getCost() {
        return cost;
    }

    public String getJournyType() {
        return journyType;
    }

    public double getTotal() {
        return total;
    }

    public double getBalance() {
        return balance;
    }

    public String getDate() {
        return CurDate();
    }
}
