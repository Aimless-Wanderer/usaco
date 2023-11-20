/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: Cow Gymnastics
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] record = new int[k][n];
        int consistentPairs = 0;

        for(int i = 0; i < k; i++){
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                record[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            int[][] lowerRanks = new int[k][n];
            boolean tracker = false;
            
            for(int j = 0; j < k; j++){
                for(int h = 0; h < n; h++){
                    if(record[j][h] == i){
                        for(int l = h; l < n; l++){
                            lowerRanks[j][l] = record[j][l];
                        }
                        break; //outer loop continues
                    }
                }
            }

            // for(int c = 1; c <= n; c++){
            //     for(int j = 0; j < k; j++){
            //         tracker = false;
            //         for(int h = 0; h < n; h++){
            //             if(lowerRanks[j][h] == c) {
            //                 tracker = true;
            //             }
            //         }
            //         if(!tracker) {
            //             consistentPairs--;
            //             break;
            //         } 
            //     }
            // }

        }

        writer.println(consistentPairs);
        reader.close();
        writer.close();
    }
}
