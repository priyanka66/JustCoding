package Easy;
//public class WaysSumOfConsecutive
import java.io.*;

public class WaysSumOfConsecutive
{
    public static long count = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine()); //Enter a number( <=10^12)
        //driver(num);
        func(num);
        System.out.println("count = " + count);
    }


    public static void func(long num)
    {
        long temp,i,j,k=1;
        long limit = ((num * (num+1))/2);
        for(i = 1 ; i <= limit ; i++)
        {
            temp = num;
            j=i;
            while(j < temp)
            {
                temp = temp - j;
                j++;
            }
            if(j == temp)
            {
                count++;
            }
        }
    }

}
