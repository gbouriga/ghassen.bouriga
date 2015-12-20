package ejb.simple.examples.remote;

import javax.ejb.Remote;

@Remote
public interface BasicCalculatorServiceRemote {

    int add(int i, int j);
}

