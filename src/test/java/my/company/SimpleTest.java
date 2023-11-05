package my.company;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.SecureRandom;
import java.util.UUID;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

/**
 * @author baev (Dmitry Baev)
 */
public class SimpleTest {

    @ParameterizedTest
    @CsvSource({
        "SK,S1",
        "UK,S2",
        "US,S5"
    })
    public void simpleTestOne(String country, String param2) {
        var paymentId = UUID.randomUUID().toString();
        parameter("paymentUid", paymentId);

        step("step 1");
        step("step 2", (step) -> {
            step.parameter("custom1", "some value");
            if(true){
                throw new RuntimeException("Something went wrong");
            }
        });
        step("step 3");
    }
    @Test
    public void simpleTestTwo() {
        step("step 1");
        step("step 2");
    }
}

