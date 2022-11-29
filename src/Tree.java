class Node {
    private final Rectangle _rectangle;
    private final Rectangle _bounds;
    private final int rightX;
    private final int leftX;
    private final int topY;
    private final int bottomY;
    Node left;
    Node right;


    /**
     * @param bounds    to show the bounds of the rectangle
     * @param rectangle the rectangle to add
     *                  average complexity time end space O(1)
     **/
    public Node(IRectangle rectangle, IRectangle bounds) {
        this._bounds = new Rectangle(bounds);
        this._rectangle = new Rectangle(rectangle);
        //mark the location of the rectangle on the x-axis end on the y-axis
        //It is based on that the getRight() represents the distance between the left of the rectangle to the right side
        //same with the x
        topY = _bounds.getBottom() - this._rectangle.getTop();
        bottomY = _bounds.getBottom() - this._rectangle.getTop() - this._rectangle.getBottom();
        rightX = _bounds.getRight() - this._rectangle.getLeft();
        leftX = _bounds.getRight() - (this._rectangle.getLeft() + this._rectangle.getRight());

        this.left = null;
        this.right = null;
    }


    /**
     * @param current   Displays the current node
     * @param rectangle the rectangle to add
     *                  this method used to build the binary tree
     *                  average time complexity O(log n)   space complexity O(log n)
     **/
    //build the tree
    public Node addRectangle(Node current, IRectangle rectangle) {
        if (current == null) {
            return new Node(rectangle, _bounds);
        }
        if (rectangle.getTop() >= current._rectangle.getTop()) {
            current.left = addRectangle(current.left, rectangle);
        } else if (rectangle.getTop() < current._rectangle.getTop()) {
            current.right = addRectangle(current.right, rectangle);
        }
        return current;
    }


    /**
     * @param current Displays the current node
     * @param x       point
     * @param y       point
     *                find the highest rectangle in the location x,y
     *                The highest is defined by the rectangle whose beginning
     *                is located the lowest on the y-axis in the required area
     *                average time complexity O(log n)   space complexity O(log n)
     **/

    public Rectangle findMaxRectangle(Node current, int x, int y) {
        if (current == null)
            return null;
        //I count the levels by their position,
        //And so since it's a binary search tree the
        // last rectangle at that position is the highest level

        if (isInBounds(current, x, y)) {
            if (current.left != null && y <= current.left.topY) {
                return findMaxRectangle(current.left, x, y) == null ? current._rectangle :
                        findMaxRectangle(current.left, x, y);
            }
            else
                return current._rectangle;
        }
        if (y >= current.topY) {
            return findMaxRectangle(current.right, x, y);
        }
        if (y <= current.bottomY) {
            return findMaxRectangle(current.left, x, y);
        }
        //in case that not exists eny rectangle on this place
        return null;
    }


    private static boolean isInBounds(Node current, int x, int y) {
        return current.leftX <= x && current.rightX >= x && current.bottomY <= y && current.topY >= y;
    }

}
