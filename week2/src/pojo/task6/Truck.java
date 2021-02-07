package pojo.task6;

public class Truck extends Vehicle {
    private int loader;
    private int payload;

    public Truck(int wheels, int weight, int loader, int payload) {
        super(wheels, weight);
        this.loader = loader;
        this.payload = payload;
    }

    public Truck() {
    }

    @Override
    public String toString() {
        return "车型:货车" + "  " + "车轮数:" + wheels + "  "
                + "车重:" + weight + "  " + "载客数:" + loader + "荷载：" + payload;
    }

    public void load(int num , int payload){
        if(num > loader){
            System.out.println("车轮数是：" + wheels);
            System.out.println("车重：" + weight);
            System.out.println("这是一辆卡车能载" + loader + "人" + ",实载" + num + "人,你超员了！");

        }else{
            System.out.println("车轮数是：" + wheels);
            System.out.println("车重：" + weight);
            System.out.println("这是一辆卡车能载" + loader + "人" + ",实载" + num);
        }
        if (payload > this.payload){
            System.out.println("这是一辆卡车荷载" + this.payload + "kg," + "已载" + payload + "kg,你超载了!");
        }else {
            System.out.println("这是一辆卡车荷载" + this.payload + "kg," + "已载" + payload + "kg");;
        }
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }
}
