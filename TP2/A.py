# Solucao exaustiva

import time as t


def input_data():
    size = int(input())
    array = input().split(" ")
    array = [int(i) for i in array]
    return size, array


def main(size, array):
    initial_run = True
    highest_sum = 0

    start_time = t.time()

    for i in range(size):
        for j in range(i + 1, size):
            soma = array[i] + array[j]
            if initial_run:
                initial_run = False
                highest_sum = soma
            else:
                if (soma > highest_sum):
                    highest_sum = soma

    print(highest_sum)

    #print(f"--{((t.time() - start_time)*1000):.4f} ms--")
    return (t.time() - start_time)*1000

#size, array = input_data()
#main(size, array)

