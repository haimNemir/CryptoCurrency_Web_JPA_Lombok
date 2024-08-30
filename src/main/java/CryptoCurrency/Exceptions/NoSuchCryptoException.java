package CryptoCurrency.Exceptions;

public class NoSuchCryptoException extends RuntimeException{

    public NoSuchCryptoException() {
    }

    public NoSuchCryptoException(String massage) {
        super(massage);
    }
}
