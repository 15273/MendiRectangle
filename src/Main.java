

import java.util.Collection;
import java.util.Collections;


public class Main {

//    public static int sortArr(int i, int j, int [][]arr, int []arr2, int x){
//
//    }
//    public static int sortArr(int i, int j, int [][]arr, int []arr2, int x, int y){
//        if (arr[i + 1][j] > arr[i][j + 1]){
//            arr2[x] = arr[i][j + 1];
//
//        }
//
//    }

    public static void main(String[] args) {

        Rectangle bounds = new Rectangle(0, 5, 0, 5);
        Rectangle rectangle0 = new Rectangle(0, 5, 1, 4);
        Rectangle rectangle1 = new Rectangle(0, 5, 0, 5);
        Rectangle rectangle2 = new Rectangle(0, 5, 2, 2);
        Rectangle rectangle3 = new Rectangle(0, 5, 3, 3);
        Rectangle rectangle4 = new Rectangle(0, 5, 4, 3);
        Rectangle rectangle5 = new Rectangle(0, 5, 1, 3);
        Rectangle rectangle6 = new Rectangle(0, 5, 1, 3);
        Collection<IRectangle> rectangles = new java.util.ArrayList<>(Collections.emptyList());

        rectangles.add(rectangle0);
        rectangles.add(rectangle1);
        rectangles.add(rectangle2);
        rectangles.add(rectangle3);
        rectangles.add(rectangle4);
        rectangles.add(rectangle5);
        rectangles.add(rectangle6);
        rectangle1.getProperties();

        RectangleStore re = new RectangleStore(bounds, rectangles);
        re.initialize(bounds, rectangles);

        if (re.findRectangleAt(2, 2) != null)
            System.out.println(re.findRectangleAt(2, 2).toString() + "\n");
        else
            System.out.println("null" + "\n");

        if (re.findRectangleAt(1, 1) != null)
            System.out.println(re.findRectangleAt(1, 1).toString() + "\n");
        else
            System.out.println("null" + "\n");

        if (re.findRectangleAt(2, 3) != null)
            System.out.println(re.findRectangleAt(2, 3).toString() + "\n");
        else
            System.out.println("null" + "\n");

        if (re.findRectangleAt(4, 2) != null)
            System.out.println(re.findRectangleAt(4, 2).toString() + "\n");
        else
            System.out.println("null" + "\n");

        if (re.findRectangleAt(5, 1) != null)
            System.out.println(re.findRectangleAt(5, 1).toString() + "\n");
        else
            System.out.println("null" + "\n");

        for (IRectangle rectangle : rectangles) {
            System.out.println(rectangle.toString() + "\n");
        }
        System.out.println(rectangle1.getProperties());


        int[][] arr = new int[][]{{2, 5, 35},
                {3, 7, 40},
                {10, 50, 60}};


    }
}