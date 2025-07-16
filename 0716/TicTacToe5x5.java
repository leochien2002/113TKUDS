import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int BOARD_SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    /**
     * 初始化 N x N 的井字遊戲棋盤，所有空格以 '.' 表示。
     * 時間複雜度: O(1)
     * 說明：棋盤大小固定為 5x5，操作次數是常數。
     */
    public static char[][] initializeBoard() {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    /**
     * 列印棋盤，包含行、列索引。
     * 時間複雜度: O(1)
     * 說明：棋盤大小固定為 5x5，列印操作的次數是常數。
     */
    public static void printBoard(char[][] board) {
        System.out.println("\n  0 1 2 3 4"); // 列索引
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print(row + " "); // 行索引
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < BOARD_SIZE - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 嘗試在指定位置放置棋子。
     * 若座標超界或位置已被佔用，顯示錯誤訊息並回傳 false。
     * 時間複雜度: O(1)
     * 說明：只包含常數次的檢查和賦值操作。
     */
    public static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            System.out.printf("無效座標 (%d, %d)。請輸入介於 0-%d 的數字。\n", row, col, BOARD_SIZE - 1);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用。請選擇其他位置。\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    /**
     * 檢查是否有玩家獲勝（連續連成 5 個相同符號）。
     * 時間複雜度: O(1)
     * 說明：儘管包含巢狀迴圈，但其遍歷範圍固定為 5x5 棋盤內的常數次檢查。
     */
    public static char checkWinner(char[][] board) {
        // 檢查所有可能的起始點
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    continue; // 跳過空位
                }

                char currentPlayer = board[i][j];

                // 檢查水平連線 (從 (i, j) 開始向右)
                if (j + 4 < BOARD_SIZE &&
                    board[i][j + 1] == currentPlayer &&
                    board[i][j + 2] == currentPlayer &&
                    board[i][j + 3] == currentPlayer &&
                    board[i][j + 4] == currentPlayer) {
                    return currentPlayer;
                }

                // 檢查垂直連線 (從 (i, j) 開始向下)
                if (i + 4 < BOARD_SIZE &&
                    board[i + 1][j] == currentPlayer &&
                    board[i + 2][j] == currentPlayer &&
                    board[i + 3][j] == currentPlayer &&
                    board[i + 4][j] == currentPlayer) {
                    return currentPlayer;
                }

                // 檢查主對角線連線 (從 (i, j) 開始向右下)
                if (i + 4 < BOARD_SIZE && j + 4 < BOARD_SIZE &&
                    board[i + 1][j + 1] == currentPlayer &&
                    board[i + 2][j + 2] == currentPlayer &&
                    board[i + 3][j + 3] == currentPlayer &&
                    board[i + 4][j + 4] == currentPlayer) {
                    return currentPlayer;
                }

                // 檢查反對角線連線 (從 (i, j) 開始向左下)
                if (i + 4 < BOARD_SIZE && j - 4 >= 0 && // j-4 >= 0 確保不會越界
                    board[i + 1][j - 1] == currentPlayer &&
                    board[i + 2][j - 2] == currentPlayer &&
                    board[i + 3][j - 3] == currentPlayer &&
                    board[i + 4][j - 4] == currentPlayer) {
                    return currentPlayer;
                }
            }
        }
        return EMPTY; // 沒有獲勝者
    }

    /**
     * 檢查棋盤是否已滿。
     * 時間複雜度: O(1)
     * 說明：棋盤大小固定為 5x5，遍歷所有格子檢查的次數是常數。
     */
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 主遊戲邏輯。
     * 時間複雜度: O(1)
     * 說明：遊戲的最大步數為 BOARD_SIZE * BOARD_SIZE (25 步)。每一步內部的操作都是 O(1)。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;
        boolean gameOn = true;

        System.out.println("=== 5x5 井字遊戲 ===");

        while (gameOn) {
            printBoard(board);
            System.out.printf("玩家 %c, 請輸入你的落子座標 (行, 列)：\n", currentPlayer);
            int row, col;

            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("輸入無效。請輸入兩個整數，例如: 1 3。");
                scanner.next(); // 清除錯誤的輸入
                scanner.next(); // 清除第二個錯誤的輸入
                continue; // 重新要求輸入
            }

            if (placePiece(board, row, col, currentPlayer)) {
                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    printBoard(board);
                    System.out.printf("玩家 %c 獲勝！\n", winner);
                    gameOn = false;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("平手！");
                    gameOn = false;
                } else {
                    // 切換玩家
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }
        }
        scanner.close();
        System.out.println("遊戲結束。");
    }
}