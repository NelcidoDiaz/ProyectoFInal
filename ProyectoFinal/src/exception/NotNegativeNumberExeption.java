package exception;

public class NotNegativeNumberExeption extends Exception {


	public NotNegativeNumberExeption() {
		super("Cantidad no puede ser negativa");
		// TODO Auto-generated constructor stub
	}

	public NotNegativeNumberExeption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NotNegativeNumberExeption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotNegativeNumberExeption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
