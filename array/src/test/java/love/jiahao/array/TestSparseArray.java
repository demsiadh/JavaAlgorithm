package love.jiahao.array;

import java.io.*;

/**
 * <pre>
 *  稀疏数组：
 *      1. 二维数组转稀疏数组
 *      2. 稀疏数组转二维数组
 * </pre>
 */
public class TestSparseArray {

    public static void main(String[] args) {
        // 创建原始二维数组
        // 0没有棋子，1：黑棋，2：白棋
        // 棋盘大小11 * 11
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        // 预览棋盘上的棋子位置
        System.out.println("===预览原始数据===");
        printChessArray(chessArr);

        // 二维数组转稀疏数组
        int[][] ints = chessToSpares(chessArr);
        System.out.println("===二维数组转稀疏数组===");
        printChessArray(ints);
        System.out.println("保存到磁盘中...");
        saveArray(ints);


        // 稀疏数组转二维数组
        System.out.println("从磁盘中读取中...");
        int[][] ints1 = readArray();
        System.out.println("===稀疏数组转二维数组===");
        if (ints1 != null) {
            int[][] chessArr2 = sparseToChess(ints1);
            printChessArray(chessArr2);
        }

    }


    /**
     * 稀疏数组转二维数组
     * @param sparseArr
     * @return
     */
    private static int[][] sparseToChess(int[][] sparseArr) {
        // 创建二维数组
        int[][] ints = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 恢复为二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            int[] arr = sparseArr[i];
            ints[arr[0]][arr[1]] = arr[2];
        }

        return ints;
    }

    /**
     * 二维数组转稀疏数组
     * @param chessArr
     * @return
     */
    private static int[][] chessToSpares(int[][] chessArr) {
        // 1.遍历二维数组得到有效棋子个数
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0) sum++;
            }
        }

        // 2.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        // 3.将二维数组的有效数据，存入稀疏数组中(从第二行开始存)
        int chessRow = chessArr.length; // 行：棋盘大小
        int chessCol = chessArr[0].length; // 列：棋盘大小
        int count = 0; // 记录当前时第几个非0的数据
        for (int i = 0; i < chessArr.length; i++) {
            int[] rows = chessArr[i];

            for (int j = 0; j < rows.length; j++) {
                int row = rows[j];
                if (row == 0) continue;

                count++;    // 因为第一行是棋盘信息，所以先自增
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = row;
            }
        }

        // 补全棋盘信息
        sparseArr[0][0] = chessRow;
        sparseArr[0][1] = chessCol;
        sparseArr[0][2] = count;

        return sparseArr;
    }



    /**
     * 打印棋子布局
     */
    public static void printChessArray(int[][] chessArr){
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%-2d\t", anInt);
            }
            // 换行
            System.out.println();
        }
    }

    /**
     * 保存当前棋盘到文件中
     * @param chessArr
     */
    public static void saveArray(int[][] chessArr) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudyArray/data/chessArr.txt"))
        ) {
                oos.writeObject(chessArr);
                System.out.println("保存成功");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] readArray() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudyArray/data/chessArr.txt"))
        ) {
            int[][] chessArr = (int[][]) ois.readObject();
            return chessArr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
