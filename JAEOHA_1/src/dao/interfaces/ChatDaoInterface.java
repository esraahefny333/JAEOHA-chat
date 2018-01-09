/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import databaseclasses.Chat;
import databaseclasses.Users;
import java.util.ArrayList;

/**
 *
 * @author abanoub samy
 */
public interface ChatDaoInterface extends DaoInterface<Chat>{
     public Chat select_individualChat(Users user,Users friend);
    public int insert_individualChat(Users user,Users friend);
    public ArrayList<Chat> select_allChats(Users user,String type);
    public ArrayList<Chat> select_allRecentChats(Users user);
}
