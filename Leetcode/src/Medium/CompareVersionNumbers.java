package Medium;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        int i=0,j=0, v1=0,v2=0;
        while (i<version1.length() || j< version2.length())  {
            v1=0;
            v2=0;
            while (i<version1.length() && version1.charAt(i) != '.') v1 = v1*10 + version1.charAt(i++)-'0';
            while (j<version2.length() && version2.charAt(j) != '.') v2 = v2*10 + version2.charAt(j++)-'0';
            if (v1>v2) return 1;
            else if (v2>v1) return -1;
            else {
                i++;
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1  = "1.0", version2="1.10";
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion(version1, version2));
    }
}
