package com.example.fashkl.project.DataWareHouse;

/**
 * Created by fashkl on 13/05/16.
 */
public class DatabaseSchma {
    public static final class RegesterationTable{
        public static  final String NAME="regestration";
        public static final class  Cols{
            public static  final String UUID="uuid";
            public static  final String NAME="name";
            public static  final String PASSWORD="password";
            public static  final String ADDRESS="address";
            public static  final String AGE="age";
            public static  final String MOBILENO="mobileno";
            public static  final String CARDNO="cardno";
        }
    }

    public static final class BookingTable{
        public static  final String NAME="booking";
        public static final class Cols {
            public static final String ticketId = "ticketId";
            public static final String lineType = "lineType";
            public static final String fromStation = "fromStation";
            public static final String toStation = "toStation";
            public static final String ticketCost = "ticketCost";
            public static final String journyType = "journyType";
            public static final String total = "total";
            public static final String balance = "balance";
            public static final String date = "date";

        }
    }


}
