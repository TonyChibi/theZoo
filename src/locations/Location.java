package locations;

import interfaces.ILocatable;
import interfaces.IOptional;

import java.util.ArrayList;

public abstract class Location implements ILocatable, IOptional {
    public ILocatable location;
    public ArrayList options;
}
