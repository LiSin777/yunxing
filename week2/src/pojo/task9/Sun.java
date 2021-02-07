package pojo.task9;

public class Sun extends Star implements Universe{

    @Override
    public void doAnything() {
        System.out.println("sun:太阳吸引着9大行星旋转");
        System.out.println("sun:光照八分钟到达地球");
    }
}
