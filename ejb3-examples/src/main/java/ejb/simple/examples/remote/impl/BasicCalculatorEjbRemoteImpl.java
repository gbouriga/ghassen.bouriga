package ejb.simple.examples.remote.impl;

import ejb.simple.examples.local.inf.BasicCalculatorEjbLocal;
import ejb.simple.examples.remote.inf.BasicCalculatorEjbRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


@Stateless
public class BasicCalculatorEjbRemoteImpl implements BasicCalculatorEjbRemote {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculatorEjbRemoteImpl.class);

    //The SessionContext is used by a bean to query the container about the bean's status or context
    @Resource
    private SessionContext ctx;

    @EJB
    BasicCalculatorEjbLocal basicCalculatorEjbLocal;

    @Override
    public int add(int i, int j) {
        LOGGER.info("Invoked interface : " + ctx.getInvokedBusinessInterface());
        return basicCalculatorEjbLocal.add(i, j);
    }

} 

