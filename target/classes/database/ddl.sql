CREATE TABLE country (
    codecountry VARCHAR(5) PRIMARY KEY,
    namecountry VARCHAR(50) NOT NULL
);

CREATE TABLE region (
    codereg VARCHAR(5) PRIMARY KEY,
    namereg VARCHAR(50) NOT NULL,
    codecountry VARCHAR(5) NOT NULL,
    FOREIGN KEY (codecountry) REFERENCES country(codecountry)
);

CREATE TABLE city (
    codecity VARCHAR(5) PRIMARY KEY,
    namecity VARCHAR(50) NOT NULL,
    codereg VARCHAR(5) NOT NULL,
    FOREIGN KEY (codereg) REFERENCES region(codereg)
);

CREATE TABLE labatory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    namelab VARCHAR(50) NOT NULL,
    codecityreg VARCHAR(5) NOT NULL,
    FOREIGN KEY (codecityreg) REFERENCES city(codecity)
);

CREATE TABLE modeadministration (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descriptionmode VARCHAR(60) NOT NULL
);

CREATE TABLE activeprinciple (
    idap INT AUTO_INCREMENT PRIMARY KEY,
    nameap VARCHAR(60) NOT NULL
);

CREATE TABLE unitmeasurement (
    idum INT AUTO_INCREMENT PRIMARY KEY,
    nameum VARCHAR(50) NOT NULL
);

CREATE TABLE medicine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    proceedings VARCHAR(10),
    namemedicine VARCHAR(100) NOT NULL,
    healthregister VARCHAR(50),
    description TEXT,
    descriptionshort VARCHAR(60),
    codemodeadmin INT,
    codeap INT,
    codeum INT,
    namerol VARCHAR(100),
    codelab INT,
    FOREIGN KEY (codemodeadmin) REFERENCES modeadministration(id),
    FOREIGN KEY (codeap) REFERENCES activeprinciple(idap),
    FOREIGN KEY (codeum) REFERENCES unitmeasurement(idum),
    FOREIGN KEY (codelab) REFERENCES labatory(id)
);

CREATE TABLE farmacy (
    idfarmacy INT AUTO_INCREMENT PRIMARY KEY,
    namefarmacy VARCHAR(60) NOT NULL,
    addressfarmacy VARCHAR(100) NOT NULL,
    `long` DOUBLE NOT NULL,
    latfarmacy DOUBLE NOT NULL,
    codecityfarm VARCHAR(5) NOT NULL,
    logofarmacy VARCHAR(50),
    FOREIGN KEY (codecityfarm) REFERENCES city(codecity)
);

CREATE TABLE customer (
    idcustomer VARCHAR(20) PRIMARY KEY,
    namecustomer VARCHAR(50) NOT NULL,
    lastnamecustomer VARCHAR(50) NOT NULL,
    codecitycustomer VARCHAR(5) NOT NULL,
    emailcustomer VARCHAR(100),
    birthdate DATE,
    lon DOUBLE,
    latitud DOUBLE,
    FOREIGN KEY (codecitycustomer) REFERENCES city(codecity)
);

CREATE TABLE farmacymedicine (
    idfarmacy INT NOT NULL,
    idmedicinefarm INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (idfarmacy, idmedicinefarm),
    FOREIGN KEY (idfarmacy) REFERENCES farmacy(idfarmacy),
    FOREIGN KEY (idmedicinefarm) REFERENCES medicine(id)
);
