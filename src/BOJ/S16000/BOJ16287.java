package BOJ.S16000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16287 {
	public static void BOJ16287_1(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		int w = Integer.parseInt(strSpl[0]);
		int n = Integer.parseInt(strSpl[1]);
		
		strSpl = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(String str : strSpl){
			list.add(Integer.parseInt(str));
		}
		
		Map<Integer, List<C>> map = new HashMap<>();
		for(int i=0; i<(n-1); ++i){
			for(int j=i+1; j<n; ++j){
				int sum = list.get(i) + list.get(j);
				C c = new C(i, j);
				
				if(!map.containsKey(sum)){
					map.put(sum, new ArrayList<C>());
				}
				
				map.get(sum).add(c);
			}
		}
		
		List<Integer> sumList = new ArrayList<>(map.keySet());
		Collections.sort(sumList);
		
		int li = 0;
		int ri = sumList.size()-1;
		boolean b = false;
		while(!b && li <= ri){
			int s1 = sumList.get(li);
			int s2 = sumList.get(ri);
			int sum = s1 + s2;
			
			if(sum < w){
				++li;
			}else if(sum == w){
				List<C> cl1 = map.get(s1);
				List<C> cl2 = map.get(s2);
				for(C c1 : cl1){
					if(b){
						break;
					}
					
					int i1 = c1.i1;
					int i2 = c1.i2;
					for(C c2 : cl2){
						if(b){
							break;
						}
						
						int i3 = c2.i1;
						int i4 = c2.i2;
						if(i1!=i3 && i1!=i4 && i2!=i3 && i2!=i4){
							b = true;
						}
					}
				}
				
				if(!b){
					++li;
				}
			}else{
				--ri;
			}
		}
		
		System.out.println(b?"YES":"NO");
		
		sc.close();
		br.close();
	}
	
	public static class C{
		public int i1;
		public int i2;
		public C(int i1, int i2){
			this.i1 = i1;
			this.i2 = i2;
		}
		
		@Override
		public String toString(){
			return "{i1 : " + i1 + ", i2 : " + i2 + "}";
		}
	}
	
	
	public static void BOJ16287_2(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean b = false;
		boolean[] bArr = new boolean[w];
		for(int i=2; !b && i<n; ++i){
			for(int j=0; !b && j<(i-1); ++j){
				if((arr[j] + arr[i-1]) < w){
					bArr[arr[j] + arr[i-1]] = true;
				}
			}
			
			for(int j=i+1; !b && j<n; ++j){
				if((arr[i] + arr[j]) < w){
					if(bArr[w - arr[i] - arr[j]]){
						b = true;
					}
				}
			}
		}
		
		System.out.println(b?"YES":"NO");
		
		sc.close();
		br.close();
	}
}
