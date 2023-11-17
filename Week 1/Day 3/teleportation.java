/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: teleportation
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teleportation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        writer.println(minimumDistance(a, b, x, y));

        reader.close();
        writer.close();

      // System.out.println(minimumDistance(0,21, 20, 99));
    }

    public static int minimumDistance(int a, int b, int x, int y) {
        int minDis = 0;
        int d1 = Math.abs(a-b);
        int d2 = Math.abs(a-x) + Math.abs(b-y);
        int d3 = Math.abs(a-y) + Math.abs(b-x);
        minDis = Math.min(d1, d2);
        minDis = Math.min(minDis, d3);
        return minDis;
    }


    //Here my mistake was overcomplicating the problem. I got inspiration from the solution to the previous
    //problem, but it turns out that there is not a "elegant" way to solve this problem, at least from what I've seen.
    // public static int minimumDistance(int a, int b, int x, int y) {
       
    //     int[] distance = new int[101];
    //     int minDistance = 0;

    //     if(a == b) {
    //         return 0;
    //     }

    //     if(x > y){
    //         int temp = x;
    //         x = y;
    //         y = temp;
    //     }

    //     if(a > b) {
    //         int temp = a;
    //         a = b;
    //         b = temp;
    //     }

    //     if(b == x){
    //         return b-a+1;
    //     }

    //     int[] overlap = new int[101];
    //     int tracker = 0;

    //     for(int i = x; i <= y; i++) {
    //         overlap[i] = 1;
    //     }
    //     for(int i = a; i <= b; i++) {
    //         if(overlap[i] == 1){
    //             break;
    //         } else {
    //             tracker++;
    //         }
    //     }

    //     //System.out.println("t: " + tracker);

    //     if(((tracker-1) == (b - a)) || (tracker == (b-a))){
    //         return b-a;
    //     }


    //     for(int i = x; i <= y; i++) {
    //         distance[i]++;
    //     }
    //     for(int i = a; i <= b; i++) {
    //         distance[i]++;
    //     }

    //     for(int i = 0; i <= 100; i++){
    //         if(distance[i] == 1){
    //             minDistance++;
    //         }
    //     }

    //     int minDistance2 = 0;
    //     int[] distance2 = new int[101];
    //     for(int i = a; i <= b; i++) {
    //         minDistance2++;
    //     }

    //     if(minDistance2 < minDistance){
    //         return minDistance2;
    //     }

    //     return minDistance;
    // }

}