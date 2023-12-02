import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class div7 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("div7.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());

        int [] cows = new int [N];

        for(int i = 0; i < cows.length; i++) {
            cows[i] = Integer.parseInt(reader.readLine());
        }

        int max = 0;

        for(int i = 0; i < cows.length; i++) {
            long sum = 0;
            int count = 0;
            for(int j = i; j < cows.length; j++) {
                sum += cows[j];
                if(sum % 7 == 0) {
                    count = j-i+1;
                }
            }
            if(count > max) {
                max = count;
            }
        }
        
        writer.print(max);
        reader.close();
        writer.close();
    }
}
