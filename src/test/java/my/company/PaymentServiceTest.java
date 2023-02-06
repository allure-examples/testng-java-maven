package my.company;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.util.Objects.nonNull;

@Feature("Payment")
public class PaymentServiceTest {

    @Feature("Issuing Bank")
    @Test(groups = {"sendTxn"})
    void validateCard() {
        // Dummy test
        String serviceResponse = "OK";
        Assert.assertEquals(serviceResponse, "OK");
    }

    @Feature("Issuing Bank")
    @Test(groups = {"sendTxn"})
    void validateTransaction() {
        // Dummy test
        String transactionId = "42";
        Assert.assertNotNull(transactionId);
    }

    @Feature("Issuing Bank")
    @Parameters({"42"})
    @Test(dependsOnGroups = {"sendTxn"})
    void rollbackATransaction(@Optional("00") String transaction) {
        // Dummy test
        Assert.assertTrue(nonNull(transaction));
    }

    @Feature("Internal system")
    @Test(dataProvider = "messageProvider")
    void sendAMessage(String type, String content) {
        // Dummy test
        Assert.assertTrue(nonNull(type) && content.startsWith("Payment"));
    }

    @DataProvider(name = "messageProvider")
    public Object[][] createMessages() {
        return new Object[][]{
                {"Success", "Payment accepted"},
                {"Failure", "Payment not accepted"},
        };
    }

    @Test
    void dontFixMe() {
        Assert.assertTrue(1994 > 2002);
    }

}