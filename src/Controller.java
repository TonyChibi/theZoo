import animals.Animal;
import creators.Creator;
import locations.Location;
import locations.Vault;
import locations.Zoo;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    View view = new View();
    Creator creator=new Creator();
    MySQL mysql;
    User user;
    public void start(){
        Boolean on= true;
        user=greeting();
        String url = view.insertString("DB url: ");
        mysql = new MySQL(url, user.name, user.password);

        Zoo zoo =(Zoo) creator.create("zoo",this.user);
        user.setLocation(zoo);
        Vault pets = (Vault) creator.create("vault", zoo);
        Vault packs = (Vault) creator.create("vault", zoo);
        zoo.vaults.addAll(Arrays.asList(pets,packs));

        while (on){

        }
        view.bye();
    }
    public User greeting(){
        String name=view.insertString("name");
        String pswd=view.insertString("password");
        return new User(name, pswd);
    }
    public void newAnimal(String name, String type, Location location, String[]commands){
        creator.create(name, type, location, commands);
    }
    public void fillZoo(){

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
