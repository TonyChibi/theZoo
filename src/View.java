
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class View {
    public void showOptions( ArrayList options ){
        for (int i=0; i<options.size(); i++){
            System.out.println((i+1)+")\t"+options.get(i));
        }
    }

}
