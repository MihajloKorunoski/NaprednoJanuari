# Pizza1
Да се имплементира апликација за примање на нарачки за пици PizzaReceipts. За класата да се имплементираат следните методи:

* Конструктор `PizzaReceipts ()`
* `void readOrders (InputStream is)` метод за вчитување на нарачките за пица од влезен поток. Секоја нарачка е во нов ред и е претставена во следниот формат: <br> `user pizzaBaser;ing1;ing2;ing3;ing4;ing5;ing6`<br>`Uѕer` претставува име на корисникот што ја нарачал пицата. `pizzaBase` претставува основата на пицата и истата може да биде `whiteSauce` или `redSauce`. Секоја пица може да има од 0 до 6 додатоци (преставени преку `ing1,`...`,ing6`). Додатоците може да бидат од тип `pepperoni`, `mushrooms` и `mozzarella`. Во една пица може да има најмногу 2 исти додатоци. <br>Да се фрли исклучок од тип `InvalidPizzaOrder` доколку пицата има повеќе од 6 додатоци или некој додаток е наведен повеќе од 2 пати. Со исклучокот да се справите на соодветното место така што нема да се додаде таа пица во системот, но исто така нема да се попречи додавањето на останатите пици.
* `void printRevenueByUser (OutputStream os)` - метод кој ќе испечати на излезен поток колку промет остварила пицеријата од сите корисници во формат<br>`user orders_count orders_price_averages$ total_revenue_from_users$`.<br> Информациите да се сортирани во опаѓачки редослед според просечната цена на нарачаните пици од корисникот. На крај да се испечати и вкупниот промет.
* `void printUserOrders (OutputStream os, String user)` - метод кој ќе ги испечати на излезен поток сите нарачани пици на корисникот `user`, сортирани во опаѓачки редослед според цената на пицата.
* `Map<String, Integer> usersByPizzaIngredient (String ingredient)` - метод којшто ќе врати мапа во која клучот е името на корисникот, а вредноста е бројот колку пати корисникот нарачал пица која ја содржи состојката ingredient барем еднаш.
  Цената на пицата се пресметува како сума на основата на пицата и сите состојки. Ценовникот на пицеријата е даден на сликата подолу.<br>

***Решенијата кои нема да користат полиморфизам и соодветен шаблон за дизајн на софтвер ќе бидат оценети со најмногу 60% од предвидените поени.*** <br>

![Screenshot 2023-09-01 230145](https://github.com/reisuzuya1337/NaprednoJanuari/assets/73530521/9520c495-e480-4f7b-98ec-7a23245e09c8)