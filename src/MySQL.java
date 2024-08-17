import animals.Animal;


import java.sql.*;
import java.util.*;

import static java.util.Map.entry;


public class MySQL {
    private static String url;
    private static String user;
    private static String password;

    private static Connection con;

    private final List<String> commands = Arrays.asList("bark","gallop","load","meow","say", "trot");
    MySQL (String url,String user,String  password)throws SQLException {
        MySQL.url = url;
        MySQL.user = user;
        MySQL.password =password;

            con = DriverManager.getConnection(MySQL.url, MySQL.user, MySQL.password);

    }


    public void setAnimals(Animal animal){

    }
    public ArrayList<HashMap> getAnimals(String conditions) throws SQLException{
        Map types = Map.ofEntries(
                entry(1,"pets"),
                entry(2,"packs")
        );
        ArrayList animals = new ArrayList<>();
        ResultSet rs = select("*","animals",conditions);
            while (rs.next()) {
                HashMap animal = new HashMap<>();
                animal.put("name", rs.getString("animal_name"));
                animal.put("type", types.get(rs.getInt("animal_type_id")));
                animal.put("id", rs.getInt("id"));
                animal.put("animal_kind", rs.getString("animal_kind"));
                animal.put("commands", getCommands(rs.getInt("id")));
                animals.add(animal);
            }

        return animals;
    }
    public void updateAnimal(Animal animal){

    }
    public Collection getCommands(int animID) throws SQLException {

        ArrayList cmdSet = new ArrayList<>();
        ResultSet rs = select("*","commands_sets", "where animal_id = "+animID);
            while (rs.next()) {
                for (String cmd : commands) {
                    if (rs.getByte(cmd) != 0) {
                        cmdSet.add(cmd);
                    }
                }
            }


        return cmdSet;
    }

    public void postAnimals(ArrayList <Animal> animals) throws SQLException{
        String animColumns = " animal_name, animal_type_id, animal_kind ";
        for (Animal animal: animals){
            int type = 1;
            if (animal.getType().equals("packs") ) type=2;
            String animValues = " '"+animal.name+" ' ,"+type+", '"+animal.kind+"'";
            String commands = "";
            String cmdValues="";
            for (String key: animal.commands.keySet()
                 ) {
                    commands+= ","+key;
                    cmdValues+=",1";
            }
            commands = commands.replaceFirst(",","");
            cmdValues = cmdValues.substring(1);

                con.setAutoCommit(false);
                Savepoint svpnt= con.setSavepoint("save_point");
            try {

                    insert("animals", animColumns,animValues);

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select last_insert_id();");
                    rs.next();
                    int id = rs.getInt(1);
                    System.out.println(id);
                    commands+=", animal_id";
                    cmdValues+=","+id;

                    insert("commands_sets",commands,cmdValues);
                    System.out.println(svpnt);

                    con.commit();
                    con.setAutoCommit(true);
                }catch (SQLException e){
                    con.rollback(svpnt);
                    con.setAutoCommit(true);
                    throw e;
                }
//                this.con.setAutoCommit(true);

        }
    }

    public ResultSet select(String columns, String table, String condition) throws SQLException{
        ResultSet rs = null;
        String query ="select "+columns+" from " + table +"\t"+ condition;

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        rs = st.executeQuery(query);

        return rs;
    }

    public void insert(String table, String columns, String values) throws SQLException{
        String query="insert into "+table+"\t("+columns+")\t values ("+values+");";
        Statement st = con.createStatement();
        st.executeUpdate(query);


    }

    public void delete(String table, String conditions) throws SQLException{
        String query = "delete from "+table+"\t where "+conditions;
        Statement st = con.createStatement();
        st.executeUpdate(query);


    }
    
}
