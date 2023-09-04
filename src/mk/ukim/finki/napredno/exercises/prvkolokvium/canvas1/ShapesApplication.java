package mk.ukim.finki.napredno.exercises.prvkolokvium.canvas1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ShapesApplication {
    List<Canvas> canvases;

    public ShapesApplication() {
        canvases = new ArrayList<>();
    }

    int readCanvases(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        canvases = reader.lines()
                .map(line -> {
                    String[] parts = line.split(" ");
                    List<Integer> squares = Arrays.stream(parts, 1, parts.length)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    return new Canvas(parts[0], squares);
                })
                .collect(Collectors.toList());
        return canvases.stream().mapToInt(Canvas::getSquaresCount).sum();
    }

    void printLargestCanvasTo(OutputStream outputStream) {
        Canvas largestCanvas = canvases.stream()
                .max(Comparator.comparingInt(Canvas::getTotalPerimeter))
                .orElse(null);

        if (largestCanvas != null) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
            pw.printf("%s %d %d\n", largestCanvas.canvasID,
                    largestCanvas.getSquaresCount(),
                    largestCanvas.getTotalPerimeter());
            pw.flush();

        }
    }
}
