package animals;

import commands.Command;
import interfaces.IAnimal;
import interfaces.ILocatable;
import interfaces.IOptional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public abstract class Animal implements IAnimal, ILocatable, IOptional{
    public String name;
    public Integer weight;

    public ILocatable location;

    public HashMap <String, Command> commands = new HashMap<>();
    public String kind;

    public abstract String getType();

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

    @Override
    public void setOptions() {

    }

    @Override
    public ArrayList<String> getOptions() {
        return (ArrayList<String>) this.commands.keySet();
    }
}
