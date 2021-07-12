package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05373 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static char[][] up;// = {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
	public static char[][] down;// = {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
	public static char[][] front;// = {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
	public static char[][] back;// = {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
	public static char[][] left;// = {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
	public static char[][] right;// = {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
	
	public static char[][] dice = {
			{'.','.','.', '0','o','o', '.','.','.'},
			{'.','.','.', 'o','o','o', '.','.','.'},
			{'.','.','.', 'o','o','o', '.','.','.'},
			{'g','g','0', '0','w','w', 'b','b','b'},
			{'g','g','g', 'w','w','w', 'b','b','b'},
			{'g','g','g', 'w','w','w', '0','b','b'},
			{'.','.','.', '0','r','r', '.','.','.'},
			{'.','.','.', 'r','r','r', '.','.','.'},
			{'.','.','.', 'r','r','r', '.','.','.'},
			{'.','.','.', '0','y','y', '.','.','.'},
			{'.','.','.', 'y','y','y', '.','.','.'},
			{'.','.','.', 'y','y','y', '.','.','.'}
	};
	
	public static void BOJ05373(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			up = new char[][] {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			down = new char[][] {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			front = new char[][] {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			back = new char[][] {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			left = new char[][] {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			right = new char[][] {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
			
			
//			for(int i=0; i<3; ++i){
//				for(int j=0; j<3; ++j){
//					bw.write(up[i][j]);
//				}
//				bw.write(" ");
//				for(int j=0; j<3; ++j){
//					bw.write(right[i][j]);
//				}
//				bw.write(" ");
//				for(int j=0; j<3; ++j){
//					bw.write(down[i][j]);
//				}
//				bw.write(" ");
//				for(int j=0; j<3; ++j){
//					bw.write(left[i][j]);
//				}
//				bw.write("\n");
//			}
//			bw.write("\n");
			
			
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()){
				cubing(st.nextToken());
				
//				for(int i=0; i<3; ++i){
//					for(int j=0; j<3; ++j){
//						bw.write(up[i][j]);
//					}
//					bw.write(" ");
//					for(int j=0; j<3; ++j){
//						bw.write(right[i][j]);
//					}
//					bw.write(" ");
//					for(int j=0; j<3; ++j){
//						bw.write(down[i][j]);
//					}
//					bw.write(" ");
//					for(int j=0; j<3; ++j){
//						bw.write(left[i][j]);
//					}
//					bw.write("\n");
//				}
//				bw.write("\n");
			}
			for(int i=0; i<3; ++i){
				for(int j=0; j<3; ++j){
					bw.write(up[i][j]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void cubing(String input){
		char face = input.charAt(0);
		char direction = input.charAt(1);
		
		if(face == 'U'){
			up(direction);
		}else if(face == 'D'){
			down(direction);
		}else if(face == 'F'){
			front(direction);
		}else if(face == 'B'){
			back(direction);
		}else if(face == 'L'){
			left(direction);
		}else if(face == 'R'){
			right(direction);
		}
	}
	
	public static int[] r1 = {0,1,2,2,2,1,0,0};
	public static int[] r2 = {0,0,0,1,2,2,2,1};
	public static void rotate(char[][] face, char direction){
		int[] rd = '+' == direction ? r1 : r2;
		int[] cd = '+' == direction ? r2 : r1;
		for(int i=0; i<2; ++i){
			char c = face[0][0];
			for(int j=0; j<7; ++j){
				face[rd[j]][cd[j]] = face[rd[j+1]][cd[j+1]];
			}
			face[rd[7]][cd[7]] = c;
		}
	}
	
	public static void rotate(char[][] upFace, char[][] rightFace, char[][] downFace, char[][] leftFace, char direction, int idx1, int idx2, int idx3){
		int r1 = idx1/3;
		int c1 = idx1%3;
		int r2 = idx2/3;
		int c2 = idx2%3;
		int r3 = idx3/3;
		int c3 = idx3%3;
		
		char char1 = upFace[r1][c1];
		char char2 = upFace[r2][c2];
		char char3 = upFace[r3][c3];
		if('+' == direction){
			upFace[r1][c1] = leftFace[r1][c1];
			upFace[r2][c2] = leftFace[r2][c2];
			upFace[r3][c3] = leftFace[r3][c3];
			leftFace[r1][c1] = downFace[r1][c1];
			leftFace[r2][c2] = downFace[r2][c2];
			leftFace[r3][c3] = downFace[r3][c3];
			downFace[r1][c1] = rightFace[r1][c1];
			downFace[r2][c2] = rightFace[r2][c2];
			downFace[r3][c3] = rightFace[r3][c3];
			rightFace[r1][c1] = char1;
			rightFace[r2][c2] = char2;
			rightFace[r3][c3] = char3;
		}else{
			upFace[r1][c1] = rightFace[r1][c1];
			upFace[r2][c2] = rightFace[r2][c2];
			upFace[r3][c3] = rightFace[r3][c3];
			rightFace[r1][c1] = downFace[r1][c1];
			rightFace[r2][c2] = downFace[r2][c2];
			rightFace[r3][c3] = downFace[r3][c3];
			downFace[r1][c1] = leftFace[r1][c1];
			downFace[r2][c2] = leftFace[r2][c2];
			downFace[r3][c3] = leftFace[r3][c3];
			leftFace[r1][c1] = char1;
			leftFace[r2][c2] = char2;
			leftFace[r3][c3] = char3;
		}
	}
	
	public static void left(char direction){
		rotate(left, direction);
		rotate(up, front, down, back, direction, 0, 3, 6);
	}
	public static void right(char direction){
		rotate(right, direction);
		rotate(up, back, down, front, direction, 2, 5, 8);
	}
	public static void up(char direction){
		rotate(up, direction);
		rotate(back, '+');
		rotate(back, '+');
		rotate(back, right, front, left, direction, 0, 1, 2);
		rotate(back, '-');
		rotate(back, '-');
	}
	public static void down(char direction){
		rotate(down, direction);
		rotate(back, '+');
		rotate(back, '+');
		rotate(front, right, back, left, direction, 6, 7, 8);
		rotate(back, '-');
		rotate(back, '-');
	}
	public static void front(char direction){
		rotate(front, direction);
		rotate(left, '+');
		rotate(right, '-');
		rotate(down, '+');
		rotate(down, '+');
		rotate(up, right, down, left, direction, 6, 7, 8);
		rotate(down, '-');
		rotate(down, '-');
		rotate(right, '+');
		rotate(left, '-');
	}
	public static void back(char direction){
		rotate(back, direction);
		rotate(right, '+');
		rotate(up, '+');
		rotate(up, '+');
		rotate(left, '-');
		rotate(down, right, up, left, direction, 6, 7, 8);
		rotate(right, '-');
		rotate(up, '-');
		rotate(up, '-');
		rotate(left, '+');
	}
}