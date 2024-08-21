package interfaces;

public interface ILocatable extends IOptional{
    String getName();
    void setLocation(ILocatable location);
    ILocatable getLocation();
}
