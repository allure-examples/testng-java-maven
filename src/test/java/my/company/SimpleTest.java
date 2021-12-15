package my.company;

import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

/**
 * @author baev (Dmitry Baev)
 */
public class SimpleTest {

    @Test
    public void simpleTestOne() {
        step("step 1");
        step("step 2");
    }
    @Test
    public void simpleTestTwo() {
        step("step 1");
        step("step 2");
    }
}

