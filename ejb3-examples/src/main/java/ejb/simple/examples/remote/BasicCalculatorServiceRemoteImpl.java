package ejb.simple.examples.remote;

import ejb.simple.examples.local.BasicCalculatorServiceLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class BasicCalculatorServiceRemoteImpl implements BasicCalculatorServiceRemote {

    @EJB
    BasicCalculatorServiceLocal basicCalculatorServiceLocal;

    @Override
    public int add(int i, int j) {
        return basicCalculatorServiceLocal.add(i, j);
    }

} 

