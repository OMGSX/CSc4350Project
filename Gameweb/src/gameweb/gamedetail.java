/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameweb;

/**
 *
 * @author bo-gu
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bo-gu
 */
public class gamedetail {

    private final StringProperty gameType;
    private final StringProperty gameTitle;
    private final StringProperty description;
    private final StringProperty rPrice;
    private final StringProperty dPrice;

    //Dafault constructor
    public gamedetail(String gameType, String gameTitle, String description, String rPrice, String dPrice) {
        this.gameType = new SimpleStringProperty(gameType);
        this.gameTitle = new SimpleStringProperty(gameTitle);
        this.description = new SimpleStringProperty(description);
        this.rPrice = new SimpleStringProperty(rPrice);
        this.dPrice = new SimpleStringProperty(dPrice);


    }

       //Getters
    public String getGameType() {
        return gameType.get();
    }

    public String getGameTitle() {
        return gameTitle.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getRprice() {
        return rPrice.get();
    }
    public String getDprice() {
        return dPrice.get();
    }
    
    //Setters
    
    public void setGameType(String value) {
        gameType.set(value);
    }

    public void setGameTitle(String value) {
        gameTitle.set(value);
    }

    public void setDescription(String value) {
         description.set(value);
    }

    public void setRprice(String value) {
        rPrice.set(value);
    }
    public void setDprice(String value) {
        dPrice.set(value);
    }
//values of property
    
    
    public StringProperty gameTypeProperty(){
    return gameType;
    }
     public StringProperty gameTitleProperty(){
    return gameTitle;
    }
      public StringProperty descriptionProperty(){
    return description;
    }
       public StringProperty rPriceProperty(){
    return rPrice;
    }
       public StringProperty dPriceProperty(){
    return dPrice;
    }
    
    
}
