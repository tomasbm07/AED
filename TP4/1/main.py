import random as r
import time
import numpy as np
import math as m
import matplotlib.pyplot as plt
from base_shell_sort import shell_sort


SIZE = 1000000


def main():

    for x in range(1000, SIZE, m.floor(SIZE*0.1)):
        N = []
        t = []

        array = [r.randint(0, 1000) for i in range(x)]

        start = time.time()
        array = shell_sort(array, x)
        tempo = time.time() - start
        N.append(x)
        t.append(tempo)
        print(tempo)

    print('DONE')



if __name__ == '__main__':
    main()