package ch12_지네릭스_열거형_애너테이션;

import java.util.ArrayList;

/**
 * @author HEEMIN
 * @date 2023. 12. 9.-오후 12:25:10
 *	@subject 지네릭스 
 * @content  제한된 지네릭 클래스 : T 자체를 제한 


 */
interface Eatable{}

class Fruit implements Eatable {public String toString() {return "Fruit" ; } } 
class FruitBox<T extends Fruit & Eatable> extends Box<T>{} 
// 지네릭 클래스 FruitBox는 Fruit 클래스를 상속했거나 Eatalbe 인터페이스를 구현한 타입 객체만 받을 수 있는 Box 이다 

public class FruitBoxEx02_지네릭클래스타입제한 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>() ; 
		Box<Apple> appleBox = new Box<Apple>() ; 
		Box<Toy> toyBox = new Box<Toy>() ; 
		
		fruitBox.add(new Fruit()); 
		fruitBox.add(new Apple()); // ok ! void add(Fruit item) :  Fruit 참조변수 <--0-- Apple 
		fruitBox.add(new Grape()); 
		
		appleBox.add(new Apple());		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}
