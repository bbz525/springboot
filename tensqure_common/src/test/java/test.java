public class test {
    public static void main(String[] args) {
        FactoryProducer.getFactory("shape").getShape("circle").draw();
    }
}
interface Shape{
    void draw();
}
class triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("is triantangle");
    }
}
class Cicle implements Shape{
    @Override
    public void draw() {
        System.out.println("is Cicle");
    }
}
class trangle implements Shape{
    @Override
    public void draw() {
        System.out.println("is trangle");
    }
}
class ShapeFactory  extends  AbstractFactory{

    @Override
    Printer getPinter(String pinter) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if (shapeType==null)return null;
        if(shapeType.equalsIgnoreCase("triangle"))return new triangle();
        if(shapeType.equalsIgnoreCase("Circle"))return new Cicle();
        if(shapeType.equalsIgnoreCase("trangle"))return new trangle();
        return null;
    }
}
interface Printer{
    void print();
}
class ScreenPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("打印在屏幕上");
    }
}
class PhonePrinter implements Printer{

    @Override
    public void print() {
        System.out.println("打印在手机上");
    }
}
class WebnPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("打印在网络上");
    }
}
class PrintrtFactory extends  AbstractFactory{

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Printer getPinter(String pinter) {
        if (pinter==null)return null;
        if(pinter.equalsIgnoreCase("screen"))return new ScreenPrinter();
        if(pinter.equalsIgnoreCase("phone"))return new PhonePrinter();
        if(pinter.equalsIgnoreCase("web"))return new WebnPrinter();
        return null;
    }
}
abstract class AbstractFactory{
    abstract Shape getShape(String shape);
    abstract Printer getPinter(String pinter);
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice==null){return null;}
        else if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }
        else if (choice.equalsIgnoreCase("printer")){
            return new PrintrtFactory();
        }
        else {
            return null;
        }
    }
}
