package CryptoCurrency.Repositories_DAL;

import CryptoCurrency.Beans.CryptoBasket;
import CryptoCurrency.Beans.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoBasketRepository extends JpaRepository<CryptoBasket, Integer> {
    CryptoBasket findOneByName(String name);
}
