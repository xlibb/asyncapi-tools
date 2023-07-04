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
import 'service.representations as ds;

@websocket:ServiceConfig{dispatcherKey: "event"}
service /payloadV on new websocket:Listener(9090) {
      resource function get .()returns websocket:Service|websocket:UpgradeError {
        return new ReadOnlyChatServer();
    }
}

service class ReadOnlyChatServer{
        *websocket:Service;
    # A list of all `Lift`s
    # + return - the lifts
    remote function onLocation(ds:Location location) returns ds:LiftRecord[] {
        ds:LiftRecord[] lifts=from var lift in ds:liftTable
            where lift.id == "5"
            select lift;
        return lifts;
    }

    # Returns a `Lift` by `id` (id: "panorama")
    # + return - the lift
    remote function onRooms(ds:Rooms room) returns ds:LiftRecord? {
        ds:LiftRecord[] lifts = from var lift in ds:liftTable
            where lift.id == "5"
            select lift;
        if lifts.length() > 0 {
            return lifts[0];
        }
        return;
    }


    remote function onReserveRoom(ds:ReserveRoom room) returns Subscribe[] {
        
       
        return [{id:"",event: ""}];
    }

}

public type Subscribe record {|
    # Unique identification of the room
    string id;

    string event;
|};