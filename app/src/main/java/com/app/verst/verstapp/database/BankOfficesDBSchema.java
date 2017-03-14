package com.app.verst.verstapp.database;

public class BankOfficesDBSchema {

    public static final class BankOfficesWorkTime{
        public static final String WORKTIME = "worktimes";

        public static final  class Columns{
            public static final String MONDAY ="monday";
            public static final String TUESDAY ="tuesday";
            public static final String WEDNESDAY ="wednesday";
            public static final String THURSDAY = "thursday";
            public static final String FRIDAY = "friday";
            public static final String SATURDAY = "saturday";
            public static final String SUNDAY = "sunday";
        }
    }

    public static final class bankOfficesTable {
        public static final String NAME = "offices";

        public static final class Columns {
            public static final String ADDRESS = "address";
            public static final String NAME = "name";
            public static final String PHONE_NUMBER = "phone_number";
            public static final String DISTANCE = "distance";
        }
    }
}
