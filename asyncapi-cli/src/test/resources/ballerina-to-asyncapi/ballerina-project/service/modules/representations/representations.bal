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


# Represents location
public type Location record {|

    # Unique identification
    string id;
     
    string event;
|};
# Represents a collection of locations
public type Locations record {|
    # collection of locations
    Location[] locations;
|};

public enum RoomCategory {
    DELUXE,
    KING,
    FAMILY
}
public enum RoomStatus {
    AVAILABLE,
    RESERVED,
    BOOKED
}

# Represents resort room
public type Room record {|
    # Unique identification
    string id;
    #Types of rooms available
    RoomCategory category;
    # Number of people that can be accommodate
    int capacity;
    # Availability of wifi
    boolean wifi;
    # Availability of room
    RoomStatus status;
    # Currency used in price
    string currency;
    # Cost for the room
    decimal price;
    # Number of rooms as per the status
    int count;
|};
# Represents a collection of resort rooms
public type Rooms record {|
    # Array of rooms
    Room[] rooms;
    string event;
|};

# Represents rooms be reserved
public type ReserveRoom record {|
    # Unique identification of the room
    string id;
    # Number of rooms
    int count;

    string event;
|};
# Represents a reservation of rooms
public type Reservation record {|
    # Rooms to be reserved
    ReserveRoom[] reserveRooms;
    # Start date in yyyy-mm-dd
    string startDate;
    # End date in yyyy-mm-dd
    string endDate;

    string event;
|};
# Represents a receipt for the reservation
public type ReservationReceipt record {|

    # Unique identification
    string id;
    # Expiry date in yyyy-mm-dd
    string expiryDate;
    # Last updated time stamp
    string lastUpdated;
    # Currency used in price
    string currency;
    # Total payable
    decimal total;
    # Reservation
    Reservation reservation;
|};
public type ReservationUpdated record {|
    ReservationReceipt body;
|};
public type ReservationCreated record {|
    ReservationReceipt body;
|};
public type ReservationConflict record {|
    string body = "Error occurred while updating the reservation";
|};

# Reperesents payement for rooms
public type Payment record {|
    # Name of the card holder
    string cardholderName;
    # Card number
    int cardNumber;
    # Expiration month of the card in mm
    string expiryMonth;
    # Expiaration year of the card in yyyy
    string expiryYear;

    string event;
|};

# Reperesents receipt for the payment
public type PaymentReceipt record {|
    # Unique identification
    string id;
    # Currency used in price
    string currency;
    # Total amount paid
    decimal total;
    # Last updated time stamp
    string lastUpdated;
    # Booked rooms
    Room[] rooms;
|};
public type PaymentCreated record {|
    PaymentReceipt body;
|};
public type PaymentConflict record {|
    string body = "Error occurred while updating the payment";
|};

public type PaymentSuccess record {|
    string body = "Error occurred while updating the payment";
|};
public type PaymentFault record {|
    string body = "Error occurred while updating the payment";
|};

public enum Status {
    OPEN,
    CLOSED,
    HOLD
}

public type LiftRecord readonly & record {|
    readonly string id;
    string name;
    Status status?;
    int capacity?;
    boolean night?;
    int elevationgain?;
|};

public final readonly & table<LiftRecord> key(id) liftTable = table [
    { id: "astra-express", name: "Astra Express", status: OPEN, capacity: 10, night: false, elevationgain: 20},
    { id: "jazz-cat", name: "Jazz Cat", status: CLOSED, capacity: 5, night: true, elevationgain: 30},
    { id: "jolly-roger", name: "Jolly Roger", status: CLOSED, capacity: 8, night: true, elevationgain: 10}
];

