package CryptoCurrency.Controller;

import CryptoCurrency.Beans.CryptoCurrency;
import CryptoCurrency.Services_Facade_BL.CryptoCurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//tells to spring web that is belonged to you and can access from chrome
@RequestMapping("CryptoCurrency")
public class CryptoCurrencyController {

    private CryptoCurrencyService cryptoCurrencyService;

    public CryptoCurrencyController(CryptoCurrencyService cryptoCurrencyService) { //auto-inject from spring
        this.cryptoCurrencyService = cryptoCurrencyService;
    }

    @GetMapping// default home page // get: when the client gets info from the server, "Get" can get from URL in chrome.
    public List<CryptoCurrency> getAll() {
        return cryptoCurrencyService.getAllCurrencies();
    }

    @PostMapping("byprice")
    public List<CryptoCurrency> getAllAbovePrice(@PathVariable double minPrice) {
        return cryptoCurrencyService.getAllCurrenciesAbovePrice(minPrice);
    }

    //    @GetMapping("getCurrency")// http://localhost:8080/getCurrency?id=haim ----> calls "Request param"
    @GetMapping("getCurrency/{id}") // http://localhost:8080/getCurrency/haim
    public CryptoCurrency getOne(@PathVariable String id) {// @PathVariable tell that {id} is part of the link and not need to do this "?id=haim"
        return cryptoCurrencyService.getById(id);
    }

    @PostMapping
    // "post" - add info to the DB. can enter in "postman". its default URL for "Post" because there is no more "Post" without URL, like "Get"
    public void addNewCurrency(@RequestBody CryptoCurrency currency, String helloWorldGetFromURL) { // the default is: "@RequestParam", it's mean he will ask for individual parameters. now his ask for an object from the client with a JSON structure, you can do it with "Postman"/Body/raw/JSON: -> {"id":"HHX", "name":"HibridDucks", "price":676484, "marketCap":"6549841128"} . URL: http://localhost:8080
        System.out.println(helloWorldGetFromURL);
        cryptoCurrencyService.addCurrency(currency);
    }

    @DeleteMapping
// Delete - from deleting staff from the DB. Because it's unique in the "Delete" methods, we don't need to give him URL
    public String deleteCurrency(@PathVariable String id) {
        if (cryptoCurrencyService.deleteCurrency(id))
            return "Currency with id: " + id + " deleted successfully!";
        return "Oops, id: " + id + " was not found!";
    }

    @PutMapping //"Put" - update one row
    public void updateCurrency(CryptoCurrency currency) {
        if (cryptoCurrencyService.getById(currency.getId()) != null) {
            cryptoCurrencyService.updateCurrency(currency);
        }
    }

    @PatchMapping //"Patch" - update one item
    public void updateCurrencyByPrice(CryptoCurrency currency) {
        cryptoCurrencyService.updateCurrencyPrice(currency);
    }


//    <dependency> // for documentation(תיעוד) on our web server, how to get all info from witch URL. This dependency can't get from Spring initializer, only menially entering to "POM" document, after that you enter chrome and enter this URL: http://localhost:8080/swagger-ui.html and you will get the documentation. Delete we don't give access to the hole world, we will add a password, Or with @Hidden annotation above the class CryptoController, you can hide it.
//			<groupId>org.springdoc</groupId>
//			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
//			<version>2.3.0</version>
//	  </dependency>
//  {
//    @JoinColumn(name = "Projects") = with this annotation you can change the name for column in bean package when this parameter is object of @ManyToOne
//    @ManyToOne
//    private Project project;
//  }
}
