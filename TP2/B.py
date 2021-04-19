# Solucao melhorada 1

import time as t


def input_data():
    size = int(input())
    array = input().split(" ")
    array = [int(i) for i in array]
    return size, array

def main(size, array):
    start_time = t.time()
    array.sort(reverse=True)
    highest_sum = array[0] + array[1]
    print(highest_sum)
    return (t.time() - start_time)*1000



#size, array = input_data()
#main(size, array)

