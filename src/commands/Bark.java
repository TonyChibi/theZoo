package commands;

import animals.Animal;

public class Bark extends Command {
    public Bark(Animal animal){
        this.animal=animal;

    }

    @Override
    public Object response(Object obj) {
        return null;
    }

    @Override
    public void response() {
        System.out.println(this.animal.name+"\tWOW-WOW");
    }
}
