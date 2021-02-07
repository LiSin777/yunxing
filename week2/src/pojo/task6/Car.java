package pojo.task6;

public class Car extends Vehicle {
    private int loader;

    public Car() {
    }

    public Car(int wheels, int weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public String toString() {
        return "车型:小车" + "  " + "车轮数:" + wheels + "  " + "车重:"
                + weight + "  " + "载客数:" + loader;
    }

    public void load(int num){
        if(num > loader){
            System.out.println("车轮数是：" + wheels);
            System.out.println("车重：" + weight);
            System.out.println("这是一辆小车能载" + loader + "人" + ",实载" + num + "人,你超员了！");
        }else{
            System.out.println("车轮数是：" + wheels);
            System.out.println("车重：" + weight);
            System.out.println("这是一辆小车能载" + loader + "人" + ",实载" + num);
        }
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }
}
