class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indegree[u]++;
        }
        int[] res = new int[numCourses];
        int k = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            res[k++] = curr;

            for(int neighbor : adj.get(curr)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        if(k != numCourses) return new int[]{};

        return res;
    }
}
