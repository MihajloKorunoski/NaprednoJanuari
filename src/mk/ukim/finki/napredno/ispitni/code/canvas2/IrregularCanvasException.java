package mk.ukim.finki.napredno.ispitni.code.canvas2;

class IrregularCanvasException extends Exception {
    IrregularCanvasException(String canvasId, double maxArea) {
        super(String.format("Canvas %s has a shape with area larger than %.2f", canvasId, maxArea));
    }
}
