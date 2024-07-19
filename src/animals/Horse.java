package animals;

import interfaces.ILocatable;

public class Horse extends Packs{
    public Horse(String name, ILocatable location){
        this.name = name;
        this.location = location;
    }
}
