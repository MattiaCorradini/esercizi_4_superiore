package com.example.forza_4;

import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Forza4 {
    private Button[][] buttonsArray;
    private char currentPlayer;
    private char[][] board;
    private int movesCount;
    public void gioca(Button[][] buttons) {
        currentPlayer = 'X';
        buttonsArray = buttons;
        board = new char[6][7];
        movesCount = 0;
        assignActionEventHandlers();
        enableAllButtons();
    }

    private void assignActionEventHandlers() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                final int rowIndex = row;
                final int colIndex = col;
                buttonsArray[row][col].setOnAction(event -> makeMove(rowIndex, colIndex));
            }
        }
    }

    private void enableAllButtons() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                buttonsArray[row][col].setDisable(false);
            }
        }
    }

    private void makeMove(int row, int col) {
        if (board[row][col] == '\0') {
            board[row][col] = currentPlayer;
            movesCount++;
            Button button = buttonsArray[row][col];
            button.setText(Character.toString(currentPlayer));
            button.setDisable(true);

            if (checkWin(row, col)) {
                showWinnerDialog(currentPlayer + " wins!");
                resetGame();
            } else if (movesCount == 42) {
                showWinnerDialog("It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWin(int row, int col) {
        int count = 0;
        for (int c = 0; c < 7; c++) {
            if (board[row][c] == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int r = 0; r < 6; r++) {
            if (board[r][col] == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        int startRow = row - Math.min(row, col);
        int startCol = col - Math.min(row, col);
        for (int i = 0; i < 6; i++) {
            if (startRow + i < 6 && startCol + i < 7 && board[startRow + i][startCol + i] == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        startRow = row + Math.min(5 - row, col);
        startCol = col - Math.min(5 - row, col);
        for (int i = 0; i < 6; i++) {
            if (startRow - i >= 0 && startCol + i < 7 && board[startRow - i][startCol + i] == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private void showWinnerDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void resetGame() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = '\0';
                buttonsArray[row][col].setText("");
                buttonsArray[row][col].setDisable(false);
            }
        }

        movesCount = 0;
    }
}