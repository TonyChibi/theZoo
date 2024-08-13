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

    /**
     * Creates an animal
     * @param name
     * @param type
     * @param location
     * @param commands
     * @return Animal
     */
    public Animal create(String name, String type, ILocatable location, ArrayList commands){
        return ac.create(name, type, location, commands);
    }

    /**
     * Creates an Location
     * @param type
     * @param locatable
     * @return Location
     */
    public Location create(String type, ILocatable locatable){
         return lc.create(type, locatable);
    }



}
