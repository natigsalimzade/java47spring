package az.ingress.java43spring.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(){
        super("Customer not found");
    }
}
