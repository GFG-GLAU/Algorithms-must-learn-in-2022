class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def level_order_traversal(root: TreeNode):
    if root is None:
        return []

    res, queue = [], [root]
    while queue:
        res.append([node.val for node in queue])
        temp = []

        for node in queue:
            temp.extend([node.left, node.right])
        queue = [leaf for leaf in temp if leaf]

    return res


a = TreeNode(10)
a.left = TreeNode(20)
a.right = TreeNode(30)
a.left.left = TreeNode(40)
a.left.right = TreeNode(50)
a.right.left = TreeNode(60)
a.right.right = TreeNode(70)
print(level_order_traversal(a))
