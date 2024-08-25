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
    public void start() throws SQLException {

        initialize();
        while (on){
            view.showContext(user.location);
            view.showOptions(user.location.getOptions());
            String answer;
            switch(user.location.getInstance()){
                case "zoo":
                    answer = view.insertString("an vault's name or else");
                    checkZooOptions(answer);
                    break;
                case "vault":
                    answer = view.insertString("an animal id or else");
                    checkVaultOptions(answer);
                    break;
                case "animal":
                    answer = view.insertString("an command or else");
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
                view.awaiting();
                break;
            case "back":
                user.location=user.location.getLocation();
                break;
            default:
                Animal animal = (Animal) user.getLocation();
                if(animal.commands.keySet().contains(answer)){
                    animal.execute(answer);
                }else view.unknown(answer);
                view.awaiting();
        }

    }

    public void killAnimal(Animal animal) throws SQLException{
        user.location = animal.getLocation();
        Vault vault= (Vault) user.getLocation();
        mysql.delete("animals", "id = "+animal.id);
        vault.animals.remove(animal.id);
        view.dead(animal);


    }
    public void teachAnimal(Animal animal)throws SQLException{
        String cmd = "";
        ArrayList<String> cmds = view.allCommands;
        cmds.removeAll(animal.commands.keySet());
        while (!cmds.contains(cmd)) {
            cmd = view.teach(animal, cmds);
        }
        animal.learn(cmd, creator.create(cmd, animal));
        mysql.updateCommand(cmd, "1", "where animal_id = " + animal.id);
    }

    public void createAnimal(ILocatable locatable) throws SQLException{
        String kind="";
        switch (locatable.getName()){
            case "packs":
                while (!view.packsAnimals.contains(kind)) {
                    view.showOptions(view.packsAnimals);
                    kind = view.insertString("animal kind");
                }
                break;
            case "pets":
                while (!view.petsAnimals.contains(kind)) {
                    view.showOptions(view.petsAnimals);
                    kind = view.insertString("animal kind");
                }
                break;
        }
        String name = view.insertString("animal name");
        Animal animal = creator.create(name,kind,locatable,null);
        Vault vault=(Vault) locatable;
        vault.animals.put(animal.id,animal);
        mysql.postAnimals(new ArrayList(Arrays.asList(animal)));

    }

    public void checkVaultOptions(String answer)throws SQLException{
        switch (answer){
            case "new animal":
                createAnimal(user.location);
                break;
            case "back":
                user.location=user.location.getLocation();
                break;
            default:
                Vault vault =(Vault) user.getLocation();
                if(vault.animals.keySet().contains(Integer.parseInt(answer))){
                    user.location=vault.animals.get(Integer.parseInt(answer));
                    view.awaiting();
                }else {
                    view.unknown(answer);
                    view.awaiting();
                }
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
        System.out.println(animals.size());
        for (HashMap item: animals){
            System.out.println(item.get("id"));
            Animal animal;
            switch ((String) item.get("type")){
                case "pets":
                    animal = creator.create(
                            (String)item.get("name"),
                            (String) item.get("animal_kind"),
                            zoo.vaults.get("pets"),
                            (Integer) item.get("id"),
                            (ArrayList<String>)item.get("commands"));
                    zoo.vaults.get("pets").animals.put(animal.id,animal);
                    break;
                case "packs":
                    animal = creator.create(
                            (String)item.get("name"),
                            (String) item.get("animal_kind"),
                            zoo.vaults.get("packs"),
                            (Integer) item.get("id"),
                            (ArrayList<String>)item.get("commands"));
                    zoo.vaults.get("packs").animals.put(animal.id,animal);
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
