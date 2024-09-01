package CryptoCurrency.Beans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

//@Table(name = "crypto_currency")//The same name the JPA will give him in the DB. only for remind.+
@Entity
@Component//telling spring to create new object with getBean...+
@Data // for lombok to create getters setters and toString+
@NoArgsConstructor// for JPA to let him create new empty object and then inject him parameters.+
@AllArgsConstructor//cant auto increment id because its String so he needs to enter this menially+
public class CryptoCurrency {
//    @GeneratedValue(strategy = GenerationType.IDENTITY) --- not work with String.+
    @Id
    @Setter(AccessLevel.PRIVATE)//tell that set id have a private access+
    @Column(length = 4)
    private String id;
    private String name;
    private double price;
    private long marketCap;
    @JoinColumn(name = "Baskets") // +with this annotation you can change the name for column in bean package when this parameter is object of @ManyToOne
    @ManyToOne
    private CryptoBasket cryptoBasket;

    @Override // override lombok toString !!!!!!!!!!!!!!!!!!!!!!!!!+
    public String toString() {
        return "CryptoCurrency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", marketCup=" + marketCap +
                '}';
    }
}

