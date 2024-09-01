package CryptoCurrency.Services_Facade_BL;

import CryptoCurrency.Beans.CryptoBasket;
import CryptoCurrency.Repositories_DAL.CryptoBasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
            throw new NoSuchElementException("there is no such Basket id!");
    }

    public List<CryptoBasket> getAllBaskets() {
        return repository.findAll();
    }

    public CryptoBasket getBasketByName(String name) {
        if(repository.findOneByName(name) != null)
            return repository.findOneByName(name);
        else
            throw new NoSuchElementException("There is no such Crypto basket with this name!");
    }
}
