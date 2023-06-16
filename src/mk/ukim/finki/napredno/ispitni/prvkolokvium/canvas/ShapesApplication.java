package mk.ukim.finki.napredno.ispitni.prvkolokvium.canvas;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ShapesApplication {

    List<Canvas> canvases;
    public void printLargestCanvasTo(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);

        Canvas max = canvases.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
        pw.println(max);

        pw.flush();
    }

    public int readCanvases(InputStream in) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        canvases = bufferedReader.lines()
                .map(Canvas::createCanvas)
                .collect(Collectors.toList());

        return canvases.stream()
                .mapToInt(canvas ->  canvas.squares.size())
                .sum();
    }
}
