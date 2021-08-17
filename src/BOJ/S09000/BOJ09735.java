package BOJ.S09000;
import java.io.*;
import java.util.*;

public class BOJ09735 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ09735(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			long D = Long.parseLong(st.nextToken());
			
			Set<Double> result = new HashSet<>();
			if(D == 0){
				result.add(0.0d);
			}else{
				int sqrt = (int) Math.sqrt(Math.abs(D));
				for(long i=1; i<=sqrt; ++i){
					if(D%i == 0){
						long K = D/i;
						if((A*i*i + B*i + C + D/i) == 0){
							result.add((double) i);
							break;
						}else if((A*i*i - B*i + C - D/i) == 0){
							result.add((double) -i);
							break;
						}else if((A*K*K + B*K + C + D/K) == 0){
							result.add((double) K);
							break;
						}else if((A*K*K - B*K + C - D/K) == 0){
							result.add((double) -K);
							break;
						}
					}
				}
			}
			
			double r1 = result.iterator().next();
			long AA = A;
			long BB = (A*(long)r1) + B;
			long CC = (A*(long)r1*(long)r1) + (B*(long)r1) + C;
			
			long discriminant = BB*BB - 4*AA*CC;
			if(discriminant > 0){
				double sqrt = Math.sqrt(discriminant);
				double r2 = (double)( -1.0d*(double)BB + sqrt ) / (2.0d*(double)AA);
				double r3 = (double)( -1.0d*(double)BB - sqrt ) / (2.0d*(double)AA);
				result.add(r2);
				result.add(r3);
			}else if(discriminant == 0){
				double r2 = (double)(-1.0d*(double)BB) / (2.0d*(double)AA);
				if(r1 != r2){
					result.add(r2);
				}
			}
			
			List<Double> list = new ArrayList<>(result);
			Collections.sort(list);
			for(double r : list){
				bw.write(String.format("%.4f ", r));
			}
			bw.newLine();
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}