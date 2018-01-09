/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.interfaces;

import databaseclasses.Chat;
import databaseclasses.Notification;
import databaseclasses.Users;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author esraa
 */
public interface ServerInterface extends Remote {

    public Users signUp(Users user) throws RemoteException;

    public Users signIn(Users user) throws RemoteException;
    
    public boolean signOut(Users user) throws RemoteException;
    
    
    public boolean checkRequestedOrNot(Users user ,Users retrivedUser)throws RemoteException;
    
    
    public Users selectByEmail(String email) throws RemoteException;

    public Vector<Users> myFriends(Users user) throws RemoteException;

    public Vector<Users> myFriendRequests(Users user) throws RemoteException;

    public Users changeMyStatus(Users user,String status)throws RemoteException;

     public Chat get_individualChat(Users user,Users friend)throws RemoteException;//chat between user and his friend
    public Chat create_individualChat(Users user,Users friend)throws RemoteException;//chat between user and his friend/////lsaaaaaaaa
    
    public ArrayList<Chat> get_allIndividualChats(Users user)throws RemoteException;//l7d dlw2ty m4 hnst5dmha
    public ArrayList<Chat> get_allGroupChats(Users user)throws RemoteException;
    public ArrayList<Chat> get_allRecentChats(Users user)throws RemoteException;

}
