package com.company.codilityLessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
