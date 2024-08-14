import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import animals.Animal;
import commands.*;
import creators.Creator;
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
//         mysql pullAnimal not finished. the DB needs improvements


        Creator creator= new Creator();
        Zoo zoo = new Zoo(null);
        Zoo zoo1 = (Zoo)creator.create("zoo", creator.create("zoo",zoo));
        Vault pets = (Vault)creator.create("vault", zoo1);
        Animal cat = creator.create("dog", "cat", pets,null);
        Animal dog = creator.create("cat", "dog", pets, null);
        pets.animals.addAll(Arrays.asList(cat,dog));
        System.out.println(pets.animals);
        System.out.println(zoo.getLocation());
        System.out.println(zoo1.getLocation());
        System.out.println(pets.getLocation());
        System.out.println(cat.getLocation());
        System.out.println(cat.getType());
        MySQL mySQL = new MySQL("jdbc:mysql://localhost:3306/zoo", "root", "glaz");

        ResultSet query = mySQL.select("*","animals", "");
        System.out.println(query);
        try {
          query.next();
            System.out.println(query.getMetaData().getColumnCount());

        }catch (Exception e){
            System.out.println("next error\t:"+e.getMessage());
        }
        mySQL.insert("animals","animal_name, animal_type_id, kind ", "'vasya', 1, 'rabbit'");

        ArrayList animal = mySQL.getAnimals("");
        System.out.println(animal);
        mySQL.delete("animals","animal_name = 'vasya'");
        animal = mySQL.getAnimals("");
        System.out.println(animal);
//        jdbc:mysql://localhost:3306/?user=root
    }
}