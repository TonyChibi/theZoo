package animals;

import commands.Command;
import interfaces.IAnimal;
import interfaces.ILocatable;

import java.util.HashMap;

public abstract class Animal implements IAnimal, ILocatable {
    public String name;
    public Integer weight;

    public ILocatable location;

    public HashMap <String, Command> commands;
    @Override
    public Object execute(String command, Object obj) {
        return this.commands.get(command).response(obj);
    }

    @Override
    public void execute(String command) {
        this.commands.get(command).response();
    }

    @Override
    public void learn(String name, Command command) {
        this.commands.put(name, command);
    }

    @Override
    public void setLocation(ILocatable location) {
        this.location = location;
    }

    @Override
    public ILocatable getLocation() {
        return this.location;
     }

}
