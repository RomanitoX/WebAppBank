package Service;

import Entity.Third;
import metier.service.tool.JPA.CRUDBaseInterface;

/**
 *
 * @author romanitox
 */
public interface ThirdService extends CRUDBaseInterface<Third> {

    Third getByName(String name) throws Exception;
}
