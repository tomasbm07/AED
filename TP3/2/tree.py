# Arvore AVL

class Utente:
    def __init__(self, num, vacina, data):
        self.num = num
        self.vacina = [vacina]
        self.data = [data]

    def __str__(self):
        return f"{self.num} {self.get_vacinas()} {self.data}"

    def get_vacinas(self):
        string = ""
        for i in self.vacina:
            string += i
            string += ' '
        return string


class Node:
    def __init__(self, num, vacina, data):
        self.left = None
        self.right = None
        self.height = 1  # altura da sub-tree
        self.utente = Utente(num, vacina, data)  # dados


class Tree():
    #tree.insert(10000, "covid", 7012001, root)
    def insert(self, x, vacina, data, node):
        if node is None:
            #print('NOVO UTENTE CRIADO')
            return Node(x, vacina, data)
        elif x < node.utente.num:
            node.left = self.insert(x, vacina, data, node.left)
        elif x > node.utente.num:
            node.right = self.insert(x, vacina, data, node.right)
        else: # igual
            if vacina in node.utente.vacina:
                node.utente.data[0] = data
                #print('VACINA ATUALIZADA')
            else:
                node.utente.vacina.append(vacina) # else, adicionar a vacina ao utente
                node.utente.data.append(data)
                #print('NOVA VACINA INSERIDA')

        self.update_height(node)
        balance = self.calculate_balance(node)

        # left heavy
        if balance > 1 and x < node.left.utente.num:
            return self.rotate_right(node)
        # right heavy
        if balance < -1 and x > node.right.utente.num:
            return self.rotate_left(node)
        #
        if balance > 1 and x > node.left.utente.num:
            node.left = self.rotate_left(node.left)
            return self.rotate_right(node)
        #
        if balance < -1 and x < node.right.utente.num:
            node.right = self.rotate_right(node.right)
            return self.rotate_left(node)

        return node

    def calculate_balance(self, node):
        if node is None:
            return 0
        return self.get_height(node.left) - self.get_height(node.right)

    def get_height(self, node):
        if node is None:
            return 0
        return node.height

    def update_height(self, node):
        node.height = 1 + max(self.get_height(node.left),
                              self.get_height(node.right))

    def rotate_right(self, node):
        temp1 = node.left
        temp2 = temp1.right

        # rotate
        temp1.right = node
        node.left = temp2

        # update height
        self.update_height(node)
        self.update_height(temp1)
        return temp1

    def rotate_left(self, node):
        temp1 = node.right
        temp2 = temp1.left

        # rotate
        temp1.left = node
        node.right = temp2

        # update height
        self.update_height(node)
        self.update_height(temp1)
        return temp1

    def print_tree(self, node):
        if node is None:
            return

        self.print_tree(node.left)
        print(f"{node.utente.num} {node.utente.vacina} {node.utente.data}")
        self.print_tree(node.right)

    def find(self, x, node):
        if node is None:
            return None
        elif node.utente.num == x:
            return node.utente
        elif node.utente.num < x:
            return self.find(x, node.right)
        return self.find(x, node.left)


def create():
    return Tree(), None
