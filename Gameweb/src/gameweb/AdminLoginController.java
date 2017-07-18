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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private MenuItem under5;
    @FXML
    private MenuItem under10;
    @FXML
    private MenuItem seeAll;
    @FXML
    private TextField searchField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void under5Clicked(ActionEvent event) {
        
          try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE discounted_price <5");
        
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
       
        // TODO
    }    
        
    
    @FXML
    private void under10Clicked(ActionEvent event) {
        
       try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE discounted_price <10");
        
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

    @FXML
    private void seeAllClicked(ActionEvent event) {
        
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

    @FXML
    private void actionClicked(ActionEvent event) {
        
        try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'action' ");
        
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

    @FXML
    private void a_aClicked(ActionEvent event) {
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Action-adventure' ");
        
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

    @FXML  
    private void advClicked(ActionEvent event) {
        
          try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'adventure' ");
        
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

    @FXML
    private void rollpClicked(ActionEvent event) {
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Role-playing' ");
        
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

    @FXML
    private void simulClicked(ActionEvent event) {
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Simulation' ");
        
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

    @FXML
    private void strategyClicked(ActionEvent event) {
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Strategy' ");
        
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

    @FXML
    private void sportClicked(ActionEvent event) {
        
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Sports' ");
        
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

    @FXML
    private void otherClicked(ActionEvent event) {
        
         try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE game_type = 'Other games' ");
        
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

    @FXML
    private void under20Clicked(ActionEvent event) {
        
        try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE discounted_price <20");
        
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

    @FXML
    private void under30Clicked(ActionEvent event) {
        
        try{
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE discounted_price <30");
        
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

    @FXML
    private void over30Clicked(ActionEvent event) {
        
        try{
            
       Connection conn = dbconnection.getConnection();
        data = FXCollections.observableArrayList();
        
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM gameweb.item WHERE discounted_price > 30");
        
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

    @FXML
    private void searchClicked(ActionEvent event) throws SQLException {
        String searching= searchField.getText();
        
        try{
            
            Connection conn = dbconnection.getConnection();								
		PreparedStatement ps = dbconnection.getConnection().prepareStatement("SELECT * FROM gameweb.item WHERE game_type LIKE ? OR game_title LIKE ? "
                                                                                + "OR description LIKE ? OR regular_price LIKE ? OR discounted_price LIKE ?");//check the user name and password
		ps.setString(1,"%"+searching+"%");
                ps.setString(2,"%"+searching+"%");
                ps.setString(3,"%"+searching+"%");
                ps.setString(4,"%"+searching+"%");
                ps.setString(5,"%"+searching+"%");
                              
                      
              data = FXCollections.observableArrayList();
                
             ResultSet rs = ps.executeQuery(); 
        
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
        searchField.setText(null);
        
        
    }

    @FXML
    public void refreshClicked(ActionEvent event) {
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
