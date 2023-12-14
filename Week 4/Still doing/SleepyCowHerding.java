import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SleepyCowHerding {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("herding.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int b = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minMoves = 0;
        int maxMoves = 0;


       
        writer.println(minMoves);
        writer.println(maxMoves);
        reader.close();
        writer.close();
    }
}