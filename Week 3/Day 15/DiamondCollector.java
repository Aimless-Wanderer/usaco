import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiamondCollector {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamonds = new int [N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            diamonds[i] = Integer.parseInt(st2.nextToken());
        }

        writer.println(display(K, diamonds));

        reader.close();
        writer.close();
        
        // int[] diamonds = {1, 6, 4, 3, 1};
        // int K = 3;
        // System.out.println(display(K, diamonds));

    }

    public static int display(int K, int [] diamonds){
        int maxDisplay = 0;
        //whoops read the problem wrong, thought there was more than one case
        // boolean[] displayed = new boolean[diamonds.length];

        // for(int i = 0; i < diamonds.length; i++) {
        //     if(!displayed[i]){
        //         for(int j = i+1; j < diamonds.length-1; j++){
        //             if(Math.abs(diamonds[j] - diamonds[i]) <= K && !displayed[j] && !displayed[i]){
        //                 System.out.println(diamonds[i] + " " + diamonds[j]);
        //                 maxDisplay += 2;
        //                 displayed[j] = true;
        //                 displayed[i] = true;
        //             }
        //         }
        //     }
        // }

        for(int i = 0; i < diamonds.length; i++) {
            int posDisplay = 0;
            for(int j = 0; j < diamonds.length; j++) {
                if(diamonds[i] <= diamonds[j] && Math.abs(diamonds[j]-diamonds[i]) <= K){
                    posDisplay ++;
                }
            }
            if(posDisplay > maxDisplay) {
                maxDisplay = posDisplay;
            }
        }

        return maxDisplay;
    }

}