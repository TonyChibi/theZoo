package creators;

import animals.*;
import commands.*;

import java.lang.reflect.Array;
import java.util.Collection;

public class Creator {

    public Animal create(String name, String type, Collection methods){
        Animal animal;
        switch (type){
            case "cat":
                animal = new Cat(name);
                break;

        }

        return null;

    }

    public Command create(String type, Animal animal){
        Command command = null;
        switch (type) {
            case "bark":
                command =  new Bark(animal);
                break;
        }
        return command;
    }
}
