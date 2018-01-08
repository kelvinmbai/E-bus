package strathmore.com.ebus;

/**
 * Created by mambo on 16/12/2017.
 */

public class Users {

    int user_id;
    String user_name;
    String phonenumber;
    String password;


    public Users(int id,String uname,String phone,String pass){

        this.user_id = id;
        this.user_name = uname;
        this.phonenumber = phone;
        this.password = pass;

    }


    public Users(int id,String uname,String phone){

        this.user_id = id;
        this.user_name = uname;
        this.phonenumber = phone;

    }

    public Users(){

    }

    public void setUser_id(int user){
        this.user_id = user;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;

    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;

    }
    public void setPassword(String password){
        this.password = password;
    }
    //Getters
    public int getUser_id(){
        return user_id;
    }
    public String getUser_name(){
        return user_name;
    }
    public String getPassword(){
        return password;
    }
    public String getPhonenumber(){
        return phonenumber;
    }

}
