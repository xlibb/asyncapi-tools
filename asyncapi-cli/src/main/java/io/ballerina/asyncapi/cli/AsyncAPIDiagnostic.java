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
package io.ballerina.asyncapi.cli;

import io.ballerina.tools.diagnostics.Diagnostic;
import io.ballerina.tools.diagnostics.DiagnosticInfo;
import io.ballerina.tools.diagnostics.DiagnosticProperty;
import io.ballerina.tools.diagnostics.Location;
import io.ballerina.tools.text.LinePosition;
import io.ballerina.tools.text.LineRange;

import java.text.MessageFormat;
import java.util.List;

/**
 * Represents a {@code Diagnostic} related to asyncapi command.
 *
 * @since 2.0.0
 */
public class AsyncAPIDiagnostic extends Diagnostic {
    private final DiagnosticInfo diagnosticInfo;
    private final Location location;
    private final List<DiagnosticProperty<?>> properties;
    private final String message;

    public AsyncAPIDiagnostic(DiagnosticInfo diagnosticInfo, Location location, List<DiagnosticProperty<?>> properties,
                              Object[] args) {
        this.diagnosticInfo = diagnosticInfo;
        this.location = location;
        this.properties = properties;
        this.message = MessageFormat.format(diagnosticInfo.messageFormat(), args);
    }

    /**
     * Rearrange line range with 1 based, since default line range gives 0 based.
     */
    static LineRange getOneBasedLineRange(LineRange lineRange) {
        return LineRange.from(
                lineRange.filePath(),
                LinePosition.from(lineRange.startLine().line() + 1, lineRange.startLine().offset() + 1),
                LinePosition.from(lineRange.endLine().line() + 1, lineRange.endLine().offset() + 1));
    }

    public Location location() {
        return this.location;
    }

    public DiagnosticInfo diagnosticInfo() {
        return this.diagnosticInfo;
    }

    public String message() {
        return this.message;
    }

    public List<DiagnosticProperty<?>> properties() {
        return this.properties;
    }

    @Override
    public String toString() {
        LineRange lineRange = getOneBasedLineRange(this.location().lineRange());
        String var10000 = this.diagnosticInfo().severity().toString();
        return var10000 + " [" + lineRange.filePath() + ":" + lineRange + "] " + this.message();
    }
}
