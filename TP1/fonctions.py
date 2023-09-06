# fonctions.py

def puissance(a, b):
   
    if not (isinstance(a, int) and isinstance(b, int)):
        raise TypeError("Les deux arguments doivent être des entiers")

    resultat = a ** b
    return int(resultat)

