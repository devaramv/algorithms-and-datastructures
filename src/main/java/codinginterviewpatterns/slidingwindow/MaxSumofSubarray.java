package codinginterviewpatterns.slidingwindow;

/*

Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any contiguous sub array of size ‘k’.

Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Sub array with maximum sum is [5, 1, 3]


Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Sub array with maximum sum is [3, 4]

 */

public class MaxSumofSubarray {

    /*
       Brute Force Approach:

       Algorithm

       1. Use two for loops.
       2. Outer for loop indicates the beginning of the each sub array whereas
       Inner for loop interates through every element of the sub array then find sum
       by adding all the elements.
       3. Compare the sum of next sub array with previous sub array, record the max value between
       both
       4. Repeat this untill all sub arrays are done
       5. Return max value


     */


    public static int maxSumofSubArray(int[] inputArray, int k){

        int maxSum = 0,intermediateSum;
        for(int i=0;i<=inputArray.length-k; i++){
            intermediateSum = 0;
            for(int j=i;j<=i+k-1;j++){
                intermediateSum = intermediateSum + inputArray[j];
            }
            maxSum = Math.max(intermediateSum,maxSum);
        }

        return maxSum;

    }

    /*
       Sliding Window Approach

       1. Calculate the slidingwindow sum of first subarray of size k
       2. if window end of first sub array is reach then start sliding window apporach
       which means from then add the next element to the sliding window sum and subtract
       first element of the previous sub array.
       3. Compare the current and previous sub array's sum and set max value
       4. Iterate the above process untill the end of the array is reached


     */

    public static int maxSumofSubArraySlidingWindowApproach(int[] inputArray, int k){
        int maxSum = 0, windowStart = 0, slidingwindowsum=0;

        for(int i= 0; i<=inputArray.length-1;i++){
                slidingwindowsum = slidingwindowsum + inputArray[i];
                if(i>=k-1){ /* first subarray is reached, sliding window starts. From this point
                               add the next element and subtract the first element of the previous
                               sub array
                            */
                    maxSum = Math.max(maxSum,slidingwindowsum);
                    slidingwindowsum = slidingwindowsum-inputArray[windowStart];
                    windowStart++;
                }
        }

        return maxSum;
    }



    public static void main(String[] args) {
          int[] test = {2, 3, 4, 1, 5};
          System.out.printf("The first output is "  + maxSumofSubArray(test,2) + "\n");
          System.out.printf("The sliding window output is " + maxSumofSubArraySlidingWindowApproach(test,3));
    }
}
