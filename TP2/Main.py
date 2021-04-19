import random as r
import matplotlib.pyplot as plt
import numpy as np
import sys
from B import main # selecionar o algoritmo a usar


def draw_plot():
    tempos = []
    N = []

    NUM = 1  # Numero operaçoes para cada N. Para poder fazer uma media de valores para cada N

    with open("B.txt", "w") as f: # mudar nome do ficheiro onde guardar os pontos
        iterations = range(100, 50000, 50)
        for k in iterations:
            aux_tempos = 0
            N.append(k)
            for j in range(NUM):
                array = [np.random.randint(0, 100000) for i in range(k)]
                tempo = main(len(array), array)
                aux_tempos += tempo
            tempo = aux_tempos / NUM
            tempos.append(tempo)
            f.write(f"{k},{tempo:.4f}\n")
            plt.plot(k, tempo, '.k')

    plt.xlabel("N")
    plt.ylabel("Tempo(ms)")

    tempos = np.array(tempos)
    N = np.array(N)

    p1 = np.polyfit(N, tempos, 1)
    plt.plot(N, np.polyval(p1, N), 'r')

    plt.show()


draw_plot()
