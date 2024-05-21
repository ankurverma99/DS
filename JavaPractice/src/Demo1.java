import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
       String st ="ABCDEFGABEF";
       String res="";
        for (int i = 0; i < st.length(); i++) {
            for (int j = i; j < st.length(); j++) {
                if(res.length()<st.substring(i,j).length())
                        if(!isContains(res))
                          res=st.substring(i,j);
                        else
                            break;
            }
        }
    System.out.println(res);
        System.out.println(tribonacci(25));
        int[] n = {3,2,4};
        System.out.println( deletePoints(n));
        System.out.println(frequencySort("tree"));
       

    }
    public static boolean isContains(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                return true;
            else
                map.put(ch,1);
        }
        return false;
    }
    public static int tribonacci(int n) {
        int t0=0,t1=1,t2=1;
        int res=0;
        n=n-3;
        while(n>=0){
             res = t0+t1+t2;
            t0=t1;//1
            t1=t2;//1
            t2=res;//2
            n--;
        }
        return res;
    }

    public static int deletePoints(int[] nums) {
        int maxGemValue = Integer.MIN_VALUE;//0
        for (int gem : nums) {
            maxGemValue = Math.max(maxGemValue, gem);//4
        }
        int[] freq = new int[maxGemValue + 1];//5
        for (int gem : nums) {
            freq[gem]++;
        }
        int[] maxPoints = new int[maxGemValue + 1];//5

        maxPoints[0] = 0;
        maxPoints[1] = freq[1] * 1;

        for (int i = 2; i < maxPoints.length; i++) {
            maxPoints[i] = Math.max(maxPoints[i - 1], maxPoints[i - 2] + freq[i] * i);
        }
        return maxPoints[maxGemValue];


    }
    public static String frequencySort(String s) {
        String res="";
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        List<Character> lst = new ArrayList<>(map.keySet());
        Collections.sort(lst, (a,b) -> map.get(b)-map.get(a));
        map.forEach((a,b) -> System.err.println(a +"    -> "+ b));
        for(Character ch : lst)
            res+=String.valueOf(ch).repeat(map.get(ch));

        return res;

    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
