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

       

        Users u = new Users();

        u.setEmail("a@yahoo.com");

        u.setPassword("47");

        ServerImpl ud = new ServerImpl();

        u = ud.signIn(u);
        if (u != null) {

            System.out.println(u.getActive());
        }

        u = ud.changeMyStatus(u, "by");


        System.out.println(u.getStatus());

        new Server();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
