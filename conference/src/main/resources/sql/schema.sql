CREATE TABLE demo (
	id IDENTITY PRIMARY KEY,
    data VARCHAR(100)
);

CREATE TABLE conference (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    description LONGVARCHAR NULL,
    location LONGVARCHAR NULL
);

CREATE INDEX startDate ON conference (startDate);
CREATE INDEX endDate ON conference (endDate);

CREATE TABLE conferenceCategory (
	id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description LONGVARCHAR NOT NULL
);

CREATE TABLE conferenceCategories (
	conferenceId INTEGER,
	conferenceCategoryId INTEGER
);
CREATE TABLE conferenceAttendees (
	conferenceId INTEGER,
	userId INTEGER
);

CREATE TABLE user (
	id IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	town VARCHAR(100) NOT NULL, --select from a list?
	country VARCHAR(100) NOT NULL,--select from a list?
	password VARCHAR(255) NOT NULL
	--,
	--type --is it needed?
);