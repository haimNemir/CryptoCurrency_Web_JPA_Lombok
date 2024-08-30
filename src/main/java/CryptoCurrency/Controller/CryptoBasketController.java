package CryptoCurrency.Controller;

import CryptoCurrency.Services_Facade_BL.CryptoBasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("CryptoBasket")
public class CryptoBasketController {
    private CryptoBasketService service;

    public CryptoBasketController(CryptoBasketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getOneBasket(int id) { // ResponseEntity return 2 parameters: 1> the object, 2> the STATUS like 404 ext. Here we are not defining the Type of parameter this method returns, we check if: "ResponseEntity.ok" this means the status is 200 return basket, else we return "body"(String) and status 404(NOT_FOUND)
        try{
            return ResponseEntity.ok(service.getOneBasket(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
