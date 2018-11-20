package javaex.ch13clientserver;
//file: RemoteServer.java

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface RemoteServer extends Remote {
    Date getDate() throws RemoteException;

    Object execute(WorkRequest work) throws RemoteException;

    void asyncExecute(WorkRequest work, WorkListener listener)
            throws RemoteException;
}
