class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def preorder(root):
    return [root.val] + preorder(root.left) + preorder(root.right) if root else []


def inorder(root):
    return inorder(root.left) + [root.val] + inorder(root.right) if root else []


def postorder(root):
    return postorder(root.left) + postorder(root.right) + [root.val] if root else []


root = TreeNode(10)
root.left = TreeNode(20)
root.right = TreeNode(30)
root.left.left = TreeNode(40)
root.left.right = TreeNode(50)
root.right.left = TreeNode(60)
root.right.right = TreeNode(70)

print(preorder(root))
print(inorder(root))
print(postorder(root))
