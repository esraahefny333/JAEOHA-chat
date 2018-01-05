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
    public Users signUp(Users user) throws RemoteException {
        
        
    
        

        boolean checkIfExist = d.checkUserByEmail(user);
        if (checkIfExist) {
            d.insert(user);
            d.select(user);

            return user;
        } else {

            System.out.println("email is already exist");
            return null;

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

    @Override
    public Users signIn(Users user) throws RemoteException {

       boolean exists = d.checkUserByEmailAndPass(user);
       if(exists)
       {
           
       user= d.select(user);
        user.setActive(1);
        d.update(user);
        return d.select(user);
           
       }
       
       else {
           
           return null;
       }

    }

    @Override
    public Users changeMyStatus(Users user,String status) throws RemoteException {
        
        
        user.setStatus(status);
        
        d.update(user);
        return d.select(user);
        
    }

    
}