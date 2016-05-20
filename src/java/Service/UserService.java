package Service;

import Entity.User;
import java.util.List;
import metier.service.tool.JPA.CRUDBaseInterface;

public interface UserService extends CRUDBaseInterface<User> {

    User getByLogin(String login) throws Exception;
    User getByNationality(String nationality) throws Exception;
    User getByEmail(String email) throws Exception;
    List<User> getAllUsers() throws Exception;
}
