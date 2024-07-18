package locations;

import interfaces.ILocatable;

public class PetVault extends Location{

    PetVault(Location location){
        this.location = location;
    }
    @Override
    public void setLocation(ILocatable location) {

    }

    @Override
    public ILocatable getLocation() {
        return null;
    }
}
