package java.ch13clientserver;
//file: StringIterator.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringIterator extends Remote {
    public boolean hasNext() throws RemoteException;
    public String next() throws RemoteException;
}
