import matplotlib.pyplot as plt
import numpy as np

def draw_graph(N, tempos):
    plt.scatter(N, tempos, color = 'black', marker = '.')

    plt.xlabel("N")
    plt.ylabel("Tempo(s)")
    #plt.xscale('log')

    tempos = np.array(tempos)
    N = np.array(N)

    #recurssion
    nlogn = np.polyfit(N*np.log(N),tempos,1)
    fit = np.poly1d(nlogn)
    plt.plot(N, fit(N*np.log(N)), 'r')

    p1 = np.polyfit(N, tempos, 1)
    #plt.plot(N, np.polyval(p1, N), '--b')

    plt.show()
