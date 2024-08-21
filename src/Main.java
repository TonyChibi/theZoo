import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import animals.Animal;
import animals.Pets;
import commands.*;
import creators.Creator;
import interfaces.ILocatable;
import interfaces.IOptional;
import locations.Location;
import locations.Vault;
import locations.Zoo;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
//        user should be able to see his options when it cames to his location
//        user options must have method for creation of animals
//        or not
//        zoo location is user

//*ToDo
//        zoo will be main character, and for a DB also ?
//        need to sort out options, at least at zoo
//        get zoo to deal with DB
//         mysql needs procefure for animal setting. and so pushAnimal at mysql
//        create animal at controller is empty



        Creator creator= new Creator();
        Zoo zoo = new Zoo(null, "zoo");
        Zoo zoo3 = (Zoo)creator.create("zoo", zoo, "zoo");
        Zoo zoo1 = (Zoo)creator.create("zoo",  creator.create("zoo", zoo, "zoo"), "zoo");
        Vault pets = (Vault)creator.create("vault", zoo1,"pets");
        Animal cat = creator.create("dog", "cat", pets,null);
        cat.learn("trot", new Trot(cat));
        cat.learn("say", new Say(cat));
        System.out.println(cat.commands);
        Animal dog = creator.create("cat", "dog", pets, null);
        pets.animals.put(cat.kind,cat);
        pets.animals.put(dog.kind,dog);
        System.out.println(pets.animals);
        System.out.println(zoo.getLocation());
        System.out.println(zoo1.getLocation());
        System.out.println(pets.getLocation());
        System.out.println(cat.getLocation());
        System.out.println(cat.getType());


        try {
            MySQL mySQL = new MySQL("jdbc:mysql://localhost:3306/zoo", "root", "glaz");
        ResultSet query = mySQL.select("*","animals", "");
        System.out.println(query);

          query.next();
            System.out.println(query.getMetaData().getColumnCount());
            mySQL.insert("animals","animal_name, animal_type_id, animal_kind ", "'vasya', 1, 'rabbit'");
            mySQL.postAnimals(new ArrayList<>(Arrays.asList(dog, cat)));


        ArrayList animal = mySQL.getAnimals("");
        System.out.println(animal);

        mySQL.updateCommand("commands_sets","gallop","1","where animal_id > 100");
            System.out.println(cat.commands);
            System.out.println(dog.commands);
        cat.execute("say","whoo_hoo");
//        dog.execute("gallop");

        mySQL.delete("animals","animal_kind = 'rabbit'");
        mySQL.delete("animals","animal_kind  = 'cat'");

        animal = mySQL.getAnimals("");
        System.out.println(animal);


        }catch (Exception e){
            System.out.println("next error\t:"+e.getMessage()+"\n"+e.toString()+"\n"+e.getClass());
        }
//        jdbc:mysql://localhost:3306/?user=root
    }
}