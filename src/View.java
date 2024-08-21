
import animals.Animal;
import commands.Command;
import interfaces.ILocatable;
import interfaces.IOptional;
import locations.Location;

import java.lang.reflect.Array;
import java.util.*;

public class View {
    public final ArrayList<String> packsAnimals = new ArrayList<>(Arrays.asList("donkey","giraffe","horse","cow"));

    public final ArrayList<String> petsAnimals= new ArrayList<>(Arrays.asList("cat","dog","crocodile","owl"));

    public final ArrayList<String> allCommands = new ArrayList<>(Arrays.asList("bark","gallop","load","meow","say","trot"));


    public void showOptions( ArrayList options ){
        for (int i=0; i<options.size(); i++){
            System.out.println((i+1)+")\t"+options.get(i));
        }
    }
    public void showContext(ILocatable locatable){
        System.out.println("You at "+locatable.getName());
    }
    public void unknown(String str){
        System.out.printf("Sorry, can't do %s", str);
    }
    public void awaiting(){
        System.out.println("\n>");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    public String teach(Animal animal){
        ArrayList<String> cmds = this.allCommands;
        cmds.removeAll(animal.commands.keySet());
        System.out.println("Available commands:");
        for (String cmd: cmds){
            System.out.println("|\t"+cmd);
        }
        return insertString("command to learn");
    }

    public String insertString(String insertion){
        Scanner in = new Scanner(System.in);
        System.out.printf("Insert the %s : ", insertion);
        return   in.nextLine();
    }



   public void greeting(){
       System.out.println("HELLO DEAr!/n");

   }
   public void bye(){
       System.out.println("See ya lateR!");
   }

}
