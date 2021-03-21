package com.qing;

import com.qing.pojo.Sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmTest {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    @Test
    public void test1(){
        ArrayList<Integer> res = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = {{1,2,3} ,{4,5,6},{7,8,9}};

        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while( top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2 ){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            for(int i = top+1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            for(int i = right-1; top!=bottom && i>=left; i--){
                res.add(matrix[bottom][i]);
            }
            for(int i = bottom-1; left!=right && i>=top+1; i--){
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        System.out.println(res);
    }

    @Test
    public void test2(){
        int[] A = {1,5,8,3,9,7,2,4,6};
        //冒泡
/*        Sort.bubbleSort(A , A.length);*/
        //插入
/*        Sort.insertSort(A , A.length);*/
        //选择
/*        Sort.selectSort(A ,A.length);*/
        //堆排
/*        Sort.heapSort(A ,A.length);*/
        //快排
/*        Sort.quickSort(A , 0 , A.length-1);*/
        //归并
        Sort.mergeSort(A , 0 , A.length-1);
        for (int i : A) {
            System.out.println(i);
        }
    }



}
