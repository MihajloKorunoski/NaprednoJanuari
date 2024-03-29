# Сензори-дел2 (45 поени)
Да се имплементира (апликација) класа за `GeoSensorApplicaiton` за читање на сензорски мерења. Класата треба да ги имплементира следните методи:

`public void readGeoSensors(Scanner scanner) throws BadSensorException, BadMeasureException`
за читање на сензорските мерења. Сензорските податоци се запишани во следниот формат:

`sensorId sensorLatitude sensorLongitude timestamp1:value1 timestamp2:value2 ...`

`public List<Sensor> inRange(IGeo location, double distance)`
за филтрирање на сите сензори кои се наоѓаат во радиус од distance метри од локацијата location. Објектот location е инстанциран од класа која го имплементира IGeo интерфејсот со две методи:
`double getLatitude()
double getLongitude()`

`public double averageValue()`
ја враќа средната вредност од пресметаните средни вредности за сите измерени вредности на сензорите.

`public double averageDistanceValue(IGeo location, double distance, long timeFrom, long timeTo)`
ја враќа средната вредност од пресметаните средни вредности за сите измерени вредности на сензорите што се направени во временскиот период од `timeFrom` до `timeTo` (`{timeFrom, timeTo}`) на растојание `distance` од локацијата `location`. Сите сензори кои немаат измерени вредности во периодот од `timeFrom` до `timeTo` (`{timeFrom, timeTo}`)  не влегуваат во пресметката за средна вредност

`public List<ExtremeValue> extremeValues(long timeFrom, longtime To)`
ги враќа екстремните прочитани вредности (минимална и максимална вредност, заедно со `sensorID`) што се направени во временскиот период од `timeFrom` до `timeTo` (`{timeFrom, timeTo}`)

Дополнително, доколку при читањето на измерените сензорски вредности се прочита негативна вредност, потребно е да биде фрлен исклучок од класата `BadMeasureException` во кој ќе се пренесе информација за сензорот и временскиот момент на погрешно внесената вредност. Исто така потребно е да биде генериран и исклучок од класата `BadSensorException` доколку за сензорот не е запишана ниту една вредност (да се пренесе информација за сензорот за кој не се внесени вредности).

Треба да се користи предефинираната имплементација на `toString` методот за сите класи и листи (внимавајте само на имињата на променливите на инстанца)
