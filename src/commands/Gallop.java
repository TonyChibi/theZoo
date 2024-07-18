package commands;

import animals.Animal;

public class Gallop extends Command {
    public Gallop(Animal animal){
        this.animal=animal;
    }


    @Override
    public  Object response(Object obj) {
        return null;
    }

    @Override
    public void response() {
        System.out.println(this.animal.name+"\t is galloping");

    }
}
