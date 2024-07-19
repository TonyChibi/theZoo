package creators;

import interfaces.ILocatable;
import locations.Location;
import locations.PacksVault;
import locations.PetVault;
import locations.Zoo;

public class LocationCreator {
    public ILocatable create(String type, ILocatable locatable){
        Location location= null;
        switch (type){
            case "zoo":
                location=new Zoo(locatable);
                break;
            case "petvault":
                location = new PetVault(locatable);
                break;
            case "packvault":
                location = new PacksVault(locatable);
                break;
        }
        return location;
    };
}
