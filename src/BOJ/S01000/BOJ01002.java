package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01002 {
	public static void BOJ01002(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; ++tc) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
			} else {
				if (r1 < r2) {
					int x3 = x1;
					int y3 = y1;
					int r3 = r1;
					
					x1 = x2;
					y1 = y2;
					r1 = r2;
					x2 = x3;
					y2 = y3;
					r2 = r3;
				}
				
				int pd = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
				int rr1 = r1*r1;
				if(pd > rr1){   // 큰원 밖에 작은원이 있을경우
					int rrr = (r1+r2) * (r1+r2);
					if(rrr > pd){
						System.out.println(2);
					}else if(rrr == pd){
						System.out.println(1);
					}else{
						System.out.println(0);
					}
				}else if(pd == rr1){    // 큰원 선안에 작은원이 있을떄
					System.out.println(2);
				}else{          // 큰원 안에 작은원이 있을때
					double pd2 = Math.pow(Math.sqrt(pd) + r2, 2);
					if(rr1 > pd2){
						System.out.println(0);
					}else if(rr1 == pd2){
						System.out.println(1);
					}else{
						System.out.println(2);
					}
				}
			}
		}
		
		sc.close();
		br.close();
	}
}
