CREATE TABLE IF NOT EXISTS PERSON
(
    ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    FIRSTNAME VARCHAR(15),
    LASTNAME VARCHAR(15),
    AGE INT

    )
;
