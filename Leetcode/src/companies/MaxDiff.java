package companies;

public class MaxDiff {

    int maxDiff(int a[])
    {
        int maxDiff = a[1] - a[0];
        int min = a[0];
        int i;
        for (i = 1; i < a.length; i++)
        {
            if (a[i] - min > maxDiff)
                maxDiff = a[i] - min;
            if (a[i] < min)
                min = a[i];
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        MaxDiff maxdif = new MaxDiff();
        int arr[] = {7,2,3,10,2,4,8,1};
        int size = arr.length;
        System.out.println("MaximumDifference is " +
                maxdif.maxDiff(arr));
    }
}
