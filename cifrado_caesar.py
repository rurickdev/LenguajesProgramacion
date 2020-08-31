'''
Proyecto 2
Integrantes equipo:
    Maqueo Poisot Rurick
    Peña Lopez Daniel Elihu
'''

import sys
'''
realiza el cifrado desplazando hacia la derecha si la ubicacion del caracer es par
y a la izquierda si no lo es, regresa la cadena ya cifrada
'''
def cifrar(cadena, rec):
    cadCifrada = ""

    i = 0
    while i < len(cadena):
        car = cadena[i]
        if i%2==0:
            cadCifrada = cadCifrada + chr(ord(car) + rec)
        else:
            cadCifrada = cadCifrada + chr(ord(car) - rec)
        i += 1

    return cadCifrada
'''
imprime "Cadena cifrada" y manda a ejecutar el cifrado pasando los argumentos desde la terminal
python caesar.py [desplazamiento en numero] [Cadena]
si la cadena tiene espacios se debe colocar entre comillas
Ej:
python caesar.py 5 "La criptografia es romantica"
'''
print ("Cadena Cifrada: " + cifrar(sys.argv[2], int(sys.argv[1])))
