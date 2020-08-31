"""
Programa que calcula el numero binario en flotante simple para un numero
real ingresado.
Creado por Maqueo Poisot Rurick y Peña Lopez Daniel Elihu
"""

from math import modf

"""
    Recibe el numero a convertir, si el numero no tiene decimales se debe poner .0
    utiliza el algoritmo de conversion a flotante simple para convertirlo en
    flotante, el algoritmo está dividido en funciones. Corta los ultimos bits si
    se pasa de 32
    Regresa el numero ya convertido
"""
def convRealToFloat(numero):
    flotante, entero, decimal = [], [], []
    #Agregamos el bit de signo
    if numero <0:
        flotante.append(1)
        numero = numero * (-1)
    else:
        flotante.append(0)
    #Separamos parte entera de decimal
    parteEntera = int(modf(numero)[1])
    parteDecimal = modf(numero)[0]
    #Obtenemos las listas ya en binario
    entero = convEntToBin(parteEntera)[:]
    decimal = convDecToBin(parteDecimal)[:]
    flotante = flotante + calcExpo(entero) + crearMatiza(entero, decimal)
    if len(flotante)>32:
        del flotante[32:len(flotante)]
    return flotante

"""
    Recibe una lista de bits para sumarle al exponente y convertirlo a binario
    Regresa la lista con los bits del exponente
"""
def calcExpo(real):
    exponente = []
    expo = 127 + (len(real)-1)
    exponente = convEntToBin(expo)[:]
    return exponente

"""
    Recibe la parte entera y decimal ya convertidas a binario
    elimina el primer digito de la perte entera para simular el recorriemiento
    del punto y guarda la concatenacion en la variable matzia, llena con ceros
    si es necesario
    Regresa la matiza ya construida
"""
def crearMatiza(entero, decimal):
    matiza = []
    del entero[0]
    matiza += entero + decimal
    while len(matiza)<23:
        matiza.append(0)
    return matiza

"""
    Recibe la parte entera de un numero real y la convierte a binario usando el
    algoritmo para cambiar a base 2, guarda los bits en una listas
    Regresa la lista invertida
"""
def convEntToBin(numero):
    binEnt = []
    while numero!=0:
        binEnt.append(numero%2)
        numero = numero // 2
    binEnt.reverse()
    return binEnt

"""
    Recibe un la parte decimal de un numero real y la convierte a binario
    usando el algoritmo de la multiplicacion por dos y guardando el entero
    de dicha multiplicacion (1 o 0) en una lista
    Devuelve la lista binaria
"""
def convDecToBin(numero):
    binDec = []
    while (numero) and (len(binDec)<23):
        numero = numero * 2
        if numero >= 1:
            binDec.append(1)
            numero = numero - 1
        else:
            binDec.append(0)
    return binDec

print(convRealToFloat(-10.52))
