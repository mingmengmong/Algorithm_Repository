package programmers;

public class Solution_62048 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/62048
	 * name : 멀쩡한 사각형
	 */
	
	long gcd(long a, long b){
		if(a == 0) return b;
		return gcd(b%a, a);
	}
	
	public long solution(int w, int h){
		long ww = w;
		long hh = h;
		return ww*hh - (ww+hh-gcd(ww,hh));
	}
	
	/**
	 * 오차 검증을 하면대는데 이건 패스
	 * @param w
	 * @param h
	 * @return
	 */
	public long solution_fail(long w, long h) {
		long answer = w*h;
		long gcd = gcd(w,h);
		
		w /= gcd;
		h /= gcd;
		
		if(w > h){
			long temp = w;
			w = h;
			h = temp;
		}
		
		
		double ih = 0;
		double inclination = (double) h / (double) w;
		long delCnt = 0;
		
		for(long i=0; i<w; ++i){
			long minH = (long) ih;
			ih += inclination;
			long maxH = (long) ih;
			if(ih-(double)maxH > 0) ++maxH;
			
			delCnt += maxH - minH;
		}
		
		return answer - (delCnt * gcd);
	}
}