package locations;

import interfaces.ILocatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Zoo extends Location {

    private static String url;
    public static Connection con;
    public static Statement st;
    public static ResultSet rs;
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
