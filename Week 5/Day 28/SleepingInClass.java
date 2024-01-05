import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SleepingInClass {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> log = new ArrayList<>();
        int[] minMods = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            int P = Integer.parseInt(st2.nextToken());
            StringTokenizer st3 = new StringTokenizer(reader.readLine());
            ArrayList<Integer> entry = new ArrayList<>();
            for (int j = 0; j < P; j++) {
                entry.add(Integer.parseInt(st3.nextToken()));
            }
            log.add(entry);
        }

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> entry = log.get(i);
            while (!checkEqual(entry)) {
                if (entry.size() > 2) {
                    // add two numbers that are closest to the current maximum(s) (can be greater
                    // than) => have to be adjacent
                    // prioritize the sum that is less than the max
                    int minDiff = Integer.MAX_VALUE;
                    int tracker = 0;
                    int max = findMax(entry);
                    for (int j = 0; j < entry.size() - 1; j++) {
                        int difference = Math.abs(max - (entry.get(j) + entry.get(j + 1)));
                        if (difference <= minDiff && (entry.get(tracker) + entry.get(tracker + 1) > entry.get(j)+entry.get(j+1))) {
                            minDiff = difference;
                            tracker = j;
                        }
                    }
                    entry.set(tracker, entry.get(tracker) + entry.get(tracker + 1));
                    entry.remove(tracker + 1);

                } else {
                    entry.set(0, entry.get(0) + entry.get(1));
                    entry.remove(1);
                }

                minMods[i]++;
            }
        }

        for (int e : minMods) {
            writer.println(e);
        }
        reader.close();
        writer.close();
    }

    private static boolean checkEqual(ArrayList<Integer> entry) {
        for (int i = 0; i < entry.size() - 1; i++) {
            if (entry.get(i) != entry.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static int findMax(ArrayList<Integer> list) {

        int max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int currentNumber = list.get(i);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }

        return max;
    }
}
