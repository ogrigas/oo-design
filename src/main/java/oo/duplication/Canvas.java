package oo.duplication;

public class Canvas {
    
    public static final int SOLID_STROKE = 0;
    public static final int DOTTED_STROKE = 1;
    public static final int DASHED_STROKE = 2;
    
    public void draw(Line line, int stroke) {
        switch (stroke) {
            case SOLID_STROKE:  drawSolidLine(line); break;
            case DOTTED_STROKE: drawDottedLine(line); break;
            case DASHED_STROKE: drawDashedLine(line); break;
        }
    }

    private void drawSolidLine(Line line) {
        // drawing omitted
    }

    private void drawDottedLine(Line line) {
        // drawing omitted
    }

    private void drawDashedLine(Line line) {
        // drawing omitted
    }
}
