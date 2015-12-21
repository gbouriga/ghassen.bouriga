package ejb.simple.examples.local.impl;

import ejb.simple.examples.local.inf.ShoppingCartEjbLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
In contrast to stateless session beans, stateful session beans maintain state for an
individual client over one or more method requests. A stateful session bean is not
shared among clients, and a client's reference to a bean only ends when the client
ends the session or the session times out. The state is not written to a database but
held in the containers cache and is lost when the container crashes.
 */
@Stateful
public class ShoppingCartEjbLocalImpl implements ShoppingCartEjbLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartEjbLocalImpl.class);


    private List<String> items;

    @PostConstruct
    @Override
    public void setUp() {
        items = new ArrayList<>();
    }

    @PrePassivate
    @Override
    public void prePassivation() {
        LOGGER.info("PrePassivate method prePassivation() Invoked");
    }

    @PostActivate
    @Override
    public void preActivation() {
        LOGGER.info("PostActivate method preActivation() Invoked");
    }

    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }


}




