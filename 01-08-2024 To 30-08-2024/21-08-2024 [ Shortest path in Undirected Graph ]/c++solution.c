class Solution {
  public:
    std::vector<int> shortestPath(std::vector<std::vector<int>>& edges, int N, int M, int src) {
        std::vector<std::vector<int>> adjlist(N, std::vector<int>());
        for (auto& edge : edges) {
            adjlist[edge[0]].push_back(edge[1]);
            adjlist[edge[1]].push_back(edge[0]);
        }

        std::vector<int> distance(N, -1);
        distance[src] = 0;
        std::queue<int> queue;
        queue.push(src);
        while (!queue.empty()) {
            for (int node : adjlist[queue.front()]) {
                if (distance[node] == -1) {
                    distance[node] = distance[queue.front()] + 1;
                    queue.push(node);
                }
            }
            queue.pop();
        }
        return distance;
    }
};
