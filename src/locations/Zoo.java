package locations;

import interfaces.ILocatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Zoo extends Location {

String name = "zoooooo";
    public ArrayList <Vault> vaults;
    public Zoo(ILocatable location){
        this.location=location;
        this.vaults = new ArrayList<>();
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
