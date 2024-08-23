package animals;

import interfaces.ILocatable;

public class Cat extends Pets{
    public Cat(String name, ILocatable location, int id){
        this.name=name;
        this.location=location;
        this.kind = "cat";
        this.id = id;
        Animal.idCounter++;
    }

}
