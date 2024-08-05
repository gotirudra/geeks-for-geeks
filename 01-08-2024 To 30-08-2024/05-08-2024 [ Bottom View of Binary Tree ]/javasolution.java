class Solution {
    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> bottomNode = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node frontNode = temp.node;
            int hd = temp.hd;

            bottomNode.put(hd, frontNode.data);

            if (frontNode.left != null) {
                q.add(new Pair(frontNode.left, hd - 1));
            }
            if (frontNode.right != null) {
                q.add(new Pair(frontNode.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : bottomNode.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
