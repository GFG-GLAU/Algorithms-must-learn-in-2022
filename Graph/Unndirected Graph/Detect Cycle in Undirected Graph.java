class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for(int currvertex=0; currvertex<V; currvertex++){
            
            if(!visited[currvertex]){
                if(hasCycle(adj,currvertex,-1,visited))
                return true;
            }
        }
        return false;
    }
    
    boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int currvertex,int currparent,boolean[] visited){
        visited[currvertex]=true;
        
        
        ArrayList<Integer> neighbour = adj.get(currvertex);
        
        for(int currneighbour : neighbour){
            if(visited[currneighbour]==false){
                if(hasCycle(adj,currneighbour,currvertex,visited))
                    return true;
            }
            else if(currneighbour!=currparent)
            return true;
        }
        
        return false;
    }
}
