package commands;

import animals.Animal;

public class Say extends Command{
    public Say(Animal animal){
        this.animal= animal;

    }



    @Override
    public  Object response(Object obj) {
        System.out.println( this.animal.name +": "+(String) obj);
        return (String)obj;
    }

    @Override
    public void response() {

    }
}
