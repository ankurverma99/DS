import java.util.*;

public class Demo {
    public static void main(String[] args) {
        String st ="bcabc";
        int[] count = new int[26];
        char[] chr = st.toCharArray();
        for (char c : chr) {
            count[c-97]++;
        }
        String res="";
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                res =res+(char)(i+97);
            }
        }
        System.err.println("->"+res);
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] groupCounts = new int[4]; // Index 0 is not used

        // Count the number of guests in each group
        for (int num : nums) {
            groupCounts[num]++;
        }

        // Calculate expected positions of each group
        int[] expectedPositions = new int[4];
        for (int i = 1; i <= 3; i++) {
            expectedPositions[i] = expectedPositions[i - 1] + groupCounts[i];
        }
        int swaps = 0;
        int[] groupPointer = new int[4];
        for (int i = 0; i < n; i++) {
            int group = nums[i];
            int expectedIndex = expectedPositions[group];
            int currentIndex = groupPointer[group] + 1;

            if (i < expectedIndex && currentIndex > expectedIndex) {
                swaps += currentIndex - expectedIndex;
            }

            groupPointer[group]++;
        }

        return swaps;
    }
}
