package mk.ukim.finki.napredno.ispitni.prvkolokvium.canvas2;

import java.io.*;
import java.util.*;

class ShapesApplication {
    private final double MaxArea;
    private final List<Canvas> canvases;

    public ShapesApplication(double MaxArea) {
        canvases = new ArrayList<>();
        this.MaxArea = MaxArea;
    }

    void readCanvases(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        reader.lines().forEach(line -> {
            String[] parts = line.split("\\s+");
            Canvas canvas = new Canvas(parts[0]);
            for (int i = 1; i < parts.length; i += 2) {
                char type = parts[i].charAt(0);
                double size = Double.parseDouble(parts[i + 1]);
                Shape shape = new Shape(type, size);

                try {
                    canvas.addShape(shape, MaxArea);
                } catch (IrregularCanvasException e) {
                    System.out.println(e.getMessage());
                    canvas = null;
                    break;
                }
            }
            if (canvas != null)
                canvases.add(canvas);
        });
    }

    void printCanvases(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);
        canvases.stream()
                .sorted(Comparator.comparingDouble(c -> -c.getStatistics().getSum()))
                .forEach(canvas -> {
                    DoubleSummaryStatistics stats = canvas.getStatistics();
                            pw.printf("%s %d %d %d %.2f %.2f %.2f\n",
                            canvas.getCanvasID(), canvas.getShapes().size(), canvas.getCircleCount(),
                            canvas.getSquaresCount(), stats.getMin(), stats.getMax(), stats.getAverage());
                });
        pw.flush();
    }
}
