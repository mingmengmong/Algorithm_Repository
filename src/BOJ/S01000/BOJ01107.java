package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ01107 {
	public static void BOJ01107(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String p = br.readLine();
		int errCnt = Integer.parseInt(br.readLine());
		int[] numArr = new int[6];
		List<Integer> numList = new ArrayList<Integer>(){{
			for(int i=0; i<10; ++i){
				add(i);
			}
		}};
		if(errCnt > 0){
			String[] strSpl = br.readLine().split(" ");
			for(String str : strSpl){
				numList.remove(new Integer(str));
			}
		}
		
		System.out.println(Math.min(getNum(numList, numArr, p, 0), Math.abs(Integer.parseInt(p) - 100)));
		
		br.close();
	}
	
	public static int getNum(List<Integer> numList, int[] numArr, String point, int index){
		if(numList.size() == 0){
			return 1000000;
		}
		
		if(numArr.length == index){
			int num = 0;
			for(int i : numArr){
				num = num * 10 + i;
			}
			return numArr.length + Math.abs(Integer.parseInt(point) - num);
		}
		
		int minNum = 1000000;
		if(index > 0){
			int num = 0;
			for(int i=0; i<index; ++i){
				num = num * 10 + numArr[i];
			}
			minNum = Math.min(minNum, index + Math.abs(Integer.parseInt(point) - num));
		}
		
		for(int i : numList){
			numArr[index] = i;
			minNum = Math.min(minNum, getNum(numList, numArr, point, index+1));
		}
		
		return minNum;
	}
}
