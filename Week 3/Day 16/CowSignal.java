import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowSignal {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] signal = new String [M];

        for(int i = 0; i < M; i++) {
            signal[i] = reader.readLine();
        }

        // String[] amplified = new String[M*K];

        // for(int i = 0; i < M; i++){
        //     for(int j = 0; j < N; j++) {
        //         for(int h = 0; h < K; h++) {
        //             if(signal[i].charAt(j) != ' ') {
        //                 amplified[i*K] += signal[i].charAt(j);
        //             }
        //         }          
        //     }
        //     for(int h = 0; h < K-1; h++) {
        //         amplified[i+h] = amplified[i];
        //     }
        // }

        // for(String line : amplified){
        //     if(line != null)
        //     writer.println(line);
        // }
        
        for (int i = 0; i < M*K; i++) {
			for (int j = 0; j < N*K; j++) {
				writer.print(signal[i / K].charAt(j / K));
			}
			writer.println();
		}
        reader.close();
        writer.close();


    }
}