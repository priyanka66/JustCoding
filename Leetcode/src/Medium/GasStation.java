package Medium;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        int[] need = new int[cost.length];
        for (int x:gas) {
            gasSum+=x;
        }
        for (int x:cost) {
            costSum+=x;
        }
        if  (costSum>gasSum) return -1;
        int  start=0, sum=0;
        for (int i=gas.length-1;i>=0;i--) {
            sum += gas[i];
            sum -= cost[i];
            need[i] = sum;
            if (need[i] > need[start]) start=i;
        }

        return start;
    }

    public static void main(String[] args) {
        GasStation s = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(s.canCompleteCircuit(gas,cost));
    }
}
