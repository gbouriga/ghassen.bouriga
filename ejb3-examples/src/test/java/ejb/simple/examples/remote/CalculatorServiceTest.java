package ejb.simple.examples.remote;

import ejb.simple.examples.remote.inf.BasicCalculatorEjbRemote;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Created by gbouriga on 18/12/15.
 **/
public class CalculatorServiceTest {
    private static EJBContainer ejbContainer;
    private static Context ctx;

    @BeforeClass
    public static void setUp() {
        //create embedded glassfish container
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDown() throws NamingException {
        ejbContainer.close();
    }

    @Test
    public void testAdd() throws Exception {
        int remoteResult;
        BasicCalculatorEjbRemote basicCalculatorServiceRemote = (BasicCalculatorEjbRemote) ctx.lookup("ejb.simple.examples.remote.BasicCalculatorServiceRemote");
        remoteResult = basicCalculatorServiceRemote.add(1, 1);
        Assert.assertEquals(2, remoteResult);
        remoteResult = basicCalculatorServiceRemote.add(2, 1);
        Assert.assertEquals(3, remoteResult);
    }


}