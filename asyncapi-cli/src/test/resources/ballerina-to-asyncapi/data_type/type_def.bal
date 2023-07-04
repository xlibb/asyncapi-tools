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

# Adding doc
public type Action string;
public type Count int;
public type Rels string[];
public type Books map<string>;
public type Price float|PriceMap;
public type Salary int|float|decimal;
public type PetId int;

type Type record {|
    Books books?;
    Rels rels;
    Action actions?;
    Count? count;
    Price price;
    Salary salary;
    string tuple;
|};

type PriceMap record {|
    int price;
    decimal salary;
    string tuple;
|};

@websocket:ServiceConfig{dispatcherKey: "tuple"}
service /payloadV on new websocket:Listener(9090) {

    # Represents resource function description
    #
    # + id - id path param description
    resource function get reservation/[PetId id]() returns websocket:Service|websocket:UpgradeError {
        return new ChatServer();
    }
}

service class ChatServer{
    *websocket:Service;
    # Remote tuple description
    #
    # + message - Type message description
    # + return - this is User return description
     remote function onType(websocket:Caller caller, Type message) returns PriceMap {
        return {price:3,salary:45.9,tuple:"testing"};
    }
}
