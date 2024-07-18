package commands;

import animals.Animal;

public class Meow extends Command{
   public Meow(Animal animal){
        this.animal= animal;
    }

    @Override
    public Object response(Object obj) {
        return null;
    }

    @Override
    public void response() {
        System.out.println(this.animal.name+"\t MEOW");

    }
}
