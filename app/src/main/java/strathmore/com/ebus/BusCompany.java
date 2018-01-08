package strathmore.com.ebus;

/**
 * Created by mambo on 16/12/2017.
 */

public class BusCompany {

    int bus_company_id;
    String bus_company_name;



    public BusCompany(int bus_company_id,String bus_company){
        this.bus_company_id = bus_company_id;
        this.bus_company_name = bus_company;


    }
    public BusCompany(int bus_company_id){
        this.bus_company_id = bus_company_id;

    }
    public BusCompany(){

    }

    public void setBus_company_id(int bus_company_id){
        this.bus_company_id = bus_company_id;
    }
    public void setBus_company_name(String bus_company_name){
        this.bus_company_name = bus_company_name;
    }
    public int getBus_company_id(){
        return bus_company_id;
    }
    public String getBus_company_name(){ return bus_company_name;}
}
