import fonctions as f
while True:
    # Saisie d'un nombre au clavier
    a = float(input("Veuillez entrer un nombre a : "))
    b = float(input("Veuillez entrer un nombre b : "))


    # Calcul du carré
    carre = a** b

    # Affichage du résultat
    print(f"Le carré de {a}**{b} est : {carre}")
    res = f.puissance(a,b)
    print res
