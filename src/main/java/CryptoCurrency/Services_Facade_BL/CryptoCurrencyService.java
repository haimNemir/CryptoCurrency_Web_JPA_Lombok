package CryptoCurrency.Services_Facade_BL;

import CryptoCurrency.Exceptions.NoSuchCryptoException;
import CryptoCurrency.Repositories_DAL.CryptoCurrencyRepository;
import org.springframework.stereotype.Service;
import CryptoCurrency.Beans.CryptoCurrency;

import java.util.List;

@Service//tells Spring this Service is yours
public class CryptoCurrencyService {
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    //    +@Autowired - not need because spring make injection automatically with this constructor.
    public CryptoCurrencyService(CryptoCurrencyRepository cryptoCurrencyRepository) {
        this.cryptoCurrencyRepository = cryptoCurrencyRepository;
    }

    public void addCurrency(CryptoCurrency currency) {
        if (cryptoCurrencyRepository.existsById(currency.getId()))
            System.out.println("There is another Currency with this id!");
        else {
            cryptoCurrencyRepository.save(currency);
        }
    }

    public List<CryptoCurrency> getAllCurrencies() {
        return cryptoCurrencyRepository.findAll();
    }

    public CryptoCurrency getById(String id) {
        return cryptoCurrencyRepository.findById(id).orElseThrow(NoSuchCryptoException::new);
    }

    public List<CryptoCurrency> getAllCurrenciesAbovePrice(Double minPrice) {
        return cryptoCurrencyRepository.findByPriceGreaterThan(minPrice);
    }

    public boolean deleteCurrency(String id) {
        if (cryptoCurrencyRepository.existsById(id)) {
            cryptoCurrencyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void updateCurrency(CryptoCurrency currency) {
        cryptoCurrencyRepository.save(currency);
    }

    public void updateCurrencyPrice(CryptoCurrency currency) {
        CryptoCurrency cryptoCurrency = cryptoCurrencyRepository.findById(currency.getId()).orElseThrow();
        cryptoCurrency.setPrice(currency.getPrice());
        cryptoCurrencyRepository.save(cryptoCurrency);
    }
}
