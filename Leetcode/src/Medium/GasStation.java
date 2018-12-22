package Medium;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0, costSum=0;
        for (int i=0;i<gas.length;i++) {
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if (costSum > gasSum) return -1;
        int sum = 0, start=0;
        int[] need= new int[gas.length];

        for (int i=gas.length-1;i>=0;i--) {
            sum+=gas[i];
            sum-=cost[i];
            need[i] = sum;
            if (need[i] > need[start]) start = i;
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
