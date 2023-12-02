import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingLiars{
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());

        Testimony[] cows = new Testimony[N];

        for (int i = 0; i < cows.length; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            String binary = st2.nextToken();
            boolean isGreater = binary.equals("G");
            cows[i] = new Testimony(Integer.parseInt(st2.nextToken()), isGreater);
        }
        
        int min = Integer.MAX_VALUE;
        int liars = 0;
        Arrays.sort(cows);

        //assume the current cow is telling the truth
        for(int i = 0; i < cows.length; i++) {
            liars = 0;
            for(int j = 0; j < i; j++) {
                if(!cows[j].greater){
                    liars++;
                }
            }
            for(int j = i+1; j < cows.length; j++) {
                if(cows[j].greater) {
                    liars++;
                }
            }

            if(liars < min) {
                min = liars;
            }
        }

        writer.print(min);
        reader.close();
        writer.close();
    }

    private static class Testimony implements Comparable<Testimony> {
        public int position;
        public boolean greater;
    
        public Testimony(int position, boolean greater) {
            this.position = position;
            this.greater = greater;
        }
    
        @Override
        public int compareTo(Testimony other) {
            return Integer.compare(this.position, other.position);
        }
    }
    
}



//Past Attempts

// public class CountingLiars {
    
//     public static void main(String[] args) throws IOException {
        
//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter writer = new PrintWriter(System.out);

//         StringTokenizer st = new StringTokenizer(reader.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int[][] testimonies = new int [N][3];

//         int max = 0;

//         for(int i = 0; i < testimonies.length; i++) {
//             StringTokenizer st2 = new StringTokenizer(reader.readLine());
//             String binary = st2.nextToken();
//             if(binary.equals("G")){
//                 testimonies[i][0] = 1;
//             } else {
//                 testimonies[i][0] = 0;
//             }
//             testimonies[i][1] = Integer.parseInt(st2.nextToken());
//             if(testimonies[i][1] > max) {
//                 max = testimonies[i][1];
//             }
//         }

//         //int liars = 0;
//         // for(int i = 0; i < testimonies.length; i++) {
//         //     int loc =  testimonies[i][0] == 1 ? testimonies[i][1]+1 : testimonies[i][1]-1;
//         //     boolean lying = false;
//         //     if(testimonies[i][2] != 1) {
//         //         for(int j = 0; j < testimonies.length; j++) {
//         //             if(testimonies[j][0] == 1 ? loc < testimonies[j][1] : loc > testimonies[j][1] && testimonies[j][2] != 1 && !(testimonies[i][1]==testimonies[j][2])) {
//         //                 //liars++;
//         //                 lying = true;
//         //                 testimonies[j][2] = 1;
//         //                 testimonies[i][2] = 1;
//         //                 //break;
//         //             }
//         //         }
//         //     }
//         //     if(lying){
//         //         liars++;
//         //     }
//         // }

//         //this method exceeds the time limit

//         int min = Integer.MAX_VALUE;
//         int liars = 0;

//         for(int i = 0; i <= max; i++){
//             liars = 0;
//             for(int j = 0; j < testimonies.length; j++) {
//                 if(!(testimonies[j][0] == 1 ? i >= testimonies[j][1] : i <= testimonies[j][1])) {
//                     liars++;
//                 }
//             }
//             if(liars < min) {
//                 min = liars;
//             }
//         }




//         writer.print(min);
//         reader.close();
//         writer.close();
//     }

// }