import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BovineGenomics {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] spotted = new char [N][M];
        char [][] unspotted = new char [N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            spotted[i] = st2.nextToken().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st3 = new StringTokenizer(reader.readLine());
            unspotted[i] = st3.nextToken().toCharArray();
        }

        writer.print(genome(spotted, unspotted));

        reader.close();
        writer.close();

    }

    public static int genome (char[][] spotted, char[][] unspotted){

        boolean mutation = true;
        int numMutations = 0;

  //      for(int i = 0; i < spotted.length; i++){
            for(int j = 0; j < spotted[0].length; j++){
                mutation = true;
                for(int k = 0; k < spotted.length; k++) {
                    for(int h = 0; h < spotted.length; h++) {
                        if(spotted[k][j] == unspotted[h][j]){
                            mutation = false;
                        }
                    }
                    if(mutation){
                        numMutations++;
                        break;
                    }
                }
            }
   //     }

        return numMutations;
    }
}