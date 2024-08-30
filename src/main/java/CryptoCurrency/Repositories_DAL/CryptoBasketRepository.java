package CryptoCurrency.Repositories_DAL;

import CryptoCurrency.Beans.CryptoBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoBasketRepository extends JpaRepository<CryptoBasket, Integer> {
}
