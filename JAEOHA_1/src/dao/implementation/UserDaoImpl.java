/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.UserDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

/**
 *
 * @author abanoub samy
 */
public class UserDaoImpl  extends UnicastRemoteObject implements UserDaoInterface{

    public UserDaoImpl() throws RemoteException{
    }

    
    
    @Override
    public boolean signUp(Users user) throws RemoteException{
        
        
      return true;
    }

    @Override
    public boolean insert(Users t) throws RemoteException{
        
        return true;
    }

    @Override
    public Users select(Users t) throws RemoteException{
        
        return t;
    }
    
    
    

    @Override
    public boolean update(Users t)throws RemoteException{
        
        
        return true;
    }

    @Override
    public boolean delete(Users t)throws RemoteException{
        
        return true;
    }
    
}
