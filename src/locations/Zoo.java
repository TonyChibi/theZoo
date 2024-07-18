package locations;

import interfaces.ILocatable;

public class Zoo extends Location {
    Zoo(Location location){
        this.location=location;
    }
    @Override
    public void setLocation(ILocatable location) {

    }

    @Override
    public ILocatable getLocation() {
        return null;
    }
}
