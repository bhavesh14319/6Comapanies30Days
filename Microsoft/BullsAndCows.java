import java.util.Arrays;

class Ans {
    public String getHint(String secret, String guess) {
        // create hashtable for secret and guess chars
        
      int i=0;
      int j=0;

      int numberOfBulls=0;
      int [] secretCount = new int[10];
      int [] guessCount = new int[10];

    //   number of bulls are equal to matched characters in secret and guess
    //   thus increase the bull for each match but decrease the count for corresponding characters as we dont want to deal with them
    //   while finding cows

      while(i<secret.length()&&j<secret.length()){
          int secretIndex = Integer.parseInt(String.valueOf(secret.charAt(i)));
          int guessIndex = Integer.parseInt(String.valueOf(guess.charAt(i)));
          
          secretCount[secretIndex]+=1;
          guessCount[guessIndex]+=1;


        if(secret.charAt(i)==guess.charAt(j)){
             numberOfBulls++;
             secretCount[secretIndex]-=1;
             guessCount[guessIndex]-=1;
          }
          i++;
          j++;
      }

      System.out.println(Arrays.toString(secretCount));
      System.out.println(Arrays.toString(guessCount));

      //after finding bull we have unmatched pairs of characters
      //we have to add the minimum count of each pairs character 
    //   eg if in secret now we have 1 times 1 and in guess we have 2 times 1 then we have to select its minimum count
    // secretCount and guessCount contain the noOfAppearances reamining after bulls for digits 0 - 9 on indexes  0 - 9
    // so we have to add minimum count of each index from secretCount and guessCount from that.



        // find numberOfCows

      int noOfCows=0;  

      for(int k=0;k<secretCount.length;k++){
          noOfCows+=Math.min(secretCount[k],guessCount[k]);
     }

      
        




      return Integer.toString(numberOfBulls)+"A"+Integer.toString(noOfCows)+"B";


    }
}


public class BullsAndCows {
    public static void main(String[] args) {
        Ans ans = new Ans();
        System.out.println(ans.getHint("1123", "0111"));
    }
}
