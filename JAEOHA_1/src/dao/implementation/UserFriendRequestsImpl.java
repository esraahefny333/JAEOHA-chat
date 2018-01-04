/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.UserFriendRequestsInterface;
import databaseclasses.UserFriendRequests;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author abanoub samy
 */
public class UserFriendRequestsImpl extends UnicastRemoteObject implements UserFriendRequestsInterface{
    
    UserFriendRequestsImpl()throws RemoteException
    {
        
        
    }

    @Override
    public boolean insert(UserFriendRequests t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserFriendRequests select(UserFriendRequests t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserFriendRequests t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UserFriendRequests t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
