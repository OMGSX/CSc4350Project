/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameweb;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bo-gu
 */
public class MyaccountController implements Initializable {

    @FXML
    private PasswordField currentPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmNewPassword;
    @FXML
    private TextField EmailAddress;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateButtonClicked(ActionEvent event) throws SQLException, IOException {
        
     String cPassword = CurrentPass.CurrentPS;
     String currentP = currentPassword.getText();
      String npword=newPassword.getText();
      String confirmnpword=confirmNewPassword.getText();
      String email=EmailAddress.getText();
      String currentUserId = CurrentUserId.CurrentUserId;
      
                 
      
      if(currentP.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your current password");
                    alert.showAndWait();
          
      }
      
       else if(npword.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your new password");
                    alert.showAndWait();
          
      }
       
       else if(confirmnpword.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your confirm password");
                    alert.showAndWait();
          
      }
      
      
      else if(email.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Email Address");
                    alert.showAndWait();
          
      }
     
      else if(!email.contains("@")){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Email address error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please write a correct email form include @ \n ex) 1234@gmail.com");
                    alert.showAndWait();
                    currentPassword.setText(null);
                    newPassword.setText(null);
                    confirmNewPassword.setText(null);
                    EmailAddress.setText(null);
                }
      
      else  if(!email.contains(".")){
                
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Email address Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please write a correct email form include .com or .net etc. \n ex) 1234@gmail.com");
                    alert.showAndWait();
                    currentPassword.setText(null);
                    newPassword.setText(null);
                    confirmNewPassword.setText(null);
                    EmailAddress.setText(null);
                }
      
       else if(!confirmnpword.equals(npword)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Password matching error");
                    alert.setHeaderText(null);
                    alert.setContentText("Password does not match. Please try again");
                    alert.showAndWait();
                    currentPassword.setText(null);
                    newPassword.setText(null);
                    confirmNewPassword.setText(null);
       }
       
              else if(!cPassword.equals(currentP)){
          
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Your current password is not correct. Please try again");
                    alert.showAndWait();
                    currentPassword.setText(null);
                    newPassword.setText(null);
                    confirmNewPassword.setText(null);
                    
      
      }
       
       
       
      else{
       
      Connection conn = dbconnection.getConnection();
		 PreparedStatement ps = conn.prepareStatement("UPDATE gameweb.user SET email=?,password=? WHERE user_id=?");
                       ps.setString(1,email);
                       ps.setString(2,npword);
                       ps.setString(3,currentUserId);
		       ps.execute();
                       
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Update Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Your new informations were saved.");
                    alert.showAndWait();
                    
        Stage stage=new Stage(); //go to main page
                      Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
                      Scene scene = new Scene(root);
                      Stage logIn= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                      logIn.setScene(scene);
                      logIn.show();
      
      }
      
  
       
    }

    @FXML
    private void backButtonClicked(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
        
        
    }
    
}
