export enum Status {
    Active = 'Connected',
    Inactive = 'notConnected',
}

export function booleanToStatus(value: String): Status {
    if (value.toString() == Status.Active.toString() ){
        return Status.Active;

    } else {
        return Status.Inactive;
    }
}
