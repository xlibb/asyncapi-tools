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

import ballerina/websocket ;

type Link record {|
    string rel;
    Dog|Cat pet;
|};

type Dog record {|
    int? id;
    string name?;
    string event;
|};

type Cat record {|
    int id;
    string eat?;
    string event;
|};

listener websocket:Listener ep0 = new(443);

@websocket:ServiceConfig{dispatcherKey: "event"}
service /payloadV on ep0 {
    resource function get pet(Link payload) returns websocket:Service| websocket:UpgradeError  {
         return new ChatServer();
    }
}

service class ChatServer{
    *websocket:Service;

     remote function onDog(websocket:Caller caller, Dog message) returns Cat {

        return {id:5,eat:"ate",event:"Cat"};
    }


}