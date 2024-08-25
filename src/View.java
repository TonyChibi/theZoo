
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
            System.out.println("|\t"+options.get(i));
        }
    }
    public void showContext(ILocatable locatable){
        System.out.println("You at "+locatable.getName());
    }
    public void unknown(String str){
        System.out.printf("Sorry, can't do %s", str);
    }
    public void awaiting(){
        System.out.println("\n> OK");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    public String teach(Animal animal, ArrayList cmds){
        showOptions(cmds);
        return insertString("the command to learn");
    }

    public String insertString(String insertion){
        Scanner in = new Scanner(System.in);
        System.out.printf("Insert %s : ", insertion);
        return   in.nextLine().toLowerCase();
    }

    public void dead(Animal animal){
        System.out.println("The "+animal.kind+"\t named "+animal.name+"\tis dead\nour condolences");
    }


   public void greeting(){
       System.out.println("HELLO DEAr!\n");

   }
   public void bye(){
       System.out.println("See ya lateR!");
   }

}
