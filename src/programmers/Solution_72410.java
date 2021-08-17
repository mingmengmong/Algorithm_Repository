package programmers;


public class Solution_72410 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/72410
	 * name : 신규 아이디 추천
	 */
	
	public String solution(String newId) {
		System.out.println(newId);
		
		String nn = newId
				.toLowerCase()
				.replaceAll("[^a-z0-9-_.]", "")
				.replaceAll("[.]+", ".")
				.replaceAll("^[.]", "")
				.replaceAll("[.]$", "")
				;
		
		System.out.println(nn);
		
		nn = nn.concat(nn.length() == 0 ? "a" : "");
		nn = nn.substring(0, Math.min(15, nn.length()))
				.replaceAll("[.]$", "");
		
		if(nn.length() < 3){
			for(int i=nn.length(), idx=nn.length()-1; i<3; ++i){
				nn += "" + nn.charAt(idx);
			}
		}
		
		System.out.println(nn);
		
		
		String answer = "";
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		s.solution("...!@BaT#*..y-_.abcdefghijklm..");
//		s.solution("...!@BaT#*..y-_.abc..");
//		s.solution("...");
//		s.solution("z-+.^.");
//		s.solution("abcdefghijklmn.p");
	}
}