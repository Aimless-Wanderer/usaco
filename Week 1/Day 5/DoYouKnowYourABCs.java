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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DoYouKnowYourABCs {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());

        long[] num = new long [7];
        long A,B,C,BC,CA,ABC;

        for(int i = 0; i <  num.length; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(num);
        ABC = num[num.length - 1];
        A = num[0];
        BC = ABC - A;
        CA = num[num.length - 3];
        C = CA - A;
        B = BC - C;

        writer.print(A + " " + B + " " + C);
        reader.close();
        writer.close();
    }

}
