/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.dao.interfaces;

import databaseclasses.Chat;
import databaseclasses.User;
import java.util.ArrayList;

/**
 *
 * @author abanoub samy
 */
public interface ChatDaoInterface extends DaoInterface<Chat>{
    
    public Chat select_individualChat(User user,User friend);
    public int insert_individualChat(User user,User friend);
    public ArrayList<Chat> select_allChats(User user,String type);
    public ArrayList<Chat> select_allRecentChats(User user);
    
}
