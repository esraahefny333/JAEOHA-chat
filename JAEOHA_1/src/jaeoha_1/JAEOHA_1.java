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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        u.setEmail("abanoub@yahoo.com");
        u.setGender("male");
        u.setPhone("0125478");
        u.setPhoto(null);
        u.setPassword("4587");
        u.setActive(1);
        u.setStatus("available");
       // u.setId(2);
        
        
        
        
        UserDaoImpl ud = new UserDaoImpl();
       //ud.insert(u);
       //ud.update(u);
      // ud.delete(u);
      ud.signUp(u);
       
        
        new Server();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
