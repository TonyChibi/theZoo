package creators;

import interfaces.ILocatable;
import locations.*;

public class LocationCreator {
    public Location create(String type, ILocatable locatable,String name){
        Location location= null;
        switch (type){
            case "zoo":
                location= new Zoo(locatable, name);
                break;
            case "vault":
                location = new Vault(locatable, name);
                break;
        }
        return location;
    };
}
