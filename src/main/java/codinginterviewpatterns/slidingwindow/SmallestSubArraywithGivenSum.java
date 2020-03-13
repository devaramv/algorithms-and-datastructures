package codinginterviewpatterns.slidingwindow;

public class SmallestSubArraywithGivenSum {

    /*

    Given an array of positive numbers and a positive number ‘S’,
    find the length of the smallest contiguous sub array whose sum is greater than or equal to ‘S’.
    Return 0, if no such sub array exists.

    Example 1:

    Input: [2, 1, 5, 2, 3, 2], S=7
    Output: 2
    Explanation: The smallest sub array with a sum great than or equal to '7' is [5, 2].

    Example 2:

    Input: [2, 1, 5, 2, 8], S=7
    Output: 1
    Explanation: The smallest sub array with a sum greater than or equal to '7' is [8].

     */


    /*
      Following is the solution using Brute force approach
     */

    public static  int smallestSubArraywithGivenSum(int[] inputArray, int givenSum){
        int minLength =Integer.MAX_VALUE;
        for(int i=0; i<=inputArray.length-1;i++){
            int subArrayLength = 0,subArraySum = 0;
            for(int j=i;j<=inputArray.length-1;j++){
                subArraySum = subArraySum + inputArray[j];
                if(subArraySum>=givenSum){
                    subArrayLength = j-i+1;
                    minLength =  Math.min(subArrayLength,minLength);
                    break;
                }
            }
        }
        return minLength;
    }

    public static int smallestSubArraywithGivenSumUsingSlidingWindow(int[] inputArray, int givenSum){

        int smallestSubArrayLength = Integer.MAX_VALUE;




        return smallestSubArrayLength;
    }

    public static void main(String[] args) {
        int[] test1 ={2,1,5,2,3,2};
        int[] test2 = {2,1,5,2,8};
        System.out.println(smallestSubArraywithGivenSum(test1,7));
        System.out.println(smallestSubArraywithGivenSum(test2,7));

    }
}
