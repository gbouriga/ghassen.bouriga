package ejb.simple.examples.remote.impl;

import ejb.simple.examples.local.inf.ShoppingCartEjbLocal;
import ejb.simple.examples.remote.inf.ShoppingCartEjbRemote;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.Collection;

@Stateful
public class ShoppingCartEjbRemoteImpl implements ShoppingCartEjbRemote {

    @EJB
    private ShoppingCartEjbLocal shoppingCartEjbLocal;


    @Override
    public void addItem(String item) {
        shoppingCartEjbLocal.addItem(item);
    }

    @Override
    public Collection<String> getItems() {
        return shoppingCartEjbLocal.getItems();
    }

    /*
    We use the @Remove annotation to indicate that after the annotated method has
    executed, the client no longer needs the session. The container can then delete
    the bean instance. If a @PreDestroy method exists, it will be executed after the
    @Remove method. Typically the method would perform tidying up such as closing
    connections
     */
    @Remove
    @Override
    public void removeAll() {
        shoppingCartEjbLocal.getItems().clear();
    }


}




