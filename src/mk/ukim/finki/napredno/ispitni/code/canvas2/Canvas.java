package mk.ukim.finki.napredno.ispitni.code.canvas2;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

class Canvas {
    private String canvasID;
    private List<Shape> shapes;

    public Canvas(String canvasID) {
        this.canvasID = canvasID;
        shapes = new ArrayList<>();
    }
    void addShape(Shape shape, double maxArea) throws IrregularCanvasException{
        if(shape.getArea() > maxArea){
            throw new IrregularCanvasException(canvasID, maxArea);
        }
        shapes.add(shape);
    }

    int getCircleCount(){
        return (int) shapes.stream().filter(i -> i.getType() == 'C').count();
    }
    int getSquaresCount() {
        return (int) shapes.stream().filter(i -> i.getType() == 'S').count();
    }

    DoubleSummaryStatistics getStatistics(){
        return shapes.stream().collect(Collectors.summarizingDouble(Shape::getArea));
    }

    public String getCanvasID() {
        return canvasID;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
