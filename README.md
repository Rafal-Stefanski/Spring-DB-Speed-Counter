## Spring DataBase Speed Counter :stopwatch:
<img align="right" src="https://badges.pufler.dev/visits/Rafal-Stefanski/Spring-DB-Speed-Counter">
##### Used:
- MySQL, Hibernate, MongoDB, 
- AOP for time measure, 
- generated CSV test file from https://www.mockaroo.com/

##### Configuration in application.properties:
- DataBase, configured for local MySQL DB and MongoDB.

***
#### Task
- [X] Wczytaj do aplikacji 1000 obiektów. Stwórz metodę, która będzie zapisywała wszystkie elementy do lokalnej bazy danych.
  Stwórz aspekt, który będzie nasłuchiwać metodę i w momencie startu włączy licznik startu, a po zakończeniu operacji odczytanie zostanie czas wykonania operacji.
  Zrób do samo dla operacji wczytywania danych z bazy danych (bez wyświetlania ich, bo to może spowodować przekłamanie wyniku). Odnotuj wynik odczytu.
  Zrealizuj to dla relacyjnej bazy danych i nierelacyjnej bazy danych.
***
##### Results
![screen shot](https://github.com/Rafal-Stefanski/Spring-DB-Speed-Counter/blob/master/src/main/resources/static/screenshot_01.png)
![screen shot](https://github.com/Rafal-Stefanski/Spring-DB-Speed-Counter/blob/master/src/main/resources/static/screenshot_02.png)
