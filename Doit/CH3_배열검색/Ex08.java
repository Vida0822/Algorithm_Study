package ch3_배열검색;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 5:32:51
 *	@subject 이진검색 
 * @content  직접 Comparator을 구현해서 binarySearch()로 이진검색 수행 


 */
public class Ex08 {

	// 클래스 자체엔 접근을 못하고 
	static class PhyscData{
		
		// 필드 
		private String name ; 
		private int height ; 
		private double vision ; 

		// 생성자 
		// 생성자를 통해 객체를 생성해야 사용 가능 
		public PhyscData(String name, int height , double vision) {
			this.name = name ; 
			this.height = height ; 
			this.vision = vision ; 
		}
		
		public String toString() {
			return name +" " + height+ " " + vision ;  
		} // toString
		
		// 필드 중 '키' 기준 오름차순으로 정렬하기 위한 comparator 
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator() ; 
		
		public static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {
				
				return (d1.height > d2.height) ? 1 // d1의 height가 d2의 height보다 크면 d1은 d2보다 큰 것이다 : 대소비교 기준을 정해줌 ! 
						: (d1.height < d2.height)? -1 : 0 ;  
				
			} // compare
		} // HeightOrderComparator
	} // PhyscData
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		PhyscData[] x = {
				new PhyscData("강민하", 162, 0.3), 
				new PhyscData("이수연", 168, 0.4), 
				new PhyscData("황지안", 171, 0.4), 				
				new PhyscData("김찬우", 174, 0.4), 				
				new PhyscData("장경오", 175, 0.4), 			
				// 키를 기준으로 정렬되어있음 
		} ; 
		
		System.out.print("키가 몇 cm인 사람을 찾고있나요?: ");
		int height = sc.nextInt(); 
		int idx = Arrays.binarySearch(x, 
				new PhyscData("", height, 0.0)
				, PhyscData.HEIGHT_ORDER // public static final : PhyscData 에서 정의한 키 중심 대소비교기준 사용  
				);  
		
		if(idx < 0)
			System.out.println("그 값의 요소가 없습니다.");
		else {
			System.out.println("그 값은 x["+idx+"]에 있습니다.");
			System.out.println("찾은 데이터: "+ x[idx]); // 객체를 그대로 출력하면 자동으로 toString 메서드가 호출된다
		}

	} // main 

}
