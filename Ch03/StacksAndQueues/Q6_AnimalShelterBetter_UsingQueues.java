package Ch03.StacksAndQueues;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 that type). They cannot select which specific animal they would like. Create the data structures to
 maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 and dequeueCat. You may use the built-in Linked List data structure.

 */
public class Q6_AnimalShelterBetter_UsingQueues {

    public static void main(String[] args){
        Shelter2 shelter = new Shelter2();
        shelter.enqueue(new Cat( "cat1"));
        shelter.enqueue(new Cat( "cat2"));
        shelter.enqueue(new Dog( "dog1"));
        shelter.enqueue(new Cat( "cat3"));
        shelter.enqueue(new Dog( "dog2"));
        shelter.display();
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueCat());
        shelter.display();
        System.out.println(shelter.dequeueDog());
        shelter.display();
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
    }

}

class Shelter2 {
   Queue<Animals> cats;
   Queue<Animals> dogs;
   private int order;

    Shelter2(){
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animals animal){
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            cats.add(animal);
        } else if (animal instanceof Dog) {
            dogs.add(animal);
        } else {
            throw new IllegalArgumentException("It's not a cat and not even a dog, bastard!");
        }
    }

    public Animals dequeueAny(){
        if (dogs.isEmpty()){
            return cats.remove();
        } else if (cats.isEmpty()){
            return dogs.remove();
        }
        if (older(cats.peek(), dogs.peek())){
            return cats.remove();
        } else{
            return dogs.remove();
        }
    }

    public Animals dequeueDog(){
        if (dogs.isEmpty()){
            throw new NoSuchElementException();
        }
        return dogs.remove();
    }

    public Animals dequeueCat(){
        if (cats.isEmpty()){
            throw new NoSuchElementException();
        }
        return cats.remove();
    }

    private boolean older(Animals animal1, Animals animal2){
        return animal1.getOrder() < animal2.getOrder();
    }
    public void display() {
        System.out.println("cats " + cats + " ,,, Dogs " + dogs);
    }

}

class Animals {
    private String name;
    private int order = 0;

    Animals(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

   
}

class Cat extends Animals {

    Cat(String name) {
        super(name);
    }
}

class Dog extends Animals {

    Dog(String name) {
        super(name);
    }
}