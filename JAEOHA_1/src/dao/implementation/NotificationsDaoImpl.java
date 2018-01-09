/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.NotificationsDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Notification;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abanoub samy
 */
public class NotificationsDaoImpl extends UnicastRemoteObject implements NotificationsDaoInterface {
    
    NotificationsDaoImpl() throws RemoteException {
        
    }

    @Override
    public boolean insert(Notification t) throws RemoteException {
        
        try (Connection conn = DatabaseConnectionHandler.getConnection(); PreparedStatement pst = conn.prepareStatement("INSERT INTO  notifications "
                + "(notifText) "
                + "values (?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            
            pst.setString(1, t.getNotifText());
            
            pst.executeUpdate();
            
            System.out.println("notification added successfully");
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Error in user insertion");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public Notification select(Notification t) throws RemoteException {
        
        try (Connection conn = DatabaseConnectionHandler.getConnection()) {
            
            ResultSet rs = null;
            Notification n = new Notification();
            
            PreparedStatement pst = conn.prepareStatement("select notifId ,notifText "
                    + "   from notifications  ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            rs = pst.executeQuery();
            
            System.out.println("notifications selected successfully");
            rs.last();
            n.setNotifId(rs.getInt(0));
            n.setNotifText(rs.getString(1));
            
            return  n;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    @Override
    public boolean update(Notification t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean delete(Notification t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Vector<Notification> convertToVector(ResultSet rs) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
