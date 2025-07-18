package Task2.Model;

public abstract class Share {
    private final String colorFill;
    private final String colorBorder;

    public String getColorFill() {
        return colorFill;
    }

    public String getColorBorder() {
        return colorBorder;
    }

    public Share(String colorFill, String colorBorder) {
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }
    public void printInfoShare(Object share){

    };
}
