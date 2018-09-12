package Self;

/**
 * 堆排序
 * 几个关键要素  
 *       最后一个节点  arr.length - 1
 *       任意一个节点的父亲节点   parent = (child - 1) / 2
 *
 *       整体思想，元素之需要和他的父亲元素进行比较
 *       假如大于/小于父亲元素，则再次对比父亲的元素的父亲，以此类推
 *       因此，比较的最大次数相当于二叉树的深度
 *
 *
 *
 *       最小堆 最小堆任何一个父节点的值，都小于等于它左右孩子节点的值。
 *       最大堆 最大堆任何一个父节点的值，都大于等于它左右孩子节点的值。
 *
 *
 *       二叉树公式  2^k-1 > len > 2^(k-1)-1
 *       满二叉树长度（已知深度）  len = 2^k -1
 *
 *       最后一个节点 arr.length - 1
 *       父亲节点  parent = (child - 1) / 2 && child > 0
 *       度是深度的反转  假如深度为n 度为0的则是叶子节点 度为n-1的则是根节点
 */
public class Heap {

    public static void main(String[] args) {
        int[] arr = {22,3,112,56,23,12,45,78,97,24,35};

        buildMinHead(arr);
        //int[] arr2 = buildMinHead(arr);

//        for(int v : arr) {
//            System.out.println(v);
//        }
//        System.out.println();
//        int[] arr1 = add(arr,1);
//        for(int v : arr1) {
//            System.out.println(v);
//        }
////        for(int v : arr) {
////            System.out.println(v);
////        }
//        System.out.println();
//        int[] arr2 = remove(arr1,3);
//        for(int v : arr2) {
//            System.out.println(v);
//        }
        System.out.println();
        buildMaxHeap(arr);
    }


    public static void buildMinHead(int[] arr) {
        //任何一个二叉树的非叶子节点都是 arr.length/2  3 =》 3/2 => 1
        for (int i = arr.length/2; i>=0; i--) {
            downHeap(arr, i, arr.length-1);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for(int i = arr.length/2;i>=0;i--) {
            downHeapMax(arr, i, arr.length - 1);
            for(int v : arr) {
                System.out.println(v);
            }
            System.out.println();
        }

    }

    public static void downHeapMax(int[] arr, int parentIndex, int len) {
        int temp = arr[parentIndex];
        int childIndex = 2*parentIndex+1; //反之求

        while (childIndex < len) {

             if(childIndex + 1 < len && arr[childIndex+1] > arr[childIndex]) {
                childIndex ++;
            }
            if(temp > arr[childIndex]) {
                break;
            }
            System.out.println(parentIndex+" "+temp+" "+arr[childIndex]+" "+childIndex);
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        System.out.println("swap index"+parentIndex);
        arr[parentIndex] = temp;
        //return arr;
    }
    //从上往下寻址
    public static void downHeap(int[] arr, int parentIndex, int len) {
        int temp = arr[parentIndex];
        int childIndex = 2*parentIndex+1; //反之求

        while (childIndex < len) {
            //
            //      5            5>2 && 2<3 && 2<5  => index变成2的index
            //    3    2                     比较节点的位置放入2  节点位置改为2的节点位置 并寻找是否有下一个子节点
            //       6   4       5>3 && 4<6 && 4<5
            //                               比较节点的位置放入4  节点位置改为4的节点位置 并寻找是否有下一个子节点
            //假如孩子节点有右节点 并且 右节点小于左节点  节点转移到右节点位置
            if(childIndex + 1 < len && arr[childIndex+1] < arr[childIndex]) {
                childIndex ++;
            }

            //如果父节点 小于当前孩子节点  停止判断
            if(temp < arr[childIndex]) {
                break;
            }

            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        arr[parentIndex] = temp;
        //return arr;
    }

    public static void upHeap(int[] arr) {
        int childIndex = arr.length - 1; //最后一个节点的下标  比如 数组长度5  下标则为4
        int parentIndex =  (childIndex-1)/2;  //它的父亲节点的下标  比如 数组长度5  下标为4  4-1 = 3 /2  =1
        int temp = arr[childIndex];

        while (childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];   //将大的元素下移 将小的元素上移动
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        arr[childIndex] = temp; // 最终要放的位置

    }


    public static int[] remove(int[] arr, int value) {
        int parentIndex = -1;
        for(int i = 0; i < arr.length; i ++) {
            if(value == arr[i]) {
                parentIndex = i;
            }
        }
        if(parentIndex == -1) {
            return arr;
        }
        //将最后一个元素填充到第一个元素
        arr[parentIndex] = arr[arr.length-1];


        downHeap(arr, 0, arr.length-1);

        return arr;
    }
//

    /**
     * 插入一个新节点
     * 只需对最后一个插入的元素进行上浮操作即可
     *
     * @param arr
     * @param value
     * @return
     */
    public static int[] add(int[] arr, int value) {
        int[] b = new int[arr.length+1];
        b[arr.length] = value;
        //System.out.println(b);
        System.arraycopy(arr, 0,b,0, arr.length);
        arr = b;

        upHeap(arr);

        return arr;
    }


}
