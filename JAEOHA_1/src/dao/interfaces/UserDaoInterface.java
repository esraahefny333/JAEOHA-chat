/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import databaseclasses.Users;
import java.rmi.RemoteException;

/**
 *
 * @author abanoub samy
 */
public interface UserDaoInterface extends DaoInterface<Users>{
    
    boolean signUp(Users user) throws RemoteException;
    
    boolean checkUserByEmail(String email)throws RemoteException;
    
    
}
