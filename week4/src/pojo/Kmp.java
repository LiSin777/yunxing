package pojo;

import java.util.ArrayList;
import java.util.List;

public class Kmp {
    public static int i=0,j=0;
    public static int[] kmpNext(String ps){//Next数组
        List<Integer> nxt = new ArrayList<Integer>();
        int[] a = new int[ps.length()];//Next数组的长度为模板串的长度
        int len = ps.length();
        if (len == 0){
            return null;
        }else if (len == 1){
            nxt.add(0);
            for (int i=0; i<nxt.size(); i++)
            {
                a[i] = nxt.get(i);
            }
            return a;
        }else if (len == 2){
            nxt.add(0);
            nxt.add(1);
            for (int i=0; i<nxt.size(); i++)
            {
                a[i] = nxt.get(i);
            }
            return a;
        }
        char[] p = ps.toCharArray();//将模式串转换为模式数组
        nxt.add(0);
        nxt.add(1);
        for (int i=2; i<p.length; i++){//采用由next(i-1)求next(i)的方法
            int k = nxt.get(i-1);
            while (k!=0){//当nxt.get(i-1)等于0时，代表已经回溯到了next数组的第一个元素
                if (p[i-1] == p[k-1]){//因为数组是从0开始计数的，所以这里需要k-1
                    nxt.add(k+1);
                    break;
                }else {
                    k = nxt.get(k-1);//p[k-1]与nxt.get(k-1)相对应
                }
            }
            if (k==0){
                nxt.add(1);
            }
        }
        for (int i=0; i<nxt.size(); i++)
        {
            a[i] = nxt.get(i);
        }
        return a;
    }
    public static int KMP(String a,String b){
        int[] nxt = kmpNext(b);
        while (i<a.length()&&j<b.length()){
            if (a.charAt(i) == b.charAt(j)){//如果比较的两位都相等的话，i++,j++
                i++;
                j++;
            }else if (j==0 &&a.charAt(i) != b.charAt(j)){//如果j=0,代表指向模式串的第一个元素，此时若比较的两个元素不相等的话，则i++,j无需++
                i++;
            }else {
                j=nxt[j-1];//因为我们的next数组下标是从0开始，所以这个地方是j-1,不然就是一个死循环
            }
        }
        if (j == b.length()) {
            return i - j;
        } else {
            return -1;
        }
    }



}
