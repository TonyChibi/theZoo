package animals;

import interfaces.ILocatable;

public class Dog extends Pets{
    public Dog(String name, ILocatable location,int id){
        this.name = name;
        this.location = location;
        this.kind = "dog";
        this.id = id;
        Animal.idCounter++;
    }

}
