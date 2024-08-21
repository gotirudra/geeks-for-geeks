
class Solution {
    public int[] shortestPath(int[][] edges, int N, int M, int src) {
       
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

      
        int[] distance = new int[N];
        Arrays.fill(distance, -1);
        distance[src] = 0; 
     
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (distance[neighbor] == -1) { 
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }
}
