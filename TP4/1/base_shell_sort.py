

def shell_sort(array, size):
    gaps = [2**i for i in range(size//2, -1, -1)]

    for gap in gaps:
        for i in range(gap, size):
            temp = array[i]
            j = i
            while j >= gap and array[j - gap] > temp:
                array[j] = array[j - gap]
                j -= gap
            array[j] = temp

    return array
