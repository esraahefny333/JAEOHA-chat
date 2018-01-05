/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImpl;


import dao.implementation.UserDaoImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.ServerImpl.ServerImpl;

/**
 *
 * @author abanoub samy
 */
public class Server {

    public Server() {

        try {
            ServerImpl obj = new ServerImpl();

            Registry reg = LocateRegistry.createRegistry(5050);

            reg.rebind("chat", obj);//esraa

            System.out.println("bind successfull");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

}
