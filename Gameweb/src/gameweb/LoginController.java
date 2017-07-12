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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author bo-gu
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button adminLogin;
    
    
    
    @FXML
    private void loginButtonClicked(ActionEvent event) throws SQLException, Exception{
        
     String urname=username.getText();
     String pword=password.getText();
      
      
            try{
                            
            
            Connection conn = dbconnection.getConnection();								
		PreparedStatement ps = dbconnection.getConnection().prepareStatement("SELECT user_id, password FROM gameweb.user WHERE user_name=? AND password=?");//check the user name and password
				
		ps.setString(1,urname);
                ps.setString(2,pword);
             
                ResultSet rs = ps.executeQuery();
               						
		if( rs.next() ){
		String currentUserId = rs.getString(1);
                CurrentUser.CurrentUserId = currentUserId;
                String cPassword = rs.getString(2);                
		CurrentPass.CurrentPS=cPassword;  
                
                       
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login information");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successful!!  Welcome!!");
                    alert.showAndWait();
                    
                 Stage stage=new Stage(); //go to main page
                      Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
                      Scene scene = new Scene(root);
                      Stage logIn= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                      logIn.setScene(scene);
                      logIn.show();
                     
											
				}
		else{
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invaild username/password combination. Please try again.");
                    alert.showAndWait();
                                                  
                        password.setText(null);
						
						}
					
						
			} catch (SQLException e1) {
						// TODO Auto-generated catch block
			e1.printStackTrace();
			}
    }
    
    @FXML
    private void registerButtonClicked(ActionEvent event) throws IOException {
      
             Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
     
    }
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void loginButtonClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void adminLoginClicked(ActionEvent event) throws IOException {
        
        String urname=username.getText();
        String pword=password.getText();
      
      
            try{
                            
            
            Connection conn = dbconnection.getConnection();								
		PreparedStatement ps = dbconnection.getConnection().prepareStatement("SELECT user_id, password FROM gameweb.user WHERE user_name=? AND password=?");//check the user name and password
				
		ps.setString(1,urname);
                ps.setString(2,pword);
             
                ResultSet rs = ps.executeQuery();
               						
		if( rs.next() && urname.equals("admin") ){
		String currentUserId = rs.getString(1);
                CurrentUser.CurrentUserId = currentUserId;
                String cPassword = rs.getString(2);                
		CurrentPass.CurrentPS=cPassword;  
                
                       
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Administration Login information");
                    alert.setHeaderText(null);
                    alert.setContentText("Administration Login Successful!");
                    alert.showAndWait();
                    
                 Stage stage=new Stage(); 
                      Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
                      Scene scene = new Scene(root);
                      Stage logIn= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                      logIn.setScene(scene);
                      logIn.show();
                     
											
				}
		else{
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login Error");
                    alert.setHeaderText(null);
                    alert.setContentText("If are not an Administrator, please use log-in button above.");
                    alert.showAndWait();
                                                  
                        password.setText(null);
						
						}
					
						
			} catch (SQLException e1) {
						// TODO Auto-generated catch block
			e1.printStackTrace();
			}
    }
        
    }

    
    

