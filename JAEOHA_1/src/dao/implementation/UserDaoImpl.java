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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abanoub samy
 */
public class UserDaoImpl extends UnicastRemoteObject implements UserDaoInterface {

    public UserDaoImpl() throws RemoteException {
    }

    @Override
    public boolean signUp(Users user) throws RemoteException {

        boolean checkIfExist = checkUserByEmail(user.getEmail());
        if (checkIfExist) {
            insert(user);

            return true;
        } else {

            System.out.println("email is already exist");
            return false;

        }

    }
    
    
    // check user if exists

    @Override
    public boolean checkUserByEmail(String email) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()){
            
            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select * from users where email = ? ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, email);

            rs = pst.executeQuery();
            if (rs.next()) {
                return false;

            } else {

                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    @Override
    public boolean insert(Users t) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()){

            PreparedStatement pst = conn.prepareStatement("INSERT INTO  users"
                    + "( userName ,email,phoneNo,gender,country,password,status,photo,active) "
                    + "values (?,?,?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, t.getUserName());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getPhone());
            pst.setString(4, t.getGender());
            pst.setString(5, t.getCountry());
            pst.setString(6, t.getPassword());
            pst.setString(7, t.getStatus());
            pst.setBlob(8, (Blob) t.getPhoto());
            pst.setInt(9, t.getActive());

            pst.executeUpdate();

            System.out.println("user added successfully");

            return true;
        } catch (SQLException ex) {
            System.out.println("Error in user insertion");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Users select(Users t) throws RemoteException {

//        try {
//            Connection conn = DatabaseConnectionHandler.getConnection();
//            ResultSet rs = null;
//
//            PreparedStatement pst = conn.prepareStatement("select userName ,email,phoneNo,gender,"
//                    + "country,status,photo,active"
//                    + "   from users where id = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            pst.setInt(1,2 );
//            
//           rs= pst.executeQuery();
//           
//            System.out.println("user selected successfully");
//            
//            
//            
//            
//            return t;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return t;
    }

    @Override
    public boolean update(Users t) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()){
            PreparedStatement pst = conn.prepareStatement(" update  users set  userName = ? , email = ? ,"
                    + " phoneNo = ? , gender = ? , country = ? , password = ? ,  "
                    + "status = ? , photo = ?  "
                    + "  where id = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, "samy");
            pst.setString(2, "samy");
            pst.setString(3, "samy");
            pst.setString(4, "samy");
            pst.setString(5, "samy");
            pst.setString(6, "samy");
            pst.setString(7, "samy");

            pst.setString(8, null);
            pst.setInt(9, 2);

            pst.executeUpdate();

            System.out.println("updated successfully");

            return true;
        } catch (SQLException ex) {
            System.out.println("error in update query");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public boolean delete(Users t) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()){

            PreparedStatement pst = conn.prepareStatement(" delete from   users "
                    + "  where id = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, 2);

            pst.executeUpdate();

            System.out.println("user deleted successflly");

            return true;
        } catch (SQLException ex) {

            System.out.println("error in delete query");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

}
