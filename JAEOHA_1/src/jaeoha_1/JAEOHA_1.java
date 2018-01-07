/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaeoha_1;

import ServerImpl.Server;
import DAL.dao.implementation.UserDaoImpl;
import DAL.connection.DatabaseConnectionHandler;
import databaseclasses.User;
import java.util.Vector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import RMI.ServerImpl.ServerImpl;
import databaseclasses.Chat;
import java.util.ArrayList;
import javafx.scene.layout.Pane;

/**
 *
 * @author esraa
 */

public class JAEOHA_1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Pane pane=new Pane();
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.show();
        
        ServerImpl server=new ServerImpl();
        User user=new User();
        user.setId(4);
        user.setUserName("esraa");
         User friend=new User();
        friend.setId(6);
        friend.setUserName("basma");
     //   ArrayList<Chat>chats= server.get_allRecentChats(user);
     Chat c=server.create_individualChat(user, friend);
     //  for(int i=0;i<chats.size();i++)
        {
            System.err.println(c.getChatId());
            System.err.println(c.getChatName());
            System.err.println(c.getChatType());
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
