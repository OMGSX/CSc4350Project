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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.text.DefaultCaret;

/**
 * FXML Controller class
 *
 * @author bo-gu
 */
public class AddpageController implements Initializable {

    
    
            
    @FXML
    private Button addButton;
    @FXML
    private Button cancel;
    @FXML
    private TextField gameType;
    @FXML
    private TextField gameTitle;
    @FXML
    private TextArea description;
    @FXML
    private TextField regularPrice;
    @FXML
    private TextField discountedPrice;
    @FXML
    private AnchorPane addPane;
    @FXML
    private ComboBox gameTypeBox;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      gameTypeBox.getItems().addAll(
               "Action",
               "Action-adventure", 
              "Role-playing",
              "Simulation", 
              "Strategy", 
              "Sports", 
              "Other games" 
);
    }    

    @FXML
    private void addButtonClicked(ActionEvent event) throws IOException {
                
        String gtype = gameTypeBox.getValue().toString();
        String gtitle = gameTitle.getText();
        String desc = description.getText();                     
        String regularP= regularPrice.getText();
        String discountedP= discountedPrice.getText();
        
        
        try {
           
                                  
            if(gtype.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type the game type.");
                    alert.showAndWait();
            }
            else if(gtitle.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type the game title.");
                    alert.showAndWait();
            }
           
           
            else if(desc.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the description of the game.");
                    alert.showAndWait();
            }
            else if(regularP.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type the regular price.");
                    alert.showAndWait();
            }
            else if(discountedP.trim().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please type the discounted price.");
                    alert.showAndWait();
            }
            
                         
         else {
                
                 Connection conn = dbconnection.getConnection();
		 PreparedStatement ps = conn.prepareStatement("INSERT INTO gameweb.item(game_type,game_title,description,regular_price,discounted_price) VALUES (?,?,?,?,?)");
                       ps.setString(1,gtype);
                       ps.setString(2,gtitle);
		       ps.setString(3,desc);
                       ps.setString(4,regularP);
                       ps.setString(5,discountedP);
                       ps.execute();
                       
                                                                                           
		     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration information");
                    alert.setHeaderText(null);
                    alert.setContentText("Registration Successful!!");
                    alert.showAndWait();
                    
                    Stage stage=new Stage(); //go to main page
                      Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
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
        
        @FXML
    private void cancelClicked(ActionEvent event) throws IOException {
        
        Stage stage=new Stage(); 
                      Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
                      Scene scene = new Scene(root);
                      Stage logIn= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                      logIn.setScene(scene);
                      logIn.show();
        
    }
    
}
