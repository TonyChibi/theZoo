package locations;

import interfaces.ILocatable;
import interfaces.IOptional;

public abstract class Location implements ILocatable, IOptional {
    public ILocatable location;
}
