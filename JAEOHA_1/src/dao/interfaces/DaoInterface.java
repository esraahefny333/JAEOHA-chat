/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import databaseclasses.Users;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author abanoub samy
 */
public interface DaoInterface<T> extends Remote {

    public boolean insert(T t) throws RemoteException;

    public T  select(T t) throws RemoteException;

    public boolean update(T t) throws RemoteException;

    public boolean delete(T t) throws RemoteException;

}
