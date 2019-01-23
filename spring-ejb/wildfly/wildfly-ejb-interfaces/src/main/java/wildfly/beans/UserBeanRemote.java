package wildfly.beans;

import java.util.List;

import javax.ejb.Remote;

import com.lee.model.User;

@Remote
public interface UserBeanRemote {

    List<User> getUsers();
}
