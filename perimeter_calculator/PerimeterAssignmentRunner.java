import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numpoints = 0;
        for (Point currPt : s.getPoints()) {
            numpoints++;
        }
    
        return numpoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int numPoints = getNumPoints (s);
        double length = getPerimeter(s);
        double avg = length/numPoints;
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist >= max){
                max = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double max = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // Update totalPerim by currDist
            if(currX >= max){
                max = currX;
            }
            // Update prevPt to be currPt
        
        }
        return max;
        
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code
        double max= 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double Currperi = getPerimeter (s);
            if(Currperi >= max){
                max = Currperi;
            }
           
           
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double max= 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double Currperi = getPerimeter (s);
            if(Currperi >= max){
                max = Currperi;
                temp = f;
            }
           
           
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints (s);
        System.out.println("perimeter = " + length);
        System.out.println("no. of points = " + numPoints);
        System.out.println("the average length of a side in your shape is "+getAverageLength(s));
        System.out.println("the largest length of a side in your shape is "+getLargestSide(s));
        System.out.println("the largest X of points in your shape is "+getLargestX(s));
        
    }
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with largest perimeter shape= " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
