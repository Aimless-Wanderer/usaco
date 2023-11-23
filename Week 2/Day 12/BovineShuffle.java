import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BovineShuffle {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] cows = new int [N+1];
        int [] pos = new int [N+1];

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= N; i++) {
            pos[i] = Integer.parseInt(st2.nextToken());
        }

        StringTokenizer st3 = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= N; i++) {
            cows[i] = Integer.parseInt(st3.nextToken());
        }

        int [] postShuffle = new int[N+1];
        postShuffle = shuffle(shuffle(shuffle(cows, pos), pos), pos);

        for(int i : postShuffle) {
            if(i != 0)
                writer.println(i);
        }
        reader.close();
        writer.close();

    }

    public static int[] shuffle (int[] cows, int[] pos){
        
        int [] postShuffle = new int[cows.length];

        for(int i = 1; i < cows.length; i++){
            for(int j = 1; j < pos.length; j++){
                if(i == pos[j]) {
                     postShuffle[j] = cows[i];
                     break;
                }
            }
        }

        return postShuffle;
    }
}
