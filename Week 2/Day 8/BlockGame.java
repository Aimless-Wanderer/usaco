/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: Block Game
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockGame {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int numBoards = Integer.parseInt(st.nextToken());

        String[] boardsUp = new String[numBoards];
        String[] boardsDown = new String[numBoards];
        int [] numBlocks = new int [26];
        String alphabet = new String("abcdefghijklmnopqrstuvwxyz");
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < numBoards; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            boardsUp[i] = st2.nextToken();
            boardsDown[i] = st2.nextToken();

            for(int j = 0; j < 26; j++) {
                
                count1 = 0;
                count2 = 0;
                
                for(int k = 0; k < boardsUp[i].length(); k++) {
                    if(boardsUp[i].charAt(k) == alphabet.charAt(j)) {
                        count1++;
                    }
                }

                for(int k = 0; k < boardsDown[i].length(); k++) {
                    if(boardsDown[i].charAt(k) == alphabet.charAt(j)) {
                        count2++;
                    }
                }

                numBlocks[j] += Math.max(count1, count2);
            }
        }

        for(int letterFreq : numBlocks) {
            writer.println(letterFreq);
        }

        reader.close();
        writer.close();
    }
}
