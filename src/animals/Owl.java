package animals;

import interfaces.ILocatable;

public class Owl extends Pets{
    public Owl(String name, ILocatable location){
        this.name = name;
        this.location = location;
    }
}
