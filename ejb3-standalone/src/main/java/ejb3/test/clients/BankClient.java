package ejb3.test.clients;

import ejb3.remote.services.BankService;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import java.util.Properties;

public class BankClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankClient.class);
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(17).toUpperCase();
    private static final String LAST_NAME = RandomStringUtils.randomAlphanumeric(17).toUpperCase();


    private BankClient() {
    }

    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
            properties.put("java.naming.provider.url", "t3://localhost:7001");
            InitialContext ctx = new InitialContext(properties);
            BankService bank = (BankService) ctx.lookup("BankService#ejb3.remote.services.BankService");
            //  add customer to database
            bank.addCustomer(FIRST_NAME, LAST_NAME);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);

        }

    }

}



