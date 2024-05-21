import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        System.err.println(findCurrency(lst));
      String st =  "What is the solution to this problem";
        String[] str = st.split(" ");
        String res="";
        for(int i=0;i<4;i++) {
            res = res + str[i];
            if (i < 3)
                res = res + " ";
        }
        System.out.println(res);
    }
    public static List<Integer> findCurrency(List<Integer> votes){
        Collections.sort(votes);
        List<Integer> lst = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(Integer i: votes){
            if(set.contains(i))
                lst.add(i);
            else
                set.add(i);
        }
        return lst;
        /*int[] voteCount = new int[votes.size() + 1];

        for (int vote : votes) {
            if (vote >= 1 && vote <= votes.size()) {
                voteCount[vote]++;
            }
        }

        List<Integer> releasedDenominations = new ArrayList<>();

        for (int denomination = 1; denomination <= votes.size(); denomination++) {
            if (voteCount[denomination] > 1) {
                releasedDenominations.add(denomination);
            }
        }

        return releasedDenominations;*/
    }
}
