package sample;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm;
    @FXML
    private TextField email;
    @FXML
    private Button register;



    public void buttonClicked(){

        Helper.CreateTable(Helper.ConnectToDatabase());

        boolean valid = true;


            String user = username.getText();



        if(Helper.validateUsername(user) == false){

            System.out.println("The username is not valid");
            valid = false;
        }else{

            System.out.println("The username is valid");
        }

        String pass = password.getText();
        if(Helper.validatePassword(pass) == false){

            System.out.println("The password is not valid");
            valid = false;
        }else{

            System.out.println("The password is valid.");
        }

        String confirmPassword = confirm.getText();


        if(Helper.validateConfirm(pass, confirmPassword)== false){

            System.out.println("The passwords do not match");
            valid = false;
        }else{

            System.out.println("The passwords do indeed match");
        }

        String mail = email.getText();

        System.out.println(valid);

        if(valid == true){

            register.setDisable(true);
            Helper.InsertRecord(Helper.ConnectToDatabase() , user, pass, mail );
        }



    }






}
