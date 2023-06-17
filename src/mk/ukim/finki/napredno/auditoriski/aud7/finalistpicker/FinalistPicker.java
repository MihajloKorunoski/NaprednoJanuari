package mk.ukim.finki.napredno.auditoriski.aud7.finalistpicker;

import java.util.*;

class FinalistPicker {

    private int finalists;
    private int solveMethod;
    static Random RANDOM = new Random();

    public FinalistPicker(int finalists, int solveMethod) {
        this.finalists = finalists;
        this.solveMethod = solveMethod;

    }

    public Collection<Integer> pick(int prizes) throws InvalidArgumentException {
        if (prizes <= 0) {
            throw new InvalidArgumentException("Invalid number of prizes: "
                    + prizes
                    + ". The number of prizes must be a non-negative value.");
        }
        if (prizes > finalists) {
            throw new IllegalArgumentException(String.format("Unable to distribute %d prizes among %d finalists. " +
                            "Ensure that the number of finalists is not zero.",
                    prizes,
                    finalists));

        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();

        switch (solveMethod) {
            case 1 -> {
                while (result.size() != prizes) {
                    int pick = RANDOM.nextInt(finalists) + 1;
                    if (!result.contains(pick))
                        result.add(pick);
                }
                return result;
            }
            case 2 -> {
                result = RANDOM.ints(1, finalists + 1)
                        .distinct()
                        .limit(prizes)
                        .peek(resultSet::add)
                        .boxed()
                        .toList();
                return result;
            }
            default -> {
                while (resultSet.size() != prizes) {
                    resultSet.add(RANDOM.nextInt(finalists) + 1);
                }
                return resultSet;
            }
        }

    }
}
