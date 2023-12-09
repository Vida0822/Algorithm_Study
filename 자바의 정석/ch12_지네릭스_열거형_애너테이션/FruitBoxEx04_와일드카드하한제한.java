package ch12_지네릭스_열거형_애너테이션;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author HEEMIN
 * @date 2023. 12. 9.-오후 12:58:17
 *	@subject 지네릭스
 * @content 와일드 카드로 하한 제한  


 */
class Fruit2{
	String name ;
	int weight ; 
	
	Fruit2(String name , int weight){
		this.name = name ; 
		this.weight = weight ; 
	}
	
	public String toString() {return name = "("+weight+")"; }  
}

class Apple2 extends Fruit2{
	Apple2(String name, int weight){
		super(name, weight) ; 
	}
}
class Grape2 extends Fruit2{
	Grape2(String name, int weight){
		super(name, weight) ; 
	}
}

class FruitComp implements Comparator<Fruit2>{
	public int compare(Fruit2 t1, Fruit2 t2) {
		return t2.weight - t1.weight ; 
	}
}


public class FruitBoxEx04_와일드카드하한제한 {

	public static void main(String[] args) {
		FruitBox<Apple> appleBox = new FruitBox<Apple>() ; 
		FruitBox<Grape> grapeBox = new FruitBox<Grape>() ; 
		
	//	appleBox.add(new Apple2("GreenApple", 300));
	//	grapeBox.add(new Grape2("GreenApple", 300));

	//	Collections.sort(appleBox.getList(), new FruitComp());
		
	}

}
