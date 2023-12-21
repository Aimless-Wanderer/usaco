import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CowTuition {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] tuition = new long[N];

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            tuition[i] = Long.parseLong(st2.nextToken());
        }

        Arrays.sort(tuition);

        long maxEarned = 0;
        long maxTuition = Long.MAX_VALUE;
        long cost = 0;
        int tracker = N;

        // have to go upwards because you break through thresholds
        for (int i = 0; i < N; i++) {
            cost = tracker * tuition[i];
            tracker--;
            if (cost > maxEarned) {
                maxEarned = cost;
                maxTuition = tuition[i];
            }
        }

        writer.print(maxEarned + " " + maxTuition);
        reader.close();
        writer.close();
    }

    /*
     * Brute force doesn't work. Optimization:
     * 1. ignore non extreme outliers
     * 2. prioritize high density tuition
     */

}
