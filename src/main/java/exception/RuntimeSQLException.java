package exception;

public class RuntimeSQLException extends RuntimeException {
    public RuntimeSQLException() {
    }

    public RuntimeSQLException(String message) {
        super(message);
    }
}
