package ru.zuma.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zuma.rest.model.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class ProductsController {

    @RequestMapping(value = "/products/hits", method = RequestMethod.GET)
    public ResponseEntity<StoresOffers> getHits(@RequestParam("category") String category, HttpServletResponse response) {
        List<Offer> offerList = new ArrayList<>();

        Shop shop = new Shop(
                1,
                "Test_shop_name",
                "Test_shop_description",
                "Test_shop_metro",
                "Test_shop_address",
                29
        );
        switch (category) {
            case "technics":
                HashMap<String, String> characteristics = new HashMap<>();
                characteristics.put("Тип устройства", "Смартфон");
                characteristics.put("Тип ОС", "IOS 11");
                characteristics.put("SIM-карты", "nano SIM");
                characteristics.put("Тип корпуса", "Стекло");
                characteristics.put("Срок гаранитии", "1 год");
                characteristics.put("Производитель", "Apple");
                offerList.add(new Offer(
                        1,
                        61_190,
                        false,
                        shop,
                        new Product(
                                1,
                                category,
                                "MacBook Air 13 MQD32RU/A 8GB",
                                4,
                                false,
                                1,
                                characteristics
                        )
                ));
                offerList.add(new Offer(
                        1,
                        61_190,
                        false,
                        shop,
                        new Product(
                                1,
                                category,
                                "MacBook Air 13 MQD32RU/A 8GB",
                                4,
                                false,
                                1,
                                characteristics
                        )
                ));
                offerList.add(new Offer(
                        1,
                        61_190,
                        false,
                        shop,
                        new Product(
                                1,
                                category,
                                "MacBook Air 13 MQD32RU/A 8GB",
                                3,
                                false,
                                2,
                                characteristics
                        )
                ));
                break;
            case "cosmetics":
                offerList.add(new Offer(
                        1,
                        61_190,
                        false,
                        shop,
                        new Product(
                                1,
                                category,
                                "Помада для губ `ARTDECO` PERFECT COLOR тон 834 увлажняющая",
                                5,
                                false,
                                3
                        )
                ));
                offerList.add(new Offer(
                        1,
                        61_190,
                        false,
                        shop,
                        new Product(
                                1,
                                category,
                                "Гель-лак для ногтей `VIVIENNE SABO` NAIL ATELIER тон 125 12 мл",
                                2,
                                false,
                                4
                        )
                ));
                break;
//            case "sports":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Eastern LOWDOWN 20\"",
//                        15300,
//                        0,
//                        false,
//                        5
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Сноуборд Nidecker \"Play\". Ростовка 159 см",
//                        16390,
//                        0,
//                        false,
//                        6
//                ));
//                break;
//            case "home_products":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Кофр для хранения обуви Valiant TRAVELLING, 6 секций, 60*40*12см",
//                        690,
//                        0,
//                        false,
//                        7
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Стремянка СИБИН 38803-04",
//                        1150,
//                        5,
//                        false,
//                        8
//                ));
//                break;
//            case "pet_supplies":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Удочка-дразнилка Triol C4012 Зеленые перья 100/500мм",
//                        120,
//                        5,
//                        false,
//                        9
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Аквариум AQUAEL Cup бокал, 10л",
//                        1390,
//                        0,
//                        false,
//                        10
//                ));
//                break;
//            case "entertainment":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Настольная игра Дженга HASBRO классическая обновленная",
//                        1049,
//                        5,
//                        false,
//                        11
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Игра HASBRO Твистер 2",
//                        1350,
//                        1,
//                        false,
//                        12
//                ));
//                break;
//            case "clothes":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "футболка Celio",
//                        1049,
//                        5,
//                        false,
//                        13
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "свитшот oodji",
//                        599,
//                        1,
//                        false,
//                        14
//                ));
//                break;
//            case "books":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Путеводитель для влюбленных в математику",
//                        504,
//                        0,
//                        false,
//                        15
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Что бы сказал Фрейд? Как великие психотерапевты решили бы ваши проблемы",
//                        504,
//                        0,
//                        false,
//                        16
//                ));
//                break;
//            case "plants":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Суккулент микс в упаковке D5",
//                        99,
//                        0,
//                        false,
//                        17
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Буксус (Самшит)",
//                        180,
//                        0,
//                        false,
//                        18
//                ));
//                break;
//            case "car_products":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Мопед АЛЬФА 4Т 50 куб.см., 3 л.с.",
//                        43000,
//                        4,
//                        false,
//                        19
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Мотоцикл Bajaj Boxer BM 150 X.",
//                        84900,
//                        4,
//                        false,
//                        20
//                ));
//                break;
//            case "child_products":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Детский матрас-кровать Intex 107*168*25см 3-8 лет (с насосом)",
//                        2380,
//                        5,
//                        false,
//                        21
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Кроватка Агат Золушка-5 автостенка, маятник продольного качания, цвет Белый",
//                        3490,
//                        4,
//                        false,
//                        22
//                ));
//                break;
//            case "stationery":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Корректор-лента (20 м х 5 мм) (EH20301)",
//                        107,
//                        0,
//                        false,
//                        23
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Ножницы \"Neon\", 135мм, в ассортименте (ED60300)",
//                        168,
//                        0,
//                        false,
//                        24
//                ));
//                break;
//            case "medicine_products":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Гематоген Витатека с кокосом в шоколадной глазури 40г",
//                        20,
//                        0,
//                        false,
//                        25
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Бинт эластичный УНГА-ВР 8х150см с застежкой \"велкро\"",
//                        75,
//                        0,
//                        false,
//                        26
//                ));
//                break;
//            case "jewelry":
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "Золотое кольцо с бриллиантом и танзанитом SOKOLOV 6014052",
//                        16398,
//                        5,
//                        false,
//                        27
//                ));
//                offerList.add(new Product(
//                        1,
//                        category,
//                        "770096 Колье",
//                        36723,
//                        5,
//                        false,
//                        28
//                ));
//                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StoresOffers(offerList), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/offers", method = RequestMethod.GET)
    public ResponseEntity<StoresOffers> getOffersById(@RequestParam("id") Long id) {
        List<Offer> offersList = new ArrayList<>();
        offersList.add(new Offer(
            2, 74_230f, true,
            new Shop(
                2,
                null,
                null,
                "Бауманская",
                "Москва, Пресненская\nнабережная дом 2",
                29
            ),
            new Product(
                1,
                "Test_category",
                "Гель-лак для ногтей `VIVIENNE SABO` NAIL ATELIER тон 125 12 мл",
                2,
                false,
                4
            )
        ));
        StoresOffers storesOffers = new StoresOffers(offersList);
        return new ResponseEntity<>(storesOffers, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/shoppingcart", method = RequestMethod.GET)
    public ResponseEntity<StoresOffers> getOffersById() {
        List<Offer> offerList = new ArrayList<>();

        Shop shop = new Shop(
                1,
                "Test_shop_name",
                "Test_shop_description",
                "Test_shop_metro",
                "Test_shop_address",
                29
        );

        offerList.add(new Offer(
                1,
                61_190,
                false,
                shop,
                new Product(
                        1,
                        "technics",
                        "MacBook Air 13 MQD32RU/A 8GB",
                        4,
                        false,
                        1
                )
        ));
        offerList.add(new Offer(
                1,
                61_190,
                false,
                shop,
                new Product(
                        1,
                        "technics",
                        "MacBook Air 13 MQD32RU/A 8GB",
                        4,
                        false,
                        1
                )
        ));
        offerList.add(new Offer(
                1,
                61_190,
                false,
                shop,
                new Product(
                        1,
                        "technics",
                        "MacBook Air 13 MQD32RU/A 8GB",
                        3,
                        false,
                        2
                )
        ));

        StoresOffers storesOffers = new StoresOffers(offerList);
        return new ResponseEntity<>(storesOffers, HttpStatus.OK);
    }
}
