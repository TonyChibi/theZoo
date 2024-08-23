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
//        animals needs id field





        try {
            MySQL mySQL = new MySQL("jdbc:mysql://localhost:3306/zoo", "root", "glaz");
        ResultSet query = mySQL.select("*","animals", "");
        System.out.println(query);

          query.next();
            System.out.println("\n\n\n\n");

        ArrayList animal = mySQL.getAnimals("");
        System.out.println(animal);



        }catch (Exception e){
            System.out.println("next error\t:"+e.getMessage()+"\n"+e.toString()+"\n"+e.getClass());
        }
//        jdbc:mysql://localhost:3306/zoo
    }
}