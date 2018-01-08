package strathmore.com.ebus;

/**
 * Created by mambo on 16/12/2017.
 */

public class Ticket {

    int ticket_id;
    int user_id;
    int customer_choie_id;

    public Ticket(int t, int u,int c){
        this.ticket_id=t;
        this.user_id=u;
        this.customer_choie_id =c;

    }
    public Ticket(int ticket,int user_id){
        this.ticket_id = ticket;
        this.user_id=user_id;

    }

    public Ticket() {

    }

    public void setTicket_id(int ticket){
        this.ticket_id = ticket;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;

    }
    public void setCustomer_choice_id(int customer){
        this.customer_choie_id = customer;
    }

    //getters
    public int getTicket_id(){
        return ticket_id;
    }
    public int getUser_id(){
        return user_id;
    }
    public int getCustomer_choice_id(){
        return customer_choie_id;
    }


}
