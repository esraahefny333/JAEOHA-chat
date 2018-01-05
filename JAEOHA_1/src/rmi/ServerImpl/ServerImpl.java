/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.ServerImpl;

import dao.implementation.UserDaoImpl;
import dao.interfaces.DaoInterface;
import databaseclasses.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import rmi.interfaces.ServerInterface;

/**
 *
 * @author esraa
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInterface{
    
        UserDaoImpl d = new UserDaoImpl();
    
    public ServerImpl()throws RemoteException
    {
        
        
    }

    @Override
    public boolean signUp(Users user) throws RemoteException {
        
        
    
        

        boolean checkIfExist = d.checkUserByEmail(user);
        if (checkIfExist) {
            d.insert(user);

            return true;
        } else {

            System.out.println("email is already exist");
            return false;

        }


    
    
}
    
    @Override
    public Vector<Users> myFriends(Users user) throws RemoteException {
        
        return d.getUserFriends(user);
    }

    @Override
    public Vector<Users> myFriendRequests(Users user) throws RemoteException {
        
        return d.getFriendRequests(user);
    }

    
}