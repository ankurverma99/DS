public class CharCount {
    public static void main(String[] args) {
        String[] chars = {"a","a","b","b","c","c","c"};
        String res="";
        if(chars.length==1)
            res=res+chars[0];
        int count=1;
        for (int i = 0; i < chars.length-1; i++) {
           if(chars[i].equals(chars[i + 1]))
                count++;
           else {
               if(count==1)
                   res=res+chars[i];
               else
                   res=res+chars[i]+count;
               count=1;
           }
        }
        res=res+chars[chars.length-1]+count;
        System.out.println(res);
    }
}
