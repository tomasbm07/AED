import time as t
import random as r
import numpy as np
import tree
import graph as g

#Gerar um transacao random
def generate_transaction():
    transaction = ""
    transaction += str(r.randint(1,9999))#Valor
    transaction += str(r.randint(1,31))#Dia
    transaction += str(r.randint(1,12))#Mes
    transaction += str(r.randint(2007,2100))#Ano
    return int(transaction)
    
#Gerar um array com um tamanho size
def generate_array(size):
    array = []
    array = [generate_transaction() for i in range(size)]
    return array


def main():
    f = open("result.csv", "w")

    N = []
    tempos = []

    iterations = range(1,23)
    k = 0 # apenas para dar print a uma percentagem de progresso

    f.write("N, tempo(s)\n")

    for i in iterations:
        array = generate_array(2**i)
        start = t.time()
        root = tree.build_tree(array)
        total_time = t.time() - start

        tempos.append(total_time)
        N.append(2**i)
        f.write(f"{2**i},{total_time}\n")
 
        k+=1 
        print(f"{((k/len(iterations))*100):.0f}%") # Print do progresso

    g.draw_graph(N, tempos)
    f.close()
        

if __name__ == '__main__':
    main()
