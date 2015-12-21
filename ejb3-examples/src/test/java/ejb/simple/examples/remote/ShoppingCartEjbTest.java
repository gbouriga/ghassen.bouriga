package ejb.simple.examples.remote;

import ejb.simple.examples.remote.inf.ShoppingCartEjbRemote;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

public class ShoppingCartEjbTest {

    private static EJBContainer ejbContainer;
    private static Context ctx;

    @BeforeClass
    public static void setUp() throws Exception {
        //create embedded glassfish container
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void testShoppingCartEjb() throws Exception {
        ShoppingCartEjbRemote shoppingCartEjbRemote = (ShoppingCartEjbRemote) ctx.lookup("ejb.simple.examples.remote.inf.ShoppingCartEjbRemote");

        shoppingCartEjbRemote.addItem("Bread");
        shoppingCartEjbRemote.addItem("Milk");
        shoppingCartEjbRemote.addItem("Tea");

        Assert.assertEquals(3,  shoppingCartEjbRemote.getItems().size());

        shoppingCartEjbRemote.removeAll();

    }

}


