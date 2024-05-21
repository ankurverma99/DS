import java.util.*;

public class CandyCrush {
    public static void main(String[] args) {
        String st ="aaabbbaaccd";
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : st.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch)!=null && map.get(ch) == 3) {
                System.err.println(ch);
                map.remove(ch);
            }

        }
        List<Character> lst = new ArrayList<>(map.keySet());
        String str = "";
        for (Character ch : lst){
            int n = map.get(ch);
            while (n>0){
                str=str+ch;
                n--;
            }
        }
        System.out.println(str);
        /*lst.forEach(System.out::println);
        map.forEach((key,val) -> System.out.println(key+"---->"+ val));*/
    }
}
