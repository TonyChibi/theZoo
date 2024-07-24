package creators;

import interfaces.ILocatable;
import locations.*;

public class LocationCreator {
    public Location create(String type, ILocatable locatable){
        Location location= null;
        switch (type){
            case "zoo":
                location=new Zoo(locatable);
                break;
            case "vault":
                location = new Vault(locatable);
                break;
        }
        return location;
    };
}
