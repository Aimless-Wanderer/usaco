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

        /*
        Brainstorming:
            Organize cows in a small 3 length array --> you don't care which cow is which
            constantly sort the array after making changes
            1. Check if the cows are consecutive
                - double for loop through array
            2.Find min moves:
                - Choose the smaller gap/difference 
                - Move cows at endpoints to the middle? 1 10 12 --> 1 5 10
            3.Find max moves:
                - Choose the larger gap/difference
                - Move cows as close to each other as possible? 1 10 12 --> 1 2 10
         */
    }
}