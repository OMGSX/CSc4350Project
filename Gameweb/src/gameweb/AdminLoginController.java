/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameweb;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bo-gu
 */
public class AdminLoginController implements Initializable {
    
    @FXML
    private MenuItem logoutButton;
    @FXML
    private MenuButton menuBottonAccount;
    @FXML
    private Button customerInfo;
  
   
    @FXML
    private TableView<gamedetail> gameTable;
    @FXML
    private TableColumn<gamedetail, String> colGameType;
    @FXML
    private TableColumn<gamedetail, String> colGameTitle;
    @FXML
    private TableColumn<gamedetail, String> colDescription;
    @FXML
    private TableColumn<gamedetail, String> colRegularPrice;
    @FXML
    private TableColumn<gamedetail, String> colDiscountedPrice;
    private ObservableList<gamedetail>data;
    private dbconnection dc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    


    private void cartclicked(MouseEvent event) throws IOException {
       Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
    }

    @FXML
    private void logoutClicked(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node)menuBottonAccount).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
    }
   

    private void contactUsClicked(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Contact Us");
                    alert.setHeaderText(null);
                    alert.setContentText("Feel free to contact our support team if you have ANY question."
                            + " \n\n Phone: 123-444-5555 \n Email: gsu@gmail.com");
                    alert.showAndWait();
        
    }

    private void myAccountClicked(ActionEvent event) throws IOException {
        
         Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("myaccount.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node)menuBottonAccount).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
        
    }

    @FXML
    private void customerInfoClicked(ActionEvent event) throws IOException {
         Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("customerInfo.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node)menuBottonAccount).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
        
        
    }

    @FXML
    private void addClicked(MouseEvent event) throws IOException {
        
         Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addpage.fxml"));
        Scene scene = new Scene(root);
        Stage register= (Stage) ((Node)menuBottonAccount).getScene().getWindow(); 
        register.setScene(scene);
        register.show();
        
    }

    @FXML
    private void loadDataClicked(ActionEvent event) {
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item");
        
        while (rs.next()){
            data.add(new gamedetail(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
           
        }
        
        } catch(SQLException ex){
            
             System.err.println("Error" + ex);
        
        }
        
        colGameType.setCellValueFactory(new PropertyValueFactory<>("gameType"));
        colGameTitle.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colRegularPrice.setCellValueFactory(new PropertyValueFactory<>("rPrice"));
        colDiscountedPrice.setCellValueFactory(new PropertyValueFactory<>("dPrice"));
        
        gameTable.setItems(null);
        gameTable.setItems(data);
        
        
    }



}
