package animals;

import interfaces.ILocatable;

public class Owl extends Pets{
    public Owl(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "owl";
        this.id = id;
        Animal.idCounter++;
    }

}
