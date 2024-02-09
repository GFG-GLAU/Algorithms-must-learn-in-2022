public class max_circualr_subarray_sum {
	public static void main(String args[])
	{
			
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int max=-9999;
			int sum=0;
			int totalsum=0;
			for(int i=0;i<n;i++){
				totalsum+=arr[i];
				sum=sum+arr[i];
				if(sum<0)sum=0;
				max=Math.max(sum,max);
			}
			int max2=-9999;
			sum=0;
			for(int i=0;i<n;i++){
				sum+=-arr[i];
				if(sum<0)sum=0;
				max2=Math.max(max2,sum);
			}
			System.out.println(Math.max(max,totalsum+max2));
	}
}
