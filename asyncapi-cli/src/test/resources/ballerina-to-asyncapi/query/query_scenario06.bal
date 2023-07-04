// Copyright (c) 2023 WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/websocket;

@websocket:ServiceConfig {dispatcherKey: "event"}
service /payloadV on new websocket:Listener(9090) {
    resource function get hello(string pet="hello",int offsetInteger=5,decimal offsetDecimal=100.08,boolean offsetBoolean=true, float offsetFloat=100.08,int[] offsetIntegerArray= [2, 1, 3, 4],int? offset=(),map<json>? offsetNullableJson = {"x": {"id": "sss"}},map<json> offsetJson = {"x": {"id": "sss"}}) returns websocket:Service|websocket:Error {
        return new WsService();
    }
}

service class WsService {
    *websocket:Service;

    remote isolated function onSubscribe(websocket:Caller caller, Subscribe data) returns string {
        return "Hello World!";
    }
}


public type Subscribe record{
    int id;
    string event;
};