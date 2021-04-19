import tree as t

tree, root = t.create()

root = tree.insert(10, "123", 123,root)
root = tree.insert(20, "123", 123,root)
root = tree.insert(130, "123", 123,root)
root = tree.insert(40, "123", 123,root)
root = tree.insert(150, "123", 123,root)
root = tree.insert(105, "123", 123,root)

utente = tree.find(200, root)
if utente is None:
    print("n existe")
else:
    print("ja la esta")