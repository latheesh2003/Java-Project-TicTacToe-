import java.util.Scanner;

class TicTacToe {
    public static void main(String args[]) {
        boolean playAgain = true;
        Scanner sc = new Scanner(System.in);
        while (playAgain) {
            char[][] board = new char[3][3];
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = ' ';
                }
            }
            char player = 'X';
            boolean gameOver = false;

            while (!gameOver) {
                printBoard(board);
                System.out.print("Player " + player + " enter: ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                System.out.println();

                if (board[row][col] == ' ') {
                    board[row][col] = player; // place the element
                    gameOver = haveWon(board, player);
                    if (gameOver) {
                        System.out.println("Player " + player + " has Won Congratulations!");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                        /*
                         * if (player == 'X'){
                         * player = 'O';}
                         * else{
                         * player = 'X';}
                         */
                    }
                } else {
                    System.out.println("Invalid move. Try again!");
                }
            }
            printBoard(board);
            System.out.println();

            // Ask if the player wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        System.out.println("Thank you for playing!");
        sc.close();

    }

    public static boolean haveWon(char[][] board, char player) {
        // check for the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // check for the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // check for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;

    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
