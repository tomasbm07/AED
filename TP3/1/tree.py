class Node:
    def __init__(self, num):
        self.num = num
        self.left = None
        self.right = None


def hashcode(x):
    return x % 1000000007


def hashcode_2(x, y):
    mod = 1000000007
    return ((x % mod) + (y % mod)) % mod

# input is array with transaction, not hashed
def build_tree(values):
    tree = []

    # Calcular os hashcodes dos valores de input
    for i in values:
        tree.append(Node(hashcode(i)))

    while len(tree) != 1:
        temp_tree = []
        # Juntar 2 valores seguidos e calcular o seu hashcode
        for i in range(0, len(tree), 2):
            aux1 = tree[i]
            aux2 = tree[i + 1]
            joined_hash = hashcode_2(aux1.num, aux2.num)
            pai = Node(joined_hash)
            pai.left = aux1
            pai.right = aux2
            temp_tree.append(pai)
        tree = temp_tree

    return tree[0]  # Returns root


def print_tree(root):
    if root is None:
        return

    level = []
    level.append(root)

    while level:
        count = len(level)

        while count > 0:
            temp = level.pop(0)
            print(temp.num)
            if temp.left:
                level.append(temp.left)
            if temp.right:
                level.append(temp.right)

            count -= 1


def mooshak():
    def input_data():
        size = int(input())
        array = input().split(" ")
        array = [int(i) for i in array]
        return size, array

    size, array = input_data()

    root = build_tree(array)
    print_tree(root)

# Funcao apenas para testar o codigo com o Mooshak
# mooshak()
