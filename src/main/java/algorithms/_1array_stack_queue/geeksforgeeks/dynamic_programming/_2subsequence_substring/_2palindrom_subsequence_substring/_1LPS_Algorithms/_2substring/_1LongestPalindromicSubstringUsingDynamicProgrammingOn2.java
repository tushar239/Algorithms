package algorithms._1array_stack_queue.geeksforgeeks.dynamic_programming._2subsequence_substring._2palindrom_subsequence_substring._1LPS_Algorithms._2substring;

/*

Longest Palindromic Substring

https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.

*/
public class _1LongestPalindromicSubstringUsingDynamicProgrammingOn2 {

    public static void main(String[] args) {
//        String str = "geekskeeg";//9 - geekskeeg
//        String str = "geeksforskeeg";//5 - geeks
//        String str = "fgeeksskeego";//10 - geeksskeeg
                String str = "rgeeeksXYskeeego";//3 - eee
//        String str = "BCPQQPXY";//4 - PQQP
//        String str = "forfor";//1
//        String str = "for";//1
        int maxLengthOfPalindromicSubstring = Brute_Force_Recursive_Another_Way_Better_To_Remember(str.toCharArray(), str.toCharArray(), 0, str.toCharArray().length - 1, 0, str.toCharArray().length - 1, false);
        System.out.println();
        System.out.println(maxLengthOfPalindromicSubstring);
    }

    /* Everything is same as "Longest Common Substring" algorithm (LongestCommonSubstringInTwoStrings.java) with a slight difference.

       When you find common character whose indices are different (s2End < s1End), you need to find same chars from remaining string by decreasing s1End and by increasing s2End till s2End < s1End

       S1 = forgeekskeegfor
                       -
       S2 = forgeekskeegfor
               -
       Here, you find 'g' as similarity at two different indices.
       Now, decrease s1End and increase s2End till chars matches and s2End < s1End

       S1 = forgeekskeegfor
                      -
       S2 = forgeekskeegfor
                -

       S1 = forgeekskeegfor
                     -
       S2 = forgeekskeegfor
                 -

       S1 = forgeekskeegfor
                    -
       S2 = forgeekskeegfor
                  -

       S1 = forgeekskeegfor
                   -
       S2 = forgeekskeegfor
                   -

       S1 = forgeekskeegfor
                  -
       S2 = forgeekskeegfor
                    -

       S1 = forgeekskeegfor
                 -
       S2 = forgeekskeegfor
                     -

       S1 = forgeekskeegfor
                -
       S2 = forgeekskeegfor
                      -

       S1 = forgeekskeegfor
               -
       S2 = forgeekskeegfor
                       -

    */

    // NOT WORKING.............
    // If you can make this work with Dynamic Programming, then this can also be in O(n^2)
    // You need to an approach as mentioned in
    //  https://www.youtube.com/watch?v=obBdxeCx_Qs
    // For O(n), you need to use Manacher's algorithm as mentioned in 'LongestPalindromicSubstring_Using_Manachers_Algorithm.java'
    private static int Brute_Force_Recursive_Another_Way_Better_To_Remember(char[] S1, char[] S2, int s1Start, int s1End, int s2Start, int s2End, boolean breakIfNotSame) {

        if (s1Start > s1End || s2End < s2Start) return 0;


       /* if(s1Start+1 == s2End) {
            if(S1[s1Start] == S2[s2End]) return 2;
        }

        if(s1Start+2 == s2End) {
            if(S1[s1Start] == S2[s2End]) return 3;
        }*/

        // reducing the problem by one
        char s1Char = S1[s1Start];
        char s2Char = S2[s2End];


        if (s1Char == s2Char) {
            if (s1Start == s2End) return 1;

            if (s1Start + 1 == s2End) return 2;

            System.out.print(s1Char + ",");

//            int includingTheChar = 1;

            int includingTheChar = 1 + Brute_Force_Recursive_Another_Way_Better_To_Remember(S1, S2, s1Start + 1, s1End, s2Start, s2End - 1, true);


//            if((s1Start + 1) > (s2End - 1)) includingTheChar = 1;
//            if((s2End - 1) - (s1Start + 1) > 1) includingTheChar = 1;

            int excludingTheChar = Math.max(Brute_Force_Recursive_Another_Way_Better_To_Remember(S1, S2, s1Start + 1, s1End, s2Start, s2End, false),
                    Brute_Force_Recursive_Another_Way_Better_To_Remember(S1, S2, s1Start, s1End, s2Start, s2End - 1, false));

            return Math.max(includingTheChar, excludingTheChar);
        }

        if (breakIfNotSame) {
            if (s1Char != s2Char) {
                return 0;
            }
        }

        // If the first and last characters do not match
        int excludingTheChar = Math.max(Brute_Force_Recursive_Another_Way_Better_To_Remember(S1, S2, s1Start + 1, s1End, s2Start, s2End, false),
                Brute_Force_Recursive_Another_Way_Better_To_Remember(S1, S2, s1Start, s1End, s2Start, s2End - 1, false));

        return excludingTheChar;

    }

}
