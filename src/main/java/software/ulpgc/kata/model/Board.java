package software.ulpgc.kata.model;

public class Board {
    private final String[][] state;
    private final int rows;
    private final int columns;

    public Board(String[][] state) {
        this.state = state;
        this.rows = state.length;
        this.columns = state[0].length;
    }

    public String[][] state() {
        return state;
    }

    public Board next() {
        return new Board(getNextState());
    }

    private String[][] getNextState() {
        String[][] newState = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newState[i][j] = getNextCellState(i, j);
            }
        }
        return newState;
    }

    private String getNextCellState(int x, int y) {
        return shouldCellBeAlive(x, y) ? "X" : ".";
    }

    private boolean shouldCellBeAlive(int x, int y) {
        int neighbors = getCellNeighbors(x, y);
        return neighbors == 3 || (cellIsAlive(x, y) && neighbors == 2);
    }

    private int getCellNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;
                if(cellExists(x + i, y + j) && cellIsAlive(x + i, y + j)) count++;
            }
        }
        return count;
    }

    private boolean cellExists(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    private boolean cellIsAlive(int x, int y) {
        return state[x][y].equals("X");
    }
}
