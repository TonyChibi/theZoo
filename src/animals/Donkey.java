package animals;

import interfaces.ILocatable;

public class Donkey extends Packs{
    public Donkey(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "donkey";
        this.id = id;
        Animal.idCounter++;
    }
}
