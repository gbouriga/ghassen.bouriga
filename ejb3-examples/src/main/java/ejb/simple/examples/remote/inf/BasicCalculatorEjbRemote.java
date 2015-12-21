package ejb.simple.examples.remote.inf;

import javax.ejb.Remote;

@Remote
public interface BasicCalculatorEjbRemote {

    int add(int i, int j);
}

