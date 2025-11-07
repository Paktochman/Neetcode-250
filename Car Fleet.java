import java.util.*;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double curTime = 0;
        for (double[] car : cars) {
            if (car[1] > curTime) {
                fleets++;
                curTime = car[1];
            }
        }
        return fleets;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] pos = new int[n];
        int[] speed = new int[n];
        for (int i = 0; i < n; i++) pos[i] = sc.nextInt();
        for (int i = 0; i < n; i++) speed[i] = sc.nextInt();
        System.out.println(carFleet(target, pos, speed));
    }
}
