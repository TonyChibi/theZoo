package animals;

import interfaces.ILocatable;

public class Dog extends Pets{
    public Dog(String name, ILocatable location){
        this.name = name;
        this.location = location;
    }
}
