/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.dao.implementation;

import DAL.connection.DatabaseConnectionHandler;
import DAL.dao.interfaces.ChatDaoInterface;
import databaseclasses.Chat;
import databaseclasses.User;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author esraa
 */
public class ChatDaoImpl implements ChatDaoInterface{

    @Override
    public ArrayList<Chat> select_allChats(User user,String type) {
        
        ArrayList individualChats=null;
        try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("select * from `chat` where chatId in(select chatId from `chat_members` where memberId=? ) && chatType=?");
           pstm.setInt(1, user.getId());
           pstm.setString(2, type);
           ResultSet rs=pstm.executeQuery();
           individualChats=convertToVector(rs);
        } catch (SQLException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return individualChats;
    }

    @Override
    public boolean insert(Chat c) throws RemoteException {
      boolean b=false;
       try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("insert into chat (chatName,chatType) values(?,?)");
           pstm.setString(1, c.getChatName());
           pstm.setInt(1, c.getChatType());
           ResultSet rs=pstm.executeQuery();
          } catch (SQLException ex) {
              b=false;
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
     return b;
    
    }

    @Override
    public Chat select(Chat t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Chat t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Chat t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Chat> convertToVector(ResultSet rs) throws RemoteException {
        ArrayList<Chat> chat = null;
        try {
            chat=new ArrayList();
            while (rs.next()) {
               // System.err.println(rs.getString("messageText"));
                Chat c = new Chat();
                c.setChatId(rs.getInt("chatId"));
                c.setChatName(rs.getString("chatName"));
                chat.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chat;
    }

    @Override
    public ArrayList<Chat> select_allRecentChats(User user) {
       
        ArrayList individualChats=null;
        try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("SELECT distinct chat.chatId,chat.chatName FROM messages inner join chat on chat.chatId=messages.chatId where chat.chatId in(select chatId from chat_members where memberId=?)  order by messages.messageDate DESC");
           pstm.setInt(1, user.getId());
           ResultSet rs=pstm.executeQuery();
            individualChats=convertToVector(rs);
            if(individualChats!=null)
            {
                return individualChats;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return individualChats;
    
    }

    @Override
    public Chat select_individualChat(User user, User friend) {
      
         Chat chat=null;
         try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("select * from chat where chatId in(select chatId from chat_members where memberId=? or memberId=?) and chatType=?");
           pstm.setInt(1, user.getId());
           pstm.setInt(2, friend.getId());
           pstm.setInt(3, 0);
           ResultSet rs=pstm.executeQuery();
           rs.next();
           chat=new Chat(rs.getInt(1),rs.getString(2),rs.getInt(3));
            
        } catch (SQLException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
     return chat;
    }
    
    public int insert_individualChat(User user, User friend) {
      
         int rs=0;
         try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("insert into chat (chatName,chatType) values(?,?)");
           pstm.setString(1, friend.getUserName());
           pstm.setInt(2, 0);
             System.err.println("done");
            rs=pstm.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
     return rs;
    }
    
}
