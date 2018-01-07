/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.dao.interfaces;

import databaseclasses.Chat;
import databaseclasses.Message;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author omnia samy
 */
public interface MessagesDaoInterface extends DaoInterface<Message>{
    
   public ArrayList<Message> selectChatMessage(Chat c,Integer from,Integer to) throws RemoteException;
        
    
}
