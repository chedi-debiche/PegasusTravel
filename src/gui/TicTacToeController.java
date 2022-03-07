/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class TicTacToeController implements Initializable {
    @FXML
    private Circle CircleOne;

    @FXML
    private Circle CircleTwo;

    @FXML
    private Circle CircleThree;

    @FXML
    private Circle CircleFour;

    @FXML
    private Circle CircleFive;

    @FXML
    private Circle CircleSix;

    @FXML
    private Circle CircleSeven;

    @FXML
    private Circle CircleEight;

    @FXML
    private Circle CircleNine;

    @FXML
    private Label XOne;

    @FXML
    private Label XTwo;

    @FXML
    private Label XThree;

    @FXML
    private Label XFour;

    @FXML
    private Label XFive;

    @FXML
    private Label XSix;

    @FXML
    private Label XSeven;

    @FXML
    private Label XEight;

    @FXML
    private Label XNine;

    @FXML
    private Label lblMessages;

    private int[] filledSquares = new int[9];
    private int[] filledCircles = new int[5];
    private int[] filledX = new int[5];

    private int filledSquaresCounter = 0;
    private int filledCirclesCounter = 0;
    private int filledXCounter = 0;

    private char winningTeam;

    final private int[][] winningPositions = {
        {1, 5, 9},
        {3, 5, 7},
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };

    private boolean allowMoves = true;

    private boolean tie = false;
    @FXML
    private Rectangle SquareOne;
    @FXML
    private Rectangle SquareTwo;
    @FXML
    private Rectangle SquareThree;
    @FXML
    private Rectangle SquareFour;
    @FXML
    private Rectangle SquareFive;
    @FXML
    private Rectangle SquareSix;
    @FXML
    private Rectangle SquareSeven;
    @FXML
    private Rectangle SquareEight;
    @FXML
    private Rectangle SquareNine;
    @FXML
    private Button btnReset;

    @FXML
    public void handleSquareOneClick(MouseEvent event) {
        this.handleSquareClick(1);
    }

    @FXML
    public void handleSquareTwoClick(MouseEvent event) {
        this.handleSquareClick(2);
    }

    @FXML
    public void handleSquareThreeClick(MouseEvent event) {
        this.handleSquareClick(3);
    }

    @FXML
    public void handleSquareFourClick(MouseEvent event) {
        this.handleSquareClick(4);
    }

    @FXML
    public void handleSquareFiveClick(MouseEvent event) {
        this.handleSquareClick(5);
    }

    @FXML
    public void handleSquareSixClick(MouseEvent event) {
        this.handleSquareClick(6);
    }

    @FXML
    public void handleSquareSevenClick(MouseEvent event) {
        this.handleSquareClick(7);
    }

    @FXML
    public void handleSquareEightClick(MouseEvent event) {
        this.handleSquareClick(8);
    }

    @FXML
    public void handleSquareNineClick(MouseEvent event) {
        this.handleSquareClick(9);
    }

    public void handleSquareClick(int squareNumber) {
        if(!isAlreadySelectedBox(squareNumber) && this.allowMoves == true) {
            switch(squareNumber) {
                case 1:
                    this.showCircleOne();
                    break;
                case 2:
                    this.showCircleTwo();
                    break;
                case 3:
                    this.showCircleThree();
                    break;
                case 4:
                    this.showCircleFour();
                    break;
                case 5:
                    this.showCircleFive();
                    break;
                case 6:
                    this.showCircleSix();
                    break;
                case 7:
                    this.showCircleSeven();
                    break;    
                case 8:
                    this.showCircleEight();
                    break;
                case 9:
                    this.showCircleNine();
                    break;
                default:
                    System.out.println("Impossible choice");
                    break;
            }

            this.filledSquares[this.filledSquaresCounter] = squareNumber;
            this.filledCircles[this.filledCirclesCounter] = squareNumber;
            this.filledSquaresCounter++;
            this.filledCirclesCounter++;

            if(this.checkVictory()) {
                this.endGame();
            } else {
                this.playRandomMove();

                if(this.checkVictory()) {
                    this.endGame();
                }
            }
        } else if(this.filledSquaresCounter >= 9) {
            this.tie = true;
            this.endGame();
        }
    }

    public boolean isAlreadySelectedBox(int squareNumber) {
        boolean found = false;

        for(int filledSquare : this.filledSquares) {
            if(squareNumber == filledSquare) {
                found = true;
            }
        }

        return found == true;
    }

    public boolean checkVictory() {
        if(this.filledCirclesCounter < 3 && this.filledXCounter < 3) {
            return false;
        }

        for(int[] filled : this.winningPositions) {
            int slotCounter = 0;

            for(int singleFilled : filled) {
                if(this.isOccupiedByCircle(singleFilled)) {
                    slotCounter++;
                }
            }

            if(slotCounter == 3) {
                this.winningTeam = 'O';
                this.allowMoves = false;
                return true;
            }

            slotCounter = 0;

            for(int singleFilled : filled) {
                if(this.isOccupiedByX(singleFilled)) {
                    slotCounter++;
                }
            }

            if(slotCounter == 3) {
                this.winningTeam = 'X';
                this.allowMoves = false;
                return true;
            }
        }

        return false;
    }

    public void showCircleOne() {
        this.CircleOne.setVisible(true);
    }

    public void showCircleTwo() {
        this.CircleTwo.setVisible(true);
    }

    public void showCircleThree() {
        this.CircleThree.setVisible(true);
    }

    public void showCircleFour() {
        this.CircleFour.setVisible(true);
    }

    public void showCircleFive() {
        this.CircleFive.setVisible(true);
    }

    public void showCircleSix() {
        this.CircleSix.setVisible(true);
    }

    public void showCircleSeven() {
        this.CircleSeven.setVisible(true);
    }

    public void showCircleEight() {
        this.CircleEight.setVisible(true);
    }

    public void showCircleNine() {
        this.CircleNine.setVisible(true);
    }

    public void playRandomMove() {
        Random random = new Random();
        int result = random.nextInt(9 - 1 + 1) + 1;;

        if(this.filledSquaresCounter < 9) {
            while(this.isAlreadySelectedBox(result)) {
                result = random.nextInt(9 - 1 + 1) + 1;
            }

            switch(result) {
                case 1:
                    this.showXOne();
                    break;
                case 2:
                    this.showXTwo();
                    break;
                case 3:
                    this.showXThree();
                    break;
                case 4:
                    this.showXFour();
                    break;
                case 5:
                    this.showXFive();
                    break;
                case 6:
                    this.showXSix();
                    break;
                case 7:
                    this.showXSeven();
                    break;    
                case 8:
                    this.showXEight();
                    break;
                case 9:
                    this.showXNine();
                    break;
                default:
                    System.out.println("Impossible choice");
                    break;
            }

            this.filledSquares[this.filledSquaresCounter] = result;
            this.filledX[this.filledXCounter] = result;
            this.filledSquaresCounter++;
            this.filledXCounter++;
        } else {
            this.tie = true;
            this.endGame();
        }


    }

    public void showXOne() {
        this.XOne.setVisible(true);
    }

    public void showXTwo() {
        this.XTwo.setVisible(true);
    }

    public void showXThree() {
        this.XThree.setVisible(true);
    }

    public void showXFour() {
        this.XFour.setVisible(true);
    }

    public void showXFive() {
        this.XFive.setVisible(true);
    }

    public void showXSix() {
        this.XSix.setVisible(true);
    }

    public void showXSeven() {
        this.XSeven.setVisible(true);
    }

    public void showXEight() {
        this.XEight.setVisible(true);
    }

    public void showXNine() {
        this.XNine.setVisible(true);
    }

    public boolean isOccupiedByCircle(int circlePosition) {
        boolean found = false;

        for(int filledCircle : this.filledCircles) {
            if(filledCircle == circlePosition) {
                found = true;
            }
        }

        return found == true;
    }

    public boolean isOccupiedByX(int xPosition) {
        boolean found = false;

        for(int filled : this.filledX) {
            if(filled == xPosition) {
                found = true;
            }
        }

        return found == true;
    }

    public void endGame() {
        this.allowMoves = false;

        if(this.tie == true) {
            this.lblMessages.setText("It was a tie!");
        } else if(String.valueOf(this.winningTeam).equals("O")) {
            this.lblMessages.setText("You win!");
        } else if(String.valueOf(this.winningTeam).equals("X")) {
            this.lblMessages.setText("Sorry, you lose!");
        }
    }

    @FXML
    public void handleResetButton(ActionEvent event) {
        this.CircleOne.setVisible(false);
        this.CircleTwo.setVisible(false);
        this.CircleThree.setVisible(false);
        this.CircleFour.setVisible(false);
        this.CircleFive.setVisible(false);
        this.CircleSix.setVisible(false);
        this.CircleSeven.setVisible(false);
        this.CircleEight.setVisible(false);
        this.CircleNine.setVisible(false);

        this.XOne.setVisible(false);
        this.XTwo.setVisible(false);
        this.XThree.setVisible(false);
        this.XFour.setVisible(false);
        this.XFive.setVisible(false);
        this.XSix.setVisible(false);
        this.XSeven.setVisible(false);
        this.XEight.setVisible(false);
        this.XNine.setVisible(false);

        this.winningTeam = 0;

        this.allowMoves = true;
        this.tie = false;

        this.lblMessages.setText("");

        this.filledSquares = new int[9];
        this.filledCircles = new int[5];
        this.filledX = new int[5];

        this.filledSquaresCounter = 0;
        this.filledCirclesCounter = 0;
        this.filledXCounter = 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}

