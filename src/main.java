import java.util.Scanner;
public class main {

        private static final int ROWS = 3;
        private static final int COLS = 3;
        private static String[][] board = new String[ROWS][COLS];
        private static Scanner console = new Scanner(System.in);

        public static void main(String[] args) {
            boolean playAgain;
            do {
                clearBoard();
                String currentPlayer = "X";
                int moveCount = 0;
                boolean gameWon = false;

                while (!gameWon && moveCount < ROWS * COLS) {
                    display();
                    int row, col;
                    do {
                        row = safeInput.getRangedInt(console, "Enter row (1-3):", 1, 3) - 1;
                        col = safeInput.getRangedInt(console, "Enter column (1-3):", 1, 3) - 1;
                    } while (!isValidMove(row, col));

                    board[row][col] = currentPlayer;
                    moveCount++;

                    if (moveCount >= 5 && isWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                    } else if (moveCount == ROWS * COLS) {
                        display();
                        System.out.println("It's a tie!");
                    } else {
                        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                    }
                }

                playAgain = safeInput.getYNConfirm(console, "Do you want to play again?");
            } while (playAgain);

            System.out.println("Thanks for playing!");
        }

        private static void clearBoard() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    board[i][j] = " ";
                }
            }
        }

        private static void display() {
            System.out.println("  1 2 3");
            for (int i = 0; i < ROWS; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < COLS; j++) {
                    System.out.print(board[i][j]);
                    if (j < COLS - 1) System.out.print("|");
                }
                System.out.println();
                if (i < ROWS - 1) System.out.println("  -----");
            }
        }

        private static boolean isValidMove(int row, int col) {
            return board[row][col].equals(" ");
        }

        private static boolean isWin(String player) {
            return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
        }

        private static boolean isRowWin(String player) {
            for (int i = 0; i < ROWS; i++) {
                if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isColWin(String player) {
            for (int j = 0; j < COLS; j++) {
                if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isDiagonalWin(String player) {
            return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                    (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
        }
    }
