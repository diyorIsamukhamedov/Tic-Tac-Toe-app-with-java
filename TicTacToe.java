// Import necessary library
import java.util.Scanner;

public class TicTacToe {
       private static final int gridSize = 3;

    public static void main(String[] args) {
        // create scanner instance to read input
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[gridSize][gridSize];

        // Initialize the board with empty cells
        initializeBoard(board);

        // Variable to keep track of the current player
        String currentPlayer = "X";

        // Print the initial empty board
        System.out.println("---------");
        printEmptyBoard(board);
        System.out.println("---------");

        while (true) {
            System.out.print("> ");

            // Check if the input is a number
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next(); // clear invalid input
                continue;
            }

            // Read row input
            int row = scanner.nextInt() - 1;

            // Check if the input is a number
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next(); // clear invalid input
                continue;
            }

            // Read column input
            int col = scanner.nextInt() - 1;

            // Check if the input coordinates are within the valid range
            if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Check if the selected cell is already occupied
            if (!board[row][col].equals(" ")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // If valid input and cell is not occupied, place the symbol of the current player
            board[row][col] = currentPlayer;

            // Print the board after the move
            System.out.println("---------");
            printBoard(board);
            System.out.println("---------");

            // Check for a win or a draw
            if (checkWin(board, currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                break;
            }

            if (isDraw(board)) {
                System.out.println("Draw");
                break;
            }

            // Switch player
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }

        // close the scanner
        scanner.close();
    }

    // Method for initializing the board with empty cells
    private static void initializeBoard(String[][] board) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = " ";
            }
        }
    }

    // Method to print an empty Tic-Tac-Toe board
    private static void printEmptyBoard(String[][] board) {
        for (int i = 0; i < gridSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // Method to print the Tic-Tac-Toe board
    private static void printBoard(String[][] board) {
        for (int i = 0; i < gridSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // Method to check if the current player has won
    private static boolean checkWin(String[][] board, String player) {
        // Checking for horizontals and verticals.
        for (int i = 0; i < gridSize; i++) {
            int horizontalCount = 0;
            int verticalCount = 0;

            for (int j = 0; j < gridSize; j++) {
                // horizontal
                if (board[i][j].equals(player)) {
                    horizontalCount++;
                }

                // vertical
                if (board[j][i].equals(player)) {
                    verticalCount++;
                }
            }

            if (horizontalCount == gridSize || verticalCount == gridSize) {
                return true;
            }
        }

        // Checking for diagonals.
        boolean mainDiagonalWin = true;
        boolean secondaryDiagonalWin = true;

        for (int i = 0; i < gridSize; i++) {
            if (!board[i][i].equals(player)) {
                mainDiagonalWin = false;
            }

            if (!board[i][gridSize - 1 - i].equals(player)) {
                secondaryDiagonalWin = false;
            }
        }

        return mainDiagonalWin || secondaryDiagonalWin;
    }

    // Method to check if the game is a draw
    private static boolean isDraw(String[][] board) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
