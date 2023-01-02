
// BruteForce
// gives TLE

class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int rotations=0;
        int max = Integer.MIN_VALUE;
        // 0   0   3     
        // 1   3   2
        // 2   2   1
        // 3   1   0
        int si = 0;
        int ei = nums.length-1;
        int ans = findAns(nums,si,ei);
        max = Math.max(ans,max);
        rotations++;
        si=nums.length-1;
        ei--;

        while(rotations<nums.length){
           
            ans = findAns(nums,si,ei);
            max = Math.max(ans,max);
            rotations++;
            si--;
            ei--;  
        }

        return max;

    }

    int findAns(int[]nums,int si,int ei){
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = ans + (i*nums[si]);
            si = (si+1)%nums.length;
        }
        return ans;
    }

}


// optimised using mathematics


class Solution1 {
    public int maxRotateFunction(int[] nums) {
        // find sum of all elements and find ans for first rotation
        int original = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            original += i*nums[i];
        }


        // now nextrotation = prevrotation  + sum - n*nums[i] -> nums[i] is the last element at ith rotation
        int max = original;

        for(int i=nums.length-1;i>=0;i--){
            original += sum - nums[i]*nums.length;
            max = Math.max(max,original);
        } 

        return max;

    }

}
