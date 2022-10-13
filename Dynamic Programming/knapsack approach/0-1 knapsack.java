class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         return maxprofit(wt,val,0,W,n,new HashMap<String,Integer>());
    } 
    
    static int maxprofit(int[] weight, int[] profit,int currbag,int capacity,int n,HashMap<String,Integer> hm){
        if(currbag==n)
        return 0;
        
        int currprofit=profit[currbag];
        int currweight = weight[currbag];
        
        String currkey = currbag+"-"+capacity;
        
        if(hm.containsKey(currkey))
        return hm.get(currkey);
        
        int consider=0;
        if(currweight<=capacity){
            consider=currprofit +maxprofit(weight,profit,currbag+1,capacity-currweight,n,hm);
        }
        
        int nonconsider = maxprofit(weight,profit,currbag+1,capacity,n,hm);
        
        hm.put(currkey, Math.max(consider,nonconsider));
        return Math.max(consider,nonconsider);
    }
}
