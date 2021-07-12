package programmers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_42888 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42888
	 * name : 오픈채팅방
	 */
	
	Map<String, String> uidNameMap = new HashMap<>();
	
	enum Type{
		ENTER,
		LEAVE;
	}
	
	class Node{
		public Type type;
		public String uid;
		public Node(Type type, String uid) {
			this.type = type;
			this.uid = uid;
		}
		
		public String toString(){
			if(this.type == Type.ENTER){
				return uidNameMap.get(this.uid) + "님이 들어왔습니다.";
			}else if(this.type == Type.LEAVE){
				return uidNameMap.get(this.uid) + "님이 나갔습니다.";
			}else{
				return "ERROR";
			}
		}
	}
	
	public String[] solution(String[] record) {
		
		List<Node> resultList = new ArrayList<>();
		
		for(String s : record){
			String[] spl = s.split(" ");
			if("Enter".equals(spl[0])){
				uidNameMap.put(spl[1], spl[2]);
				resultList.add(new Node(Type.ENTER, spl[1]));
			}else if("Leave".equals(spl[0])){
				resultList.add(new Node(Type.LEAVE, spl[1]));
			}else if("Change".equals(spl[0])){
				uidNameMap.put(spl[1], spl[2]);
			}
		}
		
		String[] res = new String[resultList.size()];
		for(int i=0; i<res.length; ++i){
			res[i] = resultList.get(i).toString();
		}
		
		return res;
	}
}