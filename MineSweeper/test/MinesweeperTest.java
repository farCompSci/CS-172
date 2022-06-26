import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    void foo() {
        StdOut.println("foo");
    }

    @Test
    void countNeighbors() {
        boolean[][] minefield = new boolean[5][5];
        minefield[0][1] = true;
        minefield[1][0] = true;
        assertEquals(2, Minesweeper.countNeighbors(minefield, 0, 0));
        assertEquals(1, Minesweeper.countNeighbors(minefield, 0, 2));
        assertEquals(0, Minesweeper.countNeighbors(minefield, 4, 4));
    }

    @Test
    void init() {
        boolean[][] minefield = new boolean[5][5];
        Minesweeper.init(minefield, 5);
        int count = 0;
        for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 5; ++y) {
                if (minefield[x][y] == true) ++count;
            }
        }
        assertEquals(5, count);
    }

    @Test
    void hasWon() {
        boolean[][] minefield = {
                {  true, false, false },
                { false, false, false },
                { false, false, false }
        };
        boolean[][] uncovered = {
                { false,  true, false },
                { false, false, false },
                { false, false, false }
        };
        assertFalse(Minesweeper.hasWon(minefield, uncovered));
        boolean[][] uncovered2 = {
                { false,  true,  true },
                {  true,  true,  true },
                {  true,  true,  true }
        };
        assertTrue(Minesweeper.hasWon(minefield, uncovered2));
    }

    @Test
    void uncover_no_propagation() {
        boolean[][] minefield = {
                { false, false,  true },
                { false, false, false },
                { false, false, false }
        };
        boolean[][] uncovered = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };
        Minesweeper.uncover(minefield, uncovered, 0, 1);
        boolean[][] expected = {
                { false,  true, false },
                { false, false, false },
                { false, false, false }
        };
        assertArrayEquals(expected, uncovered);
    }

    @Test
    void uncover_simple_propagation() {
        boolean[][] minefield = {
                { false, false, false },
                { false, false, false },
                { false, false,  true }
        };
        boolean[][] uncovered = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };
        Minesweeper.uncover(minefield, uncovered, 0, 0);
        boolean[][] expected = {
                {  true,  true,  true },
                {  true,  true,  true },
                {  true,  true, false }
        };
        assertArrayEquals(expected, uncovered);
    }

    @Test
    void uncover_complex_propagation() {
        boolean[][] minefield = {
                {  true, false, false },
                { false, false, false },
                { false, false, false }
        };
        boolean[][] uncovered = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };
        Minesweeper.uncover(minefield, uncovered, 2, 2);
        boolean[][] expected = {
                { false,  true,  true },
                {  true,  true,  true },
                {  true,  true,  true }
        };
        assertArrayEquals(expected, uncovered);
    }

}