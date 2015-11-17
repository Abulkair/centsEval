package proj;

public class cents{ 
    public static void main(String[] args) {       
    	System.out.println(countWaysToProduceGivenAmountOfMoney(10));
    }
    
    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
    	int cnt = 0;
    	
    	try {
    		if (cents <= 0) throw new Exception("Cents should be positive number");
    		
	        int[] dp = new int[cents + 1];
	        dp[0] = 1;
	        for (int x : new int[] {1, 5, 10, 25, 50})
	            for (int i = 0; i + x <= cents; ++i)
	                dp[i + x] += dp[i];
	        
	        cnt = dp[cents];
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    		return 0;
    	}
    	
        return cnt;
    }
} 