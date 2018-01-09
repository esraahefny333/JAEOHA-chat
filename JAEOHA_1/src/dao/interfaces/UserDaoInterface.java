/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import databaseclasses.Notification;
import databaseclasses.Users;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author abanoub samy
 */
public interface UserDaoInterface extends DaoInterface<Users>{
    
    public Vector<Users> getUserFriends(Users user)throws RemoteException;
    
    public Vector<Users> getFriendRequests(Users user)throws RemoteException;
    
    
    public Vector<Notification>getMyNotifications(Users user)throws RemoteException;
    
   
    public boolean checkUserByEmail(Users user)throws RemoteException;
    
    public boolean checkUserByEmailAndPass(Users user)throws RemoteException;
    
    
    
    
    
    
    
    
}
