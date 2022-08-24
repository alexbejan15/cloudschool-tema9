package exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException() {
        super("The student does not exist!");
    }
}
