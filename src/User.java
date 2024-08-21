import interfaces.ILocatable;
import interfaces.IOptional;

import java.util.*;
import java.util.function.Function;

public class User implements ILocatable {
    public String name;
    public String password;
    ILocatable location;

    User(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

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
        return null;
    }

    @Override
    public String getInstance() {
        return "user";
    }
}
