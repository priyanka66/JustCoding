package Easy;

public class StringCompression {

    public int compress(char[] chars) {
        int pos=0;
        char temp=' ';
        int count=0;
        for(char c:chars)
        {
            if(c!=temp)
            {
                if(count!=0)
                    chars[pos++]=temp;
                if(count>1)
                {
                    for(int i=0;i<(count+"").length();i++)
                        chars[pos++]=(count+"").charAt(i);
                }
                count=1;
                temp=c;
            }
            else
                count++;
        }
        chars[pos++]=temp;
        if(count!=1)
        {
            for(int i=0;i<(count+"").length();i++)
                chars[pos++]=(count+"").charAt(i);
        }
        return pos;
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        char[] chars = {'a','b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(s.compress(chars));

    }
}
