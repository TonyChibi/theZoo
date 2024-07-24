import java.util.HashMap;
import java.util.function.Function;

import animals.Animal;
import commands.*;
import creators.Creator;
import locations.Location;
import locations.Zoo;

public class Main {
    public static void main(String[] args) {
//        user should be able to see his options when it cames to his location
//        user options must have method for creation of animals
//        or not
//        zoo location is user

//*ToDo
//        complete animal's options
//        need to sort out options


        Creator creator= new Creator();
        Location zoo = new Zoo(null);
        Location zoo1 = creator.create("zoo", creator.create("zoo",zoo));
        Location pets = creator.create("vault", zoo1);
        Animal cat = creator.create("dog", "cat", pets,null);
        System.out.println(zoo.getLocation());
        System.out.println(zoo1.getLocation());
        System.out.println(pets.getLocation());
        System.out.println(cat.getLocation());
    }
}