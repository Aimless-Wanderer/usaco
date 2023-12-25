import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LivestockLineup {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());


       
        writer.println();
        reader.close();
        writer.close();
    }

    /*
     * Plan:
     * 1. Keep track of the relative position of the cows
     *    X is next to Y --> position var of Y, X is y+- 1
     */
}
