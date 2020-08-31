'''
Programa 5: Evaluacion de Funciones Booleanas
Integrantes equipo:
    Maqueo Poisot Rurick
    Peña Lopez Daniel Elihu
'''
#De la libreria Math importa todo
from math import *

"""
    Pecibe una expresion aritmetica o logica y la resuelve
    s'olo puede n'umeros y s'imbolos de operaci'on
    para simular True (verdadero) usar 1
    para simular False (Falso) usar 0
    Ej: 1 v 0 sera equivalente a True or False que es igual a True o 1
"""

"""
    La funcion ev es la misma creada en clase, solo se anexó el diccionario
    de elemntos logicos con and y or
"""

def ev(ea):
    dic_o_bin={'+':'+', '*':'*', 'res':'%', '^':'**', '/':'/', '-':'-','<':'<',
                '>':'>', '<=':'<=', '>=':'>=', '=':'=='}
    dic_o_una={'raiz':'sqrt', '¬':'not'}
    dic_o_logic={'^^':'and', 'v':'or'}

    pn, ps = [], []
    elem = ea.split()
    for e in elem:
        if e == '(':pass
        elif e in dic_o_bin or e in dic_o_una or e in dic_o_logic: ps.append(e)
        elif e == ')':
            op,va = ps.pop(),pn.pop()
            if op in dic_o_una: va = eval( dic_o_una[op]+'('+str(va)+')')
            #Se Agrega una linea mas para agregar los espacion necesarios para
            #evaluar las operaciones logicas
            elif op in dic_o_logic: va = eval( str(pn.pop())+' '+dic_o_logic[op]+' '+str(va) )
            else: va = eval( str(pn.pop())+dic_o_bin[op]+str(va) )
            pn.append(va)
        else: pn.append(float(e))
    return pn

#Definicion de las pruebas
"""
    TDD (funcion, valoresParaFuncion, valorEsperado)
"""
def tdd (f,e,r):
    return f(e)==r

print("***** TDD Aritm'eticas *****")
print(tdd(ev, '( 2 * ( 25 - 20 ) ) / 4 )', [2.5]) )
print(tdd(ev, '( 6 * 3 )', [18.0]) )
print(tdd(ev, '( 4 * ( 5 + 2 ) )', [28.0]) )
print(tdd(ev, '( 3 ^ 2 )', [9.0]) )
print(tdd(ev, '( 2 ^ 5 )', [32.0]) )
print(tdd(ev, '( 3 res 2 )', [1.0]) )
print(tdd(ev, '( raiz 25 )', [5]) )
print("***** TDD Logicas****")
print(tdd(ev, '( 5 < 7 )', [True]) )
print(tdd(ev, '( 3 > 1 )', [True]) )
print(tdd(ev, '( 3 <= 3 )', [True]) )
print(tdd(ev, '( 4 >= 3 )', [True]) )
print(tdd(ev, '( 4 = 4 )', [True]) )
print(tdd(ev, '( 1 ^^ 0 )', [False]) )
print(tdd(ev, '( 1 v 0 )', [True]) )
print(tdd(ev, '( ¬ 1 )', [False]) )
