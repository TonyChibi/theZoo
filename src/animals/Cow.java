package animals;

import interfaces.ILocatable;

public class Cow extends Packs{
    public Cow(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "cow";
        this.id = id;
        Animal.idCounter++;
    }

}
