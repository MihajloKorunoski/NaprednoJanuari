package mk.ukim.finki.napredno.ispitni.vtorkolokvium.audition;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Audition {

    Map<String, Map<String, Participant>> participantsByCity;
    Comparator<Participant> comparator = Comparator.comparing(Participant::getName)
            .thenComparing(Participant::getAge);

    public Audition() {
        participantsByCity = new HashMap<>();
    }

    public void addParticipant(String city, String code, String name, int age) {
        Participant participant = new Participant(city, code, name, age);

        participantsByCity.putIfAbsent(city, new HashMap<>());
        participantsByCity.get(city).putIfAbsent(code, participant);
    }

    public void listByCity(String city) {
        participantsByCity.get(city)
                .values()
                .stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
