/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.dao.interfaces;

import databaseclasses.Notification;
import databaseclasses.User;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author abanoub samy
 */
public interface UserDaoInterface extends DaoInterface<User>{
    
    public ArrayList<User> getUserFriends(User user)throws RemoteException;
    
    public ArrayList<User> getFriendRequests(User user)throws RemoteException;
    
   
    public boolean checkUserByEmail(User user)throws RemoteException;
    
    public boolean checkUserByEmailAndPass(User user)throws RemoteException;
    
    
    
    
    
    
}
