package locations;

import interfaces.ILocatable;

import java.util.ArrayList;

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
        return this.location;
    }

    @Override
    public void setOptions() {

    }

    @Override
    public ArrayList getOptions() {
        return null;
    }
}
