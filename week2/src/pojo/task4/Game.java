package pojo.task4;

public class Game {
    private static int v = 100;

    public static boolean guess(int num){
        if (num < v){
            System.out.println("猜的有点小,再试一次");
        }else if(num > v){
            System.out.println("猜大了哦,再试一次");
        }else if(num == v){
            System.out.println("恭喜你猜对了");
            return true;
        }
        return false;
    }
}
