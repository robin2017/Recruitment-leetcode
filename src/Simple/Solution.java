package Simple;

/**
 * Created by robin on 16/8/31.
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(new Solution().int2str(34));
    }

    private int gcd(int a,int b){
        int c;
        while((c=a%b)!=0){
            //赋值时注意左斜线
            a=b;
            b=c;
        }
        return b;
    }

    private int abs(int a,int b){
        return a>b?a-b:b-a;
    }

    private String int2str(int a){
        return Integer.toBinaryString(a);
    }

    private int numberof1(int n){
        int cnt=0;
        while(n!=0){
            n=n&(n-1);
            cnt++;
        }
        return cnt;
    }
}
