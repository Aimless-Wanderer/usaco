import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BucketList {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("blist.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] cows = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            cows[i][0] = Integer.parseInt(st2.nextToken());
            cows[i][1] = Integer.parseInt(st2.nextToken());
            cows[i][2] = Integer.parseInt(st2.nextToken());
        }

        // int[][] cows = {{4, 10, 1},{8, 13, 3},{2, 6, 2}};

        int maxBuckets = 0;
        int buckets = 0;

        int maxTime = 0;
        for(int i = 0; i < cows.length; i++){
            if(cows[i][1] > maxTime) {
                maxTime = cows[i][1];
            }
        }

        for(int t = 0; t < maxTime; t++) {
            buckets = 0;
            for(int i = 0; i < cows.length; i++){
                if(t >= cows[i][0] && t <= cows[i][1]) {
                    buckets += cows[i][2];
                }
            }
            if(buckets > maxBuckets){
                maxBuckets = buckets;
            }
        }

       // System.out.println(maxBuckets);
        
        writer.println(maxBuckets);
        reader.close();
        writer.close();
    }
}
