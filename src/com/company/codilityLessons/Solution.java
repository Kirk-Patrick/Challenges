package com.company.codilityLessons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public int forgJmp(int X, int Y, int D) {
        int jumps = (Y-X)/D;
        if((Y-X)%D==0)
            return jumps;
        else
            return jumps+1;
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
    public static String reformat(String S) {
       String  purgeString = S.replaceAll("[^\\d.]", "");
        String n = java.util.Arrays.toString(purgeString.split("(?<=\\G...)"));
      String f =  n.replace(',','-');
      String j = S.replaceAll("[*//]", "");

       return "";
    }
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    public static int demo(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int curr =1;
        int nextValue =0;
        int skipvalue = 0;
        for(int i =0;i<A.length;i++)
        {

            if(A[i]>0)
            {
               curr =A[i];
               nextValue= ++curr;
               if(nextValue!=A[i] && A[i]>nextValue )
               {
                   skipvalue =A[i]+1;
               }

            }

        }
        return skipvalue;
    }

    public static String phoneNumberCal(String[] A, String[] B, String P) {

        if(A.length>=0&&B.length>0 && P.length()>0) {
            ArrayList<String> matches = new ArrayList<String>();
            List<String> Blist = Arrays.asList(B);
            for (int i = 0; i < B.length; i++) {
                if (B[i].contains(P))
                    matches.add(A[i]);
            }
            Collections.sort(matches);

            return matches.size() <= 0 ? "NO CONTACT" : matches.get(0);
        }
        return "NO CONTACT";
    }
    public static int  oddOccurences(int[] a)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int odd =0;
        for(int i=0;i<a.length;i++)
        {
            if(mp.containsKey(a[i]))
            {
                mp.put(a[i],mp.get(a[i])+1);
            }
            else
            {
                mp.put(a[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: mp.entrySet())
        {

            if(entry.getValue()%2!=0)
            {
                odd = entry.getKey();
            }
        }

        return odd;
    }

    public static void searchWithBinarySearch(int [] arr)
    {
      //int un =  Stream.of(arr).distinct().toArray();
        Arrays.sort(arr);
        int foundIndex  = Arrays.binarySearch(arr,7);
        System.out.print(foundIndex);


    }

    public static int jumps(int X, int Y, int D)
    {
        int jumps=0;
        if(X==Y)
        {
            return jumps;
        }
        else{
            int difference = Y-X;
            int evenTimes = difference /D;
            if(difference%D!=0);
              ++jumps;
              jumps +=evenTimes;
        }
        return jumps;
    }

    public static void plusMinus(int[] arr) {
        //get count of all positive,negative and 0

        int negativeCount =0;
        int positiveCount =0;
        int zeroCount =0;
        for(int i =0;i<arr.length;++i)
        {
            if(arr[i]<0)
                ++negativeCount;
            if(arr[i]>0)
                ++positiveCount;
            if(arr[i]==0)
                ++zeroCount;
        }

        BigDecimal length = BigDecimal.valueOf(arr.length).setScale(1);
        BigDecimal positive = BigDecimal.valueOf(positiveCount).setScale(1);
        BigDecimal negative = BigDecimal.valueOf(negativeCount).setScale(1);
        BigDecimal zero = BigDecimal.valueOf(zeroCount).setScale(1);

        BigDecimal positiveResult =  positive.divide(length, 6, RoundingMode.HALF_UP);
        BigDecimal negativeResult = negative.divide(length, 6, RoundingMode.HALF_UP);
        BigDecimal zeroResult = zero.divide(length, 6, RoundingMode.HALF_UP);

       System.out.print(positiveResult+"\n"+negativeResult+"\n"+zeroResult+"\n");

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int highest = Collections.max(candles);
        int occurrences = Collections.frequency(candles,highest);
        return occurrences;

    }

    /**convert 12 hour to 24 hours*/
   public  static String timeConversion(String s) {
       DateFormat df = new SimpleDateFormat("hh:mm:ss aa");

       DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");

       Date format12 = null;
       String format24 = null;

       try{
           //Converting the input String to Date
           format12= df.parse(s);
           //Changing the format of format12 and storing it in String
           format24 = outputformat.format(format12);
           //Displaying the format12
           System.out.println(format24);
       }catch(Exception pe){
           pe.printStackTrace();
       }

        return format24;
    }
    public static String angryProfessor(int k, int[] a) {
       int arrivalTimeCount = 0;
       Arrays.sort(a);
       for(int i =0;i<a.length;++i) {
           if (a[i] <= 0)
               ++arrivalTimeCount;
           if(arrivalTimeCount>=k)
               break;
       }

       if(arrivalTimeCount<k)
         return "YES";
       else
           return "NO";
    }

    public static int beautifulDays(int i, int j, int k) {

        int beautifulDays = 0;
       for(int r=i;r<=j;++r)
        {
            String number = String.valueOf(r);
            StringBuilder builderNumber = new StringBuilder();
            builderNumber.append(number);
            builderNumber.reverse();
            String transformed = builderNumber.toString();

           String purged = transformed.replaceAll("^0*","");

           int reverseNumber = Integer.parseInt(purged);

           if( (r-reverseNumber)%k==0)
               ++beautifulDays;
        }

     return beautifulDays;

    }

    public static int migratoryBirds(List<Integer> arr) {

       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashMap<String,Integer> lowestKey = new HashMap<String,Integer>();


        for(int i=0;i<arr.size();++i)
        {
            if(map.containsKey(arr.get(i)))
            {
                map.put(arr.get(i),map.get(arr.get(i))+1);
            }
            else{
                map.put(arr.get(i),1);
            }
        }
       int max = Collections.max(map.values());

       for(Map.Entry<Integer,Integer> entry : map.entrySet())
       {
            if(entry.getValue().equals(max)){
                if(lowestKey.isEmpty()) {
                    lowestKey.put("lowKey",entry.getKey());
                }
                else if(entry.getKey()<lowestKey.get("lowKey"))
                {
                  lowestKey.put("lowKey",entry.getKey());
                }
            }
       }

    return lowestKey.get("lowKey");
    }

    public static int findDigits(int n) {

       String strNum = String.valueOf(n);
       int divisibleSum =0;
       char [] ch_arr = strNum.toCharArray();

       for(int i=0;i<ch_arr.length;i++)
       {
          int parseNumber = Character.getNumericValue(ch_arr[i]);
          if(parseNumber!=0) {
              if (n % parseNumber == 0)
                  divisibleSum++;
          }
       }
      return divisibleSum;

    }

   public  static int maximumToys(int[] prices, int k) {
        int maxToys =0;
        int spent=0;

       Arrays.sort(prices);

       for(int i=0;i<prices.length;++i)
       {
           spent += prices[i];
           ++maxToys;
           if(spent>k) {
               --maxToys;
               break;
           }

       }
      return  maxToys;
    }

    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int lastThunder =0;
        int newthunder =0;
        int minJumps =0;
        for(int i=0;i<c.length;++i)
        {
            if(c[i]==1)
            {
                newthunder =i;
                int zeros = (i-lastThunder)-1;
                    if(zeros%3==0)
                    {
                        minJumps+=(zeros/3);
                    }
                    else
                    {
                        minJumps+=(zeros/3)+1;
                    }
                    lastThunder = newthunder;
            }

        }
        return 0;
    }
    public static long repeatedString(String s, long n) {
        long oc = s.chars().filter(ch -> ch == 'a').count();
        long quotient = 0;
        long repeatCount =0;

        if(oc>0) {
            if (n % s.length() == 0) {
                quotient = n / s.length();
                repeatCount = oc * quotient;
            } else {
                quotient = n / s.length();
                repeatCount = (oc * quotient) + 1;
            }

            return repeatCount;
        }
        return  0;
    }

    public static int minimumDistances(int[] a) {
      HashMap<Integer,Integer> pairs = new HashMap<Integer,Integer>();

      for(int i =0;i<a.length;++i)
      {
          if(!pairs.containsKey(a[i]))
          {
              pairs.put(a[i],i);
          }
          else{
              pairs.put(pairs.get(a[i]),i+1);
          }
      }


      return 0;

    }
    public static int alternatingCharacters(String s) {

        int delCount =0;
        for(int i=0;i<s.length();++i)
        {
            if(i>0)
            {

                if(s.charAt(i-1)==s.charAt(i))
                    ++delCount;
            }

        }
        return delCount;
    }

   public static String isValid(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        String answer ="YES";
        for(int i=0;i<s.length();++i)
       {
           if(!map.containsKey(s.charAt(i)) )
               map.put(s.charAt(i),1);
           else{
               map.put(s.charAt(i),map.get(s.charAt(i))+1);
           }
           if(map.get(s.charAt(i))>2)
               answer ="NO";

       }

     return answer;
    }

    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        double threshold = 0.05 * customers.size();
        for (int i = 0; i < customers.size(); ++i) {
            if (!map.containsKey(customers.get(i))) {
                map.put(customers.get(i), 1);
            } else {
                map.put(customers.get(i), map.get(customers.get(i)) + 1);
            }
        }

        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

              double per= (entry.getValue()*100)/customers.size();
              if(per>threshold)
              {
                  list.add(entry.getKey());
              }
        }


        Collections.sort(list);


        return list;
    }

}
