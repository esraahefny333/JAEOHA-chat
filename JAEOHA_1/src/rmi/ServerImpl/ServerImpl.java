/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.ServerImpl;

import dao.implementation.ChatDaoImpl;
import dao.implementation.UserDaoImpl;
import dao.implementation.UserFriendReqDaoImpl;
import dao.interfaces.DaoInterface;
import databaseclasses.Chat;
import databaseclasses.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Vector;
import rmi.interfaces.ServerInterface;

/**
 *
 * @author esraa
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

    UserDaoImpl u ;
    ChatDaoImpl chat;
    
    UserFriendReqDaoImpl  fr = new UserFriendReqDaoImpl();

    public ServerImpl() throws RemoteException {
         u= new UserDaoImpl();
        chat=new ChatDaoImpl();
    }

    @Override
    public Users signUp(Users user) throws RemoteException {

        boolean checkIfExist = u.checkUserByEmail(user);
        if (checkIfExist) {

            //set user to be online 
            user.setActive(1);
            //set status to be available
            user.setStatus("available");

            u.insert(user);

            return u.select(user);
        } else {

            System.out.println("email is already exist");

            return null;

        }

    }

    @Override
    public Users signIn(Users user) throws RemoteException {

        boolean exists = u.checkUserByEmailAndPass(user);
        if (exists) {

            user = u.select(user);

            //set user to be online
            user.setActive(1);
            u.update(user);

            return u.select(user);

        } else {

            return null;
        }

    }

    @Override
    public boolean signOut(Users user) throws RemoteException {
        try {

            user.setActive(0);
            u.update(user);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Users changeMyStatus(Users user, String status) throws RemoteException {

        user.setStatus(status);

        u.update(user);
        return u.select(user);

    }

    @Override
    public Users selectByEmail(String email) throws RemoteException {

        Users u = new Users();

        u.setEmail(email);
        System.out.println(u.getEmail());

       return this.u.select(u);

    }
    
    
    
    
    @Override
    public boolean checkRequestedOrNot(Users user, Users retrivedUser) throws RemoteException {
        
        if(fr.checkIfRequested(user.getId(),retrivedUser.getId()))
        {
            
            return  true;
        }
        else
        {
            return  false;
        }
        
        
    }
    
    

    @Override
    public Vector<Users> myFriends(Users user) throws RemoteException {

        return u.getUserFriends(user);
    }

    @Override
    public Vector<Users> myFriendRequests(Users user) throws RemoteException {

        return u.getFriendRequests(user);
    }

    
     @Override
    public ArrayList<Chat> get_allIndividualChats(Users user)throws RemoteException {
 
        return chat.select_allChats(user,"0");
    }
 @Override
    public ArrayList<Chat> get_allGroupChats(Users user)throws RemoteException {
 
        return chat.select_allChats(user,"1");
    }

    @Override
    public ArrayList<Chat> get_allRecentChats(Users user) throws RemoteException {
        return chat.select_allRecentChats(user);
    }

     public Chat get_individualChat(Users user,Users friend)throws RemoteException//chat between user and his friend
     {
         return chat.select_individualChat(user,friend); 
     }
    public Chat create_individualChat(Users user,Users friend)throws RemoteException//chat between user and his friend
     {
         System.err.println("hnaa");
        Chat c=null;
          if(chat.insert_individualChat(user,friend)==1)
          {
              c=get_individualChat(user,friend);
          }
          return c;
     }
    

}
