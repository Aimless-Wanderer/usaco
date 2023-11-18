/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: Mixing Milk
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixingMilk {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        int c2 = Integer.parseInt(st2.nextToken());
        int m2 = Integer.parseInt(st2.nextToken());

        StringTokenizer st3 = new StringTokenizer(reader.readLine());
        int c3 = Integer.parseInt(st3.nextToken());
        int m3 = Integer.parseInt(st3.nextToken());

        int temp = 0;

        for (int i = 0; i < 33; i++) {
            if(m1 + m2 <= c2) {
                m2 += m1;
                m1 = 0;
            } else {
                temp = m2;
                m2 = c2;
                m1 = m1 + temp - c2;
            }

            if(m2 + m3 <= c3) {
                m3 += m2;
                m2 = 0;
            } else {
                temp = m3;
                m3 = c3;
                m2 = m2 + temp - c3;
            }

             if(m3 + m1 <= c1) {
                m1 += m3;
                m3 = 0;
            } else {
                temp = m1;
                m1 = c1;
                m3 = m3 + temp - c1;
            }

        }

        //100th pour
        if (m1 + m2 <= c2) {
            m2 += m1;
            m1 = 0;
        } else {
            temp = m2;
            m2 = c2;
            m1 = m1 + temp - c2;
        }

        writer.println(m1);
        writer.println(m2);
        writer.println(m3);

        reader.close();
        writer.close();
    }
}
