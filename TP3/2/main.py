import tree as t
import time
import random as r
import string as s


def generate_input(size, flag):
    if flag == 0:
        NUM1 = int(size*0.9)
        NUM2 = int(size*0.1)
    elif flag == 1:
        NUM2 = int(size*0.9)
        NUM1 = int(size*0.1)

    numbers = [r.randint(1,10000) for x in range(NUM1)]
    array = ""
    for i in range(NUM1):
        array += f"ACRESCENTA {r.choice(numbers)} {''.join((r.choice(list(s.ascii_lowercase))) for i in range(10))} {r.randint(10000000, 99999999)}\n"
    for i in range(NUM2):
        array += f"CONSULTA {r.choice(numbers)}\n"
    
    return array


def main():
    tempos = []
    tempos2 = []
    N = []

    #array = "APAGA\nACRESCENTA 12340 polio 20022025\nACRESCENTA 56700 covid 10082023\nACRESCENTA 88100 tuberculose 15122030\nCONSULTA 56700\nACRESCENTA 56700 covid 10102024\nACRESCENTA 56700 papeira 12112026\nLISTAGEM\nAPAGA\nFIM\n"
    #array = array.split('\n')
    #create_tree(tree, root, array)
    for y in range(2):
        for x in range(200, 1000000, 50000):
            tree, root = t.create()
            array = generate_input(x, y)
            array = array.split('\n')

            start = time.time()
            create_tree(tree, root, array)
            total_time = time.time() - start

            if y == 0:
                tempos.append(total_time)
                N.append(x)
            else:
                tempos2.append(total_time)

    write_file(N, tempos, tempos2)
    

def create_tree(tree, root, array):
    for i in array:
        comando = i.split(' ')
        if comando[0] == 'ACRESCENTA':
            root = tree.insert(int(comando[1]), comando[2], int(comando[3]), root)
        elif comando[0] == 'CONSULTA':
            utente = tree.find(int(comando[1]), root)
            #print(utente)  
        elif comando[0] == 'APAGA':
            root = None
            print('LISTAGEM DE NOMES APAGADA')
        elif comando[0] == 'LISTAGEM':
            tree.print_tree(root)
            

def write_file(size, tempos, tempos2):
    with open('results.csv', 'w') as f:
        f.write('N,90 inserts,10 inserts')
        for i in range(len(tempos)):
            f.write(f"{size[i]},{tempos[i]},{tempos2[i]}\n")


if __name__ == '__main__':
    main()
