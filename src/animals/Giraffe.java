package animals;

import interfaces.ILocatable;

public class Giraffe extends Packs{
    public Giraffe(String name, ILocatable location){
        this.name = name;
        this.location = location;
        this.kind = "giraffe";
    }
}

