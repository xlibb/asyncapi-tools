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
     # Represents Snowpeak location resource
    #
    resource function get locations() returns websocket:Service|websocket:Error {
        return new WsService();
    }
}

service class WsService {
    *websocket:Service;

    remote function onSubscribe(websocket:Caller caller, Subscribe message) returns Location[] {
        Location[] locations=getLocation();
        return locations;
    }

}

function getLocation() returns Location[] {
    return [
        {
            name: "Alps",
            id: "l1000",
            address: "NC 29384, some place, switzerland",
            links: [
                {
                    rel: "room",
                    href: "http://localhost:9090/snowpeak/locations/l1000/rooms",
                    mediaTypes: ["applicaion/vnd.snowpeak.resort+json"]

                }
            ]
        },
        {
            name: "Pilatus",
            id: "l2000",
            address: "NC 29444, some place, switzerland",
            links: [
                {
                    rel: "room",
                    href: "http://localhost:9090/snowpeak/locations/l2000/rooms",
                    mediaTypes: ["applicaion/vnd.snowpeak.resort+json"]
                }
            ]
        }
    ];
}

public type Subscribe record{
    int id;
    string event;
};
# Link details
type Link record {|
    # linnk rel
    string rel;
    # link href
    string href;
    # link mediatype
    string[] mediaTypes?;
|};

# Link details
type Links record {|
    # Array links
    Link[] links;
|};

# Represents locations
type Location record {|
    *Links;
    # Name of the location
    string name;
    # Unique identification
    string id;
    # Address of the location
    string address;
|};


