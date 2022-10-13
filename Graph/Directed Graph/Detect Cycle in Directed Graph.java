class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] hasset = new boolean[V];
        
        for(int currvertex=0; currvertex<V; currvertex++){
            
            if(!visited[currvertex] && hasCycle(adj,currvertex,visited , hasset)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int currvertex,boolean[] visited,boolean[] hasset){
        visited[currvertex]=true;
        hasset[currvertex]=true;
        
        ArrayList<Integer> neighbour = adj.get(currvertex);
        
        for(int currneighbour : neighbour){
            if(!visited[currneighbour] && hasCycle(adj,currneighbour,visited,hasset))
            return true;
            else if(hasset[currneighbour])
            return true;
        }
        hasset[currvertex]=false;
        return false;
    }
    -----------------------------------------------------------------------------------------------------------------------------------------------------
    -----------------------------------------------------------------------------------------------------------------------------------------------------
    //USING BFS APPROACH
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> q= new LinkedList<>();
        int visitedvertex =0;
        
        for(int i =0 ; i<V; i++){
            for(int currneighbour : adj.get(i)){
                indegree[currneighbour] +=1;
            }
        }
        
        for(int i=0; i<V ; i++){
            if(indegree[i]==0)
            q.add(i);
        }
        
        while(!q.isEmpty()){
            int currvertex = q.remove();
            
            if(visited[currvertex])
            continue;
            
            visited[currvertex]=true;
            visitedvertex ++;
            
            for(int currneighbour : adj.get(currvertex)){
                indegree[currneighbour] -=1;
                
                if(indegree[currneighbour]==0)
                q.add(currneighbour);
                
            }
        }
        
        return visitedvertex!=V;
    }
}
