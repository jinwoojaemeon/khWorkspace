package com.kh.example.poly1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] an = new Animal[5];
		int idx=0;
		an[idx++] = new Dog("흰둥이", 3, "푸들");
		an[idx++] = new Cat("동이", 4, "하얀색");
		an[idx++] = new Cat("구리", 6, "검정색");
		an[idx++] = new Dog("감이", 4, "치와와");
		an[idx++] = new Cat("날이", 2, "회색");
		
		for(Animal am : an) {
			am.speak();
			if(am instanceof Dog) {
				System.out.printf("이 개의 견종은 %s입니다.\n", ((Dog)am).getBreed());
			}
			if(am instanceof Cat) {
				System.out.printf("이 고양이의 색상은 %s입니다.\n", ((Cat)am).getColor());
			}
			System.out.println();
		}
	}

}
