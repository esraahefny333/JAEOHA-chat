/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.ChatDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Chat;
import databaseclasses.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abanoub samy
 */
public class ChatDaoImpl extends UnicastRemoteObject implements ChatDaoInterface{
    
    
    public ChatDaoImpl() throws RemoteException
    {
        
        
        
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
    public Vector<Chat> convertToVector(ResultSet rs) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public ArrayList<Chat> select_allChats(Users user,String type) {
        
        ArrayList individualChats=null;
        try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("select * from `chat` where chatId in(select chatId from `chat_members` where memberId=? ) && chatType=?");
           pstm.setInt(1, user.getId());
           pstm.setString(2, type);
           ResultSet rs=pstm.executeQuery();
           individualChats=convertToVectortemp(rs);
        } catch (SQLException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return individualChats;
    }



    
    public ArrayList<Chat> convertToVectortemp(ResultSet rs) throws RemoteException {
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
    public ArrayList<Chat> select_allRecentChats(Users user) {
       
        ArrayList individualChats=null;
        try (Connection con=DatabaseConnectionHandler.getConnection()){
           PreparedStatement pstm=con.prepareStatement("SELECT distinct chat.chatId,chat.chatName FROM messages inner join chat on chat.chatId=messages.chatId where chat.chatId in(select chatId from chat_members where memberId=?)  order by messages.messageDate DESC");
           pstm.setInt(1, user.getId());
           ResultSet rs=pstm.executeQuery();
            individualChats=convertToVectortemp(rs);
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
    public Chat select_individualChat(Users user, Users friend) {
      
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
    
    @Override
    public int insert_individualChat(Users user, Users friend) {
      
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
