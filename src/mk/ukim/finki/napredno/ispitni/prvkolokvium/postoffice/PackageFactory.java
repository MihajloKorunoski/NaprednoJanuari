package mk.ukim.finki.napredno.ispitni.prvkolokvium.postoffice;

public class PackageFactory {
    public static Package createPackage(String line) throws InvalidPackageException {
        String[] parts = line.split("\\s+");
        String type = parts[0];
        String name = parts[1];
        String address = parts[2];
        int trackingNumber = Integer.parseInt(parts[3]);

        if (type.equals("I")) {
            int weight = Integer.parseInt(parts[4]);
            if (weight <= 0) {
                throw new InvalidPackageException(line);
            }
            String region = parts[5];
            return new InternationalPackage(name, address, trackingNumber, weight, region);
        } else if (type.equals("L")) {
            int weight = Integer.parseInt(parts[4]);
            if (weight <= 0) {
                throw new InvalidPackageException(line);
            }
            boolean priority = Boolean.parseBoolean(parts[5]);
            return new LocalPackage(name, address, trackingNumber, weight, priority);
        } else if (type.equals("G")) {
            return new GroupPackage(name, address, trackingNumber);
        } else {
            throw new InvalidPackageException(line);
        }
    }
}
