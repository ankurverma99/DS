import java.util.*;

public class StringSum {
    public static void main(String[] args) {
       /* String str ="(1+(4+5+2)-3)+(6+8)";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if((ch>='0'&&ch<='9') || ch =='+'|| ch=='-')
                stack.push(ch);
        }
        int sum=0;
        for(Character c : stack)
        {
            int digi=0;
            if (Character.isDigit(c))
                digi=Integer.parseInt(""+c);
            System.out.println(digi);
            if(c=='+')
                sum=sum+digi;
            System.err.println(sum);
            if (c=='-')
                sum=sum-digi;
        }
    System.out.println(sum);*/
        List<Character> lst = new ArrayList<>();
        lst.add('z');
        lst.add('b');
        lst.add('c');
        lst.add('d');

        Collections.sort(lst);
        Collections.reverse(lst);
        System.out.println(lst);

        String[] sr ={"eat", "tea", "tan", "ate", "nat"," bat"};
        Arrays.sort(sr);
        System.out.println(groupAnagrams(sr));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        characters.sort((a, b) -> {
            int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if (freqCompare == 0) {
                return Character.compare(a, b);
            }
            return freqCompare;
        });
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            int count = frequencyMap.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();


    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : anagramMap.values()) {
            Collections.sort(group);
            result.add(group);
        }

        // Sort the list of groups lexicographically
        result.sort((a, b) -> a.get(0).compareTo(b.get(0)));

        return result;

    }
    public static boolean isAnagram(String a , String b){
        if(a.length()!=b.length())
            return false;
        char[] aSt =   a.toCharArray();
        char[] bSt =   b.toCharArray();
        Arrays.sort(aSt);
        Arrays.sort(bSt);
        for(int i =0;i<aSt.length;i++){
            if(aSt[i]!=bSt[i])
                return false;
        }
        return true;
    }

}
