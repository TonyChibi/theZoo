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


    public void setAnimals(Animal animal){

    }
    public ArrayList<HashMap> getAnimals(String conditions){
        Map types = Map.ofEntries(
                entry(1,"pets"),
                entry(2,"packs")
        );
        ArrayList animals = new ArrayList<>();
        try(ResultSet rs = select("*","animals",conditions)){
            while (rs.next()) {
                HashMap animal = new HashMap<>();
                animal.put("name", rs.getString("animal_name"));
                animal.put("type", types.get(rs.getInt("animal_type_id")));
                animal.put("id", rs.getInt("id"));
                animal.put("kind", rs.getString("kind"));
                animal.put("commands", getCommands(rs.getInt("id")));
                animals.add(animal);
            }

        }catch (SQLException e){
            System.out.println("MYSQL ERROR: "+e.getErrorCode()+"\n"+e.getSQLState()+"\t"+e.getMessage());
        }

        return animals;
    }
    public void updateAnimal(Animal animal){

    }
    public Collection getCommands(int animID){

        ArrayList cmdSet = new ArrayList<>();
        try (ResultSet rs = select("*","commands_sets", "where animal_id = "+animID);){
            while (rs.next()) {
                for (String cmd : commands) {
                    if (rs.getByte(cmd) != 0) {
                        cmdSet.add(cmd);
                    }
                }
            }

        }catch(SQLException e) {
            System.out.println("MYSQL  getcommands ERROR: " + e.getErrorCode() + "\n" + e.getSQLState() + "\t" + e.getMessage());
        }

        return cmdSet;
    }

    public ResultSet select(String columns, String table, String condition){
        ResultSet rs = null;
        try{
            Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            Statement st = con.createStatement();
            rs = st.executeQuery("select "+columns+" from " + table +"\t"+ condition);
        }catch (SQLException e){
            System.out.println("MYSQL select ERROR: "+e.getErrorCode()+"\n"+e.getSQLState()+"\t"+e.getMessage());
        }
        return rs;
    }

    public void insert(String table, String columns, String values){

    }
    
}
