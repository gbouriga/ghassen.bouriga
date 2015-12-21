package ejb.simple.examples.local.inf;

import javax.ejb.Local;

@Local
public interface BasicCalculatorEjbLocal {

    void setUp();

    void tearDown();

    int add(int i, int j);
}

