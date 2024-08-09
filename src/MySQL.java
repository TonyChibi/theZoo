import animals.Animal;

import java.sql.*;
import java.util.*;

import static java.util.Map.entry;


public class MySQL {
    private static String url;
    private static String user;
    private static String password;

    private final List<String> commands = Arrays.asList("bark","gallop","load","meow","say", "trot");
    MySQL(String url,String user,String  password){
        this.url = url;
        this.user = user;
        this.password=password;
    }


    public void setAnimal(Animal animal){

    }
    public HashMap getAnimal(int animID){
        Map types = Map.ofEntries(
                entry(1,"pets"),
                entry(2,"packs")
        );
        HashMap animal = new HashMap<>();
        try(Connection con = DriverManager.getConnection(this.url, this.user, this.password)){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from animals where id = "+animID);
            rs.next();
            animal.put("name",rs.getString("animal_name"));
            animal.put("type",types.get(rs.getInt("animal_type_id")));
            animal.put("id",rs.getInt("id"));
            animal.put("commands",getCommands(animID));
            animal.put("kind", rs.getString("kind"));
        }catch (SQLException e){
            System.out.println("MYSQL ERROR: "+e.getErrorCode()+"\n"+e.getSQLState()+"\t"+e.getMessage());
        }

        return animal;
    }
    public void updateAnimal(Animal animal){

    }
    public Collection getCommands(int animID){

        ArrayList cmdSet = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(this.url, this.user, this.password)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from commands_sets where animal_id = "+animID);
            rs.next();
            for (String cmd: commands
                 ) {
                if(rs.getByte(cmd)!=0){
                    cmdSet.add(cmd);
                }
            }

        }catch (SQLException e){
            System.out.println("MYSQL ERROR: "+e.getErrorCode()+"\n"+e.getSQLState()+"\t"+e.getMessage());
        }

        return cmdSet;
    }

    
}
