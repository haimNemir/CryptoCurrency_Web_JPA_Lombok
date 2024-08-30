package CryptoCurrency.Beans;

import CryptoCurrency.Utils.Reliability;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Reliability reliability;
    @OneToMany(mappedBy = "cryptoBasket")
    @JsonIgnore // tell spring, when you send CryptoBasket object with JSON text don't send this list, and like so can we prevent infinity loop when we run this from web(postman). the reason there is an infinity loop is that CryptoBasket calls to "List<CryptoCurrency>" and CryptoCurrency calls for the CryptoBasket from the method toString of "lombok"
    private List<CryptoCurrency> currency;
}
