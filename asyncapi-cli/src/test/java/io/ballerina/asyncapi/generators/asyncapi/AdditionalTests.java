package io.ballerina.asyncapi.generators.asyncapi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This {@code AdditionalTests} test class for the covering the additional tests.
 */
public class AdditionalTests {
    private static final Path RES_DIR = Paths.get("src/test/resources" +
            "/ballerina-to-asyncapi/additional").toAbsolutePath();
    private Path tempDir;

    @BeforeMethod
    public void setup() throws IOException {
        this.tempDir = Files.createTempDirectory("bal-to-asyncapi-test-out-" + System.nanoTime());
    }

    @Test(description = "test to check description has overrided")
    public void testRecordFieldDescriptionsOverrided() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("override_description_of_record.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "additional/override_description_of_record.yaml");
    }

//    @Test(description = "test to check dispatcherStreamId")
//    public void testDispatcherStreamId() throws IOException {
//        Path ballerinaFilePath = RES_DIR.resolve("dispatcherStreamId_present.bal");
//        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "additional/dispatcherStreamId_present.yaml");
//    }
    @AfterMethod
    public void cleanUp() {
        TestUtils.deleteDirectory(this.tempDir);
    }

    @AfterTest
    public void clean() {
        System.setErr(null);
        System.setOut(null);
    }

}
