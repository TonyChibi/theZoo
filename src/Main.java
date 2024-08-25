import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import animals.Animal;
import animals.Pets;
import commands.*;
import creators.Creator;
import interfaces.ILocatable;
import interfaces.IOptional;
import locations.Location;
import locations.Vault;
import locations.Zoo;
import java.sql.*;
public class Main {
    public static void main(String[] args) {

Controller cntrl = new Controller();
        try {
            cntrl.start();
        }catch (SQLException e){
            System.out.println("next error\t:"+e.getMessage()+"\n"+e.getSQLState()+"\n"+e.getClass());
        }
//        jdbc:mysql://localhost:3306/zoo
    }
}