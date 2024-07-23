package creators;

import animals.*;
import commands.*;
import interfaces.ILocatable;
import locations.Location;

import java.lang.reflect.Array;
import java.util.Collection;

public class Creator {

    AnimalCreator ac = new AnimalCreator();
    LocationCreator lc = new LocationCreator();

    public Animal create(String name, String type, ILocatable location, String [] commands){
        return ac.create(name, type, location, commands);
    }
    public Location create(String type, ILocatable locatable){
         return lc.create(type, locatable);
    }



}
