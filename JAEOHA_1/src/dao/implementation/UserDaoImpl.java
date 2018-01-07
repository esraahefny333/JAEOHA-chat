/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.UserDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Notification;
import databaseclasses.Users;
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
import javafx.scene.image.Image;

/**
 *
 * @author abanoub samy
 */
public class UserDaoImpl extends UnicastRemoteObject implements UserDaoInterface {

    public UserDaoImpl() throws RemoteException {
    }

    // check user email if exists
    @Override
    public boolean checkUserByEmail(Users user) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select * from users where email = ? ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, user.getEmail());

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

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            PreparedStatement pst = conn.prepareStatement("INSERT INTO  users"
                    + "( userName ,email,phoneNo,gender,country,password,status,photo,active) "
                    + "values (?,?,?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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

    //select user data when trying to log in 
    @Override
    public Users select(Users t) throws RemoteException {

        boolean found = false;
        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select id ,userName ,email,phoneNo,gender,"
                    + "country,password,status,photo,active"
                    + "   from users where email = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, t.getEmail());

            rs = pst.executeQuery();

            System.out.println("user selected successfully");

            while (rs.next()) {
                found = true;
                t.setId(rs.getInt(1));
                t.setUserName(rs.getString(2));
                t.setEmail(rs.getString(3));
                t.setPhone(rs.getString(4));
                t.setGender(rs.getString(5));

                t.setCountry(rs.getString(6));

                t.setPassword(rs.getString(7));
                t.setStatus(rs.getString(8));

                t.setPhoto(null);
                t.setActive(rs.getInt(10));
            }
            if (found) {
                return t;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean update(Users t) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(" update  users set  userName = ? , email = ? ,"
                    + " phoneNo = ? , gender = ? , country = ? , password = ? ,  "
                    + "status = ? , photo = ? ,active = ? "
                    + "  where id = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, t.getUserName());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getPhone());
            pst.setString(4, t.getGender());
            pst.setString(5, t.getCountry());
            pst.setString(6, t.getPassword());
            pst.setString(7, t.getStatus());

            pst.setBlob(8, (Blob) t.getPhoto());

            pst.setInt(9, t.getActive());
            pst.setInt(10, t.getId());

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

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(" delete from   users "
                    + "  where id = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, t.getId());

            pst.executeUpdate();

            System.out.println("user deleted successflly");

            return true;
        } catch (SQLException ex) {

            System.out.println("error in delete query");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Vector<Users> getUserFriends(Users user) throws RemoteException {

        Vector<Users> friends = new Vector<>();

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select id ,userName ,email,status,photo,active from users where id =  (select friendId from user_friends where userId = ? )",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //   pst.setInt(1, user.getId());
            pst.setInt(1, 3);

            rs = pst.executeQuery();

            System.out.println("friend selected successfully");

            friends = convertToVector(rs);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return friends;

    }

    @Override
    public Vector<Users> convertToVector(ResultSet rs) throws RemoteException {
        Vector<Users> users = new Vector<>();
        try {

            while (rs.next()) {

                Users u = new Users();
                u.setId(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setStatus(rs.getString(4));
                u.setPhoto((Image) rs.getBlob(5));
                u.setActive(rs.getInt(6));

                users.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public Vector<Users> getFriendRequests(Users user) throws RemoteException {

        Vector<Users> userWhoRequested = new Vector<>();

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select id ,userName ,email,status,photo,active from users where id =  (select senderId from user_friend_requests where recieverId = ? )",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //   pst.setInt(1, user.getId());
            pst.setInt(1, 3);

            rs = pst.executeQuery();

            System.out.println("user who requested selected successfully");

            userWhoRequested = convertToVector(rs);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userWhoRequested;

    }

    @Override
    public boolean checkUserByEmailAndPass(Users user) throws RemoteException {

        try (Connection conn = DatabaseConnectionHandler.getConnection()) {

            ResultSet rs = null;

            PreparedStatement pst = conn.prepareStatement("select * from users where email = ? and password = ? ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());

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

   
}
