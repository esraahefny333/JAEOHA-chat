/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaeoha_1;

import ServerImpl.Server;
import dao.implementation.UserDaoImpl;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Users;
import java.util.Vector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.ServerImpl.ServerImpl;

/**
 *
 * @author esraa
 */

public class JAEOHA_1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        DatabaseConnectionHandler.getConnection();
        
        Users u =new Users();
        u.setUserName("abanoub samy");
        u.setCountry("alex");
        u.setEmail("aub@yahoo.com");
        u.setGender("male");
        u.setPhone("078");
        u.setPhoto(null);
        u.setPassword("47");
        u.setActive(1);
        u.setStatus("available");
       // u.setId(2);
        
        
        
        
        ServerImpl ud = new ServerImpl();
       //ud.insert(u);
       //ud.update(u);
      // ud.delete(u);
//      ud.signUp(u);
//      
//        Vector<Users> v =ud.myFriends(u);
//        System.out.println(v.get(0).getUserName());
//        
//      Vector<Users>v2 = ud.myFriendRequests(u);
//       System.out.println(v2.get(0).getUserName());

Users u7 = new Users();
u7.setEmail("au@yahoo.com");
u7.setPassword("47");
        System.out.println(u7.getActive());

u7=ud.signIn(u7);
if(u7!=null)
{
       
      System.out.println(u7.getActive()); 
}


        new Server();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
