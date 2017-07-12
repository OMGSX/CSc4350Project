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
public class CurrentUserId {
   static public String CurrentUserId = null;
	
	static public void LogOut(){
		CurrentUserId = null;
	}
}

