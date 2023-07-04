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

package io.ballerina.asyncapi.generators.common;

import io.apicurio.datamodels.models.asyncapi.v25.AsyncApi25DocumentImpl;
import io.ballerina.asyncapi.core.GeneratorUtils;
import io.ballerina.asyncapi.core.exception.BallerinaAsyncApiException;
import io.ballerina.asyncapi.core.generators.schema.BallerinaTypesGenerator;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tests for BallerinaSchemaGenerators.
 */
public class SwaggerParserTests {
    private static final Path RES_DIR = Paths.get("src/test/resources/generators/schema").toAbsolutePath();
    SyntaxTree syntaxTree;

    //TODO: readd expectedExceptionsMessageRegExp = "asyncAPI file has errors: .*" after checking failure
    @Test(description = "Functionality tests for getBallerinaasyncAPIType",
            expectedExceptions = BallerinaAsyncApiException.class)
    public void generateHandleUnsupportedData() throws  IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/invalid.yaml");
        AsyncApi25DocumentImpl asyncAPI = GeneratorUtils.getAsyncAPIFromAsyncAPIParser(definitionPath);
        BallerinaTypesGenerator ballerinaSchemaGenerator = new BallerinaTypesGenerator(asyncAPI);
        syntaxTree = ballerinaSchemaGenerator.generateSyntaxTree();
    }

    //Get string as a content of ballerina file
    private String getStringFromGivenBalFile(Path expectedServiceFile, String s) throws IOException {
        Stream<String> expectedServiceLines = Files.lines(expectedServiceFile.resolve(s));
        String expectedServiceContent = expectedServiceLines.collect(Collectors.joining("\n"));
        expectedServiceLines.close();
        return expectedServiceContent;
    }

    private void compareGeneratedSyntaxTreewithExpectedSyntaxTree(String s) throws IOException {

        String expectedBallerinaContent = getStringFromGivenBalFile(RES_DIR.resolve("ballerina/"), s);
        String generatedSyntaxTree = syntaxTree.toString();

        generatedSyntaxTree = (generatedSyntaxTree.trim()).replaceAll("\\s+", "");
        expectedBallerinaContent = (expectedBallerinaContent.trim()).replaceAll("\\s+", "");
        Assert.assertTrue(generatedSyntaxTree.contains(expectedBallerinaContent));
    }
}
