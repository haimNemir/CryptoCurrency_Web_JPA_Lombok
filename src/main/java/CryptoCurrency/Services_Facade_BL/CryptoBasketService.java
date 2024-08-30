package CryptoCurrency.Services_Facade_BL;

import CryptoCurrency.Beans.CryptoBasket;
import CryptoCurrency.Repositories_DAL.CryptoBasketRepository;
import org.springframework.stereotype.Service;

@Service
public class CryptoBasketService {
    private CryptoBasketRepository repository;

    public CryptoBasketService(CryptoBasketRepository repository) {
        this.repository = repository;
    }

    public CryptoBasket getOneBasket(int id) {
        if (repository.existsById(id))
            return repository.findById(id).orElseThrow();
        else
            throw new RuntimeException("there is no such Basket id!");
    }
}
