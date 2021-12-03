package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;


public class Controller {
    public TextField FName;
    public TextField LName;
    public TextField PhoneNum;
    public TextField Email;
    public TextField UName;
    public TextField pWord;
    public TextField SAddress;
    public Button doIt;
    public Button LoginButton;
    public Button RegisterButton;
    public Label WelcomeLabel;
    public TextField UserText;
    public TextField PassText;
    public Button GoToPage;
    public Label Notify;
    public Label NoReg;
    public Button goBack;
    public Button CreateAccount;
    public Label EmpLoginWarning;


    public void Welcome(ActionEvent actionEvent) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("LoginOrRegister.fxml"));
        Scene R1Scene = new Scene(root1);
        Stage stage1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage1.setScene(R1Scene);
        stage1.setTitle("Welcome");
        stage1.show();

    }


    public void Log(ActionEvent actionEvent) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
        Scene R2Scene = new Scene(root2);
        Stage stage2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage2.setTitle("Enter the following to proceed");
        stage2.setScene(R2Scene);
        stage2.show();


    }


    public void Create(ActionEvent actionEvent) throws Exception {
        Parent root3 = FXMLLoader.load(getClass().getResource("CustomerRegister.fxml"));
        Scene R3Scene = new Scene(root3);
        Stage stage3 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage3.setScene(R3Scene);
        stage3.setTitle("Create an Account");
        stage3.show();


    }

    public void EmpLoginScreen(ActionEvent actionEvent) throws Exception {
        Parent root4 = FXMLLoader.load(getClass().getResource("EmpLogin.fxml"));
        Scene R4Scene = new Scene(root4);
        Stage stage4 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage4.setScene(R4Scene);
        stage4.setTitle("Employee Login");
        stage4.show();
    }
    public void ELogin(ActionEvent actionEvent) throws IOException {
        Parent root5 = FXMLLoader.load(getClass().getResource("EmpView.fxml"));
        Scene R4Scene = new Scene(root5);
        Stage stage5 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage5.setScene(R4Scene);
        stage5.setTitle("Employee View");
        stage5.show();



    }

    public void GoToMenuScreen(ActionEvent actionEvent) throws IOException {
        Parent root6 = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
        Scene R5Scene = new Scene(root6);
        Stage stage6 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage6.setScene(R5Scene);
        stage6.setTitle("MenuScreen");
        stage6.show();

    }
    ///////////  Cart Page  //////


    public void GoToCart(ActionEvent actionEvent) throws Exception {
        Parent root7 = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        Scene R6Scene = new Scene(root7);
        Stage stage7 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage7.setScene(R6Scene);
        stage7.setTitle("Cart");
        stage7.show();

    }
    ///////////





    public void CheckLogin(ActionEvent actionEvent) {
        String UT = UserText.getText();
        String PT = PassText.getText();
        Notify.setText(null);

        if (UT.isBlank() || PT.isBlank()) {
            Notify.setText("No UserName or Password");
        }
        else {
            Notify.setText(null);
            try {
                BufferedReader BR1 = new BufferedReader(new FileReader("UserName.txt"));
                BufferedReader BR2 = new BufferedReader(new FileReader("Password.txt"));
                Scanner URead = new Scanner(BR1);
                Scanner PRead = new Scanner(BR2);
                String R1, R2;
                while(URead.hasNextLine() && PRead.hasNextLine()){
                    R1=URead.nextLine();
                    R2=PRead.nextLine();

                    if(R1.equals(UT) && R2.equals(PT)){

                        GoToMenuScreen(actionEvent);
                    }
                }
                Notify.setText("Username or Password are incorrect");




            }
            catch (IOException E){
                E.printStackTrace();
            }







        }


    }

    public void CheckReg(ActionEvent actionEvent) throws Exception {


        if (UName.getText().isBlank() || pWord.getText().isBlank()) {
            NoReg.setText("Username and Password must be filled");

        } else {
            String Us = UName.getText();
            String Pw = pWord.getText();

            try {
                FileWriter U = new FileWriter("UserName.txt", true);
                FileWriter P = new FileWriter("Password.txt", true);
                BufferedWriter UBW = new BufferedWriter(U);
                UBW.write(Us);
                UBW.newLine();
                UBW.close();

                BufferedWriter PBW = new BufferedWriter(P);
                PBW.write(Pw);
                PBW.newLine();
                PBW.close();
                NoReg.setText("Account created");
                Log(actionEvent);

            } catch (IOException E) {
                E.printStackTrace();

            }
        }


    }



    public void jumpToEmp(ActionEvent actionEvent) throws Exception{
        String EuN= UserText.getText();
        String EpN = PassText.getText();

        if((EuN.equals("CheckEmp100") && EpN.equals("EmpPizza001") ) ||(EuN.equals("MSingh101")&& EpN.equals("EmpPizza002") ) ||(EuN.equals("JimTa491") && EpN.equals("EmpPizza3") )){
            ELogin(actionEvent);
        }
        else{
            EmpLoginWarning.setText("Please Log in with your UserName and Password");

        }
    }


}



