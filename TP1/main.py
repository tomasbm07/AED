def main():
	#print("Inserir tamanho da matrix (m x n)")
	linhas, colunas = input().split(" ")
	#print(f"Inserir matriz ({linhas} x {colunas})")
	matrix = [input().split("\n") for i in range(int(linhas))]
	for i in range(len(matrix)):
		matrix[i] = matrix[i][0].split(" ")

	print(90)
	rotated = rotate(matrix)
	print_matrix(rotated)

	for i in range(2,4,1):
		print(f"{90*i}")
		rotated = rotate(rotated)
		print_matrix(rotated)


def rotate(matrix):
	inverted = [ [0 for i in range(len(matrix))] for i in range(len(matrix[0]))]
	matrix.reverse()
	for i in range(len(matrix)):
		for j in range(len(matrix[i])):
			inverted[j][i] = matrix[i][j]
	return inverted


def print_matrix(matrix):
	# matrix = ['1','2','3']
	#          ['4','5','6']

	for i in range(len(matrix)): 
		aux = ""
		for j in range(len(matrix[i])): # matrix[i] = ['1','2','3']
			if j == len(matrix[i])-1:
				aux = aux + matrix[i][j]
			else:
				aux = aux + matrix[i][j] + " "
		print(aux)


main()
