/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.ballerina.asyncapi.generators.asyncapi;

import io.ballerina.asyncapi.cli.BallerinaToAsyncAPIGenerator;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.ballerina.asyncapi.core.generators.asyncspec.Constants.ASYNC_API_SUFFIX;

/**
 * This Util class for storing the common utils related to test in ballerina to asyncapi command implementation.
 */
public class TestUtils {

    private static final Path RES_DIR = Paths.get("src/test/resources/ballerina-to-asyncapi/").toAbsolutePath();

    private static String getStringFromGivenBalFile(Path expectedServiceFile, String s) throws IOException {
        Stream<String> expectedServiceLines = Files.lines(expectedServiceFile.resolve(s));
        String expectedServiceContent = expectedServiceLines.collect(Collectors.joining("\n"));
        expectedServiceLines.close();
        return expectedServiceContent;
    }

    public static void deleteGeneratedFiles(String filename, Path tempDir) {
        try {
            Files.deleteIfExists(tempDir.resolve(filename));
            Files.deleteIfExists(tempDir.resolve("schema.bal"));
        } catch (IOException ignored) {
        }
    }

    public static void compareWithGeneratedFile(Path ballerinaFilePath, String yamlFile) throws IOException {
        Path tempDir = Files.createTempDirectory("bal-to-asyncapi-test-out-" + System.nanoTime());
        try {
            String expectedYamlContent = getStringFromGivenBalFile(RES_DIR.resolve("yaml_outputs"), yamlFile);
            BallerinaToAsyncAPIGenerator asyncApiConverter = new BallerinaToAsyncAPIGenerator();
            asyncApiConverter.generateAsyncAPIDefinitionsAllService(ballerinaFilePath, tempDir, null,
                    false);
            if (Files.exists(tempDir.resolve(String.format("payloadV%s.yaml", ASYNC_API_SUFFIX)))) {
                String generatedYaml = getStringFromGivenBalFile(tempDir, String.format("payloadV%s.yaml",
                        ASYNC_API_SUFFIX));
                generatedYaml = (generatedYaml.trim()).replaceAll("\\s+", "");
                expectedYamlContent = (expectedYamlContent.trim()).replaceAll("\\s+", "");
                Assert.assertTrue(generatedYaml.contains(expectedYamlContent));
            } else {
                Assert.fail("Yaml was not generated");
            }
        } catch (IOException e) {
            Assert.fail("Error while generating the service. " + e.getMessage());
        } finally {
            deleteGeneratedFiles(String.format("payloadV%s.yaml", ASYNC_API_SUFFIX), tempDir);
            deleteDirectory(tempDir);
            System.gc();
        }
    }

    public static void deleteDirectory(Path path) {
        if (!Files.exists(path)) {
            return;
        }

        try (Stream<Path> walk = Files.walk(path)) {
            walk.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException ignored) {
            //ignore
        }
    }
}
