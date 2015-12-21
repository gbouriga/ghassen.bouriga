package ejb.simple.examples.local.impl;

import ejb.simple.examples.local.inf.BasicCalculatorEjbLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/*The initial state of a stateless session bean is the does-not-exist state. This would be
the case before a container starts up, for example. The next state is the method-ready pool
*/
@Stateless
public class BasicCalculatorEjbLocalImpl implements BasicCalculatorEjbLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculatorEjbLocalImpl.class);


    @PostConstruct
    @Override
    public void setUp() {
        LOGGER.info("Post Constructor Method setUp() Invoked");
    }

    @PreDestroy
    @Override
    public void tearDown() {
        LOGGER.info("Pre Destruction Method tearDown() Invoked");
    }

    @Override
    public int add(int i, int j) {
        return i + j;
    }

} 

