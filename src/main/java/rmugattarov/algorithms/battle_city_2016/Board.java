package rmugattarov.algorithms.battle_city_2016;

import java.util.*;

/**
 * Created by rmugattarov on 27.12.2016.
 */
public class Board {

    private final char[][] board;
    private final int[] myCoords = new int[2];
    private final List<int[]> enemyCoords = new ArrayList<int[]>(30);
    private final List<int[]> bullets = new ArrayList<int[]>(30);
    private final Comparator<int[]> closestFirstComparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            double o1dist = getDist(myCoords, o1);
            double o2dist = getDist(myCoords, o2);
            if (o1dist > o2dist) {
                return +1;
            } else if (o2dist > o1dist) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    public static double getDist(int[] o1, int[] o2) {
        int x = Math.abs(o1[0] - o2[0]);
        int y = Math.abs(o1[1] - o2[1]);
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Board(String boardAsString) {
        int rowLen = (int) Math.sqrt(boardAsString.length());
        board = new char[rowLen][rowLen];
        char[] chars = boardAsString.toCharArray();
        for (int y = 0; y < rowLen; y++) {
            for (int x = 0; x < rowLen; x++) {
                int offset = rowLen * y;
                char c = chars[offset + x];
                if (isMyTank(c)) {
                    myCoords[0] = x;
                    myCoords[1] = y;
                } else if (isEnemyTank(c)) {
                    enemyCoords.add(new int[]{x, y});
                } else if (isBullet(c)) {
                    bullets.add(new int[]{x, y});
                }
                board[y][x] = c;
            }
        }
        Collections.sort(enemyCoords, closestFirstComparator);
    }

    public Direction getDirection(int[] coords) {
        if (myCoords[0] == coords[0] && myCoords[1] > coords[1]) {
            return Direction.UP;
        } else if (myCoords[0] < coords[0] && myCoords[1] == coords[1]) {
            return Direction.RIGHT;
        } else if (myCoords[0] == coords[0] && myCoords[1] < coords[1]) {
            return Direction.DOWN;
        } else {
            return Direction.LEFT;
        }
    }

    public Direction getMyDirection() {
        char c = getChar(myCoords[0], myCoords[1]);
        if (c == MyTank.TANK_UP.getSym()) {
            return Direction.UP;
        } else if (c == MyTank.TANK_RIGHT.getSym()) {
            return Direction.RIGHT;
        } else if (c == MyTank.TANK_DOWN.getSym()) {
            return Direction.DOWN;
        } else {
            return Direction.LEFT;
        }
    }

    public int[][] getViews() {
        int[][] result = new int[4][2];

        result[0] = getView(Direction.UP);
        result[1] = getView(Direction.RIGHT);
        result[2] = getView(Direction.DOWN);
        result[3] = getView(Direction.LEFT);

        Arrays.sort(result, closestFirstComparator);
        return result;
    }

    public int[] getView(Direction direction) {
        int[] result = new int[2];
        int[] viewCoord = new int[]{myCoords[0], myCoords[1]};
        int failSafe = 0;
        while (failSafe++ < board.length) {
            switch (direction) {
                case UP:
                    viewCoord[1] = viewCoord[1] - 1;
                    break;
                case RIGHT:
                    viewCoord[0] = viewCoord[0] + 1;
                    break;
                case DOWN:
                    viewCoord[1] = viewCoord[1] + 1;
                    break;
                case LEFT:
                    viewCoord[0] = viewCoord[0] - 1;
                    break;
            }
            if (getChar(viewCoord[0], viewCoord[1]) != Object.GROUND.getSym()) {
                return viewCoord;
            }
        }
        return result;
    }

    public List<int[]> getBullets() {
        return bullets;
    }

    private boolean isBullet(char c) {
        return c == Object.BULLET.getSym();
    }

    private boolean isConstruction(char c) {
        return Construction.fromChar(c) != null;
    }

    public List<int[]> getEnemyCoords() {
        return enemyCoords;
    }

    private boolean isMyTank(char c) {
        return MyTank.fromChar(c) != null;
    }

    private boolean isEnemyTank(char c) {
        return OtherTanks.fromChar(c) != null;
    }

    public int[] getMyCoords() {
        return myCoords;
    }

    public char getChar(int x, int y) {
        return board[y][x];
    }

    public int[] moveToDir(int[] coord, Direction dir) {
        int[] result = Arrays.copyOf(coord, coord.length);
        switch (dir) {
            case UP:
                result[1] = result[1] - 1;
                break;
            case RIGHT:
                result[0] = result[0] + 1;
                break;
            case DOWN:
                result[1] = result[1] + 1;
                break;
            case LEFT:
                result[0] = result[0] - 1;
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Parsed board:\r\n");
        for (char[] chars : board) {
            result.append(Arrays.toString(chars)).append("\r\n");
        }
        return result.toString();
    }

    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    public enum MyTank {
        TANK_UP('▲'),
        TANK_RIGHT('►'),
        TANK_DOWN('▼'),
        TANK_LEFT('◄');
        private final char sym;

        MyTank(char sym) {
            this.sym = sym;
        }

        public static Board.MyTank fromChar(char sym) {
            for (Board.MyTank val : values()) {
                if (sym == val.getSym()) {
                    return val;
                }
            }
            return null;
        }

        public char getSym() {
            return sym;
        }
    }

    public enum OtherTanks {
        BOT_UP('?'),
        BOT_RIGHT('»'),
        BOT_DOWN('¿'),
        BOT_LEFT('«'),
        OTHER_TANK_UP('˄'),
        OTHER_TANK_RIGHT('˃'),
        OTHER_TANK_DOWN('˅'),
        OTHER_TANK_LEFT('˂');
        private final char sym;

        OtherTanks(char sym) {
            this.sym = sym;
        }

        public static Board.OtherTanks fromChar(char sym) {
            for (Board.OtherTanks val : values()) {
                if (sym == val.getSym()) {
                    return val;
                }
            }
            return null;
        }

        public char getSym() {
            return sym;
        }
    }

    public enum Object {
        GROUND(' '),
        WALL('☼'),
        DEAD('Ѡ'),
        BULLET('•');

        private final char sym;

        Object(char sym) {
            this.sym = sym;
        }

        public char getSym() {
            return sym;
        }

        public static Board.Object fromChar(char sym) {
            for (Board.Object val : values()) {
                if (sym == val.getSym()) {
                    return val;
                }
            }
            return null;
        }
    }

    public enum Construction {
        CONSTRUCTION('╬', 3),
        CONSTRUCTION_DESTROYED_DOWN('╩', 2),
        CONSTRUCTION_DESTROYED_UP('╦', 2),
        CONSTRUCTION_DESTROYED_LEFT('╠', 2),
        CONSTRUCTION_DESTROYED_RIGHT('╣', 2),
        CONSTRUCTION_DESTROYED_DOWN_TWICE('╨', 1),
        CONSTRUCTION_DESTROYED_UP_TWICE('╥', 1),
        CONSTRUCTION_DESTROYED_LEFT_TWICE('╞', 1),
        CONSTRUCTION_DESTROYED_RIGHT_TWICE('╡', 1),
        CONSTRUCTION_DESTROYED_LEFT_RIGHT('│', 1),
        CONSTRUCTION_DESTROYED_UP_DOWN('─', 1),
        CONSTRUCTION_DESTROYED_UP_LEFT('┌', 1),
        CONSTRUCTION_DESTROYED_RIGHT_UP('┐', 1),
        CONSTRUCTION_DESTROYED_DOWN_LEFT('└', 1),
        CONSTRUCTION_DESTROYED_DOWN_RIGHT('┘', 1);

        private final char sym;
        private final int strength;

        Construction(char sym, int strength) {
            this.sym = sym;
            this.strength = strength;
        }

        public static Board.Construction fromChar(char sym) {
            for (Board.Construction val : values()) {
                if (sym == val.getSym()) {
                    return val;
                }
            }
            return null;
        }

        public char getSym() {
            return sym;
        }

        public int getStrength() {
            return strength;
        }
    }
}

