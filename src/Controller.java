import animals.Animal;
import creators.Creator;
import locations.Location;
import locations.Vault;
import locations.Zoo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Controller {
    View view = new View();
    Creator creator=new Creator();
    MySQL mysql;
    User user;
    public void start() throws Exception {
        Boolean on= true;
        user=greeting();
        String url = view.insertString("DB url: ");
        mysql = new MySQL(url, user.name, user.password);

        Zoo zoo =(Zoo) creator.create("zoo",this.user);
        user.setLocation(zoo);
        Vault pets = (Vault) creator.create("vault", zoo);
        Vault packs = (Vault) creator.create("vault", zoo);
        zoo.vaults.put("pets", pets);
        zoo.vaults.put("packs", packs);


        while (on){

        }
        view.bye();
    }
    public User greeting(){
        String name=view.insertString("name");
        String pswd=view.insertString("password");
        return new User(name, pswd);
    }
    public void newAnimal(String name, String type, Location location, ArrayList <String> commands){
        creator.create(name, type, location, commands);
    }
    public void fillZoo(Zoo zoo) throws SQLException{
        ArrayList <HashMap> animals = mysql.getAnimals("");
        for (HashMap item: animals){
            Animal animal;
            switch ((String) item.get("type")){
                case "pets":
                    animal = creator.create(
                            (String)item.get("name"),
                            (String) item.get("type"),
                            zoo.vaults.get("pets"),
                            (ArrayList<String>)item.get("commands"));
                    zoo.vaults.get("pets").animals.add(animal);
                    break;
                case "packs":
                    animal = creator.create(
                            (String)item.get("name"),
                            (String) item.get("type"),
                            zoo.vaults.get("packs"),
                            (ArrayList<String>)item.get("commands"));
                    zoo.vaults.get("packs").animals.add(animal);
                    break;
            }

        }


    }
    public void updateZoo(){

    }
    public void deleteToy(){

    }
    public void showToys(){

    }
    public void showOptions(){

    }

    public Animal pullAnimal(){

        return null;
    }




}
