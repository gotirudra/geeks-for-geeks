class Solution {
    public int minimumCostPath(int[][] v) {
        int n = v.length, m = v[0].length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{v[0][0], 0, 0});
        dist[0][0] = v[0][0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0], x = curr[1], y = curr[2];

            for (int k = 0; k < 4; k++) {
                int i = x + dr[k];
                int j = y + dc[k];

                if (i >= 0 && j >= 0 && i < n && j < m && dist[i][j] > w + v[i][j]) {
                    dist[i][j] = w + v[i][j];
                    pq.offer(new int[]{dist[i][j], i, j});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
