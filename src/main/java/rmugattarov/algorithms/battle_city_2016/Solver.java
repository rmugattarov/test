package rmugattarov.algorithms.battle_city_2016;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by rmugattarov on 27.12.2016.
 */
public class Solver {

    private Random rand = new Random();
    private final int[] noCoord = new int[]{0, 0};
    private int[] prevPos = noCoord;
    private int tankCooldown;

    public String answer(String boardAsString) {
        try {
            Board board = new Board(boardAsString);

            int[] myCoords = board.getMyCoords();
            if (Arrays.equals(myCoords, noCoord)) {
                return "";
            }
            Board.Direction myDirection = board.getMyDirection();

            int[][] views = board.getViews();
            for (int[] view : views) {
                char viewChar = board.getChar(view[0], view[1]);

                if (Board.OtherTanks.fromChar(viewChar) != null) {
                    Board.Direction direction = board.getDirection(view);
                    if (myDirection == direction) {
                        tankCooldown = 2;
                        prevPos = Arrays.copyOf(board.getMyCoords(), board.getMyCoords().length);
                        return "ACT," + direction;
                    } else {
                        tankCooldown = 2;
                        prevPos = Arrays.copyOf(board.getMyCoords(), board.getMyCoords().length);
                        return direction + ",ACT";
                    }
                }
            }
            return move(board, views);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    private String move(final Board board, int[][] views) {
        tankCooldown--;
        String prefix = "";
        if (tankCooldown < -6) {
            prefix = "ACT,";
            tankCooldown = 2;
        }
        if (prevPos == null || (prevPos[0] == 0 && prevPos[1] == 0) || Arrays.equals(prevPos, board.getMyCoords())) {
            prevPos = Arrays.copyOf(board.getMyCoords(), board.getMyCoords().length);
            return prefix + getRandomDir();
        } else {
            prevPos = Arrays.copyOf(board.getMyCoords(), board.getMyCoords().length);
            return prefix + board.getMyDirection();
        }
    }

    private String getRandomDir() {
        int randInt = rand.nextInt(4);
        for (Board.Direction dir : Board.Direction.values()) {
            if (dir.ordinal() == randInt) {
                return dir.toString();
            }
        }
        return Board.Direction.UP.toString();
    }
}
