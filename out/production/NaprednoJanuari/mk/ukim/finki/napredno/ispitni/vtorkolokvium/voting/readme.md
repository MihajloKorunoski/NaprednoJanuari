# Резултати од Избори
За организирање на изборниот процес на парламентарни избори потребно е да имплементирате апликација за внесување на резултатите од избирачките места која ќе има и функционалност да го пресмета бројот на освоени пратеници по изборни единици. Изборите се организирани во рамки на неколку изборни единици (пример 6 во Македонија). Секоја изборна единица има избирачки места во кои граѓаните гласаат. По завршувањето на изборите, од секоја изборна единица се доделуваат ист број на мандати (по 20 пратеници од секоја изборна единица во Македонија).

За таа цел потребно е да се имплементираат следните класи:

1. `VotesController` - класа која би ја користеле членовите на избирачките места за да ги внесуваат гласовите по партии од нивните избирачки места. За класата да се дефинираат следните методи:

   * `VotesController(List<String> parties, Map<String, Integer> unitPerPoll)` - конструктор со два аргументи: листа од политичките партии регистрирани за учество на изборите и мапа во која клуч е ИД на избирачко место, а вредност е бројот на изборната единица од која е дел соодветното избирачко место.

   * `void addElectionUnit (ElectionUnit electionUnit)` - метод за додавање на избирачка единица во контролерот.

   * `void addVotes(String pollId, String party, int votes)` - метод за додавање на гласови `votes` за политичката партија party од избирачкото место `pollId`. 
     * Методот да фрли исклучок од тип `InvalidVotesException` доколку партијата не е регистрирана за учество на изборите.

2. Класа `ElectionUnit` за репрезентација на избирачка единица. За класата да се имплементираат:

   * `ElectionUnit (int unit, Map<String, Integer> votersByPoll)` - конструктор со два аргументи: редниот број на изборната единица и мапа во која клуч е ИД на избирачко место, а вредност е бројот на запишани избирачи во тоа избирачко место.

   * `void addVotes(String pollId, String party, int votes)` - метод за додавање на гласови votes за политичката партија party од избирачкото место `pollId`.

   * `void subscribe(Subscriber subscriber)` - метод за претплатување на набљудувач на изборните резултати од оваа изборна единица

   * `void unsubscribe(Subscriber subscriber)` - метод за прекинување на претлатата на набљудувачот subscriber.

3. Интерфејс `Subscriber` со еден метод
   * `void updateVotes(int unit, String pollId, String party, int votes, int totalVotersPerPoll, int totalVotersPerUnit)` - метод за ажурирање на гласовите во набљудувачот со информации за бројот на избирачката единица, ИД на избирачкото место, политичката партија, гласовите за политичката партија, вкупниот број на гласачи во избирачкото место и вкупниот број на гласачи во изборната единица.

4. Класа `VotersTurnoutApp` претставува еден тип на набљудувач на изборните единици која пресметува статистики за излезеноста на гласачите по изборни единици. Во класата треба да се имплементира методот:
   * `printStatistics()` - кој ги печати статистиките за излезност во следниот формат: `Unit: Casted: Voters: Turnout:`. Точниот формат е: `%5d %7d %7d %7.2f“`.

5. Класа `SeatsApp` претставува друг тип на набљудувач на изборните единици која ги пресметува броевите на пратеничките места кои партиите ги освоиле по изборна единица, како и вкупниот број на пратеници во изборните единици кои ги наблудува. Во класата треба да се имплементира методот:
   * `void printStatistics()` - кој ги печати статистиките за освоени пратенички места во следниот формат: `Party Votes %Votes Seats %Seats` каде што `Party` е името на партијата, `Votes` претставува број на гласови на национално ниво (во сите единици), а `Seats` претставува бројот на освоени пратенички мандати на национално ниво. Политичките партии да се сортирани според бројот на освоени гласови на национално ниво во опаѓачки редослед. Точниот формат на печатење е : `%10s %5d %7.2f%% %5d %7.2f%%`

Пресметката на мандати во рамки на една изборна единица се прави по методот прикажан на сликата подолу. Најпрво се пресметува колку гласови се потребни за еден пратенички мандат (ако бројот на мандати по изборна единица е 20): 1800 гласови / 20 мандати - 90 гласа/мандат. Потоа гласовите на партиите се делат (целобројно) со потребните гласови за мандат (во примерот 90) И количникот го означува бројот на освоени мандати на таа партија. Неподелените мандати (во примерот 1 мандат, 19 поделени од вкупно 20 предвидени) се доделуваат на партијата која има освоено најмногу гласови (партијата А добива вкупно 12 мандати).