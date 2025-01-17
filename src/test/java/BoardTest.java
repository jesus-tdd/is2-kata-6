import org.junit.jupiter.api.Test;
import software.ulpgc.kata.model.Board;

import static  org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void empty_board() {
        Board board = new Board(Cases.EMPTY_BOARD).next();
        assertThat(board.state()).isEqualTo(Cases.EMPTY_BOARD);
    }

    @Test
    public void single_dead_cell() {
        Board board = new Board(Cases.ONE_DEAD_CELL).next();
        assertThat(board.state()).isEqualTo(Cases.ONE_DEAD_CELL);
    }

    @Test
    public void single_alive_cell() {
        Board board = new Board(Cases.ONE_ALIVE_CELL).next();
        assertThat(board.state()).isEqualTo(Cases.ONE_DEAD_CELL);
    }

    @Test
    public void dead_cells_2x2() {
        Board board = new Board(Cases.ALL_DEAD_CELLS_2X2).next();
        assertThat(board.state()).isEqualTo(Cases.ALL_DEAD_CELLS_2X2);
    }

    @Test
    public void alive_cells_2x2() {
        Board board = new Board(Cases.ALL_ALIVE_CELLS_2X2).next();
        assertThat(board.state()).isEqualTo(Cases.ALL_ALIVE_CELLS_2X2);
    }

    @Test
    public void line_2x2() {
        Board board = new Board(Cases.LINE_STRUCTURE_2X2).next();
        assertThat(board.state()).isEqualTo(Cases.ALL_DEAD_CELLS_2X2);
    }

    @Test
    public void triangle_2x2() {
        Board board = new Board(Cases.TRIANGLE_STRUCTURE_2X2).next();
        assertThat(board.state()).isEqualTo(Cases.ALL_ALIVE_CELLS_2X2);
    }

    @Test
    public void triangle_3x3() {
        Board board = new Board(Cases.TRIANGLE_STRUCTURE_3X3).next();
        assertThat(board.state()).isEqualTo(Cases.SQUARE_STRUCTURE_3X3);
    }


    public static class Cases {
        static final String[][] EMPTY_BOARD = {{}};
        static final String[][] ONE_DEAD_CELL = {{"."}};
        static final String[][] ONE_ALIVE_CELL = {{"X"}};
        static final String[][] ALL_DEAD_CELLS_2X2 = {
                {".", "."},
                {".", "."}
        };
        static final String[][] ALL_ALIVE_CELLS_2X2 = {
                {"X", "X"},
                {"X", "X"}
        };
        static final String[][] TRIANGLE_STRUCTURE_2X2 = {
                {"X", "X"},
                {"X", "."}
        };
        static final String[][] LINE_STRUCTURE_2X2 = {
                {"X", "X"},
                {".", "."}
        };
        static final String[][] TRIANGLE_STRUCTURE_3X3 = {
                {"X", "X", "."},
                {"X", ".", "."},
                {".", ".", "."}
        };
        static final String[][] SQUARE_STRUCTURE_3X3 = {
                {"X", "X", "."},
                {"X", "X", "."},
                {".", ".", "."}
        };
    }
}
