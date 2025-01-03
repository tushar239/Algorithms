package algorithms.crackingcodinginterviewbook._5recursion_and_dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
Coins:
Given an infinite number of quarters(25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
Write code to calculate the number of ways of representing n cents;

NOTE:
Fibonacci.java and TripleSteps.java are the best examples of Bottom-Up Dynamic programming using 1-D array for memoization.
Thinking 1-D is easier, if you first implement the algorithm in brute-force way.

This algorithm is the best example of Bottom-Up Dynamic programming using 2-D array for memoization.
It is harder to think brute-force way for this algorithm.
It is a lot easier to think Bottom-Up Dynamic programming way directly for this algorithm.

(Important)
For any approach of "Dynamic Programming" (Top-Bottom or Bottom-Up), it is mandatory that problem has
    - optimal substructure
      if problem can be divided into subproblems and the solutions of subproblems can be used to construct the solution of a bigger problem (basically you can use recursion)
        and
    - overlapping problems (like fibonacci.java)
      function with same input is called multiple times or function’s output depends on previously calculated output of the function with previous parameters.

If there is optimal substructure, but no overlapping problem, then you may be able to use "Greedy Algorithm".

(Important)
What do you need to think of a problem in "Bottom-Up Dynamic programming" way directly instead of thinking Brute-Force and Top-Down Dynamic Approach first?

    Do you remember, 0/1 Knapsack problem from Grokking Algorithm Book?
    It says that you need to know
    - how much weight your knapsack (backpack) can hold.
        Here, you are told that you can have max so and so amount.
    - how much each item that can be put in knapsack weighs (and valued)
        Here, you have coins as items. each coin has its amount(value).
*/
public class _11CoinsChange {
    public static void main(String[] args) {
//        int amount = 5;
//        int[] coins = {1, 2, 3, 4};
//        int[] coins = {2, 1, 4, 3};
        //int[] coins = {1, 2, 3};
        int amount = 3;
        int[] coins = {1, 2};
        {
            System.out.println(count_bottom_up_dynamic_approach_from_some_other_source(coins, amount));
        }
        {
            int count = count_brute_force_book_way(coins, 0, coins.length - 1, amount);
            System.out.println(count);
        }
        System.out.println("Trying my way recursive");
        {
            int count = findTotalWays_My_Way(coins, 0, coins.length - 1, amount);
            System.out.println(count);
        }


        System.out.println("trying my way recursive 2...");
        {
            int count = ways(coins, 0, coins.length - 1, amount);
            System.out.println(count);
        }

        System.out.println("trying iterative....");
        {
            int count = count_brute_force_my_way_iterative(coins, 0, coins.length - 1, amount);
            System.out.println(count);
        }

        {
            int count = count_brute_force_two_level_recursion(coins, 0, coins.length - 1, amount);
            System.out.println(count);
        }
        {
            // i couldn't correct this algorithm. answer is not matching with above ones.
            int count = count_top_down_dynamic_approach(coins, 0, coins.length - 1, amount, new HashMap<>());
            System.out.println(count);
        }
        {
            int count = count_bottom_up_dynamic_approach_my_way(coins, amount);
            System.out.println(count);
        }
    }

    /*

        This algorithm is a good example of understanding how to start thinking Bottom-Up Dynamic programming right away instead of thinking about Recursion first.

        Read Dynamic Programming from 'README_grokking_algorithms_book_notes.docx'

        Watch below videos
        'Coin Change - Bottom-Up Dynamic Programming approach-1.mp4'
        'Coin Change - Bottom-Up Dynamic Programming approach-2.mp4'.

        This is the perfect example of how to think the solution using bottom-up dynamic programming.

        When can you use dynamic programming?
            'Optimal Substructure and Overlapping Problem - Prerequisite for Dynamic Programming.mp4'
            when you have
            - optimal substructure - if problem can be divided into subproblems and the solutions of subproblems can be used to construct the solution of a bigger problem (basically you can use recursion)
            and
            - overlapping problems (like fibonacci.java) - function with same input is called multiple times.

        When can you use Greedy programming?
            When you have
            - optimal substructure
            but not
            - overlapping problem


        IMPORTANT:  (I might be wrong because I tried this algorithm with unsorted and array and it worked, but while building a matrix on the paper, you use sorted array for your convinience)
            When you use Bottom-Up Dynamic Programing values for rows and cols have to be in ascending sort order.
            In this example, if you have been given coins in unsorted way, then you need to sort them first.


        Challenging part of below way of bottom-up dynamic approach is to find out a formula to calculate the result in each cell of the matrix.
        Watch above mentioned videos to understand that.

            amount
               0       1       2       3       4       5
           ----------------------------------------------
    c    0 |   1       0       0       0       0       0        ----- value in a matrix cell represents number of ways to make so and so amount with so and so coin(s)
    o      |
    i    1 |   1       1       1       1       1       1
    n      |
    s    2 |   1       1       1+1     1+1    1+2      1+2
           |                    |      |      |
           |                    v      v      v
         3 |   1       1        2      2+1    3+1      3+2
           |   |       |                 ^      ^
               |       |                 |      |
               --------|------------------      |
                       |                        |
                       --------------------------
         4 |   1       1        2       3       4       5+1=6


        - Always remember to start 1st row with 0 (one additional row is required).
          If you have 0 coins, there are 0 ways to get to any amount.

        - Always remember to start 1st col with 0 (one additional col is required).
          Later on, we will see how to determine the values in col 0.

        - At each row, you have current row coin and prev rows coins available for calculation.
          e.g. when you are on row 3, you have coins 1,2,3 available for calculation.

        - Don't initialize the value for 1st col right now. you start filling up the values from coins=1 and amount=1 cell (memo[1][1]) in above matrix.
          When you will try to determine the value of memo[2][2] (number of ways to get amount 2 with coins 1 and 2), you will figure out the whether the value of 1st col should be 1 or 0.

        - How to determine number of ways to get amount 4 with for with coins 1,2,3 (value for memo[3][4])?

            including number of ways with to get amount 4 with coins 1 and 2        +      number of ways to get amount 4 using coin 2

            ways with coins 1,2 for amount 4 = memo[2][4]                           +      to get amount=4, you need to include amount 1 to coin 3. so, 3+| 1 | = 4. So, to find out number of ways to get amount 1 with coins 1,2,3, you should get value from memo[3][1]

            So, memo[3][4] = memo[2][4] + memo[3][1]

        - How to decide the value of 1st col with amount 0, should it be 0 or 1?

            You will be able to determine it when you try to find out the value of memo[2][2] or memo[3][3] etc.
            e.g. number of ways to get amount 2 with coins 1 and 2 (memo[2][2]) are
            number of ways to get amount 2 with coins 1 (memo[1][2])
            (1+1)
                        +
            number of ways you can get amount 2 with coin 2. You know that this value has to be 1 to determine that a possible way is 2+0.
            what amount should you add to coin 2 to get amount 2?
            (2+0=2)
            You should find out number of ways to get amount 0 using coins 1 and 2 (memo[2][0)). Now, you know that to get expected result value of memo[2][0] should be 1. It cannot be 0.

     */
    private static int count_bottom_up_dynamic_approach_my_way(int coins[], int amount) {
        if (coins == null || coins.length == 0) return 0;
        if (amount < 0) return 0;

        int memo[][] = new int[coins.length + 1][amount + 1];

        // populate first row
        for (int col = 0; col <= amount; col++) {
            memo[0][col] = 0;// Important.  initialize 1st row with 0s
        }

        // populate first col
        for (int row = 0; row < coins.length; row++) {
            memo[row][0] = 1;// Important. initialize 1st col with 1s or 0s as per your need as explained in method comment
        }

        // start iterating from second row
        for (int row = 1; row < memo.length; row++) {
            // start iterating from second col
            for (int col = 1; col < memo[row].length; col++) {

                int coin = coins[row - 1];

                // These formulas are important for bottom-up dynamic approach that you need to determine by drawing a matrix on paper and filling it up first before writing the code.
                if (coin > col) {
                    memo[row][col] = memo[row - 1][col];
                } else {
                    memo[row][col] = memo[row - 1][col] + memo[row][col - coin];
                }
            }
        }
        return memo[memo.length - 1][memo[0].length - 1];// last value of memo is the answer
    }

    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java
    // i took this code just to check my code's output with this code's output
    public static int count_bottom_up_dynamic_approach_from_some_other_source(int[] coins, int total) {
        int temp[][] = new int[coins.length + 1][total + 1];
        for (int i = 0; i <= coins.length; i++) {
            temp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (coins[i - 1] > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
                }
            }
        }
        return temp[coins.length][total];
    }


    /*
        My thought process of how to work with 2-D problem
        --------------------------------------------------

        Coin Changing problem is 2-D because there are two dimensions - coins and amount.

        Can I use Bottom-Up Dynamic Approach to start with instead of Brute-Force?

            You can, if

            - It is hard to think Brute-Force to begin with
              If you can code Brute-Force, you can easily convert it into Top-Bottom Dynamic Approach.

            - It is a 0/1 knapsack kind of problem
              You knapsack(backpack) can hold some fixed amount of weight using various combinations of items available.
              It means that your one dimension has to have fixed range AT LEAST. Here amount is fixed and you can use a same coin infinitely to make up an amount).

        IMPORTANT:
            Whether you start with Bottom-Up Dynamic Approach or Brute-Force Approach for knapsack kind of problem,
            it is always better to draw a 2-D matrix on paper with one additional row and col (0th row and 0th col - it determines the most important exit condition) first.

            For normal matrix traversal problem like EightQueens.java and RobotInGrid.java, matrix is provided as an input. You are not solving knapsack problem there.
            So, you don't start matrix with additional row and col.

        IMPORTANT:
            If you choose to start with Bottom-Up Dynamic approach, first you need to fill up the matrix on paper starting from first cell.

        IMPORTANT:
            If you choose to go with Brute-Force (followed by Top-Bottom Dynamic Approach, if required),
            then also you draw a matrix on paper. You may not need to fill it up.

            When you think of recursion's reduce the problem by 1 approach, start from the last cell of the matrix (here amount=5 and coin=4)
            Why?
            Because normally, in 2-D problem, it is easier to think of a solution for the last element in drawn matrix instead of the first one.
            Here, it is easier to think that value at cell(4,5) depends on the values from its previous cells.


        IMPORTANT:
            There are two dimensions of this problem (coins and amount).
            So, you need to recurse this problem using both dimensions.

        It means that you need to recurse this problem using in 2-D, if you are using Brute-Force.

        There are 3 ways to solve 2-D problem:

            1) Total Imperative Approach:

              two loops (one loop for coins and another loop inside first one for amount)
              This is basically 100% imperative approach and very hard to code using Brute-Force.
              You actually will not be able to use it for Brute-Force.

            2) Half Imperative-Half Recursive Approach:  ----- This is the easiest approach among all. I would normally use this approach.

               Use a loop for one of the dimension and use recursion for another dimension.

               Use a look for amount and recursion for coins.

                int count(int coins[], int startIndex, int endIndex, int amount) {
                    ... exit conditions ...

                    int lastCoin = coins[endIndex];

                    for (int amt = amount; amt >= 0; amt--) { // loop for amount
                        int totalWays = 0;

                        // sometimes it is hard to find out all conditions to determine the value for one coin
                        // Drawing matrix will help you. So remember to draw 2-D matrix for 2-D problems before you start writing the code.
                        int waysUsingLastCoin = ..... // This value is determined based on conditions (comparisons between amt and coin)

                        // recursion for coins
                        int waysUsingPrevCoins = count(coins, startIndex, endIndex - 1, amt); // recursion for coins

                        int totalWays = waysUsingLastCoin + waysUsingPrevCoins;
                        return totalWays;
                    }

                }

            3) Think of recursive approach for both dimensions (coins and amount).

               This approach is a bit harder than approach 2 as per my experience. So, I normally go with approach 2.


                int count(int coins[], int startIndex, int endIndex, int amount) {

                    ... exit conditions ...

                    int lastCoin = coins[endIndex];

                    int waysUsingLastCoin = ...;

                    // recurse using coins for the same amount
                    int waysUsingPrevCoins = count_brute_force_two_level_recursion(coins, startIndex, endIndex - 1, amount);

                    int totalWaysUsingLastCoinAndPrevCoins = waysUsingLastCoin + waysUsingPrevCoins;

                    // In this algorithm, amount level recursion is happening in the condition to determine waysUsingLastCoin. So, you don't need additional reducing amount by 1 as shown in below statement.
                    // But in other algorithms, you may need to do this and choose final return value using  totalWaysUsingLastCoinAndPrevCoins and totalWaysUsingCombinationsOfOtherCoinsAndAmount.

                    // int totalWaysUsingCombinationsOfOtherCoinsAndAmount = count_brute_force_two_level_recursion(coins, startIndex, endIndex, amount - 1);
                    // return (logic to determine final return value using totalWaysUsingLastCoinAndPrevCoins and totalWaysUsingCombinationsOfOtherCoinsAndAmount)

                    return totalWaysUsingLastCoinAndPrevCoins;
                }

     */
    private static int count_brute_force_my_way_iterative(int coins[], int startIndex, int endIndex, int amount) {

        // if you don't have any coins, you cannot make any amount
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // if you have coins, but target amount is 0, then there is only 1 way to make amount 0;
        /*if (amount == 0) {
            return 1; // this is a very important condition. If you keep it 0, then end result will be wrong. Best way to determine this value is 2-D matrix process of Bottom-Up Dynamic Approach. That's why you should think of Bottom-Up dynamic approach to begin with for this kind of problems.
        }*/

        if (amount < 0) {
            return 0;
        }

        if (startIndex > endIndex) {
            return 0;
        }

        int lastCoin = coins[endIndex];

        for (int amt = amount; amt >= 0; amt--) {// you can covert this for loop also in recursion, but this is easier to think. You can see an example of converting for loop into recursion in EightQueens.java
            int totalWays = 0;

            int waysUsingLastCoin = 0;
            if (lastCoin == amt) {
                waysUsingLastCoin = 1;
            } else if (lastCoin > amt) {
                waysUsingLastCoin = 0;
            } else {
                waysUsingLastCoin = count_brute_force_my_way_iterative(coins, startIndex, endIndex, amt - lastCoin);
            }

            int waysUsingRemainingCoin = count_brute_force_my_way_iterative(coins, startIndex, endIndex - 1, amt);

            totalWays = waysUsingLastCoin + waysUsingRemainingCoin;
            return totalWays;
        }

        return 0;
    }

    @Deprecated// not working
    private static int count_brute_force_my_way_total_iterative(int coins[], int startIndex, int endIndex, int amount) {


        if (startIndex == endIndex) {

            int coinValue = coins[startIndex];

            int waysUsingThisCoin = 0;

            if (coinValue == amount) {
                waysUsingThisCoin = 1;
            }

            if (coinValue > amount) {
                waysUsingThisCoin = 0;
            }

            if (coinValue < amount) {
                waysUsingThisCoin = 0;
            }

            return waysUsingThisCoin;

        }
        if (amount < 0) {
            return 0;
        }

        int totalWays = 0;

        for (int i = startIndex; i <= endIndex; i++) {

            int waysUsingThisCoin = 0;

            int coinValue = coins[i];

            if (coinValue == amount) {
                waysUsingThisCoin = 1;
            }

            if (coinValue > amount) {
                waysUsingThisCoin = 0;
            }

            if (coinValue < amount) {
                waysUsingThisCoin = count_brute_force_my_way_total_iterative(coins, startIndex + 1, endIndex, amount - coinValue);
            }

            totalWays += waysUsingThisCoin;
        }

        return totalWays;
    }

    private static int count_brute_force_my_way_total_iterative(int coin, int amount) {

        // if you have coins, but target amount is 0, then there is only 1 way to make amount 0;
        /*if (amount == 0) {
            return 1; // this is a very important condition. If you keep it 0, then end result will be wrong. Best way to determine this value is 2-D matrix process of Bottom-Up Dynamic Approach. That's why you should think of Bottom-Up dynamic approach to begin with for this kind of problems.
        }*/

        int waysUsingLastCoin = 0;

        for (int amt = amount; amt >= 0; amt--) {

            if (coin == amt) {
                waysUsingLastCoin = 1;
            } else if (coin > amt) {
                waysUsingLastCoin = 0;
            } else {
                waysUsingLastCoin = count_brute_force_my_way_total_iterative(coin, amt - coin);
            }


        }

        return waysUsingLastCoin;
    }

    // This code is from Cracking In Coding Interview book that is root_to_leaf_problems_hard for me to understand because code doesn't follow the rules that established for 2D problem.
    // You should read explanation of the solution though.

    // Watch 'Coin Change - Top-Down Dynamic Programming approach.mp4'
    private static int count_brute_force_book_way(int coins[], int coinsStartIndex, int coinsEndIndex, int amount) {

        // if you don't have any coins, you cannot make any amount
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // if you have coins, but target amount is 0, then there is only 1 way to make amount 0;
        if (amount == 0) {
            return 1; // this is a very important condition. If you keep it 0, then end result will be wrong. Best way to determine this value is 2-D matrix process of Bottom-Up Dynamic Approach. That's why you should think of Bottom-Up dynamic approach to begin with for this kind of problems.
        }

        if (coinsStartIndex > coinsEndIndex) {
            return 0;
        }

        //System.out.println(amount+"-"+coins[coinsStartIndex]);
        /*
        if you have coins {1, 2, 3, 4} of cents to make 5 cents

        reducing the problem by one:
            think you have only {1} coin to make 0 cents. find out the ways to make 0 cents from {1} coin.
            recurse the logic to make remaining amount (5-0) with remaining {2,3,4} coins and add their ways to make 5 cents to the ways to make 5 cents using {1}.

            now increase the amount by coin value

        Steps with coin 1

             amountForCoin1 = 0

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 5
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)


             amountForCoin1 = 0 + coin value(1) = 1

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 4
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)


             amountForCoin1 = 1 + coin value(1) = 2

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 3
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)

             amountForCoin1 = 2 + coin value(1) = 3

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 2
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)

             amountForCoin1 = 3 + coin value(1) = 4

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 1
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)

             amountForCoin1 = 4 + coin value(1) = 5

             ways({1}, amountForCoin1)
             |
             | remainingAmountForOtherCoins = amount-amountForCoin1 = 0
             |
             --- ways({2,3,4}, remainingAmountForOtherCoins)


            So, while loop for coin {1} till amountForCoin1 <= amount
            With different combinations of {1} and amountForCoin1, determine different combinations of remaining coins with remaining amount (amount-amountForCon1).

        */
        int ways = 0;
        int amountRemainingWithCoin = 0;
        while (amountRemainingWithCoin <= amount) {
            int amountRemainingForOtherCoins = amount - amountRemainingWithCoin;

            int waysUsingRemainingCoins = count_brute_force_book_way(coins, coinsStartIndex + 1, coinsEndIndex, amountRemainingForOtherCoins);
            ways += waysUsingRemainingCoins;

            amountRemainingWithCoin += coins[coinsStartIndex];
        }

        return ways;

    }

    private static int count_brute_force_two_level_recursion(int coins[], int coinsStartIndex, int coinsEndIndex, int amount) {

        // if you don't have any coins, you cannot make any amount
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // if you have coins, but target amount is 0, then there is only 1 way to make amount 0;
       /* if (amount == 0) {
            return 1; // this is a very important condition. If you keep it 0, then end result will be wrong. Best way to determine this value is 2-D matrix process of Bottom-Up Dynamic Approach. That's why you should think of Bottom-Up dynamic approach to begin with for this kind of problems.
        }*/

        if (amount < 0) {
            return 0;
        }

        if (coinsStartIndex > coinsEndIndex) {
            return 0;
        }

        int lastCoin = coins[coinsEndIndex];

        int waysUsingLastCoin = 0;
        if (lastCoin == amount) {
            waysUsingLastCoin = 1;//+ count_brute_force_two_level_recursion(coins, coinsStartIndex, coinsEndIndex - 1,  amount);;
        } else if (lastCoin > amount) {
            waysUsingLastCoin = 0;
        } else {
            // recurse amount
            waysUsingLastCoin = count_brute_force_two_level_recursion(coins, coinsStartIndex, coinsEndIndex, amount - lastCoin);
        }

        int waysUsingPrevCoins = count_brute_force_two_level_recursion(coins, coinsStartIndex, coinsEndIndex - 1, amount);

        int totalWaysUsingLastCoinAndPrevCoins = waysUsingLastCoin + waysUsingPrevCoins;

        /*
            In this algorithm, amount level recursion is happening in the condition to determine waysUsingLastCoin. So, you don't need additional reducing amount by 1 as shown in below statement.
            But in other algorithms, you may need to do this and choose final return value using  totalWaysUsingLastCoinAndPrevCoins and totalWaysUsingCombinationsOfOtherCoinsAndAmount.
        */
        // int totalWaysUsingCombinationsOfOtherCoinsAndAmount = count_brute_force_two_level_recursion(coins, coinsStartIndex, coinsEndIndex, amount - 1);
        // return (logic to determine final return value using totalWaysUsingLastCoinAndPrevCoins and totalWaysUsingCombinationsOfOtherCoinsAndAmount)

        return totalWaysUsingLastCoinAndPrevCoins;

    }


    /*
        As you see in above recursive call, changing elements are coinsStartIndex and amount.
        So, you can memoize the result of recursive call with key containing coinsStartIndex and amount.
     */
    private static int count_top_down_dynamic_approach(int coins[], int coinsStartIndex, int coinsEndIndex, int amount, Map<String, Integer> coinsStartIndexAmountAndWaysMap) {

        String key = coinsStartIndex + "-" + amount;

        if (coinsStartIndexAmountAndWaysMap.containsKey(key)) {

            return coinsStartIndexAmountAndWaysMap.get(key);

        } else {

            // if you don't have any coins, you cannot make any amount
            if (coins == null || coins.length == 0) {
                return 0;
            }

            // if you have coins, but target amount is 0, then there is only one way to make amount 0;
            if (amount == 0) {
                return 1;
            }

            if (coinsStartIndex > coinsEndIndex) {
                return 0;
            }

            int ways = 0;

            int amountRemainingWithCoin = 0;
            while (amountRemainingWithCoin <= amount) {
                int amountRemainingForOtherCoins = amount - amountRemainingWithCoin;

                int waysUsingRemainingCoins = count_top_down_dynamic_approach(coins, coinsStartIndex + 1, coinsEndIndex, amountRemainingForOtherCoins, coinsStartIndexAmountAndWaysMap);
                ways += waysUsingRemainingCoins;

                amountRemainingWithCoin += coins[coinsStartIndex];
            }

            coinsStartIndexAmountAndWaysMap.put(key, ways);

            return ways;
        }
    }

    private static int ways(int[] coins, int start, int end, int amount) {
        //if(start > end) return 0;
        if (start == end) {
            int coinValue = coins[start];
            if (coinValue == amount) {
                return 1;
            }
            if (coinValue > amount) {
                return 0;
            }
            if (coinValue < amount) {
                if (amount % coinValue == 0) {
                    return 1;
                } // this condition is required when you can use infinite number of same coin
                return 0;
            }
        }

        if(amount == 0){
            return 1;
        }
        /*if (amount < 0) { // I kept it like this because from recursive condition, it seems that amount can go below 0
            return 0;
        }*/

        int coinValue = coins[start];

        int waysUsingCurrentCoin = 0;

        if (coinValue == amount) {

            /*
             This is wrong because e.g. int[] A = {5,2,3,4} and amount=5
             Here, coinValue=5 and 5==5
             when you say --- totalWays for 5 = 1 + ways(coins, (2,3,4), amount);
             When you are trying to find ways with coins=(2,3,4) to make amount=5, coin=5 is not included in those combinations.

             Take LIS example:
             int[] A = {4,1,12,6,2}
             You are saying LIS(4) = 1 + max(LIS(12), LIS(6)). Here, 4 is a part of LIS from 12 or 6.
            */

            //totalWays = 1 + ways(coins, start + 1, end, amount);

            waysUsingCurrentCoin = 1;
        }
        if (coinValue > amount) {
            //totalWays = ways(coins, start + 1, end, amount); // This is wrong because you are already calculating totalWaysExcludingCurrentCoin
            waysUsingCurrentCoin = 0;
        }
        if (coinValue < amount) {

            // this code is required when you can use infinite number of same coin
            /*int ways = 0;

            int totalNumberOfCoinCanBeUsedToContributeToAmount = findMaxNumberOfCurrentCoinCanBeUsed(coinValue, amount);
            for(int i=1; i<= totalNumberOfCoinCanBeUsedToContributeToAmount; i++) {
                ways = ways + ways(coins, start+1, end, amount - coinValue*i);
            }
            waysUsingCurrentCoin += ways;*/

            // or
            waysUsingCurrentCoin = ways(coins, start, end, amount - coinValue);

            // This code is required instead of above code, if you can use only 1 coin of same value
            //totalWays=0;
            //totalWays = ways(coins, start + 1, end, amount - coinValue);// this is wrong
        }

        int totalWaysExcludingCurrentCoin = ways(coins, start + 1, end, amount);

        int totalWays = waysUsingCurrentCoin + totalWaysExcludingCurrentCoin;

        return totalWays;
    }


    /*
        amount = 79 cents
        coins = {25 cents, 10 cents, 5 cents, 1 cents}

        Just like LCS, this is two inputs problem. It means that for outer loop (finding total ways to make change using all coins one by one) will be a part of recursive call.

        Now, reducing the problem by 1:
        take first coin value = 25 cents and find out number of ways to make amount = 79 cents using it.

        if(coinValue == amount)
            ways = 1
            // not 1 + findTotalWays(coins, startIndex+1,endIndex,amount) --- it says findTotalWays_My_Way(79, (10,5,1)). In this, we are not utilizing 25 cents to make 79 cents. This code is all about how can use 25 cents to make 79 cents.

        if(coinValue > amount)
            ways = 0

        if(coinValue < amount)
            maxNumberOf25Cents = find out max number of 25 cents that can be used to make 79 cents.

        for (int i = 1; i <= maxNumberOf25Cents; i++) {

            If 25 cents < 79 cents,
            find out total ways using (10,5,1) coins to make amount=(79-25=54 cents)
            find out total ways using (10,5,1) coins to make amount=(79-50=29 cents)


            ways += findTotalWays(coins, startIndex + 1, endIndex, 79 - (25 * i));
        }

     */
    private static int findTotalWays_My_Way(int[] coins, int startIndex, int endIndex, int amount) {

        if (startIndex == endIndex) {
            int currentCoinValue = coins[startIndex];

            if (currentCoinValue > amount) {
                return 0;
            } else if (currentCoinValue == amount) {
                return 1;
            } else {
                int maxNumberOfCurrentCoinCanBeUsed = findMaxNumberOfCurrentCoinCanBeUsed(currentCoinValue, amount);
                if (amount == currentCoinValue * maxNumberOfCurrentCoinCanBeUsed) {
                    return 1;
                }
                return 0;
            }

        }

        // Very important exit condition.
        // Look at the else condition to figure out why return value should be 1 and not 0
        if (amount == 0) {
            return 1;
        }

        int currentCoinValue = coins[startIndex];

        int waysToMakeAmountUsingCurrentCoin = 0;

        if (currentCoinValue > amount) {
            waysToMakeAmountUsingCurrentCoin = 0;
        } else if (currentCoinValue == amount) {
            waysToMakeAmountUsingCurrentCoin = 1;
        } else { // if currentCoinValue < amount

            // This code is not working, but ORed code is working. I don't know why this code is not working.
           int maxNumberOfCurrentCoinCanBeUsed = findMaxNumberOfCurrentCoinCanBeUsed(currentCoinValue, amount);// this will be 1 or more
           for (int i = 1; i <= maxNumberOfCurrentCoinCanBeUsed; i++) {

                // if amount = 50 cents and current coin value = 25 cents, then maxNumberOfCurrentCoinCanBeUsed=2
                // when i==2, recursed amount value = 0. So, when amount==0, number of it should return 1.
                // By seeing this recursive call, it seems that recursive call's amount can down at the most 0
                waysToMakeAmountUsingCurrentCoin += findTotalWays_My_Way(coins, startIndex + 1, endIndex, amount - (currentCoinValue * i));
            }

            // OR

            //waysToMakeAmountUsingCurrentCoin = ways(coins, startIndex, endIndex, amount - currentCoinValue);
        }

        int waysToMakeAmountUsingRemainingCoins = findTotalWays_My_Way(coins, startIndex + 1, endIndex, amount);

        int totalWays = waysToMakeAmountUsingCurrentCoin + waysToMakeAmountUsingRemainingCoins;

        return totalWays;

    }

    private static int findMaxNumberOfCurrentCoinCanBeUsed(int coinValue, int amount) {
        return amount / coinValue;
    }
}
