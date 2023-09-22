package cH2_기본자료구조;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 9:44:48
 *	@subject 배열 
 * @content  기수 변환 - 입력받은 10진수를 2진수 ~ 36진수로 기수 변환하여 출력 


 */
public class ex06 {
	
	static int cardConv(int x, int r, char[] d) { //정수값 x , r진수 
		int digits = 0; 
		String dchar = "0123456789ABCDEFGHIJLLMNOPQRSTUVWXZ" ; 
		
		do {
			d[digits++] = dchar.charAt(x % r) ; 
			x /= r ; 
		}while(x != 0) ; 
		
		for (int i = 0; i < digits / 2; i++) {
			char t = d[i] ; 
			d[i] = d[digits -i -1] ; 
			d[digits -i -1] = t; 			
		} 
		return digits ; 
	}

	public static void main(String[] args) {

	}

}
