# Solucao melhorada 2

import time as t

def input_data():
    size = int(input())
    array = input().split(" ")
    array = [int(i) for i in array]
    return size, array


def main(size, array):
    num_max = 0
    prev_max = 0

    start_time = t.time()

    for i in array:
        changed = False
        if i > num_max:
            changed = True
            prev_max = num_max
            num_max = i

        if not changed and i > prev_max:
            prev_max = i

    highest_sum = num_max + prev_max

    print(highest_sum)
    return (t.time() - start_time)*1000


#size, array = input_data()
#main(size, array)
