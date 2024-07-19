package creators;

import animals.Animal;
import commands.*;

public class CommandCreator {
    public Command create(String type, Animal animal){
        Command command = null;
        switch (type) {
            case "bark":
                command =  new Bark(animal);
                break;
            case "gallop":
                command= new Gallop(animal);
                break;
            case "load":
                command = new Load(animal);
                break;
            case "meow":
                command = new Meow(animal);
                break;
            case "say":
                command = new Say(animal);
                break;
            case "trot":
                command = new Trot(animal);
                break;
        }
        return command;
    }
}
