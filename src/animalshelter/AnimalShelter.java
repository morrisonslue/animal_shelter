package animalshelter;

import java.util.*;

public class AnimalShelter {

    Queue<Animal> dogQueue;
    Queue<Animal> catQueue;

    public AnimalShelter() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    // add animal to correct queue
    public void enqueue(Animal a) {
        if (a.getType().equalsIgnoreCase("dog")) {
            dogQueue.add(a);
        } else if (a.getType().equalsIgnoreCase("cat")) {
            catQueue.add(a);
        }
    }

    // adopt oldest animal
    public Animal dequeueAny() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return null;
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll();
        }

        Animal dog = dogQueue.peek();
        Animal cat = catQueue.peek();

        if (dog.getArrivalTime().isBefore(cat.getArrivalTime())) {
            return dogQueue.poll();
        } else {
            return catQueue.poll();
        }
    }

    // adopt oldest dog
    public Animal dequeueDog() {
        return dogQueue.poll();
    }

    // adopt oldest cat
    public Animal dequeueCat() {
        return catQueue.poll();
    }
}
