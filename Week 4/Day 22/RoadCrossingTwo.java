import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoadCrossingTwo {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        String info = st.nextToken();
        char[] crossing = info.toCharArray();

        // String info = "ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ";
        // char[] crossing = info.toCharArray();

        int pairs = 0;
        String tracker = "";

        for (int i = 0; i < crossing.length; i++) {
            if (tracker.indexOf(crossing[i]) == -1) {
                int start = info.indexOf(crossing[i]);
                int end = info.indexOf(crossing[i], start + 1);
                for (int j = start + 1; j < end; j++) {
                    int start2 = info.indexOf(crossing[j]);
                    int end2 = info.indexOf(crossing[j], start2 + 1);
                    if (tracker.indexOf(crossing[j]) == -1
                            && !(start2 > start && start2 < end && end2 > start && end2 < end)) {
                        pairs++;
                    }
                }
                tracker += crossing[start];
            }
        }

        // System.out.println(pairs);

        writer.print(pairs);
        reader.close();
        writer.close();
    }
}