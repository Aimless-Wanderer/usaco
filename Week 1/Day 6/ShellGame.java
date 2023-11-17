/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: Shell Game
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShellGame {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader("shell.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int numSwaps = Integer.parseInt(st.nextToken());

        int[][] swap = new int[numSwaps][2];
        int[] guess = new int[numSwaps];

        for(int i = 0; i < numSwaps; i++) {
            st = new StringTokenizer(reader.readLine());
            swap[i][0] = Integer.parseInt(st.nextToken());
            swap[i][1] = Integer.parseInt(st.nextToken());
            guess[i] = Integer.parseInt(st.nextToken());
        }

        // //test
        // int[][] swap = {{1, 2},{3, 2},{1, 3}};
        // int[] guess = {1,1,1};

        int maxScore = Math.max(findMaxScore(swap, guess, 1), findMaxScore(swap, guess, 2));
        maxScore = Math.max(maxScore, findMaxScore(swap, guess, 3));

        //System.out.print(maxScore);
        //System.out.println(findMaxScore(swap, guess, 2));
        
        writer.println(maxScore);

        reader.close();
        writer.close();
    }

    public static int findMaxScore(int[][] swap, int[] guess, int initialShell) {

        int maxScore = 0;
        int currentShell = initialShell;

        for(int i = 0; i < swap.length; i++) {

         //   System.out.println("iteration: " + i);

            if(swap[i][0] == currentShell) {
                currentShell = swap[i][1];
            } else if(swap[i][1] == currentShell) {
                currentShell = swap[i][0];
            } 

        //    System.out.println(initialShell + " : " + currentShell);

            if(guess[i] == currentShell) {
                maxScore++;
            }
        }

       // System.out.println("MaxScore " + initialShell + " : " + maxScore);

        return maxScore;
    }
   
}
