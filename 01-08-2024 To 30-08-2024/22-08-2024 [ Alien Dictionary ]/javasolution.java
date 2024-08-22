
class Solution {
    public String findOrder(String[] words, int n, int K) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (int k = 0; k < K; k++) {
            char c = (char) ('a' + k);
            graph.put(c, new HashSet<>());
            indegree.put(c, 0);
        }

        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (!graph.get(word1.charAt(j)).contains(word2.charAt(j))) {
                        graph.get(word1.charAt(j)).add(word2.charAt(j));
                        indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    }
                    found = true;
                    break;
                }
            }

            if (!found && word2.length() < word1.length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            result.append(ch);

            for (char neighbor : graph.get(ch)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result.length() == graph.size() ? result.toString() : "";
    }
}
