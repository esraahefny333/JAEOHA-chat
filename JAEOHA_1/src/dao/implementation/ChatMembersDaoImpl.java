/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.ChatMembersDaoInterface;
import databaseclasses.ChatMembers;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author abanoub samy
 */
public class ChatMembersDaoImpl extends UnicastRemoteObject implements ChatMembersDaoInterface{
    
    
    ChatMembersDaoImpl()throws RemoteException
    {
        
        
    }

    @Override
    public boolean insert(ChatMembers t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChatMembers select(ChatMembers t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ChatMembers t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ChatMembers t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
