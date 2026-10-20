package az.ingress.java43spring.exception;

// Checked exception: Spring default olaraq bunun ucun rollback ETMIR
public class CityOperationException extends Exception {

    public CityOperationException(String message){
        super(message);
    }
}
