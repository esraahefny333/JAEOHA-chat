/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.dao.implementation;

import DAL.dao.interfaces.CategoriesInfoDaoInterface;
import databaseclasses.CategoriesInfo;
import databaseclasses.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author abanoub samy
 */
public class CategoriesInfoDaoImpl extends UnicastRemoteObject implements CategoriesInfoDaoInterface{

    
    
    
    
    CategoriesInfoDaoImpl()throws RemoteException
    {
        
    }
    
    
    @Override
    
   public boolean insert(CategoriesInfo t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriesInfo select(CategoriesInfo t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CategoriesInfo t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(CategoriesInfo t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CategoriesInfo> convertToVector(ResultSet rs) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
