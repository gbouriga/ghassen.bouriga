package ejb.simple.examples.local;

import javax.ejb.Stateless;


@Stateless
public class BasicCalculatorServiceLocalImpl implements BasicCalculatorServiceLocal {

    @Override
    public int add(int i, int j) {
        return i + j;
    }

} 

