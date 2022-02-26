public class Test {
    public static void main(String[]h){
        MyRectangle2D std_rect = new MyRectangle2D();
        System.out.printf("Area of std_rect is %.1f\n\n", std_rect.getArea());


        MyRectangle2D test_rect = new MyRectangle2D(4d, 5d, 2d, 4d);
        System.out.print("test_rect: (MyRectangle2D) <as json>\n");
        test_rect.printJSON();
        test_rect.printMethodResults();
        System.out.printf("contains(3.5, 6.0) => %b\ncontains(1.0, 9.0) => %b", 
            test_rect.contains(3.5, 6.0),
            test_rect.contains(1.0, 9.0));
    }
}
