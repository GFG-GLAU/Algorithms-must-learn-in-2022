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


root = TreeNode(10)
root.left = TreeNode(20)
root.right = TreeNode(30)
root.left.left = TreeNode(40)
root.left.right = TreeNode(50)
root.right.left = TreeNode(60)
root.right.right = TreeNode(70)

print(level_order_traversal(root))
