package projectOOp;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner Sca = null;

        try {
            File file = new File("C:/Users/ahmed/OneDrive/Desktop/project/Input.txt");

            Sca = new Scanner(file);

            if(!Sca.hasNextDouble()){  
                writeError("Missing or invalid number of objects");
                return;
            }

            double numDouble = Sca.nextDouble();
            int num = (int) numDouble;

            if (num <= 0) {  
                writeError("Number must be positive");
                return;
            }

            if (num < 2) {
                writeError("Number of objects must be >= 2");
                return;
            }

            Drawable[] ar = new Drawable[num];

            double sum = 0;
            double length;
            String type;

            boolean hasError = false; 

            for (int i = 0; i < ar.length; i++) {

                if(!Sca.hasNext()){ 
                    hasError = true;
                    break;
                }

                type = Sca.next();

                if(!Sca.hasNextDouble()){
                    hasError = true;
                    break;
                }

                length = Sca.nextDouble();

                if(length <= 0){
                    hasError = true;
                    continue; 
                }

                switch (type.toLowerCase()) {

                    case "circle":
                        ar[i] = new Circle(length);
                        sum += ((Circle) ar[i]).getArea();
                        break;

                    case "cube":
                        ar[i] = new Cube(length);
                        sum += ((Cube) ar[i]).getArea();
                        break;

                    default:
                        hasError = true;
                        continue;
                }
            }

            PrintWriter pw =
            new PrintWriter(new FileWriter("C:/Users/ahmed/OneDrive/Desktop/project/Output.txt"));

            if(hasError)
                pw.println("Error");
            else
                pw.println("Sum = " + sum);

            pw.close();

            ShapesFrame frame = new ShapesFrame(ar);
            frame.setVisible(true);

        } catch (Exception e) {
            writeError("Error");
        } finally {
            if (Sca != null) Sca.close();
        }

    }

    private static void writeError(String msg) {
        try {
            PrintWriter pw = new PrintWriter(
            new FileWriter("C:/Users/ahmed/OneDrive/Desktop/project/Output.txt"));

            pw.println("Error");
            pw.close();

        } catch (Exception e) {
            System.out.println("Cannot write error");
        }
    }
}
