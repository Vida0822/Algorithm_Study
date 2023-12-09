package ch12_지네릭스_열거형_애너테이션;

import java.util.ArrayList;

/**
 * @author HEEMIN
 * @date 2023. 12. 9.-오후 12:25:10
 *	@subject 지네릭스 
 * @content  지네릭 클래스 - 선언, 객체 생성, 호출 


 */

class Apple extends Fruit {public String toString() {return "Fruit" ; } } 
class Grape extends Fruit {public String toString() {return "Grape" ; } } 
class Toy {public String toString() {return "Toy" ; } } 

class Box<T>{ // <T>를 받는 지네릭 클래스 Box를 생성하면 <T>만 받을 수 있는 ArrayList 생성   
	ArrayList<T> list  = new ArrayList<T>() ; 
	
	void add(T item) {list.add(item); } 
	T get(int i) {return list.get(i) ; } 
	int size() { return list.size() ; } 
	public String toString() {return list.toString() ; } 
	
	ArrayList<T> getList(){return list ; } 
}

public class FruitBoxEx01_지네릭클래스 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>() ; 
		Box<Apple> appleBox = new Box<Apple>() ; 
		Box<Toy> toyBox = new Box<Toy>() ; 
		
//		Box<Fruit> grapeBox = new Box<Apple>();  // Type mismatch: cannot convert from Box<Apple> to Box<Fruit> ---> 부정형  : Fruit 지네릭스 <--x -- Apple 
//		Box<Grape> grapeBox = new Box<Apple>();  // Type mismatch: cannot convert from Box<Apple> to Box<Grape>
		
		fruitBox.add(new Fruit()); 
		fruitBox.add(new Apple()); // ok ! void add(Fruit item) :  Fruit 참조변수 <--0-- Apple 
		
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); // void add(Grape item ) : Grape <-x- Apple 
		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}
