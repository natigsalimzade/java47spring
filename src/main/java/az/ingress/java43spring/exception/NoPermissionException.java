package az.ingress.java43spring.exception;

public class NoPermissionException extends RuntimeException{

    public NoPermissionException(String message){
        super(message);
    }
}
