import java.util.Stack;

public class StringDecoded {
    public static void main(String[] args) {
        String s ="2[abc]3[cd]ef";//"3[a2[c]]";
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();//3,2
        StringBuilder sb = new StringBuilder();//ac
        int n=0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                n=n*10+(c-'0');
            else if (c == '[') {
                st.push(n);
                n=0;
                str.push(sb);
                sb=new StringBuilder();
            } else if (c == ']') {
                int k = st.pop();
                StringBuilder temp = sb;
                sb=str.pop();
                while (k -- >0)
                    sb.append(temp);
            }else
                sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
