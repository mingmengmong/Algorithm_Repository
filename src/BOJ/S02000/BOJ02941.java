package BOJ.S02000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02941 {
    public static void BOJ02941(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        String str = br.readLine() + "..";
        int l = str.length()-2;
        String prevStr = "";
        boolean b = false;
        int length = 0;
        for(int i=0; i<l; ++i){
            char c = str.charAt(i);
            char cc = str.charAt(i+1);
            char ccc = str.charAt(i+2);
            
            if(c == 'c'){
                if(cc == '=' || cc == '-'){
                    ++i;
                }
            }else if(c == 'd'){
                if(cc == '-'){
                    ++i;
                }else if(cc == 'z'){
                    if(ccc == '='){
                        i += 2;
                    }
                }
            }else if(c == 'l'){
                if(cc == 'j'){
                    ++i;
                }
            }else if(c == 'n'){
                if(cc == 'j') {
                    ++i;
                }
            }else if(c == 's'){
                if(cc == '='){
                    ++i;
                }
            }else if(c == 'z'){
                if(cc == '='){
                    ++i;
                }
            }
            
            ++length;
        }
        
        System.out.println(length);
        
        
        br.close();
    }
}
