package test;

import org.junit.Test;
import pojo.Kmp;

import java.io.*;
import java.util.*;

public class MyTest {
    //1.输入一个原字符串（string）和子串（pattern），要求返回子串在原字符串中首次出现的位置。
    @Test
    public void test1(){
        System.out.print("输入：");
        String a , b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        b = scanner.nextLine();
        System.out.println("输出：" + Kmp.KMP(a,b));
    }

    //2.给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    @Test
    public void test2(){
        System.out.print("输入：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int i , j;
        for (i = 0; i < chars.length; i++) {
            for (j = i + 1; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    break;
                }
            }
            if(j == chars.length){
                System.out.println("输出：" + i);
                return;
            }
        }
        System.out.println("输出：-1");
    }

    //编写一个程序，实现将小数转为分数的功能
    @Test
    public void test3(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入：");
        double num = scanner.nextDouble();
        String s = String.valueOf(num);

        if (s.indexOf(".") == -1) {
            //如果是整数直接输出
            System.out.println("输出：" + s);
            return;
        }

        String sZsbf = s.substring(0,s.indexOf(".") );
        String sXsbf = s.substring(s.indexOf(".") + 1);

        int nXsws = sXsbf.length() ; //小数位数

        long lFenmu = 1;
        for (int k=0; k< nXsws; k++) {
            lFenmu *= 10;
        }

        long lFenzi = Long.parseLong( sZsbf + sXsbf );

        long lXs = (lFenzi < lFenmu) ? lFenzi : lFenmu;

        long j = 1; //最大公约数
        for (j = lXs; j > 1; j --) {
            if (lFenzi % j ==0 && lFenmu % j == 0) {
                break;
            }
        }
        lFenzi = lFenzi / j;
        lFenmu = lFenmu / j;
        System.out.println("输出：" + String.valueOf(lFenzi) + "/" + String.valueOf(lFenmu));
        return;
    }

    //给定一个整数数组，找出该数组中第 k 小的数。
    @Test
    public void test4(){
        System.out.print("输入数组：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(Integer.parseInt(strs[i]));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.print("k = ");
        int i = scanner.nextInt();
        System.out.println("输出：" + list.get(i - 1));
    }

    //数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没
    //有，返回-1。
    @Test
    public void test5(){
        System.out.print("输入数组：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int average = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count >= average){
                System.out.println("输出：" + nums[i]);
                return;
            }
        }
    }

    //6.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    @Test
    public void test6(){
        System.out.print("输入数组：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('[' , ']');
        map.put('(' , ')');
        map.put('{' , '}');
        if(chars.length % 2 != 0 || chars.length <= 0){
            System.out.println("输出：false");
            return;
        }else {
            for (int i = 0 , j = chars.length - 1; i < j; i++ , j--) {
                if(map.get(chars[i]) != chars[j]){
                    System.out.println("输出：false");
                    return;
                }
            }
        }
        System.out.println("输出：true");
    }

    //7.给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字
    //符串。
    @Test
    public void test7(){
        System.out.print("输入数组：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(",");

        Map<String, List<String>> map = new HashMap<>();
        //遍历数组，对每个字符串进行操作
        for (int i = 0; i < strings.length; i++) {
            //把字符串转成字符数组
            char[] ch = strings[i].toCharArray();
            //排序
            Arrays.sort(ch);
            String s = new String(ch);

            //取出对应的list，如果没有，新建
            List<String> temp = map.getOrDefault(s, new ArrayList<>());
            temp.add(strings[i]);
            map.put(s, temp);
        }
        ArrayList<List<String>> arrayList = new ArrayList<>(map.values());
        System.out.println("输出：" + arrayList);
    }

    //在电脑 c 盘的 csatest 目录下，创建一个名称为 demo.txt 的文件。然后将下列内容：
    //"csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa20
    //21csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2
    //021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021"添
    //加到 demo.txt 中，接着利用 java 程序读取该文件中的内容，计算出总共有多少个 2021,并输
    //出到控制台。
    @Test
    public void test8() throws Exception {
            File file=new File("C:/csatest/demo.txt");
            if(file.exists()){
                InputStream input=new FileInputStream(file);
                byte[] data=new byte[1024];
                int foot=0;
                int temp=0;
                while ((temp=input.read())!=-1){
                    data[foot]=(byte) temp;
                    foot++;
                }
                String str=new String(data,0,foot);
                String[] split = str.split("csa");
                System.out.println(split.length);
                input.close();
        }
    }

    @Test
    public void test9() throws IOException {
        File sourceFile=new File("C:/csatest/demo.txt");
        if(!sourceFile.exists()) {
            System.out.println("源文件不存在，请确认执行路径");
            System.exit(1);
        }

        File targetFile=new File("C:/csatest2/demo2.txt");
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }

        InputStream input=new FileInputStream(sourceFile);
        OutputStream output=new FileOutputStream(targetFile);
        int temp=0;
        byte[] data=new byte[1024];
        while ((temp=input.read(data))!=-1){//循环读入
            output.write(data,0,temp);//输出
        }
        System.out.println("复制成功！");
        input.close();
        output.close();
    }
}
