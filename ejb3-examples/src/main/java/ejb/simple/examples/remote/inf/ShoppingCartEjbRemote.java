package ejb.simple.examples.remote.inf;

import javax.ejb.Remote;
import java.util.Collection;

@Remote
public interface ShoppingCartEjbRemote {

    void addItem(String item);

    Collection<String> getItems();

    void removeAll();


}

