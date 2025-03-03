package algorithms._1array_stack_queue.geeksforgeeks.dynamic_programming._2subsequence_substring._1LIS_LCS_LRS_Algorithms._1subsequence;

import java.util.HashMap;
import java.util.Map;

/*
Longest Increasing Subsequence Size

    Time complexity = O(n^2)
    https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

    Time complexity = O(n log n) --- I haven't tried this
    https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

    (Dynamic Programming)
    https://www.youtube.com/watch?v=E6us4nmXTHs
    From Brute-Force, you can easily figure out Bottom-Up.


IMPORTANT:
This algorithm teaches you how to think iterative and then converting it to recursive.
When you have one input (e.g. this algorithm), it is easy to do Bottom-Up by looking at iterative approach.
When you have two inputs (e.g. LCS algorithm), it is super hard to do Bottom-Up by looking at iterative approach. So, for two inputs kind of algorithms, always think recursive. See LCS algorithm.

Remember, for one input algorithms, outer loop should not be a part of recursion. (e.g. this algorithm)
          for two inputs algorithms, outer loop has to be a part of recursion     (e.g. LCS algorithm)

*/
public class _0_0LIS_LongestIncreasingSubSequenceInArray {

    public static void main(String[] args) {

        {
            int[] A = {1, 2, 3, 4, 5, 6, 7, 8};// O/P: 6 - {1,2,3,4,5,6}

            System.out.println("My Way Brute-Force Iterative");
            int maxIncreasingSubSequenceSize = LIS_My_Best_Way_Iterative(A);
            System.out.println("Result:" + maxIncreasingSubSequenceSize);

            System.out.println("My Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_My_Way(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            /*System.out.println("Online Way Recursive - GIVES WRONG RESULT IN CERTAIN SCENARIO");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_1(A, 0, A.length - 1, Integer.MIN_VALUE);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("Online Another Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_2(A, Integer.MIN_VALUE, 0, A.length - 1);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);*/


            System.out.println("Bottom-Up Approach");
            maxIncreasingSubSequenceSize = LIS_Bottom_Up(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);


        }

        co = 0;
        System.out.println();

        {
            int[] A = {1, 12, 3, 4};// O/P: 3 - {1,3,4}

            System.out.println("My Way Brute-Force Iterative");
            int maxIncreasingSubSequenceSize = LIS_My_Best_Way_Iterative(A);
            System.out.println("Result:" + maxIncreasingSubSequenceSize);

            System.out.println("My Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_My_Way(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);
/*
            System.out.println("Online Way Recursive - GIVES WRONG RESULT IN CERTAIN SCENARIO");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_1(A, 0, A.length - 1, Integer.MIN_VALUE);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("Online Another Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_2(A, Integer.MIN_VALUE, 0, A.length - 1);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);
*/

            System.out.println("Bottom-Up Approach");
            maxIncreasingSubSequenceSize = LIS_Bottom_Up(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

        }

        co = 0;
        System.out.println();

        {
            //int[] A = {1, 0, 4, 5, 2, 7};// O/P: 4 - {1,4,5,7} or {0,4,5,7}
            int[] A = {10, 0, 4, 5, 2, 7};// O/P: 4 - {0,4,5,7}

            System.out.println("My Way Brute-Force");
            int maxIncreasingSubSequenceSize = LIS_My_Best_Way_Iterative(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("My Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_My_Way(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);
/*
            System.out.println("Online Way Recursive - GIVES WRONG RESULT IN CERTAIN SCENARIO");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_1(A, 0, A.length - 1, Integer.MIN_VALUE);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("Online Another Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_2(A, Integer.MIN_VALUE, 0, A.length - 1);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);*/

            System.out.println("Bottom-Up Approach");
            maxIncreasingSubSequenceSize = LIS_Bottom_Up(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

        }

        co = 0;
        System.out.println();

        {
            int[] A = {4, 12, 2, 10};//2 - {4, 12}  or {4,10} or {2, 10}

//            int[] A = {4, 1, 12, 6, 2}; // 2 - {4, 12}  or {4, 6} or {1, 12} or {1, 6} or {1, 2}
//            int[] A = {3, 4, 12, 2, 10};//3 - {3,4,12}
//            int[] A = {15, 4, 12, 2, 10};//2 - {4, 12}  or {4,10} or {2, 10}
//            int[] A = {15, 4, 12, 2, 10, 6, 9, 0};//3 - {2,6,9}
//            int[] A = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15}; //6 - {0,2,6,9,11,15} or {0,2,6,9,13,15}

            System.out.println("My Way Brute-Force Iterative");
            int maxIncreasingSubSequenceSize = LIS_My_Best_Way_Iterative(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("My Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_My_Way(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);
/*

            System.out.println("Online Way Recursive - GIVES WRONG RESULT IN CERTAIN SCENARIO");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_1(A, 0, A.length - 1, Integer.MIN_VALUE);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

            System.out.println("Online Another Way Recursive");
            maxIncreasingSubSequenceSize = LIS_Recursive_Online_2(A, Integer.MIN_VALUE, 0, A.length - 1);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);
*/

            System.out.println("Bottom-Up Approach");
            maxIncreasingSubSequenceSize = LIS_Bottom_Up(A);
            System.out.println("Result: " + maxIncreasingSubSequenceSize);

        }

    }

    /*
        int[] A = {4   1   12  6   2}

        Solution:

            currentElement = 4. For Increasing sub-sequence, you need to find the next greater element and find LIS from that element.

            e.g.

         currentEle     nextGreaterEle
            4       1       12          6       2

            LIS of 4 = max ( 1+LIS(12,6,2), 1+LIS(6,2) )
            LIS of 1 = max ( 1+LIS(12,6,2), 1+LIS(6,2), 1+LIS(2) )
            LIS of 12 = 1  because you cannot find element greater than 12 after 12
            LIS of 6 = 1
            LIS of 2 - 1

            Max of all LISes is the result.



            Brute-Force Recursive Tree Structure:


                                                                    LIS(6)
                                LIS(5)                  LIS(4)                  LIS(3)                  LIS(2)                  LIS(1)
                LIS(4)  LIS(3)  LIS(2) LIS(1)   LIS(3)  LIS(2) LIS(1)       LIS(2) LIS(1)               LIS(1)
                ...


                Time complexity = Exponential

                Similar to Fibonacci.java, this kind of recursive tree structure also fall into O(2 ^ n-1) category of time complexity.

                You are iterating over all elements fo array to find their LISes (outermost for loop). So, it will be O(n * 2 ^ n-1). so, it will be O(2^n)

                When you use dynamic programming on fibonacci, then you can achieve O(2n) time complexity. There will be 2n nodes in recursive tree and each node does O(1) operaions.


                                                            fib(5)
                                   fib(4)                                       fib(3)
                         fib(3)              fib(2)                 fib(2)                  fib(1)
                    fib(2)   fib(1)     fib(1)  fib(0)          fib(1)  fib(0)
                fib(1) fib(0)


                When you use dynamic programming on LIS, then you can achieve O(n*n)


                IMPORTANT:
                Total number of nodes in recursive tree structure using dynamic programming will be  1+7+6+5+4+3+2+1. it is same as 1+2+3+4+....n-1 = O(n^2)

                                                    LIS(8)
                                                     |
                                    LIS(7)                                                                                              LIS(6)          LIS(5)          LIS(4)          LIS(3)          LIS(2)          LIS(1)
                                      |
                LIS(6)              LIS(5)              LIS(4)              LIS(3)              LIS(2)              LIS(1)
                |
                LIS(5)      LIS(4)      LIS(3)      LIS(2)      LIS(1)
                |
                LIS(4)   LIS(3)   LIS(2)   LIS(1)
                |
                LIS(3)   LIS(2)   LIS(1)
                |
                LIS(2)   LIS(1)
                |
                LIS(1)


                What is the difference?

                On each method call, there are 2 recursive calls in Fibonacci. So, using dynamic programming, you can achieve O(2n).
                On each method call, there are n recursive calls in LIS. So, using dynamic programming, you can achieve O(n*n).

                You are just changing the 'start' on each recursive call. So, you can create memoization using Map<start index, result>.

    */
    private static int LIS_My_Best_Way_Iterative(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxLisFromEntireArray = 0;

        // finding LIS from all elements one by one and keeping max of all.
        // find LIS for 4, then 1, then 12 and then 6 and then 2
        for (int i = 0; i < A.length; i++) {

            int startIndex = i;
            int endIndex = A.length - 1;

            // finding LIS for individual element
            int maxLisFromCurrentElement = LIS_My_Best_Way_Iterative(A, startIndex, endIndex);

            if (maxLisFromCurrentElement > maxLisFromEntireArray) {
                maxLisFromEntireArray = maxLisFromCurrentElement;
            }
        }

        return maxLisFromEntireArray;
    }

    private static int c = 0;

    @SuppressWarnings("Duplicates")
    private static int LIS_My_Best_Way_Iterative(int[] A, int startIndex, int endIndex) {

        c++;

        // In recursive call, startIndex is increasing by 1, so it can reach to endIndex.
        // So, you need an exit condition for that.
        if (startIndex == endIndex) {
            return 1;
        }

        int currentElementIndex = startIndex;

        int currentElement = A[currentElementIndex];

        /*
            currentEle          nextGreaterEle
                    4       1       12          6       2

                    LIS from 4 = max ( 1+LIS(12,6,2), 1+LIS(6,2) )

                    LIS from 4 =  max of LIS from all greater elements after 4 + 1
                                  If no greater element is found, then it is 1.
        */

        int maxLisFromCurrentElement = 1;// LIS from current element will be min 1

        // finding greater element one by one after current element and finding their LISes and keeping max of all
        for (int i = currentElementIndex + 1; i <= endIndex; i++) {

            int nextElement = A[i];

            if (nextElement > currentElement) {// find next greater element

                int lisFromNextGreaterElement = LIS_My_Best_Way_Iterative(A, i, endIndex);

                int lisFromCurrentElement = 1 + lisFromNextGreaterElement;

                if (lisFromCurrentElement > maxLisFromCurrentElement) {
                    maxLisFromCurrentElement = lisFromCurrentElement;
                }

            }
        }

        return maxLisFromCurrentElement;

    }

    @SuppressWarnings("Duplicates")
    @Deprecated
    // Thought of doing it in same way as LCS, but doesn't work. Recursion should not happen along with outer loop.
    // If you convert this iterative code in recursive code, you will get the formula that you can use it for Bottom-Up approach
    // If you use that formula and find out maxLises of all element, you will figure out the problem.
    // Read the comment kept on top of 'LIS_Recursive_My_Way(int[] A) method.
    private static int LIS_My_Best_Way_Another(int[] A, int startIndex, int endIndex) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        int maxLisFromEntireArray = 0;

        // finding LIS from each element one by one and keeping max of all.
        for (int i = startIndex; i <= endIndex; i++) {// this loop should not be a part of recursion

            int currentElementIndex = i;
            int currentElement = A[currentElementIndex];

            int maxLisFromCurrentElement = 1;// LIS from current element will be min 1

            // finding greater element one by one after current element and finding their LIS and keeping max of all
            for (int j = currentElementIndex + 1; j <= endIndex; j++) {

                int nextElement = A[j];

                if (nextElement > currentElement) {// find next greater element

                    int lisFromNextGreaterElement = LIS_My_Best_Way_Another(A, j, endIndex);

                    int lisFromCurrentElement = 1 + lisFromNextGreaterElement;

                    if (lisFromCurrentElement > maxLisFromCurrentElement) {
                        maxLisFromCurrentElement = lisFromCurrentElement;
                    }

                }
            }

            if (maxLisFromCurrentElement > maxLisFromEntireArray) {
                maxLisFromEntireArray = maxLisFromCurrentElement;
            }
        }

        return maxLisFromEntireArray;
    }

    /*
        e.g. int[] A        = {4,12,2,10}

             int[] maxLises = {2,1,2,1}
             maxLis=2

        IMPORTANT:
        In 1-D array, when you think of recursion, outer loop should not be a part of recursion.

         for (int i = startIndex; i <= endIndex; i++) { // outer loop
            ...
            for (int j = currentElementIndex + 1; j <= endIndex; j++) {



        If you keep outer loop as part of recursion,
            int[] A     = [4,12,2,10]
            int[] lis   = [3,2,2,1]
        lis of 12 will be 2 instead of 1
        and so lis of 4 will be 3 instead of 2.

        If you write WRONG code, where outer loop is a part recursion,
        maxLis(element) =

                  lisOfCurrentElement = 1 // minimum lis of any element can be 1

                  if (nextElement > element)
                    lisOfCurrentElement = 1+lis(nextElementIndex,endIndex,nextElementIndex+1)// 1 + lis of nextElement

                  // do above processing for finding lis of element from rest of the elements in array (loop that finds lis of current element by comparing current element with all next elements)
                  listOfCurrentElementUsingRestOfArray = lis(startIndex,endIndex,nextElementIndex+1)

                  int maxLisOfCurrentElement = Math.max(lisOfCurrentElement, listOfCurrentElementUsingRestOfArray)

                  // find max lis from rest of the element of an array (loop that finds lis of rest of the elements)
                  int maxLisFromRestOfArray = lis(startIndex+1, endIndex, nextElementIndex=startIndex+2)

                  return Math.max(maxLisOfCurrentElement, maxLisFromRestOfArray)


    From above code Recursive formula is
        maxLis(element) =  max (element's max lis, max lis from rest of the array)

        maxLis(12) = max(12's max lis = 1, max lis from rest of the array = 2) = 2
        maxLis(12) should be 1, not 2


    So, below code should be taken out as a separate loop

       // find max lis from rest of the element of an array (loop that finds lis of rest of the elements)
      int maxLisFromRestOfArray = lis(startIndex+1, endIndex, nextElementIndex=startIndex+2)
    */
    private static int LIS_Recursive_My_Way(int[] A) {
        int maxLis = 0;
        // loop that find maxLis of every single element and keeping max of all
        for (int i = 0; i <= A.length - 1; i++) {
            int lis = LIS_Recursive_My_Way(A, i, A.length - 1, i + 1);
            if (lis > maxLis) {
                maxLis = lis;
            }
        }
        return maxLis;
    }

    private static int LIS_Recursive_My_Way(int[] A, int startIndex, int endIndex, int nextIndex) {

        if (startIndex == endIndex) {
            return 1;
        }

        int lisFromCurrentElement = 1;

        if (nextIndex > endIndex) {
            return lisFromCurrentElement;
        }

        if (A[nextIndex] > A[startIndex]) {
            lisFromCurrentElement = 1 + LIS_Recursive_My_Way(A, nextIndex, endIndex, nextIndex + 1);
        }

        // do above processing for finding lis of element from rest of the elements in array (loop that finds lis of current element by comparing current element with all next elements)
        int lisFromCurrentElementConsideringRestOfArray = LIS_Recursive_My_Way(A, startIndex, endIndex, nextIndex + 1);

        int maxLisFromCurrentElement = Math.max(lisFromCurrentElement, lisFromCurrentElementConsideringRestOfArray);

        return maxLisFromCurrentElement;

        // IMPORTNAT: DO NOT keep this code here
        // find max lis from rest of the element of an array (loop that finds lis of rest of the elements)
        //int maxLisFromRestOfArray = LIS_Recursive_My_Way(A, startIndex + 1, endIndex, startIndex + 2);

        //int maxLis = Math.max(maxLisFromCurrentElement, maxLisFromRestOfArray);

        //return maxLis;
    }

    // From https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
    // Function to find length of longest increasing subsequence using include-exclude kind of logic
    @Deprecated // not working
    public static int LIS_Recursive_Online_1(int[] A, int startIndex, int endIndex, int prevElement) {
        // Base case
        if (startIndex == endIndex) {
            return 1;
        }

        // case 1: include the current element if it is greater than previous element in LIS
        int incl = 0;
        if (A[startIndex] > prevElement) {
            incl = 1 + LIS_Recursive_Online_1(A, startIndex + 1, endIndex, A[startIndex]);
        }

        // case 2: exclude the current element and process the
        // remaining elements
        int excl = LIS_Recursive_Online_1(A, startIndex + 1, endIndex, prevElement);


        // return maximum of above two choices
        return Integer.max(incl, excl);
    }

    // https://leetcode.com/articles/longest-increasing-subsequence/
    private static int LIS_Recursive_Online_2(int[] A, int prevElement, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }

        int taken = 0;
        if (A[startIndex] > prevElement) {
            taken = 1 + LIS_Recursive_Online_2(A, A[startIndex], startIndex + 1, endIndex);
        }
        int nottaken = LIS_Recursive_Online_2(A, prevElement, startIndex + 1, endIndex);
        return Math.max(taken, nottaken);
    }

    /*
        It is written from 'LIS_My_Best_Way(...)'

        How to find LIS from 'memory' array.

        e.g.
        int[] A           = {7    4   3   5   6}

        final memory[]    = {1    3   3   2   1}


        Initializing memory[] :
        memory[] is always initialized based on exit condition(s) of brute-force/top-down approach.
        As you see exit condition of brute-force/top-down approach says that when start reaches to end, return 1.
        So,
        start memory[]    = {0    0   0   0   1}. So, LIS(6)=1

        Now, memory(5), you need to iterate memory table for all A's element that are bigger than 5. Keep the max of them and add 1 to it.
        so
        memory(5)=  1 + memory(6) = 2

        memory(3) = 1 + max(memory(5), memory(6)) = 3

        memory(4) = 1 + max(memory(5), memory(6)) = 3

        memory(7) = 1  --- there is no element bigger than 7 on right side of 7


        Now, go through entire memory[] and find out the max. It will be 3. So MaxLIS=3.


        To fill up memory array, it will take
        Time Complexity = O(n^2)

    */
    private static int LIS_Bottom_Up(int[] A) {
        // 'memory' array will be filled in with LIS of each element.
        int memory[] = new int[A.length];

        memory[A.length - 1] = 1; // from the exit condition of brute-force/top-down approach. We are incrementing start index in brute-force, so when it reaches to end, result is 1.

        for (int i = A.length - 2; i >= 0; i--) {
            memory[i] = 1 + findMaxLisFromLisOfAllNextGreaterElements(A, i, i + 1, memory);
        }

        // finding the maxLis from maxLis of all elements
        int maxLis = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] > maxLis) {
                maxLis = memory[i];
            }
        }

        //System.out.println(maxLis);
        return maxLis;
    }

    private static int findMaxLisFromLisOfAllNextGreaterElements(int[] A, int currentElementIndex, int nextElementIndex, int[] memory) {

        int maxLis = 0;

        int currentElement = A[currentElementIndex];

        for (int i = nextElementIndex; i < A.length; i++) {
            if (currentElement < A[i]) {
                int nextGreaterElementLis = memory[i];
                if (nextGreaterElementLis > maxLis) {
                    maxLis = nextGreaterElementLis;
                }
            }
        }
        return maxLis;
    }
// ---------------------------------------------------------------------------------------------------------------------------- //
// ---------------------------------------------------------------------------------------------------------------------------- //
// ---------------------------------------------------------------------------------------------------------------------------- //

    /*
     int[] A = {4   1   12  6   2}

     Just like above method 'LIS_My_Best_Way(...)', find Max LIS for 4

     and then find Max LIS from remaining array. ----- This is same as outer for loop in 'LIS_My_Best_Way(...)'

     and then take the max of both

 */
    // Include - Exclude approach didn't work the way I tried.
    // int[] A = {4,12,2,10}, it creates memory[]={3,2,2,1}
    // so, you will think answer is 3. But actual answer is 2 that is made of {4,12} or {4,10} or {2,10}
    @Deprecated
    @SuppressWarnings("Duplicates")
    private static int LIS_My_Another_Best_Way_Using_Include_Exclude_Approach(int[] A, int startIndex, int endIndex) {

        // In recursive call, startIndex can reach to endIndex. So, you need an exit condition for that
        if (startIndex == endIndex) {
            return 1;
        }

        int currentElementIndex = startIndex;

        int currentElement = A[currentElementIndex];

        // finding greater element one by one after current element and finding their LIS and keeping max of all
        int maxLisFromCurrentElement = 1;// LIS from current element will be min 1

        for (int i = currentElementIndex + 1; i <= endIndex; i++) {

            int nextElement = A[i];

            if (nextElement > currentElement) {// find next greater element

                int lisFromNextGreaterElement = LIS_My_Another_Best_Way_Using_Include_Exclude_Approach(A, i, endIndex);

                int lisFromCurrentElement = 1 + lisFromNextGreaterElement;

                if (lisFromCurrentElement > maxLisFromCurrentElement) {
                    maxLisFromCurrentElement = lisFromCurrentElement;
                }

            }
        }

        // find max LIS from remaining array
        int maxLisExcludingCurrentElement = LIS_My_Another_Best_Way_Using_Include_Exclude_Approach(A, currentElementIndex + 1, endIndex);

        // take max of maxLIS from currentElement and maxLIS from remaining array
        int maxLisFromEntireArray = Math.max(maxLisFromCurrentElement, maxLisExcludingCurrentElement);

        return maxLisFromEntireArray;

    }


    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java
    // O(2^n)
    private static int co;

    private static int longestSubsequenceRecursive_Brute_Force(int arr[]) {
        int maxLen = 0;

        // 2^n + 2^n-1 + ...... + 2^0 = 2^n+1 - 1 = O(2^n)
        for (int i = 0; i < arr.length; i++) {

            int currentElementIndex = i;

            int len = longestSubsequenceRecursive_Brute_Force(arr, currentElementIndex, currentElementIndex + 1);
            if (len > maxLen) {
                maxLen = len;
            }
        }
        System.out.println("time complexity: " + co);
        return maxLen + 1;
    }

    /*
                    m(1,2,3,4)
            m(2,3,4)            m(2,3,4)  ---- O(1) operation happens on each node
         m(3,4) m(3,4)      m(3,4) m(3,4)  ---- O(1) operation happens on each node
         ...

         at each level O(1) operation is happening on each node. total number of nodes will be 2^n. So, time complexity = O(2^n)
     */

    private static int longestSubsequenceRecursive_Brute_Force(int[] arr, int currentElementIndex, int nextElementIndex) {
        co++;

        if (nextElementIndex == arr.length) {
            return 0;
        }

        int currentElement = arr[currentElementIndex];

        int t1 = 0;
        if (arr[nextElementIndex] > currentElement) {
            t1 = 1 + longestSubsequenceRecursive_Brute_Force(arr, nextElementIndex, nextElementIndex + 1);
        }
        int t2 = longestSubsequenceRecursive_Brute_Force(arr, currentElementIndex, nextElementIndex + 1);
        return Math.max(t1, t2);
    }


   /* private static int lis_total_recursive(int[] A, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 1;
        }

        int currentElement = A[startIndex];//4

        int nextElementIndex = startIndex + 1;//1

        int lisOfCurrentElement = 1;// lis of current element is at least 1

        if (nextElementIndex > endIndex) {// just for range checking
            return lisOfCurrentElement;
        }

        int nextElement = A[nextElementIndex];

        if (nextElement > currentElement) { // if next element is > current element
            lisOfCurrentElement = 1 + lis_total_recursive(A, nextElementIndex, endIndex);
        }

        int maxLisFromRemainingElements = lis_total_recursive(A, startIndex + 1, endIndex);

        return Math.max(lisOfCurrentElement, maxLisFromRemainingElements);
    }*/

    // O(n^2)
    private static int longestSubsequenceRecursive_top_down(int arr[]) {
        Map<Integer, Integer> memo = new HashMap<>();

        int maxLen = 0;

        for (int i = 0; i < arr.length - 1; i++) { // O(n)

            int currentElementIndex = i;

            // for the first element O(n^2) will happen.
            // from second element it will return already memoized results.
            int len = longestSubsequenceRecursive_top_down(arr, currentElementIndex, currentElementIndex + 1, memo);

            if (len > maxLen) {
                maxLen = len;
            }
        }
//        System.out.println();
        return maxLen + 1;
    }

    // O(n^2)
    private static int longestSubsequenceRecursive_top_down(int[] arr, int currentElementIndex, int nextElementIndex, Map<Integer, Integer> memo) {
        if (memo.containsKey(currentElementIndex)) {
            return memo.get(currentElementIndex);
        }

        if (nextElementIndex == arr.length) {
            return 0;
        }

        int currentElement = arr[currentElementIndex];

        int t1 = 0;
        if (arr[nextElementIndex] > currentElement) {
            t1 = 1 + longestSubsequenceRecursive_top_down(arr, nextElementIndex, nextElementIndex + 1, memo);// you can memoize the result of this recursive call
        }
        int t2 = longestSubsequenceRecursive_top_down(arr, currentElementIndex, nextElementIndex + 1, memo);


       /* if(t1 > t2){
            System.out.print(arr[currentElementIndex]+",");
        }*/

        int result = Math.max(t1, t2);

        memo.put(currentElementIndex, result);

        return result;
    }

    // ---------------------------------------------------------------------------------------------------------------------------- //


    static int cnt = 0;

    // O(2^n)
    private static int LIS_My_Way_Harder_Way_Brute_Force(int[] A, int start, int end, boolean calculateExcludingCurrentElement) {
        cnt++;

        if (A == null || A.length == 0) return 0;

        //if (start == end) return 1; // not mandatory

        if (end < start) return 0;

        int currentElement = A[start];


        int maxIncludingCurrentElement = 1;

        for (int i = start + 1; i <= end; i++) {

            if (A[i] > currentElement) {

                int includingCurrentElement = 1 + LIS_My_Way_Harder_Way_Brute_Force(A, i, end, false);

                if (includingCurrentElement > maxIncludingCurrentElement) {
                    maxIncludingCurrentElement = includingCurrentElement;
                }
            }

        }

        if (!calculateExcludingCurrentElement) {// very important
            System.out.print(currentElement + ",");
            return maxIncludingCurrentElement;
        }

        int maxExcludingCurrentElement = LIS_My_Way_Harder_Way_Brute_Force(A, start + 1, end, true);

        if (maxIncludingCurrentElement > maxExcludingCurrentElement) {
            System.out.print(currentElement + ",");
        }
        return Math.max(maxIncludingCurrentElement, maxExcludingCurrentElement);

    }


    static int count = 0;

    // O(n^2)
/*

                                    LIS(8)
                                     |
                    LIS(7)                                                                                              LIS(6)          LIS(5)          LIS(4)          LIS(3)          LIS(2)          LIS(1)
                      |
LIS(6)              LIS(5)              LIS(4)              LIS(3)              LIS(2)              LIS(1)
|
LIS(5)      LIS(4)      LIS(3)      LIS(2)      LIS(1)
|
LIS(4)   LIS(3)   LIS(2)   LIS(1)
|
LIS(3)   LIS(2)   LIS(1)
|
LIS(2)   LIS(1)
|
LIS(1)

This many recursions will happen with Dynamic Programming  O(n^2)

*/
    private static int LIS_My_Way_Harder_Way_With_Dynamic_Top_Down_Approach(int[] A, int start, int end, boolean calculateExcludingCurrentElement, Map<Integer, Integer> memo) {

        if (A == null || A.length == 0) return 0;

        //if (start == end) return 1; // not mandatory

        if (start > end) return 0;

        count++;

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        int currentElement = A[start];


        int maxIncludingCurrentElement = 1;

        for (int i = start + 1; i <= end; i++) {

            if (A[i] > currentElement) {

                int includingCurrentElement = 1 + LIS_My_Way_Harder_Way_With_Dynamic_Top_Down_Approach(A, i, end, false, memo);

                maxIncludingCurrentElement = Math.max(maxIncludingCurrentElement, includingCurrentElement);

//                break;
            }

        }

        if (!calculateExcludingCurrentElement) {
            System.out.print(currentElement + ",");
            memo.put(start, maxIncludingCurrentElement);
            return maxIncludingCurrentElement;
        }

        int maxExcludingCurrentElement = LIS_My_Way_Harder_Way_With_Dynamic_Top_Down_Approach(A, start + 1, end, true, memo);

        if (maxIncludingCurrentElement > maxExcludingCurrentElement) {
            System.out.print(currentElement + ",");
        }

        int result = Math.max(maxIncludingCurrentElement, maxExcludingCurrentElement);
        memo.put(start, result);
        return result;

    }

// ---------------------------------------------------------------------------------------------------------------------------- //
}
