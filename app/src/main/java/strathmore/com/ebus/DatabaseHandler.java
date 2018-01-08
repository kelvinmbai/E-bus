package strathmore.com.ebus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mambo on 16/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_NAME = "TrialDatbase";

//table user
    private static final String TABLE_USER = "User";

    private static final String TABLE_BUSCOMPANY = "BusCompany";

    private static final String TABLE_BUS = "Bus";

    private static final String TABLE_CUSTOMER_DETAIL = "CustomerDetail";

    private static final String TABLE_TICKET = "Ticket";

    //Table users columns
    private static final String KEY_ID = "user_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PASSWORD = "password";

    //Table bus company columns
    private static final String KEY_BUS_CO_ID = "Bus_co_id";
    private static final String KEY_BUS_CO_NAME = "Bus_co_name";

    //Table bus tables
    private static final String KEY_BUS_ID = "Bus_id";
    private static final String KEY_COST = "Cost";
    private static final String KEY_DEPARTURE_TIME = "Departure_Time";
    private static final String KEY_DEPARTURE_DATE= "Departure_Date";
    private static final String KEY_DESTINATION = "Destination";
    private static final String KEY_BUS_COMPANY_ID = "Bus_company_id";

    //Table customer detail table
    private static final String KEY_CUSTOMER_CHOICE_ID = "Customer_choice_id";
    private static final String KEY_BUS_COMPANY_NAME = "Bus_company_name";
    private static final String KEY_DESTINATIONS = "Destinations";
    private static final String KEY_DATE= "Date";
    private static final String KEY_TIME = "Time";
    private static final String KEY_SEATS = "Seats";
    private static final String KEY_COSTS = "Costs";
    private static final String KEY_USERID = "UserID";

    //Table Ticket Columns
    private static final String KEY_TICKET_ID = "Ticket_id";
    private static final String KEY_USERS_ID = "User_id";
    private static final String KEY_CUSTOMERS_CHOICE_ID = "Customers_choice_id";


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT," + KEY_PHONE + " TEXT," + KEY_PASSWORD +" TEXT"+")";
        String CREATE_BUS_CO_TABLE = "CREATE TABLE " + TABLE_BUSCOMPANY + "(" + KEY_BUS_CO_ID + " INTEGER PRIMARY KEY," + KEY_BUS_CO_NAME + " TEXT"+")";
        String CREATE_BUS_TABLE = "CREATE TABLE " + TABLE_BUS + "(" + KEY_BUS_ID + " INTEGER PRIMARY KEY," + KEY_COST + " INTEGER," + KEY_DEPARTURE_TIME + " TEXT," + KEY_DEPARTURE_DATE + " TEXT,"  + KEY_DESTINATION +" TEXT,"+ KEY_BUS_COMPANY_ID + " INTEGER," + " FOREIGN KEY ("+ KEY_BUS_COMPANY_ID +") REFERENCES "+ TABLE_BUSCOMPANY +" ("+ KEY_BUS_CO_ID +")" + ")";
        String CREATE_CUSTOMER_DETAIL_TABLE = "CREATE TABLE " + TABLE_CUSTOMER_DETAIL + "(" + KEY_CUSTOMER_CHOICE_ID + " INTEGER PRIMARY KEY," + KEY_BUS_COMPANY_NAME + " TEXT,"+ KEY_DESTINATIONS + " TEXT," + KEY_DATE + " TEXT," + KEY_TIME + " TEXT,"  + KEY_SEATS +" INTEGER,"+ KEY_COSTS +" INTEGER,"+ KEY_USERID + " INTEGER," + " FOREIGN KEY ("+ KEY_USERID +") REFERENCES "+ TABLE_USER +" ("+ KEY_ID +")" + ")";
        String CREATE_TICKETS_TABLE = "CREATE TABLE " + TABLE_TICKET + "(" + KEY_TICKET_ID + " INTEGER PRIMARY KEY," + KEY_USERS_ID  + " INTEGER," + KEY_CUSTOMERS_CHOICE_ID   + " INTEGER," + " FOREIGN KEY ("+ KEY_USERS_ID  +") REFERENCES "+ TABLE_USER + " ("+ KEY_ID + ")" + " FOREIGN KEY ("+ KEY_CUSTOMERS_CHOICE_ID   +") REFERENCES "+ TABLE_CUSTOMER_DETAIL +" ("+ KEY_CUSTOMER_CHOICE_ID  +")" + ")";


        db.execSQL(CREATE_BUS_CO_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_BUS_TABLE);
        db.execSQL(CREATE_CUSTOMER_DETAIL_TABLE);
        db.execSQL(CREATE_TICKETS_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSCOMPANY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER_DETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TICKET);
        onCreate(db);
    }

    //1//Adding a new user
    public void addUser(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUser_name());
        values.put(KEY_PHONE, user.getPhonenumber());
        values.put(KEY_PASSWORD, user.getPassword());
        //insert a row
        db.insert(TABLE_USER,null,values);

    }

    //1/.1/Adding a new bus company
    public void addBusCompany(BusCompany company){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BUS_CO_NAME, company.getBus_company_name());
        //insert a row
        db.insert(TABLE_BUSCOMPANY,null,values);

    }
    //1.2//Adding a new BUS
    public void addBus(Bus bus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BUS_COMPANY_ID, bus.getBus_co_id());
        values.put(KEY_COST, bus.getCost());
        values.put(KEY_DEPARTURE_TIME, bus.getTime_of_departure());
        values.put(KEY_DEPARTURE_DATE, bus.getDate_of_departure());
        values.put(KEY_DESTINATION, bus.getDestination());

        //insert a row
        db.insert(TABLE_BUS,null,values);

    }
    //1.3 adding a customer's detail
    public void addCustomerDetail(CustomerDetail detail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERID, detail.getUser_id());
        values.put(KEY_BUS_COMPANY_NAME, detail.getBus_co_name());
        values.put(KEY_DESTINATIONS, detail.getDestination());
        values.put(KEY_TIME, detail.getTime());
        values.put(KEY_DATE, detail.getDate());
        values.put(KEY_SEATS, detail.getSeats());
        values.put(KEY_COSTS, detail.getCost());


        //insert a row
        db.insert(TABLE_CUSTOMER_DETAIL,null,values);

    }
    //1/.1/Adding a new ticket
    public void addTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERS_ID , ticket.getUser_id());
        values.put(KEY_CUSTOMERS_CHOICE_ID  , ticket.getCustomer_choice_id());
        //insert a row
        db.insert(TABLE_TICKET,null,values);

    }

    //2//Getting a single user
    public Users getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_ID, KEY_USERNAME, KEY_PHONE, KEY_PASSWORD}, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Users user = new Users(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
        );
        //return user
        return user;
    }

    //2.1//Getting a single bus company
    public BusCompany getBusCompany(int bus){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BUSCOMPANY, new String[] { KEY_BUS_CO_ID, KEY_BUS_CO_NAME}, KEY_BUS_CO_ID + "=?", new String[] { String.valueOf(bus) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        BusCompany company = new BusCompany(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1)
        );
        //return user
        return company;
    }

    //2.2//Getting a single user
    public Bus getBus(int buses){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BUS, new String[] { KEY_BUS_ID,KEY_BUS_COMPANY_ID,KEY_COST, KEY_DEPARTURE_TIME, KEY_DEPARTURE_DATE, KEY_DESTINATION}, KEY_BUS_ID + "=?", new String[] { String.valueOf(buses) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Bus bus = new Bus(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)

        );
        //return user
        return bus;
    }
    //2.3 getting a single customer detail
    public CustomerDetail getCustomerDetail(int detail){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CUSTOMER_DETAIL, new String[] { KEY_CUSTOMER_CHOICE_ID ,KEY_BUS_COMPANY_NAME ,KEY_DESTINATIONS , KEY_DATE, KEY_TIME , KEY_SEATS, KEY_COSTS, KEY_USERID}, KEY_CUSTOMER_CHOICE_ID + "=?", new String[] { String.valueOf(detail) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        CustomerDetail customer = new CustomerDetail(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7))

        );
        //return user
        return customer;
    }

    //2.33//Getting a single bus company
    public Ticket getTicket(int t){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TICKET, new String[] { KEY_TICKET_ID, KEY_USERS_ID , KEY_CUSTOMERS_CHOICE_ID}, KEY_TICKET_ID + "=?", new String[] { String.valueOf(t) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Ticket ticket = new Ticket(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2))
        );
        //return user
        return ticket;
    }

    //3//Getting all users
    public List<Users> getAllUsers(){
        List<Users> usersList = new ArrayList<Users>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows adding to list

        if(cursor.moveToFirst()){
            do{
                Users user = new Users();
                user.setUser_id(Integer.parseInt(cursor.getString(0)));
                user.setUser_name(cursor.getString(1));
                user.setPhonenumber(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                usersList.add(user);
            }while(cursor.moveToNext());
        }

        return usersList;
    }

    //3.1//Getting all buses
    public List<BusCompany>getAllBusCompanies(){
        List<BusCompany>companyList = new ArrayList<BusCompany>();
        String selectQuery = "SELECT * FROM " + TABLE_BUSCOMPANY;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows adding to list

        if(cursor.moveToFirst()){
            do{
                BusCompany company = new BusCompany();
                company.setBus_company_id(Integer.parseInt(cursor.getString(0)));
                company.setBus_company_name(cursor.getString(1));
                companyList.add(company);
            }while(cursor.moveToNext());
        }

        return companyList;
    }

    //3//Getting all bus
    public List<Bus> getAllBuses(){
        List<Bus> busList = new ArrayList<Bus>();
        String selectQuery = "SELECT * FROM " + TABLE_BUS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows adding to list

        if(cursor.moveToFirst()){
            do{
                Bus bus = new Bus();
                //bus.setBus_co_id(Integer.parseInt(cursor.getString(0)));
                bus.setBus_id(Integer.parseInt(cursor.getString(0)));
                bus.setCost(Integer.parseInt(cursor.getString(1)));
                bus.setTime_of_departure(cursor.getString(2));
                bus.setDate_of_departure(cursor.getString(3));
                bus.setDestination(cursor.getString(4));

                busList.add(bus);
            }while(cursor.moveToNext());
        }

        return busList;
    }

    //3.3//Getting all customer details
    public List<CustomerDetail> getAllCustomerDetails(){
        List<CustomerDetail> customerList = new ArrayList<CustomerDetail>();
        String selectQuery = "SELECT * FROM " + TABLE_CUSTOMER_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows adding to list

        if(cursor.moveToFirst()){
            do{
                CustomerDetail customer = new CustomerDetail();
                customer.setCustomer_choice_id(Integer.parseInt(cursor.getString(0)));
                customer.setBus_co_name(cursor.getString(1));
                customer.setDestination(cursor.getString(2));
                customer.setDate(cursor.getString(3));
                customer.setTime(cursor.getString(4));
                customer.setSeats(Integer.parseInt(cursor.getString(5)));
                customer.setCost(Integer.parseInt(cursor.getString(6)));
                customer.setUser_id(Integer.parseInt(cursor.getString(7)));

                customerList.add(customer);
            }while(cursor.moveToNext());
        }

        return customerList;
    }

    //3.3.3//Getting all tickets
    public List<Ticket>getAllTickets(){
        List<Ticket>ticketList = new ArrayList<Ticket>();
        String selectQuery = "SELECT * FROM " + TABLE_TICKET;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows adding to list

        if(cursor.moveToFirst()){
            do{
                Ticket ticket = new Ticket();
                ticket.setTicket_id(Integer.parseInt(cursor.getString(0)));
                ticket.setUser_id(Integer.parseInt(cursor.getString(1)));
                ticket.setCustomer_choice_id(Integer.parseInt(cursor.getString(2)));
                ticketList.add(ticket);
            }while(cursor.moveToNext());
        }

        return ticketList;
    }

    //4//Getting users count
    public int getUsersCount(){
        String countQuery ="SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery(countQuery, null);
        cursors.close();
        //return count
        return cursors.getCount();

    }
    //4.1//Getting buses count
    public int getBusCompanyCount(){
        String countQuery ="SELECT * FROM " + TABLE_BUSCOMPANY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery(countQuery, null);
        cursors.close();
        //return count
        return cursors.getCount();

    }
    //4//Getting buses count
    public int getBusesCount(){
        String countQuery ="SELECT * FROM " + TABLE_BUS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery(countQuery, null);
        cursors.close();
        //return count
        return cursors.getCount();

    }
    //4//Getting customer detail count
    public int getCustomerDetailCount(){
        String countQuery ="SELECT * FROM " + TABLE_CUSTOMER_DETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery(countQuery, null);
        cursors.close();
        //return count
        return cursors.getCount();

    }

    //4.1//Getting tickets count
    public int getTicketCount(){
        String countQuery ="SELECT * FROM " + TABLE_TICKET;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursors = db.rawQuery(countQuery, null);
        cursors.close();
        //return count
        return cursors.getCount();

    }

    //5//Updating a single user
    public int updateUser(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUser_name());
        values.put(KEY_PHONE, user.getPhonenumber());
        values.put(KEY_PASSWORD, user.getPassword());

        //updating a row
        return db.update(TABLE_USER, values, KEY_ID + "+?", new String[] { String.valueOf(user.getUser_id())});

    }

    //5.1//Updating a single bus company
    public int updateBusCompany(BusCompany company){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BUS_CO_NAME, company.getBus_company_name());

        //updating a row
        return db.update(TABLE_BUSCOMPANY, values, KEY_BUS_CO_ID + "+?", new String[] { String.valueOf(company.getBus_company_id())});

    }

    //5//Updating a single user
    public int updateBuses(Bus bus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BUS_COMPANY_ID, bus.getBus_co_id());
        values.put(KEY_COST, bus.getCost());
        values.put(KEY_DEPARTURE_TIME, bus.getTime_of_departure());
        values.put(KEY_DEPARTURE_TIME, bus.getDate_of_departure());
        values.put(KEY_DESTINATION, bus.getDestination());

        //updating a row
        return db.update(TABLE_BUS, values, KEY_BUS_ID + "+?", new String[] { String.valueOf(bus.getBus_id())});

    }
    //5//Updating a single user
    public int updateCustomerDetail(CustomerDetail detail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BUS_COMPANY_NAME , detail.getBus_co_name());
        values.put(KEY_DESTINATIONS , detail.getDestination());
        values.put(KEY_DATE, detail.getDate());
        values.put(KEY_TIME , detail.getTime());
        values.put(KEY_SEATS  , detail.getSeats());
        values.put(KEY_COSTS   , detail.getCost());
        values.put(KEY_USERID , detail.getUser_id());

        //updating a row
        return db.update(TABLE_CUSTOMER_DETAIL, values, KEY_CUSTOMER_CHOICE_ID + "+?", new String[] { String.valueOf(detail.getCustomer_choice_id())});

    }

    //5.1//Updating a single bus company
    public int updateTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERS_ID , ticket.getUser_id());
        values.put(KEY_CUSTOMERS_CHOICE_ID  , ticket.getCustomer_choice_id());

        //updating a row
        return db.update(TABLE_TICKET, values, KEY_TICKET_ID  + "+?", new String[] { String.valueOf(ticket.getTicket_id())});

    }

    //6//Deleting a single user
    public void deleteUser(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + "=?", new String[] { String.valueOf(user.getUser_id())});
        db.close();


    }
    public boolean checkUser(String trim, String phonenumber) {

        // array of columns to fetch
        String[] columns = {
                KEY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = KEY_PHONE + " = ?";

        // selection argument
        String[] selectionArgs = {phonenumber};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //6//Deleting a single user
    public void deleteBusCompany(BusCompany company){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUSCOMPANY, KEY_BUS_CO_ID + "=?", new String[] { String.valueOf(company.getBus_company_id())});
        db.close();

    }

    //6//Deleting a single user
    public void deleteBus(Bus bus){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUS, KEY_BUS_ID + "=?", new String[] { String.valueOf(bus.getBus_id())});
        db.close();

    }
    //6//Deleting a single customer detail
    public void deleteCustomerDetail(CustomerDetail detail){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CUSTOMER_DETAIL, KEY_CUSTOMER_CHOICE_ID + "=?", new String[] { String.valueOf(detail.getCustomer_choice_id())});
        db.close();


    }
    //6//Deleting a single ticket
    public void deleteTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TICKET, KEY_TICKET_ID + "=?", new String[] { String.valueOf(ticket.getTicket_id())});
        db.close();


    }

}
