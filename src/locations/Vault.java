package locations;

import animals.Animal;
import interfaces.ILocatable;

import java.util.ArrayList;
import java.util.HashMap;

public class Vault extends Location{

    public HashMap<Integer,Animal> animals = new HashMap<>();
    public Vault(ILocatable location, String name){
        this.location = location;
        this.name = name;
    }

    String name;


    @Override
    public String getName() {
        return this.name;
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
        this.options=new ArrayList<>();
        for(Animal animal: this.animals.values()){
            this.options.add("id: "+animal.id+"\t"+animal.kind+"\t"+animal.name);
        }
        this.options.add("new animal");
        this.options.add("back");
    }

    @Override
    public ArrayList getOptions() {
        setOptions();
        return this.options;
    }

    @Override
    public String getInstance() {
        return "vault";
    }

}
