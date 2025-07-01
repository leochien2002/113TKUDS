public class MatrixMultiplicationVerboseIndex {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] C = new int[3][3]; 

        System.out.println("詳細計算過程：");
        for (int i = 0; i < 3; i++) {        
            for (int j = 0; j < 3; j++) {     
                StringBuilder calc = new StringBuilder("C[" + i + "][" + j + "] = ");
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    calc.append("A[" + i + "][" + k + "]*B[" + k + "][" + j + "]");
                    sum += A[i][k] * B[k][j];
                    if (k < 2) calc.append(" + ");
                }
                calc.append(" = " + sum);
                C[i][j] = sum;
                System.out.println(calc);
            }
        }

        System.out.println("\n結果矩陣 C：");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
