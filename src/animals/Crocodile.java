package animals;

import interfaces.ILocatable;

public class Crocodile extends Pets{
     public Crocodile(String name, ILocatable location){
        this.name = name;
        this.location = location;
    }
}
