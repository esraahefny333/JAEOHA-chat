/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfunctions;

import dao.implementation.MessagesDaoImpl;
import database.connection.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author omnia
 */
public class ServerFunctions {
    
    ArrayList<String> online = new ArrayList<String>();
    ArrayList<String> offline = new ArrayList<String>();
    
     public ArrayList<String> getofflineusers()
    {
      try {
            Connection conn = DatabaseConnectionHandler.getConnection();
            ResultSet rs=null;
            PreparedStatement pst = conn.prepareStatement(" select * from users where active=0"
                    ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs=pst.executeQuery();
             while(rs.next())
            {
              offline.add(rs.getString(2));
            }
             
            conn.close();
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
      return offline;
    }
    
    public ArrayList<String> getonlineusers()
    {
     try {
            Connection conn = DatabaseConnectionHandler.getConnection();
            ResultSet rs=null;
            PreparedStatement pst = conn.prepareStatement(" select * from users where active=1"
                    ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs=pst.executeQuery();
             while(rs.next())
            {
              online.add(rs.getString(2));
            }
             
            conn.close();
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
     return online;
    }
    
    public int getNumberOfonLineUsers()
    {
        return getonlineusers().size();
    }
    public int getNumberOfOfflineUsers()
    {
        return getofflineusers().size();
    }
    
    public int numberOfFemale()
    {
        int female=0;
     try {
            Connection conn = DatabaseConnectionHandler.getConnection();
            ResultSet rs=null;
            PreparedStatement pst = conn.prepareStatement(" select * from users where gender='female'"
                    ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs=pst.executeQuery();
             while(rs.next())
            {
             female++;
            }
             
            conn.close();
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
        
        return female;   
    }
    
     public int numberOfmale()
    {
        int male=0;
     try {
            Connection conn = DatabaseConnectionHandler.getConnection();
            ResultSet rs=null;
            PreparedStatement pst = conn.prepareStatement(" select * from users where gender='male'"
                    ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs=pst.executeQuery();
             while(rs.next())
            {
             male++;
            }
             
            conn.close();
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
        
        return male;   
    }
   
     
     
    public static void main(String []args)
    {
        ServerFunctions s=new ServerFunctions();
        System.out.println("offline"+s.getNumberOfOfflineUsers());
        System.out.println("online"+s.getNumberOfonLineUsers());
        System.out.println("female"+s.numberOfFemale());
        System.out.println("male"+s.numberOfmale());
    }
}
