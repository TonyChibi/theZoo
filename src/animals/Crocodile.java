package animals;

import interfaces.ILocatable;

public class Crocodile extends Pets{
     public Crocodile(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "crocodile";
        this.id = id;
        Animal.idCounter=id+1;
    }

}
