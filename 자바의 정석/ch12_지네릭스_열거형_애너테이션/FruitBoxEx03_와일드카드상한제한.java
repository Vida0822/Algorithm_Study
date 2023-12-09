package ch12_지네릭스_열거형_애너테이션;

/**
 * @author HEEMIN
 * @date 2023. 12. 9.-오후 12:48:07
 *	@subject 지네릭스 
 * @content 와일드 카드로 상한 제한 


 */
class Juice{
	String name ; 
	
	Juice(String name) {
		this.name = name+"Juice"; 
	}
	
	public String toString() {
		return name ; 
	}
} // Juice 

class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) { // makeJuice의 매개변수론 Fruit 클래스를 상속 받는 과일을 담은 박스를 받는다 (appleBox, grapeBox가 매개변수로 들어갈 수 있음 ) 
		String tmp = "" ; 
		
		for(Fruit f : box.getList())
			tmp += f+" " ; 
		return new Juice(tmp); 
	}
}

public class FruitBoxEx03_와일드카드상한제한 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>() ;  
//		FruitBox<Fruit> appleBox = new FruitBox<Apple>() ;  ---> error  
		FruitBox<Apple> appleBox = new FruitBox<Apple>() ; 
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));

	}

}
