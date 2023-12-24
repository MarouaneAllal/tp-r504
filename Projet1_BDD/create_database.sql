-- Machines Table
CREATE TABLE Machines (
    ID_Machine INT PRIMARY KEY,
    Marque VARCHAR(255),
    Date_Achat DATE,
    RAM INT
);

-- Logiciels Table
CREATE TABLE Logiciels (
    ID_Logiciel INT PRIMARY KEY,
    Nom_Logiciel VARCHAR(255),
    Version VARCHAR(50),
    Licence VARCHAR(50)
);

-- Utilisateurs Table
CREATE TABLE Utilisateurs (
    ID_Utilisateur INT PRIMARY KEY,
    Nom VARCHAR(255),
    Prenom VARCHAR(255)
);

-- Affectations Table
CREATE TABLE Affectations (
    ID_Affectation INT PRIMARY KEY,
    ID_Machine INT,
    ID_Utilisateur INT,
    Date_Affectation DATE,
    FOREIGN KEY (ID_Machine) REFERENCES Machines(ID_Machine),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateurs(ID_Utilisateur)
);

-- Maintenance Table
CREATE TABLE Maintenance (
    ID_Maintenance INT PRIMARY KEY,
    ID_Machine INT,
    Technicien VARCHAR(255),
    Date_Maintenance DATE,
    Action_Maintenance VARCHAR(255),
    FOREIGN KEY (ID_Machine) REFERENCES Machines(ID_Machine)
);

