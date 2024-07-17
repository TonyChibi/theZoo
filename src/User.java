import interfaces.ILocatable;
import interfaces.IOptional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class User implements IOptional<String, Function<String,String>>, ILocatable {
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
    public void setOptions(Map<String, Function<String,String>> options) {
        this.options.putAll(options);
    }

    @Override
    public Map getOptions() {
        return this.options;
    }
}
