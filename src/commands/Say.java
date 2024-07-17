package commands;

import animals.Animal;

public class Say extends Command{
    Say(Animal animal){
        this.animal= animal;

    }



    @Override
    public  Object response(Object obj) {
        System.out.println( (String) obj);
        return (String)obj;
    }

    @Override
    public void response() {

    }
}
