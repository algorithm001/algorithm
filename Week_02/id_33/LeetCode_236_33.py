def lowestCommonAncestor(root, p, q):
    for i in range(len(root)):
        if root[i] == p:
            pi = i+1
        if root[i] == q:
            qi = i+1
    while(pi < qi):
        qi = qi // 2
    while(qi < pi):
        pi = pi // 2
    if pi == qi:
        print(root[pi-1])


root = [3,5,1,6,2,0,8,None,None,7,4]

p = 5
q = 1
lowestCommonAncestor(root, p, q)

root = [3,5,1,6,2,0,8,None,None,7,4]
p = 5
q = 4
lowestCommonAncestor(root, p, q)
