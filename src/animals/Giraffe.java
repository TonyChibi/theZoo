package animals;

import interfaces.ILocatable;

public class Giraffe extends Packs{
    public Giraffe(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "giraffe";
        this.id=id;
        Animal.idCounter++;
    }
}

