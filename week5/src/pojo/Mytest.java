package pojo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mytest {
    //1.整数反转 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入：x = ");
        String s = scanner.nextLine();
        int x = Integer.parseInt(s);
        int result;
        int temp = x;
        String s2="";
        try {
            if (temp > 0) {
                while (temp / 10 >= 0 && temp != 0) {
                    s2 += (temp % 10);
                    temp /= 10;
                }
                result = Integer.parseInt(s2);
            } else {
                temp = Math.abs(x);
                while (temp / 10 >= 0 && temp != 0) {
                    s2 += (temp % 10);
                    temp /= 10;
                }
                result = -Integer.parseInt(s2);
            }
        }catch(NumberFormatException e){
            result=0;
        }
        System.out.println("输出：" + result);
    }

    //2.爬楼梯 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    @Test
    public void test2() {

        int numsMax = 0;
        int num1 = 1;
        int num2 = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入：");
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        if (n == 2) {
            System.out.println(2);
        }

        for (int i = 3; i <= n; i++) {
            numsMax = num1 + num2;
            num1 = num2;
            num2 = numsMax;
        }
        System.out.println("输出：" + numsMax);
    }

    //3.求子集 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集
    @Test
    public void test3(){
        System.out.print("输入：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");

        int[] arr = new int[split.length];
        for (int i = 0 ; i < split.length ; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        List<List<Integer>> subsets = new Method().subsets(arr);
        System.out.println("输出：" + subsets);
    }
    public class Method {

        public List<List<Integer>> subsets(int nums[]) {
            List<List<Integer>> list_1 = new ArrayList<List<Integer>>();
            list_1.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                int size = list_1.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> temp_list = new ArrayList<>(list_1.get(j));
                    temp_list.add(nums[i]);
                    list_1.add(temp_list);
                }
            }
            return list_1;
        }
    }
}
