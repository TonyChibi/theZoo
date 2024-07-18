package commands;

import animals.Animal;

public class Load extends Command {
    Integer weight= 0;
    public Load(Animal animal){
        this.animal = animal;
    }


    @Override
    public Object response(Object weight) {
        this.animal.weight= (Integer) weight;
        System.out.println(this.animal.name + "\t loaded "+this.weight+"\t weights");
        return weight;
    }

    @Override
    public void response() {

    }
}
