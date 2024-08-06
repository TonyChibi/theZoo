package locations;

import animals.Animal;
import interfaces.ILocatable;

import java.util.ArrayList;

public class Vault extends Location{

    public ArrayList <Animal> animals = new ArrayList<>();
    public Vault(ILocatable location){
        this.location = location;
    }


    @Override
    public void setLocation(ILocatable location) {
        this.location=location;
    }

    @Override
    public ILocatable getLocation() {
        return this.location;
    }

    @Override
    public void setOptions() {

    }

    @Override
    public ArrayList getOptions() {
        return this.animals;
    }

    public void setAnimals(ArrayList<Animal> animals){
        this.animals.addAll(animals);
    }
}
