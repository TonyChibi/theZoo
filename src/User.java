import interfaces.ILocatable;
import interfaces.IOptional;

import java.util.*;
import java.util.function.Function;

public class User implements IOptional, ILocatable {
    ILocatable location;
    HashMap<String, Function<String,String>> options= new HashMap<String, Function<String, String>>();
    @Override
    public void setLocation(ILocatable location) {
        this.location= location;
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
        return (ArrayList) this.options.keySet();
    }
}
