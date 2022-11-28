import java.util.Properties;


public class Rectangle implements IRectangle {
    private final int _left;
    private final int _right;
    private final int _top;
    private final int _bottom;


    public Rectangle(IRectangle other) {
        this._left = other.getLeft();
        this._right = other.getRight();
        this._top = other.getTop();
        this._bottom = other.getBottom();
    }

    public Rectangle(int left, int right, int top, int bottom) {
        this._left = left;
        this._right = right;
        this._top = top;
        this._bottom = bottom;
    }

    @Override
    public int getLeft() {
        return this._left;
    }

    @Override
    public int getTop() {
        return this._top;
    }

    @Override
    public int getRight() {
        return this._right;
    }

    @Override
    public int getBottom() {
        return this._bottom;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "_left=" + _left +
                ", _right=" + _right +
                ", _top=" + _top +
                ", _bottom=" + _bottom +
                '}';
    }
    /**
     * return the aria of the rectangle*/
    @Override
    public Properties getProperties() {
        Properties rectangleProps = new Properties();
        int aria = (_bottom - _top) * (_right - _left);
        rectangleProps.setProperty("aria", " " + aria + " ");
        return rectangleProps;
    }
}
