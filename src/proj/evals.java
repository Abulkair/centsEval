package proj;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class evals{ 
    public static void main(String[] args) throws Exception {             
        int[] data = evaluate(new int[] {1,2,3, 4, 5}, 3);
        
        if (data!=null) {
	        for(int i:data) {
	        	System.out.print(i + " ");
	        }
        }
    }
    
    public static int[] evaluate(int[] data, final int p) throws Exception {
    	ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ArrayList<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        for(final int num : data){
        	try {
        		if (num <= 0) throw new Exception("Numbers should be positive");
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        		return null;
        	}
        	
           tasks.add(new Callable<Object>()
           {
        	    public Object call() throws Exception
        	    {
        	      return eval(num, p);
        	    }
        	});
        }
        
        List<Future<Object>> results = exec.invokeAll(tasks);
        exec.shutdown();
        
        for(int i=0;i<results.size();i++) {
        	data[i] = (int)results.get(i).get();
        }

        return data;
    }
    
    public static int eval(int a, int p) {
    	return (int)Math.round(Math.exp(p * Math.log(a)));
    }
} 