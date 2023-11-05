package my.company;


import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.UUID;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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
  @Description("Provide test description here")
  public void simpleTestOne(@Param String country, @Param String myParam) {
    var objectUid = UUID.randomUUID().toString();
    parameter("objectUid", objectUid);

    MyObjectForProcessing objectForProcessing = createObject(objectUid, country, myParam);

    step("step 1", (step) -> {
      if ("US".equals(country)) {
        fail("Failed assertion comment");
      }
    });

    step("step 2", (step) -> {
      step.parameter("stepSpecificArgument", "some value");
      if ("SK".equals(country)) {
        throw new RuntimeException("Runtime exception message");
      }
    });

    var resultObject = getResults(objectForProcessing); // Step is defined in the method annotation
    assertNotNull(resultObject, "Processing didn't return any result");
  }

  /**
   * This is the test description for the Allure report
   * But it doesn't work as expected.
   * See:
   * - https://github.com/allure-framework/allure-java/issues/757
   * - https://github.com/allure-framework/allure2/issues/1102
   */
  @Test
  @Owner("John Doe")
  @Description(useJavaDoc = true)
  public void simpleTestTwo() {
    step("step 1");
    step("step 2");
  }

  // *******************************
  // private methods
  // *******************************

  @Step("Prepare an object for sending")
  private MyObjectForProcessing createObject(String objectUid, String country, String myParam){
    return new MyObjectForProcessing(objectUid, country, myParam);
  }

  @Description("Step-specific description") // it doesn't work
  @Step("Get results from processor")
  private String getResults(MyObjectForProcessing myObject) {
    return "Object (objectUid: " + myObject.objectUid() + ") was processed";
  }
}

