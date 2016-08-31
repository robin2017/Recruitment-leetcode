package String;

/**
 * Created by robin on 16/8/28.
 */
public class BigInteger {
    public static void main(String[] args){
        System.out.println(multiply("66666", "44444"));
    }

    public static String multiply(String num1, String num2){
        int[] result=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
            for(int j=num2.length()-1;j>=0;j--){
                result[i+j-1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');

            }

        for(int i=result.length-1;i>=0;i--){
            result[i-1]+=result[i]/10;
            result[i]=result[i]%10;
        }

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<result.length;i++)
            sb.append(result[i]+'0');
        return sb.toString();
    }
}


