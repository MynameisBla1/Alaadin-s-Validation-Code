package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {


    public static Connection ConnectToDatabase(){
        try{

            Connection conn =
                    DriverManager.getConnection("JDBC:sqlite:testjava.db");
                    return conn;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
           return null;

        }


    }

    public static boolean CreateTable(Connection conn){
        try{

            Statement query = conn.createStatement();

            query.execute("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT, email TEXT)");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " +  e.getMessage());

            return false;
        }




    }

    public static boolean InsertRecord(Connection conn, String username, String password, String email){

        try{

            Statement query = conn.createStatement();
            query.execute("INSERT INTO users VALUES('username','password','email')");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;


        }
    }

    public static boolean validateUsername(String username){

        String regex = "^[A-Za-z]\\w{5,29}$";


        Pattern p = Pattern.compile(regex);

        if(username == null){

            return false;
        }

        Matcher m = p.matcher(username);

        return m.matches();

    }
    public static boolean validatePassword(String password){


        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
        Pattern p = Pattern.compile(regex);
        if(password == null){

            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();


    }

    public static boolean validateConfirm(String a, String b){

        if(a.equals(b)){

            return true;
        }else{
            return false;
        }

    }

    public static boolean validateEmail(String email){

        String regex = "^(.+)@(.+)$";

        Pattern p = Pattern.compile(regex);

        if(email == null){

            return false;
        }
        Matcher m = p.matcher(email);

        return m.matches();

    }
}







