import csv
import random
from faker import Faker
from datetime import datetime, timedelta

fake = Faker()

# Fonction pour générer une date aléatoire entre deux dates spécifiées
def random_date(start_date, end_date):
    return fake.date_between_dates(date_start=start_date, date_end=end_date)

# Génération de données pour la table Machines
with open('fichier_machines.csv', 'w', newline='') as csvfile:
    fieldnames = ['ID_Machine', 'Marque', 'Date_Achat', 'RAM']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()

    for i in range(1, 101):
        writer.writerow({
            'ID_Machine': i,
            'Marque': random.choice(['HP', 'Dell', 'Lenovo', 'Asus']),
            'Date_Achat': random_date(datetime(2010, 1, 1), datetime(2022, 1, 1)),
            'RAM': random.randint(4, 32)  # Change the range as needed
        })

# Génération de données pour la table Logiciels
with open('fichier_logiciels.csv', 'w', newline='') as csvfile:
    fieldnames = ['ID_Logiciel', 'Nom_Logiciel', 'Version', 'Licence']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()

    for i in range(1, 51):
        writer.writerow({
            'ID_Logiciel': i,
            'Nom_Logiciel': fake.word(),
            'Version': fake.random_element(elements=('1.0', '2.0', '3.0')),
            'Licence': fake.random_element(elements=('Open Source', 'Propriétaire'))
        })

# Génération de données pour la table Utilisateurs
with open('fichier_utilisateurs.csv', 'w', newline='') as csvfile:
    fieldnames = ['ID_Utilisateur', 'Nom', 'Prenom']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()

    for i in range(1, 51):
        writer.writerow({
            'ID_Utilisateur': i,
            'Nom': fake.last_name(),
            'Prenom': fake.first_name()
        })

# Génération de données pour la table Affectations
with open('fichier_affectations.csv', 'w', newline='') as csvfile:
    fieldnames = ['ID_Affectation', 'ID_Machine', 'ID_Utilisateur', 'Date_Affectation']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()

    for i in range(1, 101):
        writer.writerow({
            'ID_Affectation': i,
            'ID_Machine': random.randint(1, 100),
            'ID_Utilisateur': random.randint(1, 50),
            'Date_Affectation': random_date(datetime(2010, 1, 1), datetime(2022, 1, 1))
        })

# Génération de données pour la table Maintenance
with open('fichier_maintenance.csv', 'w', newline='') as csvfile:
    fieldnames = ['ID_Maintenance', 'ID_Machine', 'Technicien', 'Date_Maintenance', 'Action_Maintenance']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()

    for i in range(1, 101):
        writer.writerow({
            'ID_Maintenance': i,
            'ID_Machine': random.randint(1, 100),
            'Technicien': fake.name(),
            'Date_Maintenance': random_date(datetime(2010, 1, 1), datetime(2022, 1, 1)),
            'Action_Maintenance': fake.sentence()
        })

