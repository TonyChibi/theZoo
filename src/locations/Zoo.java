package locations;

import interfaces.ILocatable;

public class Zoo extends Location {
    public Zoo(ILocatable location){
        this.location=location;
    }
    @Override
    public void setLocation(ILocatable location) {
        this.location = location;
    }

    @Override
    public ILocatable getLocation() {
        return null;
    }
}
