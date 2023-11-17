/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: promotioncounting
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PromotionCounting {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("promote.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int bronze = Integer.parseInt(st.nextToken());
        int bronze2 = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        int silver = Integer.parseInt(st2.nextToken());
        int silver2 = Integer.parseInt(st2.nextToken());

        StringTokenizer st3 = new StringTokenizer(reader.readLine());
        int gold = Integer.parseInt(st3.nextToken());
        int gold2 = Integer.parseInt(st3.nextToken());

        StringTokenizer st4 = new StringTokenizer(reader.readLine());
        int plat = Integer.parseInt(st4.nextToken());
        int plat2 = Integer.parseInt(st4.nextToken());


        int [] before = {bronze,silver,gold,plat};
        int [] after = {bronze2,silver2,gold2,plat2};
        int [] result = promotion(before, after);

        for(int i = 0; i < result.length; i++) {
            writer.println(result[i]);
        }

        reader.close();
        writer.close();
    }

    public static int[] promotion (int [] before, int [] after) {

        int[] result = new int[3];

        for(int i = after.length - 1; i > 0; i--) {
            result[i-1] = after[i] - before[i];
            before[i-1] = before[i-1] - result[i-1];
        }
      
        return result;
    }
        
}

//Notes afterward:  OMG THIS WORKED FIRST TRY WHAT THIS HAS NEVER HAPPENED BEFORE 