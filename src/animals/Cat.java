package animals;

import interfaces.ILocatable;
import locations.PacksVault;

public class Cat extends Pets{
    public Cat(String name, ILocatable location){
        this.name=name;
        this.location=location;
    }
}
