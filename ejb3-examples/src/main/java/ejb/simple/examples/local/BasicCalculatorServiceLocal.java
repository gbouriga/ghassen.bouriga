package ejb.simple.examples.local;

import javax.ejb.Local;

@Local
public interface BasicCalculatorServiceLocal {

    int add(int i, int j);
}

