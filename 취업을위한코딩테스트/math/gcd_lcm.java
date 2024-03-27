package math;

public class gcd_lcm {
	
	// 두 수의 gcd, lcm
	public static int gcd(int a, int b) {
		if(a % b == 0)
			return b ;
		return gcd(b, a % b) ; 
	}
	
	public static int lcm(int a, int b) {
		return (a*b) / gcd(a,b) ; 
	}
	
	// 여러수의 gcd, lcm 
	public static int gcd(int[] arr) {
		int result = arr[0] ; 
		for(int i = 1 ; i < arr.length ; i++)
			result = gcd(result, arr[i]) ; 
		return result;  
	}
	
	public static int lcm(int[] arr) {
		int result = arr[0] ; 
		for(int i = 0 ; i < arr.length ; i++)
			result = lcm(result, arr[i]) ; 
		return result ; 
	}
}
