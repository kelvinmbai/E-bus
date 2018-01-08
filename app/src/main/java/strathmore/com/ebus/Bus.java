package strathmore.com.ebus;

/**
 * Created by mambo on 16/12/2017.
 */

public class Bus {

    int Bus_co_id;
    int Bus_id;
    int cost;
    String time_of_departure;
    String date_of_departure;
    String destination;
    public Bus(int bus_co_id,int bus_id,int cost,String departure_time,String departure_date,String destination){
        this.Bus_co_id = bus_co_id;
        this.Bus_id = bus_id;
        this.cost = cost;
        this.time_of_departure = departure_time;
        this.date_of_departure = departure_date;
        this.destination = destination;

    }
    public Bus(int bus_co_id,int bus_id,int cost,String departure_time,String departure_date){
        this.Bus_co_id = bus_co_id;
        this.Bus_id = bus_id;
        this.cost = cost;
        this.time_of_departure = departure_time;
        this.date_of_departure = departure_date;
    }
    public Bus(){

    }
    public void setBus_co_id(int id){
        this.Bus_co_id = id;
    }
    public void setBus_id(int bus_id){
        this.Bus_id = bus_id;
    }
    public void setCost(int cost){
        this.cost = cost;

    }
    public void setTime_of_departure(String time){
        this.time_of_departure = time;
    }
    public void setDate_of_departure(String date){
        this.date_of_departure = date;
    }
    public void setDestination(String des){
        this.destination = des;
    }
    //getters
    public int getBus_co_id(){
        return Bus_co_id;
    }
    public int getBus_id(){
        return Bus_id;
    }
    public int getCost(){
        return cost;
    }
    public String getTime_of_departure(){
        return time_of_departure;
    }
    public String getDate_of_departure(){
        return date_of_departure;
    }
    public String getDestination(){
        return destination;
    }
}
