package wildfly.beans;

import java.util.List;

import javax.ejb.Local;

import com.lee.model.User;

@Local
public interface UserBeanLocal {

    List<User> getUsers();
}
