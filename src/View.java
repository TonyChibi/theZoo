
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {
    public void showOptions( ArrayList options ){
        for (int i=0; i<options.size(); i++){
            System.out.println((i+1)+")\t"+options.get(i));
        }
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
