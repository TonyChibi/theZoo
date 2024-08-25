package locations;

import interfaces.ILocatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Zoo extends Location {


String name = "zoo";
    public HashMap<String,Vault> vaults;
    public Zoo(ILocatable location, String name){
        this.location=location;
        this.vaults = new HashMap<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
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
    this.options = new ArrayList<>(this.vaults.keySet());
    this.options.add("exit");
    }

    @Override
    public ArrayList getOptions() {
        setOptions();
        return this.options;
    }

    @Override
    public String getInstance() {
        return "zoo";
    }
}
