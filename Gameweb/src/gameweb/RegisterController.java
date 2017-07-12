/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameweb;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static gameweb.dbconnection.conn;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author bo-gu
 */
public class RegisterController implements Initializable {

    private Connection connection;
    @FXML
    private AnchorPane registerPane;
    @FXML
    private Button registerBack;
    @FXML
    private TextField firstname, lastname, email, username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField ConfirmPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void backToLogin(ActionEvent event) throws IOException {
                
             Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
    }

    @FXML
    private void register_submit(ActionEvent event) throws SQLException, Exception {
        
        String fname= firstname.getText();
        String lname = lastname.getText();
        String mailad= email.getText();
        String urname= username.getText();
        String pword= password.getText();
        String confirm=ConfirmPassword.getText();
        
        try {
           
                                  
            if(fname.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your First name.");
                    alert.showAndWait();
            }
            else if(lname.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Last name.");
                    alert.showAndWait();
            }
            else  if(!mailad.contains("@")){
                
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please write a correct email form include @ \n ex) 1234@gmail.com");
                    alert.showAndWait();
                    
                        email.setText(null);
                        password.setText(null);
                        ConfirmPassword.setText(null);
                }
            else  if(!mailad.contains(".")){
                
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please write a correct email form include .com or .net etc. \n ex) 1234@gmail.com");
                    alert.showAndWait();
                        email.setText(null);
                        password.setText(null);
                        ConfirmPassword.setText(null);
                }
            else if(mailad.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Email Address.");
                    alert.showAndWait();
            }
            else if(urname.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Username.");
                    alert.showAndWait();
            }
             else if(urname.contains(" ")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("You can't have space on username. Please try again.");
                    alert.showAndWait();
            }
            
           else if(pword.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Password.");
                    alert.showAndWait();
            }
           else if(confirm.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type your Password Confirm.");
                    alert.showAndWait();
            }
             else if(!confirm.equals(pword)){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Password does not match. Please try again.");
                    alert.showAndWait();
                    password.setText(null);
                    ConfirmPassword.setText(null);
                    }
             
            else {
                
                 Connection conn = dbconnection.getConnection();
		 PreparedStatement ps = conn.prepareStatement("INSERT INTO gameweb.user(first_name,last_name,email,user_name,password) VALUES (?,?,?,?,?)");
                       ps.setString(1,fname);
                       ps.setString(2,lname);
		       ps.setString(3,mailad);
                       ps.setString(4,urname);
                       ps.setString(5,pword);
                       ps.execute();
                       
                  PreparedStatement ps1 = conn.prepareStatement("SELECT user_id, password FROM gameweb.user WHERE user_name='"+urname+"' AND password='"+pword+"'");
				ResultSet rs = ps1.executeQuery();
				rs.next();
				String currentUserId = rs.getString(1);
                                CurrentUserId.CurrentUserId = currentUserId;
                                String cPassword = rs.getString(2);                
                                    CurrentPass.CurrentPS=cPassword;                                                       
				
                                                                                              
		     Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Registration information");
                    alert.setHeaderText(null);
                    alert.setContentText("Registration Successful!!");
                    alert.showAndWait();
                    
                    Stage stage=new Stage(); //go to main page
                      Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                      Scene scene = new Scene(root);
                      Stage logIn= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                      logIn.setScene(scene);
                      logIn.show();
                    
                               
            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        
        
    }                                               
       
               
    }
    
    
   
