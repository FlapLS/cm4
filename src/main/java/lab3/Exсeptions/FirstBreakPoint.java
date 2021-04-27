package lab3.Exсeptions;

public class FirstBreakPoint extends RuntimeException {
    private String message;
    public FirstBreakPoint(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
