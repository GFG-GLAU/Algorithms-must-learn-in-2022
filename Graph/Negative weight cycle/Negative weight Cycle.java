class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[] costs = new int[n];
        for(int i=0;i<n;i++){
            costs[i]=Integer.MAX_VALUE;
        }
        
        costs[0]=0;
        
        for(int i=0;i<n-1;i++){
            for(int[] curredge : edges){
                int src = curredge[0];
                int dest = curredge[1];
                int weight = curredge[2];
                
                if(costs[src]!=Integer.MAX_VALUE)
                costs[dest] = Math.min(costs[dest],costs[src]+weight);
            }
        }
        
        
            for(int[] curredge : edges){
                int src = curredge[0];
                int dest = curredge[1];
                int weight = curredge[2];
                
                if(costs[src]!=Integer.MAX_VALUE && costs[dest] > costs[src]+weight)
                return 1;
            }
        
        
        return 0;
    }
}
