package locations;

import interfaces.ILocatable;

public class PacksVault extends Location{
    public PacksVault(ILocatable location){
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
