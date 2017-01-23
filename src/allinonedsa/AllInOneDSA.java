package allinonedsa;

import dynamicprogramming.MaxMoneyAgainstOpponent;

public class AllInOneDSA {

    public static void main(String[] args) {
       int[] arr = new int []{3,2,2,3,1,2};
       
      int max = MaxMoneyAgainstOpponent.getMaxMoneyAgainstOpponent(arr, 0, arr.length -1);
      
        System.out.println("max amount is : " + max);
        
        int max2 = MaxMoneyAgainstOpponent.getMaxMoneyAgainstOpponent(arr);
        System.out.println("max amount is : " + max);
    }
}
