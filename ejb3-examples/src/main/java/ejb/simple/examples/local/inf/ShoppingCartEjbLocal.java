package ejb.simple.examples.local.inf;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface ShoppingCartEjbLocal {

    void setUp();

    void prePassivation();

    void preActivation();

    void addItem(String item);

    Collection<String> getItems();


}

