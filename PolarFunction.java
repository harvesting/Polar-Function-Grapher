import java.util.*;
import gpdraw.*;

public class PolarFunction {

	private DrawingTool marker;
	private SketchPad paper;
	private ArrayList <Double> numR;
	private ArrayList <Double> numTheta;
	private ArrayList <Double> rectX;
	private ArrayList <Double> rectY;
    
	public PolarFunction() {
        
		paper = new SketchPad(400, 400);
		marker = new DrawingTool(paper);
		numR = new ArrayList <Double>();
		numTheta = new ArrayList <Double>();
		rectX = new ArrayList <Double>();
		rectY = new ArrayList <Double>();

	}

	public void polarValues() {

		for (double x = 0; x <= Math.PI * 200; x += .1) {

			numTheta.add(x);
            //equation goes after 100; ex. sin(2.5theta)
			numR.add(100 * Math.sin(2.5 * (x)));
		}
	}

	//x = r * cos theta, y = r * sin theta

	public void rectValues() {

		for (int x = 0; x < numR.size(); x++) {

			rectX.add(numR.get(x) * Math.cos(numTheta.get(x)));
			rectY.add(numR.get(x) * Math.sin(numTheta.get(x)));
		}
	}

	public void graph() {

		marker.up();
		marker.move(rectX.get(0), rectY.get(0));
		marker.down();

		for (int x = 0; x < rectX.size(); x++) {

			double coordX = rectX.get(x);
			double coordY = rectY.get(x);
			marker.move(coordX, coordY);

			}
			marker.move(0,0);
	}
    
    public static void main(String[] args) {
        
        PolarFunction test = new PolarFunction();
        test.polarValues();
        test.rectValues();
        test.graph();
        
    }
    
}
