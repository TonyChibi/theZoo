package creators;

import interfaces.ILocatable;
import animals.*;


import java.util.ArrayList;
import java.util.HashMap;


public class AnimalCreator {
    CommandCreator CmCreator = new CommandCreator();
    public Animal create(String name, String type, ILocatable location, ArrayList<String> commands){
        Animal animal=null;
        switch (type){
            case "cat":
                animal = new Cat(name, location);
                break;
            case "cow":
                animal =new Cow(name, location);
                break;
            case "crocodile":
                animal = new Crocodile(name, location);
                break;
            case "dog":
                animal = new Dog(name, location);
                break;
            case "dunkey":
                animal = new Donkey(name, location);
                break;
            case "giraffe":
                animal = new Giraffe(name, location);
                break;
            case "horse":
                animal = new Horse(name, location);
                break;
            case "owl":
                animal = new Owl(name, location);
                break;
        }
        if (commands!=null) {
            HashMap preCommands = new HashMap<>();
            for (String item : commands) {
                preCommands.put(item, CmCreator.create(item, animal));
            }
            animal.commands.putAll(preCommands);

        }
        return animal;
    }
}
