package lab3.Exсeptions;

public class SecondBreakPoint extends RuntimeException {
    private String message;
    public SecondBreakPoint(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
