/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.MessagesDaoInterface;
import database.connection.DatabaseConnectionHandler;
import databaseclasses.Chat;
import databaseclasses.Message;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omnia
 */
public class MessagesDaoImpl extends UnicastRemoteObject implements MessagesDaoInterface{
    
    
    MessagesDaoImpl()throws RemoteException
    {
            
    }

    @Override
    public boolean insert(Message t) throws RemoteException {
        return false;
       
    }

    @Override
    public Message select(Message t) throws RemoteException {
     
        return null;
    }

    @Override
    public boolean update(Message t) throws RemoteException {
       
        return false;
    }

    @Override
    public boolean delete(Message t) throws RemoteException {

        return false;
    }

    @Override
    public Vector<Message> convertToVector(ResultSet rs) throws RemoteException {
        
        Vector <Message> message=new Vector<Message>();
        try {
            while(rs.next())
            {
               Message mesg=new Message();
               mesg.setMessageId(rs.getInt(1));
               mesg.setMessageText(rs.getString(2));
               mesg.setMessageTime(rs.getDate(3));
               mesg.setFile(rs.getBlob(4));
               mesg.setFileType(rs.getInt(5));
               mesg.setSenderId(rs.getInt(6));
               mesg.setChatId(rs.getInt(7));
               mesg.setMessageColor(rs.getString(8));
               mesg.setFontSize(rs.getInt(9));
               mesg.setFontType(rs.getString(10));
               
               message.add(mesg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    @Override
    public Vector<Message> selectChatMessage(Chat c, Integer from, Integer to) throws RemoteException {
       
        Vector<Message>msg=null;
      try {
            Connection conn = DatabaseConnectionHandler.getConnection();
            ResultSet rs=null;
            PreparedStatement pst = conn.prepareStatement(" select * from messages where chatId=? order by messageDate DESC"
                    ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, c.getChatId());
            rs=pst.executeQuery();
            msg=convertToVector(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(MessagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
             

        return msg;
    }
    
}
