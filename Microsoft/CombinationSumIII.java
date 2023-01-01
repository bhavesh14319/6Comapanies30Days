import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Set<Integer> set = new HashSet<Integer>(arr);
        // arr.clear();
        // arr.addAll(set);
        // Collections.sort(arr);
 
        
        List<List<Integer>> ans = new ArrayList<>(); //will store the possible combinations
        ArrayList<Integer> temp = new ArrayList<>(); //will store callwise combinations        
    
        int [] arr = {1,2,3,4,5,6,7,8,9};
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
		    list.add(arr[i]);
		}
        findNumbers(ans,list,n,0,temp,k); //index is passes as 0 to start from start index and go upto end


        return ans;
    }

    static void findNumbers(List<List<Integer>>ans,ArrayList<Integer>arr,int sum, int index, ArrayList<Integer>temp,int k){
        if(sum==0 && k==0){
            ans.add(new ArrayList<>(temp));
            System.out.println(ans);
            return;
        }
        
        for(int i=index;i<arr.size();i++){
            if(sum-arr.get(i)>=0 && k>0){
                temp.add(arr.get(i));
               
                findNumbers(ans,arr,sum-arr.get(i),i+1,temp,k-1);
                temp.remove(arr.get(i));
            }
        }
    }
    
}


public class CombinationSumIII {


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.combinationSum3(3, 9));
    }
}
