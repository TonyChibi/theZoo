package animals;

import interfaces.ILocatable;

public class Horse extends Packs{
    public Horse(String name, ILocatable location, int id){
        this.name = name;
        this.location = location;
        this.kind = "horse";
        this.id= id;
        Animal.idCounter=id+1;
    }

}
