/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.UserFriendReqDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.UserFriendRequests;
import databaseclasses.Users;
import java.rmi.RemoteException;
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
public class UserFriendReqDaoImpl implements UserFriendReqDaoInterface{

    
    
    
     @Override
    public boolean checkIfRequested(int userId,int userRetrievedId) throws RemoteException {
        
        
        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select * from user_friend_requests where senderId = ? and recieverId = ? ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, userId);
            pst.setInt(2, userRetrievedId);

            rs = pst.executeQuery();
            if (rs.next()) {
                return true;

            } else {

                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
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

    @Override
    public Vector<UserFriendRequests> convertToVector(ResultSet rs) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
