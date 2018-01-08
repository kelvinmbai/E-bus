package strathmore.com.ebus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class DB extends  AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        DatabaseHandler db = new DatabaseHandler(this);
        //Inserting users
        Log.d("Insert: ", "Insert...");

        db.addUser(new Users(1, "Wiltord", "0789008904", "plspro"));

        //Reading all contacts
        Log.d("Reading: ", "Reading.....");
        List<Users> user = db.getAllUsers();

        for (Users u : user) {
            String log = "Id" + u.getUser_id() + " ,Name: " + u.getUser_name() + " ,Phone" + u.getPhonenumber() + " ,Password: " + u.getPassword();
            //Writing contacts to log
            Log.d("Name", log);
        }

        //Inserting bus company
        Log.e("Insert: ", "Insert...");

        db.addBusCompany(new BusCompany(1, "Wagwaan company"));

        //Reading all bus companies
        Log.e("Reading: ", "Reading.....");
        List<BusCompany> company = db.getAllBusCompanies();

        for (BusCompany c : company) {
            String bus = "Id" + c.getBus_company_id() + " ,Name: " + c.getBus_company_name();
            //Writing contacts to log
            Log.e("Work", bus);
        }

        Log.d("Insert: ", "Insert...");

        db.addBus(new Bus(1, 22, 33, "8.15", "12/6/2017", "Kisumu"));

        //Reading all contacts
        Log.d("Reading: ", "Reading.....");
        List<Bus> bus = db.getAllBuses();

        for (Bus u : bus) {
            String log = "Bus company id: " + u.getBus_co_id() + " ,BusId: " + u.getBus_id() + " ,Cost" + u.getCost() + " ,Time of Departure: " + u.getTime_of_departure() + " ,Date of Departure: " + u.getDate_of_departure() + " ,Destination: " + u.getDestination();
            //Writing contacts to log
            Log.d("Worker", log);
        }


        Log.d("Insert: ", "Insert...");

        db.addCustomerDetail(new CustomerDetail(1, "KANAMBO", "MALABA", "8/9/2014", "8.15", 4, 4, 4));

        //Reading all contacts
        Log.d("Reading: ", "Reading.....");
        List<CustomerDetail> detail = db.getAllCustomerDetails();

        for (CustomerDetail c : detail) {
            String log = "Customer choice id: " + c.getCustomer_choice_id() + " ,Bus Co name: " + c.getBus_co_name() + " ,Destination" + c.getDestination() + " ,Date of departure: " + c.getDate() + " ,Time of Departure: " + c.getTime() + " ,Seats: " + c.getSeats() + " ,Cost: " + c.getCost() + " ,Userid: " + c.getUser_id();
            //Writing contacts to log
            Log.d("Worker", log);
        }

        Log.e("Insert: ", "Insert...");

        db.addTicket(new Ticket(1, 2, 3));

        //Reading all contacts
        Log.e("Reading: ", "Reading.....");
        List<Ticket> ticket = db.getAllTickets();

        for (Ticket c : ticket) {
            String log = "Ticket id  : " + c.getTicket_id() + " ,User_id: " + c.getUser_id() + " ,Customer choice Id: " + c.getCustomer_choice_id();
            //Writing contacts to log
            Log.e("Worker", log);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}