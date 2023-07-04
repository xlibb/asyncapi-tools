/*
 * Copyright (c) 2021, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

module io.ballerina.asyncapi.core {
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires info.picocli;
    requires io.ballerina.lang;
    requires io.ballerina.parser;
    requires io.ballerina.cli;
    requires io.ballerina.runtime;
    requires io.ballerina.tools.api;
    requires io.ballerina.formatter.core;
    requires jsr305;
    requires org.apache.commons.io;
    requires org.slf4j;
    requires org.apache.commons.lang3;
    requires apicurio.data.models;
    requires com.fasterxml.jackson.dataformat.yaml;
    exports io.ballerina.asyncapi.core.generators.asyncspec.diagnostic;
    exports io.ballerina.asyncapi.core.generators.asyncspec.utils;
    exports io.ballerina.asyncapi.core.generators.asyncspec.model;
    exports io.ballerina.asyncapi.core.generators.asyncspec.service;
    exports io.ballerina.asyncapi.core.exception;
    exports io.ballerina.asyncapi.core;
    exports io.ballerina.asyncapi.core.generators.client.model;
    exports io.ballerina.asyncapi.core.generators.client;
    exports io.ballerina.asyncapi.core.generators.asyncspec;
//    exports io.ballerina.asyncapi.core.generators.schema;
    exports io.ballerina.asyncapi.core.model;
    exports io.ballerina.asyncapi.core.generators.schema;
    exports io.ballerina.asyncapi.core.generators.schema.ballerinatypegenerators;
    exports io.ballerina.asyncapi.core.generators.schema.model;

}

