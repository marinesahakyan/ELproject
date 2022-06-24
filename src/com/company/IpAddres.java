package com.company;

public class IpAddres {

    private static class IPaddresCounter {
        private final String value;
        private long height;
        private IPaddresCounter leftC;
        private IPaddresCounter rightC;

        public IPaddresCounter(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private IPaddresCounter root;
    private long size;

    public void insert(String value) {
        root = insert(root, value);
    }

    private IPaddresCounter insert(IPaddresCounter root, String value) {
        if (root == null) {
            size++;
            return new IPaddresCounter(value);
        }

        if (value.compareTo(root.value) < 0)
            root.leftC = insert(root.leftC, value);
        else if (value.compareTo(root.value) > 0)
            root.rightC = insert(root.rightC, value);

        setHeight(root);

        return balance(root);
    }

    public long size(){
        return size;
    }

    private IPaddresCounter rotateRight(IPaddresCounter root) {
        var newRoot = root.leftC;

        root.leftC = newRoot.rightC;
        newRoot.rightC = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private IPaddresCounter rotateLeft(IPaddresCounter root) {
        var newRoot = root.rightC;

        root.rightC = newRoot.leftC;
        newRoot.leftC = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(IPaddresCounter node) {
        node.height = Math.max(height(node.leftC), height(node.rightC)) + 1;
    }

    private IPaddresCounter balance(IPaddresCounter root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftC) < 0)
                root.leftC = rotateLeft(root.leftC);
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightC) > 0)
                root.rightC = rotateRight(root.rightC);
            return rotateLeft(root);
        }

        return root;
    }

    private boolean isLeftHeavy(IPaddresCounter node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(IPaddresCounter node) {
        return balanceFactor(node) < -1;
    }

    private long balanceFactor(IPaddresCounter node) {
        return (node == null) ? 0 : height(node.leftC) - height(node.rightC);
    }

    private long height(IPaddresCounter node) {
        return (node == null) ? -1 : node.height;
    }
}





