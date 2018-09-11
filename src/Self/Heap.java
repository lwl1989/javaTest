package Self;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {22,3,112,56,23,12,45,78,97,24,35};

        int[] arr1 = buildMaxHeap(arr);
        //int[] arr2 = buildMinHead(arr);

        for(int v : arr1) {
            System.out.println(v);
        }
    }

    public static int[] buildMaxHeap(int[] arr) {
        //任何一个二叉树的非叶子节点都是 arr.length/2  3 =》 3/2 => 1
        for (int i = arr.length/2; i>=0; i--) {
            arr = downHeap(arr, i, arr.length-1);
        }

        return  arr;
    }

//    public static int[] buildMinHead(int[] arr) {
//
//    }
//
    //从上往下寻址
    public static int[] downHeap(int[] arr, int parentId, int len) {
        int temp = arr[parentId];
        int childId = 2*parentId+1; //反之求

        while (childId < len) {
            //假如孩子节点有右节点 并且 右节点小鱼左节点  节点转移到右节点位置
            if(childId + 1 < len && arr[childId+1] < arr[childId]) {
                childId ++;
            }

            //如果父节点 小于当前孩子节点  停止判断
            if(temp < arr[childId]) {
                break;
            }

            arr[parentId] = arr[childId];
            parentId = childId;
            childId = 2*parentId+1;
        }
        arr[parentId] = temp;
        return arr;
    }

    public static int[] upHeap(int[] arr) {
        int childId = arr.length - 1; //最后一个节点的下标  比如 数组长度5  下标则为4
        int parentId =  (childId-1)/2;  //它的父亲节点的下标  比如 数组长度5  下标为4  4-1 = 3 /2  =1
        int temp = arr[childId];

        while (childId > 0 && temp < arr[parentId]) {
            arr[childId] = arr[parentId];   //将大的元素下移 将小的元素上移动
            childId = parentId;
            parentId = (parentId-1)/2;
        }
        arr[childId] = temp; // 最终要放的位置


        return arr;
    }

//    public static int[] remove(int[] arr, int value) {
//
//    }
//
//    public static int[] add(int[] arr, int value) {
//
//    }


}
