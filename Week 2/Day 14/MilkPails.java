import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkPails {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("pails.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        writer.println(maxMilk(X, Y, M));

        reader.close();
        writer.close();

        //System.out.println(maxMilk(1, 1, 1000));

    }

    public static int maxMilk(int X, int Y, int M){
        int max = 0;

        for(int i = 0; i <= 1001; i++) {
            for (int  j = 0; j <= 1001; j++) {
                if((X*i + Y*j <= M) && (X*i + Y*j > max)) {
                    max = X*i + Y*j;
                }
            }
        }

        return max;
    }

}