package interfaces;

import commands.Command;

public interface IAnimal {
   public void execute(String command);
   public Object execute(String command, Object obj);
    public void learn(String name, Command command);

}
