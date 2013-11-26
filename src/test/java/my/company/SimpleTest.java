package my.company;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attach;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.testng.AllureTestListener;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 24.11.13
 */
@Listeners(AllureTestListener.class)
public class SimpleTest {
    @Test
    public void simpleTest() throws Exception {
        assertThat(2, is(2));
    }

    @Step
    public void checkThat2is2() {
        assertThat(2, is(2));
    }

    @Test
    public void simpleTestWithSteps() throws Exception {
        checkThat2is2();
    }

    @Attach
    public String makeAttach() {
        return "yeah, 2 is 2";
    }

    @Test
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
    }
}
