package creators;

import animals.Animal;
import animals.Cat;
import animals.Cow;
import interfaces.ILocatable;


import java.util.HashMap;


public class AnimalCreator {
    CommandCreator CmCreator = new CommandCreator();
    public Animal create(String name, String type, ILocatable location, String[] commands){
        Animal animal=null;
        switch (type){
            case "cat":
                animal = new Cat(name, location);
                break;
            case "cow":
                animal =new Cow();
                break;
        }
        HashMap preCommands = new HashMap<>();
        for (String item: commands){
                preCommands.put(item, CmCreator.create(item,animal));
        }
        animal.commands.putAll(preCommands);
        return animal;

    }
}
