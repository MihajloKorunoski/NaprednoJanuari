package mk.ukim.finki.napredno.exercises.ispitni.stopcorona;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class StopCoronaApp {
    Map<String, User> userByIdMap;
    Map<User, Map<User, Integer>> countingMapForNearContacts;

    public StopCoronaApp() {
        userByIdMap = new HashMap<>();
        countingMapForNearContacts = new TreeMap<>(Comparator.comparing(User::getTimeInfected)
                .thenComparing(User::getId));
    }

    public void addUser(String name, String id) throws UserAlreadyExistException {
        if (userByIdMap.containsKey(id))
            throw new UserAlreadyExistException(id);
        userByIdMap.put(id, new User(name, id));
    }

    public void addLocations(String id, List<ILocation> iLocations) {
        userByIdMap.get(id).addLocation(iLocations);
    }

    public void detectNewCase(String id, LocalDateTime timestamp) {
        User infected = userByIdMap.get(id);
        infected.setInfected(true);
        infected.setTimeInfected(timestamp);
    }

    private void countContacts() {
        for (User user : userByIdMap.values())
            for (User user2 : userByIdMap.values())
                if (!user.equals(user2)) {
                    int count = LocationUtils.dangerContactsBetween(user, user2);
                    if (count > 0)
                        countingMapForNearContacts.computeIfAbsent(user, k -> new TreeMap<>(Comparator.comparing(User::getTimeInfected)
                                        .thenComparing(User::getId)))
                                .merge(user2, count, Integer::sum);
                }

    }

    public Map<User, Integer> getDirectContacts(User u) {
        return countingMapForNearContacts.get(u)
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    private Collection<User> getIndirectContacts(User u) {
        Set<User> indirectContacts = new TreeSet<>(Comparator.comparing(User::getName)
                .thenComparing(User::getId));
        Map<User, Integer> directContact = getDirectContacts(u);
        directContact.keySet().stream()
                .flatMap(user -> getDirectContacts(user).keySet().stream())
                .filter(user -> !indirectContacts.contains(user)&&!directContact.containsKey(user)&&!user.equals(u))
                .forEach(indirectContacts::add);
        return indirectContacts;
    }


    public void createReport() {
        countContacts();

        List<Integer> directContactsCount = new ArrayList<>();
        List<Integer> indirectContactsCount = new ArrayList<>();

        for(User infectedUser : countingMapForNearContacts.keySet())
            if(infectedUser.isInfected()){
                System.out.println(infectedUser.userComplete());

                System.out.println("Direct contacts:");
                Map<User,Integer> directContacts = getDirectContacts(infectedUser);
                directContacts.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEach(entry -> System.out.printf("%s %d\n",entry.getKey().userHidden(), entry.getValue()));
                int directCount = directContacts.values().stream().mapToInt(Integer::intValue).sum();
                System.out.printf("Count of direct contacts: %d%n", directCount);
                directContactsCount.add(directCount);

                Collection<User> indirectContacts = getIndirectContacts(infectedUser);
                System.out.println("Indirect contacts: ");
                indirectContacts.forEach(user -> System.out.println(user.userHidden()));
                System.out.printf("Count of indirect contacts: %d%n",indirectContacts.size());
                indirectContactsCount.add(indirectContacts.size());
            }
        System.out.printf("Average direct contacts: %.4f\n",directContactsCount.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0));
        System.out.printf("Average indirect contacts: %.4f", indirectContactsCount.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0));
    }
}
