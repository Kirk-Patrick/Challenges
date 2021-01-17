package com.company.codilityLessons;

import java.util.*;

public class Solution {

    public static int BinaryGap(int N) {
        String binary = Integer.toBinaryString(N);        // get a string binary representation N
        char[] barray = binary.toCharArray();            // convert to char array /*perference*/

        List<Integer> gaps = new ArrayList<Integer>();  //DS to store gaps found
        int currindex = 0;                             // intial 0 to track the index of end of gap
        for (int i = 0; i < barray.length; i++) {
            if (i > 0 && barray[i] == '1') {
                gaps.add( i - 1 - currindex);          // add the gaps found
                currindex = i;                        // update index when a gap end is found
            }
        }
        return gaps.size() == 0 ? 0 : Collections.max(gaps); //if the are gaps find the max else return 0
    }

    public static int distinctElements(int[] A) {
     HashSet<Integer> hs = new HashSet<>();

     for(int i =0;i<A.length;i++)
     {
         if(!hs.contains(A[i]))
         {
             hs.add(A[i]);
         }
     }
     return hs.size();
    }

   public static int[] rightRotate(int[] A, int K)
   {
       if(A.length>1 || K==0) {
           int[] rotationArr = A.clone();
           int numRotations = 0;
           while (numRotations < K) {

               int lastItem = rotationArr[rotationArr.length - 1];
               int firstItem = rotationArr[0];
               int[] swap = {lastItem, firstItem};
               int[] subarray = Arrays.copyOfRange(rotationArr, 1, rotationArr.length - 1);

               rotationArr = new int[swap.length + subarray.length];
               System.arraycopy(swap, 0, rotationArr, 0, swap.length);
               System.arraycopy(subarray, 0, rotationArr, swap.length, subarray.length);

               numRotations++;

           }
           return rotationArr;
       }
       return A;
   }
}
