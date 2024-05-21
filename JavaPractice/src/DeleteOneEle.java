import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteOneEle {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int pc=0,total_count=0;
        boolean contains0=false;
        int res=0;
        for(int i =0;i< nums.length;i++){
           if(nums[i]==0){
              res= Math.max(res,total_count);
               total_count=pc;
               pc=0;
               contains0=true;
           }else {
               pc++;
               total_count++;
           }

        }
        if(!contains0)
            res = nums.length-1;
        res=Math.max(res,total_count);
        System.out.println(res);
        int nu[] ={1,0,0,0};
        System.out.println(count1s(nu));
    }
    public static int count1s(int[] nums){
        String num="";
        boolean containszero=false;
        for(int i : nums) {
            if (i == 0)
                containszero = true;
            num = num + i;
        }
      String[] str = num.split("0");
      int res=0;
        if(str.length==1 && containszero)
            return str[0].length();
        if(!containszero)
            return nums.length-1;
      for(int i =0;i<str.length-1;i++){
          int curr=str[i].length();
          res=Math.max(res,curr+str[i+1].length());
      }

      return res;
    }
}
