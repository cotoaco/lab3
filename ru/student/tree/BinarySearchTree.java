package ru.student.tree;

public class BinarySearchTree {
    private TreeNode root;

    public void add(int value) {
        root = add(root, value);
    }

    private TreeNode add(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {
            node.left = add(node.left, value);
        } else if (value > node.value) {
            node.right = add(node.right, value);
        }

        return node;
    }

    public boolean contains(int value) {
        TreeNode current = root;

        while (current != null) {
            if (current.value == value) {
                return true;
            }

            current = value < current.value
                    ? current.left
                    : current.right;
        }

        return false;
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private TreeNode remove(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = remove(node.left, value);
        } else if (value > node.value) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode min = node.right;
            while (min.left != null) {
                min = min.left;
            }

            node.value = min.value;
            node.right = remove(node.right, min.value);
        }

        return node;
    }
}