package creators;

import animals.*;
import commands.*;
import interfaces.ILocatable;
import jdk.jfr.Description;
import locations.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Creator {

    AnimalCreator ac = new AnimalCreator();
    LocationCreator lc = new LocationCreator();

    CommandCreator cm =  new CommandCreator();

    /**
     * Creates an animal
     * @param name
     * @param kind
     * @param location
     * @param commands
     * @return Animal
     */
    public Animal create(String name, String kind, ILocatable location, Integer id, ArrayList commands){
        System.out.println("creating with id = "+id);
        return ac.create(name, kind, location, id, commands);
    }
    public Animal create(String name, String kind, ILocatable location, ArrayList<String> commands){
        System.out.println("creating without id");
        return create(name, kind, location, Animal.idCounter, commands);
    }

    /**
     * Creates an Location
     * @param type of location zoo/vault
     * @param locatable the location of this new location
     * @return Location
     */
    public Location create(String type, ILocatable locatable, String name){
         return lc.create(type, locatable, name);
    }

    public Command create(String cmd, Animal animal){
        return cm.create(cmd, animal);
    }


}
