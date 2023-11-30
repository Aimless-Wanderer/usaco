import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DaisyChain {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] flowers = new int [N];

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            flowers[i] = Integer.parseInt(st2.nextToken());
        }
 
        //int[] flowers = {336, 490, 644, 324, 895, 121, 801, 290, 291, 405, 192, 694, 443, 427, 332, 20, 20, 224, 286, 460, 112, 643, 385, 355, 355, 936, 518, 839, 834, 829, 824, 819, 814, 809, 804, 799, 794, 789, 784, 779, 774, 769, 764, 759, 754, 749, 744, 739, 734, 729, 724, 719, 714, 709, 704, 699, 694, 689, 684, 679, 674, 669, 664, 659, 654, 649, 644, 639, 634, 629, 624, 619, 614, 609, 604, 599, 594, 589, 584, 579, 574, 569, 564, 559, 554, 549, 544, 539, 534, 529, 524, 519, 514, 509, 504, 499, 494, 489, 484, 479};
 
        int numAvg = 0;

        for(int i = 0; i < flowers.length; i++) {
            for(int j = i; j < flowers.length; j++){
                //if(flowers[i] <= flowers[j]) {
                if(i <= j) {
                    ArrayList<Integer> photo = new ArrayList<>();
                    int sum = 0;
                    for(int k = i; k <= j; k++){
                        photo.add(flowers[k]);
                        sum += flowers[k];
                    }
                    double average = (double)(sum)/(double)(photo.size());
                    for(int petals : photo) {
                        if(Math.abs(petals - average) < 0.0001) {
                           // System.out.println(average);
                            numAvg++;
                            break;
                        }
                    }
                }
            }
        }

        //System.out.println(numAvg);

        writer.print(numAvg);
        reader.close();
        writer.close();
    }

}
