Входные данные:
1. CSV файл. 
Назначение столбцов: 
Идентификатор ордера, сумма, валюта, комментарий
Пример записи:
1,100,USD,оплата заказа
Примечание:  все столбцы обязательны
2. JSON файл.
Пример записи:
{“orderId”:1,”amount”:100,”currency”:”USD”,”comment”:”оплата заказа”}
Примечание:  все поля обязательны

Тестовые файлы можно найти в папке src/main/resources/testfiles.

Выходные данные:
{”id”:1, ”amount”:100, ”comment”:”оплата заказа”, "currency": "USD" ”filename”:”orders.csv”, ”line”:1, ”result”:”OK” }

* id - идентификатор ордера  
* amount - сумма ордера  
* comment - комментарий по ордеру  
* currency - валюта суммы ордера  
* filename - имя исходного файла  
* line - номер строки исходного файла  
* result - результат парсинга записи исходного файла.  
* OK - если запись конвертирована корректно, 
или описание ошибки если запись не удалось конвертировать.

Пример команды запуска: "java -jar payment-console-1.0.jar orders1.csv orders2.json"  
(orders1.csv  и orders2.json  файлы для парсинга).