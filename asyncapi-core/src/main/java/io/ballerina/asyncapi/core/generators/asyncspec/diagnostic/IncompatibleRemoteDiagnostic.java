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

package io.ballerina.asyncapi.core.generators.asyncspec.diagnostic;

import io.ballerina.tools.diagnostics.DiagnosticSeverity;
import io.ballerina.tools.diagnostics.Location;

import java.util.Optional;

/**
 * This {@code IncompatibleRemoteDiagnostic} represents the diagnostic that AsyncApiSpec not compatible with ballerina
 * implementation.
 *
 * @since 2.0.0
 */
public class IncompatibleRemoteDiagnostic implements AsyncAPIConverterDiagnostic {
    private final String code;
    private final String message;
    private final Location location;
    private final DiagnosticSeverity severity;

    public IncompatibleRemoteDiagnostic(DiagnosticMessages details, Location location, Object... args) {
        this.code = details.getCode();
        this.message = generateDescription(details, args);
        this.location = location;
        this.severity = details.getSeverity();
    }

    /**
     * This method is to create message description with args values.
     */
    private static String generateDescription(DiagnosticMessages details, Object[] args) {
        return String.format(details.getDescription(), args);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public DiagnosticSeverity getDiagnosticSeverity() {
        return severity;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }
}
