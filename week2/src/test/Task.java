package test;


import org.junit.Test;
import pojo.task4.Game;
import pojo.task5.Monkey;
import pojo.task5.People;
import pojo.task6.Car;
import pojo.task6.Truck;
import pojo.task6.Vehicle;
import pojo.task7.Duck;
import pojo.task8.C;
import pojo.task9.Star;
import pojo.task9.Sun;

import java.util.Scanner;

public class Task {
    //1. 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    @Test
    public void test1(){
        int n;
        System.out.println("请输入维度n:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] array = new int[n][n];
        System.out.println("旋转前：");
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = count++;
                System.out.print(array[i][j]);
            }
            System.out.println();
        }


        for (int i = 0; i < n / 2; i++) { //绕各个顶点旋转 所以顶点不用算在内
            for (int j = i; j < n - 1 - i; j++) { //我们每次只交换一个元素，而且一次就把元素交换到旋转以后的位置
                int temp = array[i][j];
                array[i][j] = array[n-1-j][i];
                array[n-1-j][i] = array[n-1-i][n-1-j];
                array[n-1-i][n-1-j] = array[j][n-1-i];
                array[j][n-1-i] = temp;
            }
        }

        System.out.println("旋转后：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    //2.编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符
    //串 ""。（注：在进行匹配时注意区分字母大小写）
    @Test
    public void test2(){
        String[] strs = {"abc" , "abdf" , "abcv"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String maxPrefix = strs[0];
        int firstLen = maxPrefix.length();

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < firstLen; j++) {
                maxPrefix = strs[0].substring(0, j + 1);
                if (!strs[i].startsWith(maxPrefix)) {
                    maxPrefix = maxPrefix.substring(0, j);
                    firstLen = maxPrefix.length();
                    break;
                }
            }
            if (firstLen == 0) {
                return maxPrefix;
            }
        }
        return maxPrefix;
    }

    //3.找出字符串中的数字
    @Test
    public void test3(){
        String str= "233hello15aop999";
        char[] a = new char[str.length()];
        char[] temp = new char[str.length()];
        str.getChars(0 , str.length() , a , 0);
        int k= 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] >= '0' && a[i] <= '9'){
                temp[k++] = a[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
        }

    }

    //4.猜数字游戏：
    // 一个类 Game 有一个成员变量 v，v 有一个初值 100。
    // 定义一个方法 guess，对 Game 类的成员变量 v，用你输入的数字进行猜。
    // 如果大了则提示大了，小了则提示小了。直到猜对才停止
    @Test
    public void test4(){
        System.out.println("请输入一个数:");
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            num = scanner.nextInt();
            if (Game.guess(num)){
                break;
            }
        }
    }

    //5. 编写一个 Java 应用程序，该程序包括 3 个类：Monkey 类、People 类和主类。要求：
    // Monkey 类中有个构造方法：Monkey (String s)，并且有个 public void speak()方法，在 speak
    //方法中输出“咿咿呀呀......”的信息。
    // People 类是 Monkey 类的子类，在 People 类中重写方法 speak(),在 speak 方法中输出“小
    //样的，不错嘛！会说话了！”的信息。
    // 在 People 类中新增方法 void think()，在 think 方法中输出“别说话！认真思考！”的信
    //息。
    // 在主类的 main 方法中创建 Monkey 与 People 类的对象类测试这 2 个类的功能。
    @Test
    public void test5(){
        Monkey monkey = new Monkey();
        monkey.speak();
        People people = new People();
        people.speak();
        people.think();
    }

    //6. 编写一个 Java 应用程序，设计一个汽车类 Vehicle，包含的属性有车轮个数 wheels 和车重
    //weight。小车类 Car 是 Vehicle 的子类，其中包含的属性有载人数 loader。卡车类 Truck 也是
    //Vehicle 的子类，其中包含的属性有载人数 loader 和载重量 payload。每个类都有构造方法和
    //输出相关数据的方法。最后，写一个测试类来测试这些类的功能。
    @Test
    public void test6(){
        Vehicle vehicle = new Vehicle(1, 2);
        Car car = new Car(1, 2, 3);
        Truck truck = new Truck(1, 2, 3, 4);
        car.load(3);
        truck.load(4 , 5);
    }

    //7.模拟农学院动物医疗系统信息。
    // 定义抽象家禽类(Poultry)
    //(1)私有成员变量：动物种类(name)，症状(symptom)，年龄(age)， 病因（illness）
    // (2)提供空参和带参构造方法
    // (3)成员方法：
    // ①抽象方法症状(showSymptom)
    // ②普通方法基本信息(showMsg)
    // ③提供 setXxx 和 getXxx 方法
    // 定义普通鸭子类(Duck)继承家禽类(Poultry)
    //(1)提供空参和带参构造方法
    // (2)重写 showSymptom 方法，打印症状信息。
    @Test
    public void test7(){
        Duck duck = new Duck("鸭子" , "发烧" , 10 , "感冒");
        duck.showSymptom();
    }

    //8.抽象类练习题
    // 定义抽象类 A，抽象类 B 继承 A，普通类 C 继承 B  A 类中，定义成员变量 numa，赋值为 10，抽象 showA 方法。
    // B 类中，定义成员变量 numb，赋值为 20，抽象 showB 方法。
    // C 类中，定义成员变量 numc，赋值为 30，重写 showA 方法，打印 numa，重写 showB
    //方法，打印 numb，定义 showC 方法，打印 numc。
    //  测试类中，创建 C 对象，调用 showA 方法，showB 方法，showC 方法。
    @Test
    public void test8(){
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }

    //9.接口多态练习
    // 定义接口 Universe，提供抽象方法 doAnything。  定义普通类 Star，提供成员发光 shine 方法
    // 定义普通类 Sun，继承 Star 类，实现 Universe 接口
    // 测试类中，创建 Star 对象，调用 shine 方法
    // 测试类中，多态的方式创建 Sun 对象，调用 doAnything 方法，向下转型，调用 shine 方
    //法。
    @Test
    public void test9(){
        Star star = new Star();
        star.shine();
        System.out.println("===============");
        Star star2 = new Sun();
        star2.shine();
        Sun sun = (Sun) star2;
        sun.doAnything();
    }
}
