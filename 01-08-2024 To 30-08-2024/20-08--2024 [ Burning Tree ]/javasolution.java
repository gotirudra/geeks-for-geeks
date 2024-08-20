class Solution {
   
    private void solve(int[] maxi, Node root) {
        if (root == null)
            return;
        maxi[0] = Math.max(maxi[0], root.data);
        solve(maxi, root.left);
        solve(maxi, root.right);
    }

    private void constructGraph(Node root, List<List<Integer>> adj) {
        if (root == null)
            return;
        if (root.left != null) {
            adj.get(root.data).add(root.left.data);
            adj.get(root.left.data).add(root.data);
        }
        if (root.right != null) {
            adj.get(root.data).add(root.right.data);
            adj.get(root.right.data).add(root.data);
        }
        constructGraph(root.left, adj);
        constructGraph(root.right, adj);
    }

    public int minTime(Node root, int target) {
        int[] maxi = new int[1];
        maxi[0] = -1;
        solve(maxi, root); 
      
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= maxi[0]; i++) {
            adj.add(new ArrayList<>());
        }

        constructGraph(root, adj);

        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[maxi[0] + 1];
        q.add(new int[]{0, target});
        visit[target] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int dist = front[0];
            int u = front[1];

            ans = Math.max(ans, dist);

            for (int v : adj.get(u)) {
                if (!visit[v]) {
                    visit[v] = true;
                    q.add(new int[]{dist + 1, v});
                }
            }
        }
        return ans;
    }
}
