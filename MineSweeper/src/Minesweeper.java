public class Minesweeper {

    public static int SIZE = 10;
    public static int NUM_MINES = 15;

    public static void main(String[] unused) {
        boolean[][] minefield = new boolean[SIZE][SIZE];
        boolean[][] uncovered = new boolean[SIZE][SIZE];
        StdDraw.setScale(-0.5, SIZE - 0.5);
        init(minefield, NUM_MINES);
        draw(minefield);

        // Event loop
        while (true) {
            handleMouseClick(minefield, uncovered);
            draw(minefield);
            if (hasWon(minefield, uncovered)) {
                StdOut.println("You won!");
                break;
            }
        }

    }

    public static int countNeighbors(boolean[][] minefield, int x, int y) {
        int size = minefield.length;
        int count = 0;
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < size && y1 >= 0 && y1 < size && (x1 != x || y1 != y)) {
                    if (minefield[x1][y1]) ++count;
                }
            }
        }
        return count;
    }

    public static void init(boolean[][] minefield, int numMines) {
        int size = minefield[0].length;
        for (int i = 0; i < numMines; ++i) {
            int x = StdRandom.uniform(size);
            int y = StdRandom.uniform(size);
            if (!minefield[x][y]) {
                minefield[x][y] = true;
            }
            else {
                --i;
            }
        }
    }

    public static void draw(boolean[][] minefield) {
        int size = minefield.length;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                StdDraw.square(i, j, 0.5);
            }
        }
    }

    public static void handleMouseClick(boolean[][] minefield, boolean[][] uncovered) {
        // waiting for the button to be pressed
        while (!StdDraw.isMousePressed()) {
            // do nothing
        }

        int x = (int)Math.round(StdDraw.mouseX());
        int y = (int)Math.round(StdDraw.mouseY());

        // waiting for the button to be released
        while (StdDraw.isMousePressed()) {
            // do nothing
        }

        uncover(minefield, uncovered, x, y);

        if (minefield[x][y]) {
            StdOut.println("BOOM");
        }
    }

    static public void uncover(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        if (countNeighbors(minefield, x, y) == 0) {
            propagate(minefield, uncovered);
        }

    }

    static public void propagate(boolean[][] minefield, boolean[][] uncovered) {
        int size = minefield.length;

        while (true){
            boolean equilibriumReached = true;

            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    if (isThereNeighborWithOutMinesAndUncovered(minefield, uncovered, x, y)) {
                        uncovered[x][y] = true;
                    }
                }
            }
            if (equilibriumReached) break;
        }
        return;
    }

    static public boolean isThereNeighborWithOutMinesAndUncovered(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        int size = minefield.length;
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < size && y1 >= 0 && y1 < size) {
                    if (!uncovered[x1][y1] && countNeighbors(minefield, x1, y1) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static public boolean hasWon(boolean[][] minefield, boolean[][] uncovered) {
        /*
        countUncovered = 0;
        numMines = <whatever that is>

        for (int i = 0; i < minefield[][].length; i++ ){
            for (int j = 0; j < minefield[0].length; j++ ){
                if (minefield[i][j] == uncovered)
            }
        }

        * */
        return false;
    }

}