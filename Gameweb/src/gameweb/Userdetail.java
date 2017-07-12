/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameweb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bo-gu
 */
public class Userdetail {

    private final StringProperty fname;
    private final StringProperty lname;
    private final StringProperty email;
    private final StringProperty urname;

    //Dafault constructor
    public Userdetail(String fname, String lname, String email, String urname) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.email = new SimpleStringProperty(email);
        this.urname = new SimpleStringProperty(urname);

    }

       //Getters
    public String getFname() {
        return fname.get();
    }

    public String getLname() {
        return lname.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getUrname() {
        return urname.get();
    }
    
    //Setters
    
    public void setFname(String value) {
        fname.set(value);
    }

    public void setLname(String value) {
        lname.set(value);
    }

    public void setEmail(String value) {
         email.set(value);
    }

    public void setUrname(String value) {
        urname.set(value);
    }
//values of property
    
    
    public StringProperty fnameProperty(){
    return fname;
    }
     public StringProperty lnameProperty(){
    return lname;
    }
      public StringProperty emailProperty(){
    return email;
    }
       public StringProperty urnameProperty(){
    return urname;
    }
    
    
}
