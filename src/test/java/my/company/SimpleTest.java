package my.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.fail;


/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 24.11.13
 */
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

    @Attachment
    public String makeAttach() {
        return "yeah, 2 is 2";
    }

    @Test
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
    }

    @Test
    public void failedTest() {
        fail("This test should be failed");
    }

    @Test(dependsOnMethods = "failedTest")
    public void skippedByDependencyTest() {
    }

    @Test(enabled = false)
    public void skippedTest() throws Exception {
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {1}, {2}, {3}
        };
    }

    @Test(dataProvider = "dataProvider")
    @Issues({@Issue("ALR-123"), @Issue("ALR-456"), @Issue("ALR-789")})
    @TestCaseId("TMS-123")
    public void parametrizedTest(@Parameter int parameter) {
        assertThat(parameter, is(2));
    }

    @DataProvider
    public Object[][] anotherDataProvider() {
        return new Object[][]{
                {"Long-long parameter value", 1, 2}, {"Even longer parameter value than long-long parameter value", 2, 3}, {"", 3, 4}
        };
    }

    @Test(dataProvider = "anotherDataProvider")
    @Issues({@Issue("ALR-123"), @Issue("ALR-456"), @Issue("ALR-789")})
    @TestCaseId("TMS-123")
    public void parametrizedTest(@Parameter String parameter1, @Parameter("Third Parameter Name") int parameter2, int parameters3) {
        assertThat(parameter2, is(2));
    }

    @Test
    public void csvAttachmentTest() throws Exception {
        saveCsvAttachment();
    }

    @Test
    public void svgAttachmentTest() throws Exception {
        saveSvgAttachment();
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        return getSampleFile("sample.csv");
    }

    @Attachment(value = "Sample svg attachment", type = "image/svg+xml")
    public byte[] saveSvgAttachment() throws URISyntaxException, IOException {
        return getSampleFile("sample.svg");
    }

    private byte[] getSampleFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }
}

