package chap3;

import java.util.*;

enum Animal {
  Dog, 
	Cat
}

public class Question_3_6 {
	LinkedList<Animal> shelter = new LinkedList<Animal>();
	
	void enqueue (Animal a) {
		this.shelter.add(a);
		return;
	}
	
	Animal dequeueAny() {
		if (this.shelter.isEmpty()) {
			System.out.println("There's no animal in this shelter!");
			return null;
		}
		
		return this.shelter.poll();
	}
	
	Animal dequeueDog () {
		if (this.shelter.isEmpty()) {
			System.out.println("There's no animal in this shelter!");
			return null;
		}
		
		int index = 0;
		while (!this.shelter.isEmpty()) {
			if (Animal.Dog == this.shelter.get(index)) {
				break;
			}
			index++;
		}
		return this.shelter.remove(index);
	}
	
	Animal dequeueCat () {
		if (this.shelter.isEmpty()) {
			System.out.println("There's no animal in this shelter!");
			return null;
		}
		
		int index = 0;
		while (!this.shelter.isEmpty()) {
			if (Animal.Cat == this.shelter.get(index)) {
				break;
			}
			index++;
		}
		return this.shelter.remove(index);
	}
	
	void dispShelter() {
		System.out.println(this.shelter);
		return;
	}
	
	public static void main(String[] args) {
	    Question_3_6 test = new Question_3_6();
	    int i;
	    for (i=0; i<5; i++) {
	    	test.shelter.add(Animal.Cat);
	    }
	    for (i=0; i<5; i++) {
	    	test.shelter.add(Animal.Dog);
	    }
	    test.shelter.add(Animal.Cat);
		test.dispShelter();
		
		System.out.println(test.dequeueAny());
		System.out.println(test.dequeueDog());
		System.out.println(test.dequeueCat());
		test.dispShelter();
        return;
	}

}