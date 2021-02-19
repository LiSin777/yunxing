package test;

import org.junit.Test;
import pojo.Employee;
import pojo.TCPException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyTest {
    //1.三数之和：给你一个包含 n 个整数的数组 nums，
    // 判断 nums 中是否存在三个元素 a， b，c ，使得 a + b + c =target。
    // 请你找出所有满足条件且不重复的三元组。
    @Test
    public void test1(){
        System.out.println("输入数组：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        System.out.print("输入target：");
        int target = scanner.nextInt();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == target){
                        System.out.println("[" + nums[i] + "," + nums[j] + "," + nums[k] + "]");
                    }
                }

            }
        }
    }

    //2.用 List 来存储下表信息并遍历输出
    @Test
    public void test2(){
        System.out.println("+----+-------+--------+-----------+");
        System.out.println("| Id |  Name | Salary | ManagerId |");
        System.out.println("+----+-------+--------+-----------+");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1 , "Joe" , 70000 , 3));
        employees.add(new Employee(2 , "Henry" , 80000 , 4));
        employees.add(new Employee(3 , "Sam" , 60000 , 5));
        employees.add(new Employee(4 , "Max" , 90000 , 6));
        for (Employee employee : employees) {
            System.out.print("| " + employee.getId() + "  |");
            System.out.print(" " + employee.getName() + " |");
            System.out.print(" " + employee.getSalary() + " |");
            System.out.println("      " + employee.getManagerId() + " |");
        }
    }

    //3. 现获取到用户输入的一段字符串（可从键盘录入），例如：aaaabbbcccccdd。请编写程序
    //获取其中无重复的字符组成一个新的字符串，即：abcd。请不要改变字符的输入顺序。
    @Test
    public void test3(){
        System.out.println("输入一段字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = new char[line.length()];
        line.getChars(0 , line.length() , chars , 0);
        char a =' ';
        ArrayList<Character> list = new ArrayList<>();
        for (char c : chars) {
            if(c != a){
                a = c;
                list.add(a);
            }
        }

        for (Character character : list) {
            System.out.println(character);
        }
    }

    //4.wordCount（用 hashMap 实现）
    //输入一串由英文单词组成的字符串，现在需要统计出每个英文字母出现的频数。
    @Test
    public void test4(){
        System.out.println("输入一段字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = new char[line.length()];
        line.getChars(0 , line.length() , chars , 0);

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if(map.get(c) == null){
                map.put(c , 1);
            }else {
                map.put(c , map.get(c) + 1);
            }
        }

        for (Character character : map.keySet()) {
            System.out.println(character + ":" + map.get(character));
        }
    }

    //5.自定义一个异常类，然后在发生异常时能调用到你自定义的异常类
    @Test
    public void test5() throws TCPException {
        try{
            int i = 1 / 0;
        }catch (Exception e){
            throw new TCPException(false , 20001 , "发生除零错误");
        }
    }
}
