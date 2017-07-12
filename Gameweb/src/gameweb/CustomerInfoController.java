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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bo-gu
 */
public class CustomerInfoController implements Initializable  {

    @FXML
    private TableView<Userdetail> tableUser;
    @FXML
    private TableColumn<Userdetail, String> colFname;
    @FXML
    private TableColumn<Userdetail, String> colLname;
    @FXML
    private TableColumn<Userdetail, String> colEmail;
    @FXML
    private TableColumn<Userdetail, String> colUrname;
    @FXML
    private Button loadDataButton;
    @FXML
    private Button backbButton;
    
    private ObservableList<Userdetail>data;
    private dbconnection dc;
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     
    }    

    @FXML
    private void loadDataButtonClicked(ActionEvent event) {
        try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.user");
        
        while (rs.next()){
            data.add(new Userdetail(rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
           
        }
        
        } catch(SQLException ex){
            
             System.err.println("Error" + ex);
        
        }
        
        colFname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colLname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUrname.setCellValueFactory(new PropertyValueFactory<>("urname"));
        
        tableUser.setItems(null);
        tableUser.setItems(data);
        
        
        
    }

    @FXML
    private void backbButtonClicked(ActionEvent event) throws IOException {
         Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
        
    }
    
}
