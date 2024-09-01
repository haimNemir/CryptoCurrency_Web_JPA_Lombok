package CryptoCurrency.Repositories_DAL;

import CryptoCurrency.Beans.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // +not need this annotation, because it extends it from JpaRepository+
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, String> {
    List<CryptoCurrency> findByPriceGreaterThan(Double minPrice); //+ spring understood from List<> that we ask Array and no single object. and we not need to name it findAll...
}
