package Ch03.StacksAndQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 that type). They cannot select which specific animal they would like. Create the data structures to
 maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 and dequeueCat. You may use the built-in Linked List data structure.

 */
public class Q6_AnimalShelter {

    public static void main(String[] args){
        Shelter shelter = new Shelter();
        shelter.enqueue(new Animal(0, "cat1"));
        shelter.enqueue(new Animal(0, "cat2"));
        shelter.enqueue(new Animal(1, "dog1"));
        shelter.enqueue(new Animal(0, "cat3"));
        shelter.enqueue(new Animal(1, "dog2"));
        shelter.display();
        System.out.println(shelter.dequeueAny());
        shelter.display();
        System.out.println(shelter.dequeueDog());
        shelter.display();
    }

}

class Shelter {
    LinkedList<Animal> list;

    Shelter(){
        list = new LinkedList<>();
    }

    public void enqueue(Animal animal){
        list.add(animal);
    }

    public Animal dequeueAny(){
        return list.removeLast();
    }

    public Animal dequeueDog(){
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        Animal curr = list.getFirst();
        int i = 1;
        while (curr.getType() != 1 && list.size() > i-1){
            System.out.println(i);
            curr = list.get(i++);
            System.out.println(curr.getName());
        }
        return curr;

    }
    public void dequeueCat(){

    }

    public void display() {
        System.out.println(list);
    }
}

class Animal{
    // 0 - cat
    // 1 - dog
    private int type;
    private String name;

    Animal(int type, String name){
        if (type != 0 && type != 1){
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String type = (this.type == 0) ? "cat" : "dog";
        return type + " " + name;
    }

}