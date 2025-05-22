package algorithm_part2.Greedy;

public class GasStation {
    public static void main(String[] args) {

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};

        int i = canCompleteCircuitGreedy(gas, cost);
        System.out.println("i = " + i);

    }

    public static int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length ; start++) {
            int fuel = 0;
            boolean carTravel = true;

            // 굳굳굳 Good Point!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            for (int j = start; j < gas.length + start; j++) {
                int index = j % gas.length;
                fuel += (gas[index] - cost[index]);

                if (fuel<0) {
                    carTravel = false;
                }
            }

            if (carTravel) {
                return start;
            }
        }
        return -1;
    }

    public static int canCompleteCircuitGreedy(int[] gas, int[] cost) {

        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0)
            return -1;
        ////////////////////////////////////////////////////////////////////////////
        // 위에서 종료되지 않았다면, 전체를 도달할수 있는 방법이 존재 -> 총합 [gas > cost]

        int start = 0;
        int fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            fuel += (gas[i] - cost[i]);
            if (fuel < 0) {
                start = i + 1;
                fuel = 0;
            }
        }
        return start;
    }
}
