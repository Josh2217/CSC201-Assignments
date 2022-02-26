//THIS ASSIGNMENT WILL NOT BE GOLFED

public class MyRectangle2D {
    private double x, y, width, height;
    
    /*I wish I could just right "public: " once 
    (like in c++) and not have to repeat it 
    for EVERY SINGLE METHOD AND CONSTRUCTOR*/

    //constructors
    public MyRectangle2D(){
        System.out.print("Josh Johnson\n\n\n");
        x = y = 0;
        width = height = 1;
    }
    public MyRectangle2D(double x, double y, double width, double height){
        this.x = (x < 0d) ? 0d : x;
        this.y = (y < 0d) ? 0d : y;
        this.width = (width < 1d) ? 1d : width;
        this.height = (height < 1d) ? 1d : height;
    }

    //getters
    public double getX(){return x;}
    public double getY(){return y;}
    public double getWidth(){return width;}
    public double getHeight(){return height;}
    public double getArea(){return width * height;}
    public double getPerimeter(){return 2 * (width + height);}

    //setters
    public void setX(double n){x=n;}
    public void setY(double n){y=n;}
    public void setWidth(double n){width=n;}
    public void setHeight(double n){height=n;}

    //misc
    public double myTop(){return y + 0.5 * height;}
    public double myBottom(){return y - 0.5 * height;}
    public double myLeft(){return x - 0.5* width;}
    public double myRight(){return x + 0.5 * width;}

    public boolean contains(double inx, double iny){
        //I know you probably wanted us to use a bunch of if statements
        //but I like this way better
        /*
        if the distance from the center (in each dimension)
        is less than half the width or height 
        then the point is definitely within the shape
        */
        //multiply both sides by two to make it less ugly
        return (2 * abs(inx - x) < width) && (2 * abs(iny - y) < height);
    }
    
    //display methods
    public void printJSON(){System.out.printf("{\n\tx: %.2f,\n\ty: %.2f,\n\twidth: %.2f,\n\theight: %.2f\n}\n\n", x, y, width, height);}
    
    public void printMethodResults(){
        System.out.printf("getX: %.2f\ngetY: %.2f\ngetWidth: %.2f\ngetHeight: %.2f\nmyTop: %.2f\nmyBottom: %.2f\nmyLeft: %.2f\nmyRight: %.2f\ngetArea: %.2f\ngetPerimeter: %.2f\n\n", 
            x, 
            y,
            width,
            height,
            myTop(),
            myBottom(),
            myLeft(),
            myRight(),
            getArea(),
            getPerimeter());
    }
    

    //helper functions
    private double abs(double n){return n < 0 ? -n : n;}

}
