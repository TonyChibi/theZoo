package locations;

import interfaces.ILocatable;

public class PetVault extends Location{

    public PetVault(ILocatable location){
        this.location = location;
    }
    @Override
    public void setLocation(ILocatable location) {
        this.location=location;
    }

    @Override
    public ILocatable getLocation() {
        return null;
    }
}
