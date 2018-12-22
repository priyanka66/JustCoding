package Medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        List<String> output = new ArrayList<>();
        if (source.length == 0) return output;
        boolean blockComment = false;
        StringBuilder result = new StringBuilder();
        for (int i=0;i<source.length;i++) {
            String line = source[i];
            for (int j=0;j<line.length();j++) {
                if (!blockComment) {
                    if ((j+1)<line.length() && (line.charAt(j)=='/' && line.charAt(j+1)=='/'))
                        break;
                    else if ((j+1)<line.length() && (line.charAt(j)=='/' && line.charAt(j+1)=='*')) {
                        blockComment = true;
                        j++;
                    } else {
                        result.append(line.charAt(j));
                    }
                } else {
                    if ((j+1)<line.length() && (line.charAt(j)=='*' && line.charAt(j+1)=='/')) {
                        blockComment = false;
                        j++;
                    }
                }
            }
            if (result.toString().length() > 0 && !blockComment) {
                output.add(result.toString());
                result.setLength(0);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        RemoveComments c = new RemoveComments();
        String[] source = {
                "/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"};
        System.out.println(c.removeComments(source));
    }
}
