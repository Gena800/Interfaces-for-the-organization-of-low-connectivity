# Задание 1. Поиск билетов (обязательное к выполнению)

Вы работаете в сервисе по продаже авиабилетов онлайн.

![image](https://user-images.githubusercontent.com/53707586/154491051-0bc17b53-cf07-4502-80c0-6379e1a89b92.png)

Что вам нужно сделать:
1. Спроектируйте класс для информации о билете.
1. Реализуйте репозиторий для хранения информации о билетах: добавить, удалить, получить набор билетов.
1. Реализуйте менеджера поиска по аэропорту вылета и аэропорту прилёта, даты не учитывайте.

#### Информация о билете

Класс информации о билете — это data-класс, который должен содержать:
1. ID.
1. Стоимость, для упрощения будем считать стоимость единой для всех продавцов.
1. Аэропорт вылета, вы можете использовать [IATA-коды](https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%B4_%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82%D0%B0_%D0%98%D0%90%D0%A2%D0%90).
1. Аэропорт прилёта, вы можете использовать [IATA-коды](https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%B4_%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82%D0%B0_%D0%98%D0%90%D0%A2%D0%90).
1. Время в пути в минутах.

Других данных не нужно.

Этот класс должен реализовывать интерфейс `Comparable<...>` так, чтобы по умолчанию сортировка происходила по цене, самый дешёвый — самый первый. Для этого шапка вашего дата-класса должна выглядеть как-то так:
```java
public class Ticket implements Comparable<Ticket> {
```

После чего идея подсветит вам её красным, нажмите на подсказку и выберите «Implement methods» — «Реализовать методы». Идея сама сгенерирует заглушку для нужного метода из этого интерфейса, которая всегда возвращает `0`. Вам надо переписать тело сгенерированного метода, чтобы если билет, у которого вызвали метод `compareTo`, стоит дешевле, чем тот, который передали через параметр, то возвращалось бы число меньше нуля. Если же билет, наоборот, дороже, то число больше нуля, а если стоимость одинакова, то `0`. Дав верную реализацию этому методу, вы научите Java сравнивать объекты этого класса.

#### Репозиторий

Репозиторий для хранения билетов ничем не отличается от тех репозиториев, что мы проходили раньше.

### Менеджер

В менеджере методов `findAll` должен претерпеть некоторые изменения — он должен принимать два параметра:
* `from` — аэропорта вылета,
* `to` —  аэропорт прилёта.

Значит, в результате поиска возвращается массив только с теми билетами, что соответствуют условиям поиска. Методы поиска вы уже делать умеете.

Кроме того, результаты должны быть отсортированы по цене от меньшей к большей.

### Автотесты

Напишите автотесты на поиск, удостоверившись, что он удовлетворяет условиям задачи. Количество тестов и тестируемые сценарии мы оставляем на ваше усмотрение.

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код и автотесты к нему, GitHub Actions и т. д. — всё как обычно.

Отправьте на проверку ссылку на репозиторий GitHub с вашим проектом. 

# Задание 2*. Самый быстрый (необязательная задача)

Иногда необходима сортировка не только по цене, но и, например, по времени — люди хотят найти самый быстрый перелёт.

Естественно, ваш сервис идёт навстречу пожеланиям клиентов и решает добавить такую возможность.

Но как мы это сделаем, ведь наши билеты уже сортируются по цене.

### `Comparator`

Помимо интерфейса `Comparable`, который определяет порядок сортировки объектов данного класса по умолчанию, у нас есть интерфейс `Comparator`, который позволяет создавать объекты, определяющие порядок сортировки других объектов.

Как это выглядит, мы покажем на примере сортировки по цене по возрастанию — аналог, который реализован вами в первой задаче:

```java
public class TicketByPriceAscComparator implements Comparator<Ticket> {
  public int compare(Ticket o1, Ticket o2) {
    return o1.getPrice() - o2.getPrice();
  }
}
```

Обратите внимание: это отдельный специальный класс, который умеет сравнивать два объекта типа «Билет».

Логика интерпретации возвращаемого из метода `compare` значения аналогична логике `compareTo`.

В отдельной ветке `fast` того же репозитория улучшите сервис, создав метод `findAll(String from, String to, Comparator<Ticket> comparator)`.

Этот метод делает всё то же самое, что и обычный `findAll` из первой задачи, но сортирует не методом `Arrays.sort(result)`, а `Arrays.sort(result, comparator)`.

Таким образом, вы сможете передавать в этот метод объект любого класса, реализующего интерфейс `Comparator<Ticket>`.

Итого: у вас должен быть репозиторий на GitHub, в котором в отдельной ветке расположен ваш компаратор, сервис с новыми методами и автотесты к сервису.

Если автотесты в ветке проходят — делаете Pull Request на слияние в основную ветку. Сливать не нужно.

### Результат
При отправке решения в личном кабинете прикрепите ссылку на ваш публичный репозиторий GitHub с вашим проектом.
