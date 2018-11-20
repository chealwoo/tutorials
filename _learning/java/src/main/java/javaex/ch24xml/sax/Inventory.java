package javaex.ch24xml.sax;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends SimpleElement {
    List<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
