package exception;

public class SpecialtyNotFoundException extends Exception{
    public SpecialtyNotFoundException(){
        super("This specialty does not exist!");
    }
}
