package love.jiahao.binarySearch;

public class BinarySearchMethods {
    // 暴力遍历查找
    public static int search(int[] a, int data) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == data) {
                return i;
            }
        }
        return -1;
    }

    /*
    考虑算法的好坏
    1.假设执行最差的情况
    2.每条语句的执行时间相等
    假设a的长度等于n
    遍历查找语句          次数
    int i = 0           1
    i<a.length          n+1     因为最后一次还是要比较然后不执行循环所以是n+1次
    i++;                n
    a[i] == data        n
    return -1           1
    一共计算3n+3次
    所需要的总时间就是(3n+3)t
    O时间复杂度是函数的渐进上界，也就是算法运行最坏的情况同时还有渐进下届，渐进紧界
    根据计算得出时间复杂度为O(n)
    空间复杂度，就是看算法执行过程中所需要的额外的空间，就算暴力遍历的算法也只需要i，j，m三个常数指针只占用12个字节，所以空间复杂度是O(n)
     */
    public static int binarySearchBasic(int[] a, int data) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        while (i <= j) {                 // i-j范围内有东西
            // 右移一位，普通除法不会转换符号，如果m超出整数表示的范围就会变为负数，但是如果是右移则不会出现负数，而且可以正常除2取整
            // 同时适用于更多语言
            int m = (i + j) >>> 1;
            if (a[m] < data) {       // 目标在右边
                i = m + 1;
            } else if (data < a[m]) {   // 目标在左边
                j = m - 1;
            } else return m;        // 找到了
        }
        return -1;
        /*
        都写成小于号有啥好处？
            首先我们可以一眼看出来数组是升序排列的
            其次我们可以知道需要查找目标值的位置
         */
        /**
         * 二分查找所需要的时间   没找到且查找值在最右边为最差的结果
         * 假设数组长度为n
         * int i = 0, j= a.length -1        2
         * return -1                        1
         * 假设循环l次
         * i <= j                           l+1
         * int m = (i +j) >>> 1             l
         * if (a[m] < data)                 l
         * else if(data < a[m])             l
         * 所需要总次数为5l + 4
         * 数组长度为4-7时  循环3次
         * 数组长度为8-15时 循环4次
         * 所以l=floor(log_2(n)) +1
         * 所以可得二分查找算法所需要时间为(floor(log_2(n)) + 1) * 5 + 4 (t)
         * 我们可以借组图来比较好坏，得出结论，在数据量大时二分查找优于遍历查找，并且随着数据量的增加差距越明显
         * 二分查找法的时间复杂度为O(log_2(n)) 底数是什么无所谓可以通过公式转换为系数
         * 空间复杂度也是O(1)
         */
    }

    // 二分查找 改动版
    public static int binarySearchAlternative(int[] a, int data) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (data < a[m]) {
                j = m;
            } else if (a[m] < data) {
                i = m + 1;
            } else return m;
        }

        return -1;
    }

    // 二分查找 改动改动版
    /*
    相较于上面的查找，该查找则是把i和j之间的范围，作为剩下的元素，而j继续保持边界不能与j相等，但可以与i相等
    同时判断时如果目标值小于中间值，因为没有相等，就让j占据从而少了一个else if
    而如果目标值大于等于中间值，就让i占据m，因为i并不排除当前值
    这种做法最好的情况性能变差了，因为需要等待循环结束，但是最坏的情况变好了，因为每次循环少了一个判断
    最后跳出循环进行一次判断就够了
     */
    public static int binarySearch2(int[] a, int data) {
        int i = 0, j = a.length;
        // j-i代表剩余要查找的元素个数，如果小于等于1就跳出循环了
        while (1 < j - i){
            int m = (i + j) >>> 1;
            if (data < a[m]) j = m;
            else i = m;
        }
        if (data == a[i]) return i;
        else return -1;
    }

    // 二分查找改动版，如果有多个重复的被查找值，查找出最左侧的索引
    public static int binarySearch3(int[] a, int target){
        int i = 0, j = a.length - 1;
        int temp = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else if (target < a[m]) {
                j = m - 1;
            } else {
                temp = m;
                j = m - 1;
            }
        }
        return temp;

    }

    // 查找最左边的改动版
    // 最终返回值为i意为左边界 如果找到了就是最左边值的索引，如果没找到就是可以在i位置插入索引值，刚好升序
    // 1 2 2 3 5    4
    // i       j
    //       i j
    //         ij


    // 应用比如求排名，这里求5插入数组的排名最后返回5加上1，5就是排名第六
    // 0 1 2 3 4 5
    // 1 2 4 4 4 7
    // i         j
    //       i   j
    //           ij
    public static int binarySearch4(int[] a, int target){
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
    // 查找最右边索引
    // 1 3 4 4 5    4
    // i       j
    //
    //          i

    // 应用 用来寻找一个数的后任，在返回值加一就可以找到
    // 1 2 4 4 4 7      5
    // i         j
    //       i   j
    //         i j
    //           ij
    //         j i
    public static int binarySearch5(int[] a, int target){
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return j;
    }
}
