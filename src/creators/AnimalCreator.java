package creators;

import interfaces.ILocatable;
import animals.*;


import java.util.ArrayList;
import java.util.HashMap;


public class AnimalCreator {
    CommandCreator CmCreator = new CommandCreator();
    public Animal create(String name, String kind, ILocatable location,int id, ArrayList<String> commands){
        Animal animal=null;
        switch (kind){
            case "cat":
                animal = new Cat(name, location, id);
                break;
            case "cow":
                animal =new Cow(name, location, id);
                break;
            case "crocodile":
                animal = new Crocodile(name, location, id);
                break;
            case "dog":
                animal = new Dog(name, location, id);
                break;
            case "donkey":
                animal = new Donkey(name, location, id);
                break;
            case "giraffe":
                animal = new Giraffe(name, location, id);
                break;
            case "horse":
                animal = new Horse(name, location, id);
                break;
            case "owl":
                animal = new Owl(name, location, id);
                break;
        }
        if (commands!=null) {
            HashMap preCommands = new HashMap<>();
            for (String item : commands) {
                preCommands.put(item, CmCreator.create(item, animal));
            }
            animal.commands.putAll(preCommands);

        }
        System.out.println(animal);
        return animal;
    }


}
