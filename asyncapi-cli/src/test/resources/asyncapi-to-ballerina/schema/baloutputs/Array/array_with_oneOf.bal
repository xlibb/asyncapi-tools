public type Subscribe record {
    (ActivityResponseObject|EmployeeDetails)[] data?;
    string event;
};

public type UnSubscribe record {
    int zipCode?;
    string event;
};

public type ActivityResponseObject record {
    # Due date of the Activity. Format: YYYY-MM-DD
    string due_date?;
    # Due time of the Activity in UTC. Format: HH:MM
    string due_time?;
    # Duration of the Activity. Format: HH:MM
    string duration?;
    # The ID of the Deal this Activity is associated with
    int deal_id?;
};

public type EmployeeDetails record {
    # Employee ID
    string employee_id?;
    # Employee Name
    string employee_name?;
};
