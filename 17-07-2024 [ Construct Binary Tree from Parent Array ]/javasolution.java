class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int n = parent.length;
        if (n == 0) return null;

        // Step 2: Create an array of Node to store references to all nodes
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;

        // Step 3: Iterate through the parent array to build the tree
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = nodes[i];  // Identify the root node
            } else {
                Node parentNode = nodes[parent[i]];
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else {
                    parentNode.right = nodes[i];
                }
            }
        }

        return root;
    }
}
