/*
 * Copyright (c) 2022, WSO2 LLC. (http://www.wso2.com). All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.asyncapi.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants for asyncapi code generator.
 *
 * @since 1.3.0
 */
public class GeneratorConstants {

    public static final String UTIL_FILE_NAME = "utils.bal";
    public static final String ASYNCAPI_PATH_SEPARATOR = "/";
    public static final String ESCAPE_PATTERN = "([\\[\\]\\\\?!<>@#&~`*\\-=^+();:\\/{}\\s|.$])";
    //ClientCode generator
    public static final String HTTP = "http";
    public static final String WEBSOCKET = "websocket";

    public static final String LANG_RUNTIME = "lang.runtime";


    public static final String SIMPLE_PIPE = "pipe";

    public static final String UUID = "uuid";

    public static final String CREATE_TYPE1_AS_STRING = "createType1AsString()";

    public static final String CAPITAL_PIPE = "Pipe";

    public static final String URL = "url";
    public static final String MODULE_TEST = "test";
    public static final String BALLERINA = "ballerina";

    //Honour goes to Nuvindu
    public static final String XLIBB = "xlibb";
    public static final String XLIBB_PIPE = "pipe";

    public static final String X_DISPATCHER_KEY = "x-dispatcherKey";

    public static final String X_DISPATCHER_STREAM_ID = "x-dispatcherStreamId";

    public static final String CLIENT_CLASS_NAME = "Client";
    public static final String CLIENT_EP = "clientEp";

    public static final String WEBSOCKET_EP = "websocketEp";

    public static final String NULL_VALUE = "()";

    public static final String MAP_ANY_DATA = "map<anydata>";

    public static final String SPACE = " ";

    public static final String EQUAL_SPACE = " = ";

    public static final String PLUS_SPACE = " + ";

    public static final String CHECK_PATH_FOR_QUERY_PARAM = "check getPathForQueryParam(queryParam)";

    public static final String MAP_STRING = "map<string>";

    public static final String GET_COMBINE_HEADERS = "getCombineHeaders(clientConfig.customHeaders,headerParam)";

    public static final String CLOSE = "close";

    public static final String WRITE_MESSAGE_QUEUE = "writeMessageQueue";

    public static final String READ_MESSAGE_QUEUE = "readMessageQueue";

    public static final String START_MESSAGE_READING = "startMessageReading";

    public static final String START_MESSAGE_WRITING = "startMessageWriting";

    public static final String START_PIPE_TRIGGERING = "startPipeTriggering";

    public static final String CONSUME = "consume";

    public static final String PRODUCE = "produce";

    public static final String DEFAULT_PIPE_TIME_OUT = "5";

    public static final String REQUEST_MESSAGE = "requestMessage";

    public static final String WRITE_MESSAGE = "writeMessage";

    public static final String READ_MESSAGE = "readMessage";

    public static final String PIPE_TRIGGER = "pipeTrigger";
    public static final String MESSAGE = "Message";
    public static final String MESSAGE_WITH_ID = "MessageWithId";

    public static final String CONNECTION_CLOSED = "connection closed";

    public static final String MESSAGE_VAR_NAME = "message";
    public static final String MESSAGE_WITH_ID_VAR_NAME = "messageWithId";
    public static final String TYPE_INCLUSION_GENERATOR = "Generator";
    public static final String WORKER_SLEEP_TIME_OUT = "0.01";

    public static final String STREAM_GENERATORS_MAP = "StreamGeneratorsMap";

    public static final String PIPES_MAP = "PipesMap";
    public static final String SLEEP = "sleep";
    public static final String RUNTIME = "runtime";

    public static final String PIPES = "pipes";

    public static final String STREAM_GENERATORS = "streamGenerators";
    public static final String EQUAL = "=";
    public static final String CLIENT_CONFIG = "clientConfig";
    public static final String PREFIX_TEST = " test";
    public static final String ANNOT_TEST = "test:Config";
    public static final String TEST_DIR = "tests";
    public static final String STRING = "string";
    public static final String XML = "xml";
    public static final String JSON = "json";
    public static final String SERVICE_URL = "serviceUrl";

    public static final String BINARY = "binary";
    public static final String FLOAT = "float";
    public static final String HEADER_PARAM = "headerParam";
    public static final String PDF = "pdf";
    public static final String QUERY_PARAM = "queryParam";
    public static final String SELF = "self";

    public static final String MIME = "mime";
    public static final String CUSTOM_HEADERS = "customHeaders";
    public static final String MODIFIED_URL = "modifiedUrl";
    public static final String ERROR = "error";

    public static final String ENSURE_TYPE = "ensureType";
    // auth related constants
    public static final String HTTP_API_KEY = "httpApiKey";
    public static final String USER_PASSWORD = "userPassword";
    public static final String API_KEY = "apiKey";
    public static final String API_KEYS_CONFIG = "ApiKeysConfig";
    public static final String API_KEY_CONFIG = "apiKeyConfig";
    public static final String AUTH = "auth";

    public static final String PING_PONG_SERVICE = "websocket:PingPongService";
    public static final String PING_PONG_HANDLER_FIELD = "pingPongHandler";
    public static final String SECURE_SOCKET = "websocket:ClientSecureSocket";
    public static final String SECURE_SOCKET_FIELD = "secureSocket";
    public static final String PING_PONG_SERVICE_FIELD = "pingPongHandler";
    public static final String WEB_SOCKET_RETRY_CONFIG = "websocket:WebSocketRetryConfig";
    public static final String BASIC = "basic";
    public static final String BEARER = "bearer";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CLIENT_CRED = "client_cred";
    public static final String PASSWORD = "password";
    public static final String REMOTE_METHOD_NAME_PREFIX = "do";
    public static final String CONNECTION_CONFIG = "websocket:ClientConfiguration";
    public static final String OAUTH2 = "oauth2";

    public static final String CONFIG = "config";
    public static final String CONFIG_DESCRIPTION = "The configurations to be used when initializing the `connector`";

    public static final String RETURN = "return";

    public static final String RETURN_DESCRIPTION = "An error if connector initialization failed";
    public static final String RETRY_CONFIG_FIELD = "retryConfig";
    public static final String VALIDATION = "validation";
    public static final String DEFAULT_API_KEY_DESC = "API keys for authorization";
    public static final String ANY_DATA = "anydata";

    //AsyncAPI Ballerina extensions
    public static final String X_BALLERINA_INIT_DESCRIPTION = "x-ballerina-init-description";

    public static final String X_BALLERINA_MESSAGE_WRITE_DESCRIPTION = "x-ballerina-write-message-description";

    public static final String X_BALLERINA_MESSAGE_READ_DESCRIPTION = "x-ballerina-read-message-description";

    public static final String X_BALLERINA_PIPE_TRIGGER_DESCRIPTION = "x-ballerina-pipe-trigger-description";
    public static final String X_BALLERINA_DEPRECATED_REASON = "x-ballerina-deprecated-reason";
    //Service related
    public static final String X_RESPONSE = "x-response";

    public static final String X_RESPONSE_TYPE = "x-response-type";

    public static final String DECIMAL = "decimal";

    public static final String DESCRIPTION = "description";

    public static final String TIMEOUT = "timeout";


    public static final String SERVER_STREAMING = "server-streaming";

    public static final String SIMPLE_RPC = "simple-rpc";
    public static final String INTEGER = "integer";
    public static final String BOOLEAN = "boolean";
    public static final String IS_MESSAGE_WRITING = "isMessageWriting";
    public static final String IS_MESSAGE_READING = "isMessageReading";
    public static final String IS_PIPE_TRIGGERING = "isPipeTriggering";

    public static final String OPTIONAL_ERROR = "error?";

    public static final String IMMEDIATE_CLOSE = "immediateClose";

    public static final String REMOVE_PIPES = "removePipes";

    public static final String REMOVE_STREAM_GENERATORS = "removeStreamGenerators";

    public static final String CONNECTION_CLOSE = "connectionClose";

    public static final String NUMBER = "number";

    public static final String OBJECT = "object";
    public static final String ARRAY = "array";
    public static final Integer MAX_ARRAY_LENGTH = 2147483637;
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String SPECIAL_CHARACTERS_REGEX = "[^a-zA-Z0-9]";
    public static final String OPEN_CURLY_BRACE = "{";
    public static final String CLOSE_CURLY_BRACE = "}";
    public static final String SLASH = "/";
    public static final String CONSTRAINT = "constraint";
    public static final String CONSTRAINT_STRING = "constraint:String";
    public static final String CONSTRAINT_NUMBER = "constraint:Number";
    public static final String CONSTRAINT_FLOAT = "constraint:Float";
    public static final String CONSTRAINT_INT = "constraint:Int";
    public static final String CONSTRAINT_ARRAY = "constraint:Array";
    public static final String OPEN_BRACE = "{";
    public static final String CLOSE_BRACE = "}";
    public static final String COLON = ":";

    public static final String CLIENT_CONFIG_CUSTOM_HEADERS = "clientConfig.customHeaders";

    public static final String S_DOT = "s.";

    public static final String DOT_TO_STRING = ".toString()";

    public static final String HEADER_PARAMS = "headerParams";

    public static final String QUERY_PARAMS = "queryParams";

    public static final String PATH_PARAMS = "pathParams";

    public static final String PATH_PARAMETERS = "path parameters";

    public static final String QUERY_PARAMETERS = "query parameters";

    public static final String HEADER_PARAMETERS = "header parameters";

    public static final String FAIL_TO_READ_ENDPOINT_DETAILS = "Failed to read endpoint details of the server: ";

    public static final String DISPATCHER_KEY_AND_DISPATCHER_STREAM_ID_MUST_BE_STRING = "Both dispatcherKey and " +
            "dispatcherStreamId type must be string";

    public static final String DISPATCHER_KEY_AND_DISPATCHER_STREAM_ID_MUST_BE_INSIDE_REQUIRED_PROPERTY = "Both " +
            "dispatcherKey and dispatcherStreamId type must be inside required property";

    public static final String SCHEMA_MUST_BE_A_RECORD = "%s schema must be a record, and it must have" +
            " properties to contain dispatcherKey as a field";

    public static final String RESPONSE_TYPE_MUST_BE_A_RECORD = "Response type must be a record, " +
            "invalid response type %s in %s schema, schema must contain " +
            "properties field to contain dispatcherKey";

    public static final String X_NULLABLE = "x-nullable";

    public static final String INVALID_RESPONSE_SCHEMA = "Response type must be a record, invalid response schema";
    public static final String REF = "$ref";

    public static final String GRACEFUL_CLOSE = "gracefulClose";

    public static final String DOT = ".";

    public static final String NOT_IS = "!is";


    public static final String WSS = "wss";

    public static final String DEFAULT_URL = "ws://localhost:9090/v1";

    public static final String SERVICE_URL_DESCRIPTION = "URL of the target service";

    public static final String DOUBLE_QUOTE = "\"";
    public static final String COMMA = ",";
    public static final String MAX_LENGTH = "maxLength";
    public static final String MIN_LENGTH = "minLength";
    public static final String MINIMUM = "minValue";
    public static final String MAXIMUM = "maxValue";
    public static final String EXCLUSIVE_MAX = "maxValueExclusive";
    public static final String EXCLUSIVE_MIN = "minValueExclusive";
    public static final String SPECIAL_CHARACTER_REGEX = "([\\[\\]\\\\?!<>@#&~`*\\-=^+'();:\\/\\_{}\\s|.$])";
    public static final String PIPE = "|";

    public static final String READ_ONLY = "readOnly";

    public static final String GET_PIPE = "getPipe";

    public static final String CLONE_WITH_TYPE = "cloneWithType";

    public static final String INIT = "init";

    public static final String QUEUE_DEFAULT_SIZE = "1000";

    public static final String BALLERINA_WEBSOCKET_DOESNT_SUPPORT_FOR_MULTIPLE_CHANNELS =
            "Ballerina websocket doesn't support for multiple channels";
    public static final String X_DISPATCHER_KEY_MUST_INCLUDE_IN_THE_SPECIFICATION = "x-dispatcherKey must include" +
            " in the specification";

    public static final String X_DISPATCHER_KEY_CANNOT_BE_EMPTY = "x-dispatcherKey cannot be empty";

    public static final String X_DISPATCHER_STREAM_ID_CANNOT_BE_EMPTY = "x-dispatcherStreamId cannot be empty";

    public static final String BALLERINA_CLIENT_CANNOT_BE_GENERATED = "Ballerina client cannot be " +
            "generated enter correct specification and adhere to tool's rules";

    public static final String START_MESSAGE_READING_DESCRIPTION = "Use to read messages from the websocket.";

    public static final String START_PIPE_TRIGGERING_DESCRIPTION = "Use to map received message responses into " +
            "relevant requests.\n";

    public static final String START_MESSAGE_WRITING_DESCRIPTION = "Use to write messages to the websocket.";

    public static final String HAS_KEY = "hasKey";

    public static final String DEFAULT_RETURN = "null";

    public static final Map<String, String> TYPE_MAP;

    static {
        Map<String, String> typeMap = new HashMap<>();
        typeMap.put("integer", "int");
        typeMap.put("string", "string");
        typeMap.put("boolean", "boolean");
        typeMap.put("array", "[]");
        typeMap.put("object", "record {}");
        typeMap.put("decimal", "decimal");
        typeMap.put("number", "decimal");
        typeMap.put("double", "decimal");
        typeMap.put("float", "float");
        typeMap.put("binary", "byte[]");
        typeMap.put("byte", "byte[]");
        typeMap.put("{}", "json");
        TYPE_MAP = Collections.unmodifiableMap(typeMap);
    }

    /**
     * Enum to select the code generation mode.
     * Ballerina service, mock and client generation is available
     */
    public enum GenType {
        GEN_SERVICE("gen_service"),
        GEN_CLIENT("gen_client"),
        GEN_BOTH("gen_both");

        private final String name;

        GenType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    /**
     * Enum to select the relevant ballerina http auth record.
     */
    public enum AuthConfigTypes {
        BASIC("websocket:CredentialsConfig"),
        BEARER("websocket:BearerTokenConfig"),
        CLIENT_CREDENTIAL("websocket:OAuth2ClientCredentialsGrantConfig"),
        CUSTOM_CLIENT_CREDENTIAL("OAuth2ClientCredentialsGrantConfig"),
        REFRESH_TOKEN("websocket:OAuth2RefreshTokenGrantConfig"),
        CUSTOM_REFRESH_TOKEN("OAuth2RefreshTokenGrantConfig"),
        PASSWORD("websocket:OAuth2PasswordGrantConfig"),
        CUSTOM_PASSWORD("OAuth2PasswordGrantConfig");

        private final String authType;

        AuthConfigTypes(String authType) {
            this.authType = authType;
        }

        public String getValue() {
            return authType;
        }
    }
}
