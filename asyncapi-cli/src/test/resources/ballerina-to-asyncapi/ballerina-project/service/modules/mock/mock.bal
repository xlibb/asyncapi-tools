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

import 'service.representations as rep;

public isolated function getLocations() returns rep:Locations {
    return {
        locations: [
            {
         
                id: "l1000",
                event:""
                
            },
            {
            
                id: "l2000",
                event:""
            }
        ]
    };
}

public isolated function getRooms(string startDate, string endDate) returns rep:Rooms {
    return {
        rooms: [
            {
                id: "r1000",
                category: rep:DELUXE,
                capacity: 5,
                wifi: true,
                status: rep:AVAILABLE,
                currency: "USD",
                price: 200.00,
                count: 3
            }
        ],
        event: ""
    };
}

public isolated function createReservation(rep:Reservation reservation) returns rep:ReservationCreated {
    return {

        body: {
            id: "re1000",
            expiryDate: "2021-07-01",
            lastUpdated: "2021-06-29T13:01:30Z",
            currency: "USD",
            total: 400.00,
            reservation: {
                reserveRooms: [
                    {
                        id: "r1000",
                        count: 2,
                        event: ""
                    }
                ],
                startDate: "2021-08-01",
                endDate: "2021-08-03",
                event: ""
            }
        }
    };
}

public isolated function updateReservation(rep:Reservation reservation) returns rep:ReservationUpdated {
    return {
        body: {
            id: "re1000",
            expiryDate: "2021-07-01",
            lastUpdated: "2021-07-05T13:01:30Z",
            currency: "USD",
            total: 400.00,
            reservation: {
                reserveRooms: [
                    {
                        id: "r1000",
                        count: 1,
                        event: ""
                    }
                ],
                startDate: "2021-08-01",
                endDate: "2021-08-03",
                event: ""
            }
        }
    };
}

public isolated function createPayment(string id, rep:Payment payment) returns rep:PaymentCreated {
    return {
       
        body: {
            id: "p1000",
            currency: "USD",
            total: 400.00,
            lastUpdated: "2021-06-29T13:01:30Z",
            rooms: [
                    {
                    id: "r1000",
                    category: rep:DELUXE,
                    capacity: 5,
                    wifi: true,
                    status: rep:RESERVED,
                    currency: "USD",
                    price: 200.00,
                    count: 1
                }
            ]
        }
    };
}

