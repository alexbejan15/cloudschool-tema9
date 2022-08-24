package exception;

public class ProfessorNotFoundException extends Exception{
    public ProfessorNotFoundException() {
        super("This professor does not exist!");
    }
}
