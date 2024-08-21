import animals.Animal;
import animals.Packs;
import animals.Pets;
import creators.Creator;
import interfaces.ILocatable;
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



    Boolean on= true;

    Zoo zoo;
    public void start() throws Exception {

        initialize();
        while (on){
            view.showContext(user.location);
            view.showOptions(user.location.getOptions());
            String answer = view.insertString("an option");
            switch(user.location.getInstance()){
                case "zoo":
                    checkZooOptions(answer);
                    break;
                case "vault":
                    checkVaultOptions(answer);
                    break;
                case "animal":
                    checkAnimalOptions(answer);
                    break;
            }

        }
        view.bye();
    }

    public void checkAnimalOptions(String answer)throws SQLException{
        switch (answer){
            case "learn":
                teachAnimal((Animal) user.getLocation());
                break;
            case "kill":
                killAnimal((Animal) user.getLocation());
                break;
            case "back":
                user.location=user.location.getLocation();
                break;
            default:
                Animal animal = (Animal) user.getLocation();
                if(animal.commands.keySet().contains(answer)){
                    animal.execute(answer);
                }else view.unknown(answer);
        }
        view.awaiting();
    }

    public void killAnimal(Animal animal) throws SQLException{
        user.location = animal.getLocation();
        Vault vault= (Vault) user.getLocation();
        mysql.delete("animals", "id = "+animal.id);
        vault.animals.remove(animal);

    }
    public void teachAnimal(Animal animal){
        String cmd =view.teach(animal);
        animal.learn(cmd,creator.create(cmd,animal));
    }

    public void createAnimal(ILocatable locatable){
        switch (locatable.getName()){
            case "packs":
                view.showOptions(view.packsAnimals);
                break;
            case "pets":
                view.showOptions(view.petsAnimals);
                break;
        }
        String kind=view.insertString("animal kind");
        String name = view.insertString("animal name");
        Animal animal = creator.create(name,kind,locatable,null);
        Vault vault=(Vault) locatable;
        vault.animals.put(animal.name,animal);

    }

    public void checkVaultOptions(String answer){
        switch (answer){
            case "new animal":
                createAnimal(user.location);
                break;
            case "back":
                user.location=user.location.getLocation();
                break;
            default:
                Vault vault =(Vault) user.getLocation();
                if(vault.animals.keySet().contains(answer)){
                    user.location=vault.animals.get(answer);
                }else view.unknown(answer);
        }
    }
    public void checkZooOptions(String answer){
        switch (answer){
            case "exit":
                on= false;
                break;
            default:
                if(zoo.vaults.keySet().contains(answer)){
                    user.location=zoo.vaults.get(answer);
                }else view.unknown(answer);

        }
    }


    public void initialize() throws SQLException{
        user=greeting();
        String url = view.insertString("DB url: ");
        mysql = new MySQL(url, user.name, user.password);
        zoo =(Zoo) creator.create("zoo",this.user, "zoo");
        user.setLocation(zoo);
        Vault pets = (Vault) creator.create("vault", zoo, "pets");
        Vault packs = (Vault) creator.create("vault", zoo, "packs");
        zoo.vaults.put(pets.getName(), pets);
        zoo.vaults.put(packs.getName(), packs);
        fillZoo(zoo);
    }
    public User greeting(){
        view.greeting();
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
                    zoo.vaults.get("pets").animals.put(animal.kind,animal);
                    break;
                case "packs":
                    animal = creator.create(
                            (String)item.get("name"),
                            (String) item.get("type"),
                            zoo.vaults.get("packs"),
                            (ArrayList<String>)item.get("commands"));
                    zoo.vaults.get("packs").animals.put(animal.kind,animal);
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
