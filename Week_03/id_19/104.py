def maxDepth(self, root):     
     if not root:
         return 0
     
     tqueue, h = collections.deque(),0
     tqueue.append(root)
     while tqueue:
         nextlevel = collections.deque()
         while tqueue:
             front = tqueue.popleft()
             if front.left:
                 nextlevel.append(front.left)
             if front.right:
                 nextlevel.append(front.right)
         tqueue = nextlevel
         h += 1
     return h
