package programmers;


public class Solution_81301 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/81301
	 * name : 숫자 문자열과 영단어
	 */
	
	/*
	0	zero    4 z=0
	1	one     3 o=1
	2	two     3 tw=2
	3	three   5 th=3
	4	four    4 fo=4
	5	five    4 fi=5
	6	six     3 si=6
	7	seven   5 se=7
	8	eight   5 e=8
	9	nine    4 n=9
	 */
	
	int[] wordLength = {4, 3, 3, 5, 4, 4, 3, 5, 5, 4};
	
	public int solution(String s) {
		int res = 0;
		
		int length = s.length();
		for(int i=0; i<length; ++i){
			char c = s.charAt(i);
			int n = 0;
			if('0' <= c && c <= '9'){
				n = c - '0';
			}else{
				char cc = s.charAt(i+1);
				switch(c){
					case 'o': n = 1; break;
					case 't': n = cc == 'w' ? 2 : 3; break;
					case 'f': n = cc == 'o' ? 4 : 5; break;
					case 's': n = cc == 'i' ? 6 : 7; break;
					case 'e': n = 8; break;
					case 'n': n = 9; break;
				}
				i += wordLength[n] - 1;
			}
			
			res *= 10;
			res += n;
		}
		
		return res;
	}
}