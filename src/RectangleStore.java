import java.util.Collection;

public class RectangleStore implements IRectanglesStore {

    private final Collection<IRectangle> rectangles;
    private final Rectangle bounds;
    private Node _head;



    /**
     * @param bounds     Symbolizes the border within which the rectangles are located
     * @param rectangles the list of the rectangles to store
     *                   average time complexity O(1)   space complexity O(1)
     **/
    public RectangleStore(IRectangle bounds, Collection<IRectangle> rectangles) {
        this.rectangles = rectangles;
        this.bounds = new Rectangle(bounds);
    }

    /**
     * @param bounds     Symbolizes the border within which the rectangles are located
     * @param rectangles the list of the rectangles to store
     *                   this method used to build the binary tree
     *                   average time complexity O(n log n)   space complexity O(n log n)
     **/

    @Override
    public void initialize(IRectangle bounds, Collection<IRectangle> rectangles) {
        boolean start = false;
        for (IRectangle rectangle : rectangles) {
            if (!start) {
                start = true;
                _head = new Node(rectangle, bounds);
            }
            _head.addRectangle(_head, rectangle);
        }
    }

    /**
     * @param x point
     * @param y point
     *          find the highest rectangle in the location x,y
     *          average time complexity O(log n)   space complexity O(log n)
     **/
    @Override
    public IRectangle findRectangleAt(int x, int y) {
        return _head.findMaxRectangle(this._head, x, y);
    }

    @Override
    public String toString() {
        return "BuildStore{" +
                "rectangles=" + rectangles +
                ", bounds=" + bounds +
                ", _head=" + _head +
                '}';
    }
}
