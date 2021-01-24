import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
    }

    //体质指数BMI
    @Test
    public void test1(){
        System.out.print("输入体重：");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        System.out.print("输入身高：");
        double high = scanner.nextDouble();
        double BMI = weight / (high * high);

        if(BMI < 18.5){
            System.out.println("过轻");
        }else if(BMI > 18.5 && BMI < 25){
            System.out.println("正常");
        }else if(BMI > 25 && BMI < 28){
            System.out.println("过重");
        }else if(BMI > 28 && BMI < 32){
            System.out.println("肥胖");
        }else if(BMI > 32){
            System.out.println("非常肥胖");
        }
    }

    //水仙花数
    @Test
    public void test2(){
        for (int i = 100; i < 1000; i++) {
            int bai = i / 100;
            int shi = i / 10 % 10;
            int ge = i % 10;

            if(i == (bai*bai*bai) + (shi*shi*shi) + (ge*ge*ge)){
                System.out.println(i);
            }
        }
    }

    //字符串反转
    @Test
    public void test3(){
        String str;
        System.out.print("输入：");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println(str);
        char[] chars = str.toCharArray();
        System.out.println("输出：");
        for (int i = chars.length - 1; i >= 0 ; i--) {
            System.out.print(chars[i]);
        }
    }

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    @Test
    public void test4(){
        int[] a = {0,1,5,0,8,9,10};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] == 0){
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    //5.定义一个 Circle 类，其中成员变量 radius 表示圆的半径，编写方法 getArea() 计
    //算圆的面积、getPerimeter()计算圆的周长，并在主函数中构造一个 Circle 的对象进行测
    //试。
    //示例：
    //输入：3
    //输出：the area is 28.26
    // the perimeter is 18.84
    @Test
    public void test5(){
        double radius;
        System.out.print("输入：");
        Scanner scanner = new Scanner(System.in);
        radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("输出：the area is " + circle.getArea());
        System.out.println("the perimeter is " + circle.getPerimeter());
    }

    //编写一个银行账户类，类的构成包括：
    //数据成员：用户的账户名称、用户的账户余额;
    //方法包括：开户（设置账户名称及余额, 利用构造方法完成)；查询余额。
    @Test
    public void test6(){
        Bank user = new Bank("李青", 250);
        System.out.println("用户：" + user.getUsername());
        System.out.println("余额：" + user.findBalance());
    }

    //7. 声明并测试一个复数类，其中包括 add()、reduce()、multiply()三种方法，分别实现两
    //个复数的相加、相减、相乘，然后输出计算的结果。
    @Test
    public void test7(){
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        System.out.println("输出：");
        Complex c = a.add(b);
        System.out.println("两复数相加的结果为：" + c.getReal() + "+" +  c.getImage() + "i");
        c = a.reduce(b);
        System.out.println("两复数相减的结果为：" + c.getReal() + "+" + c.getImage() + "i");
        c = a.multiply(b);
        System.out.println("两复数相乘的结果为：" + c.getReal() + "+" + c.getImage() + "i");
    }
}
