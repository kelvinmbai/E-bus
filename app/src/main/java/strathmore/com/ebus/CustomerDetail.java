package strathmore.com.ebus;

/**
 * Created by mambo on 16/12/2017.
 */

public class CustomerDetail {

    int customer_choice_id;
    String bus_co_name;
    String destination;
    String date;
    String time;
    int seats;
    int cost;
    int user_id;
    public CustomerDetail(int customer_choice_id,String bus_co_name,String destination,String date,String time,int seats,int cost,int user_id){
        this.customer_choice_id = customer_choice_id;
        this.bus_co_name = bus_co_name;
        this.destination = destination;
        this.time = time;
        this.date = date;
        this.seats = seats;
        this.cost= cost;
        this.user_id = user_id;
    }
    public CustomerDetail(int customer_choice_id,String bus_co_name,String destination,String date,String time,int user_id){
        this.customer_choice_id = customer_choice_id;
        this.bus_co_name = bus_co_name;
        this.destination = destination;
        this.time = time;
        this.date = date;
        this.user_id = user_id;
    }
    public CustomerDetail(){

    }

    //setters
    public void setCustomer_choice_id(int customer){
        this.customer_choice_id = customer;
    }
    public void setBus_co_name(String busname){
        this.bus_co_name = busname;
    }
    public void setDestination(String des){
        this.destination = des;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setSeats(int seats){
        this.seats = seats;

    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setUser_id(int id){
        this.user_id = id;
    }

    //getters
    public int getCustomer_choice_id(){
        return customer_choice_id;
    }
    public String getBus_co_name(){
        return bus_co_name;
    }
    public String getDestination(){
        return destination;
    }

    public String getTime(){
        return time;
    }
    public String getDate(){
        return date;
    }
    public int getSeats(){
        return seats;
    }
    public int getCost(){
        return cost;
    }
    public int getUser_id(){
        return user_id;
    }


}
