package sudukoSolver.model;

public class Cell {
	private final int x, y;
	private final Puzzle puzzle;

	public Cell(Puzzle puzzle, int x, int y) {
		this.x = x;
		this.y = y;
		this.puzzle = puzzle;
	}

	public boolean fits(int possibleNumber) {
		if (this.puzzle.getRow(this.x).hasValue(possibleNumber)) {
			return false;
		}

		if (this.puzzle.getCol(this.y).hasValue(possibleNumber)) {
			return false;
		}

		if (this.getGrid().hasValue(possibleNumber)) {
			return false;
		}

		return true;
	}

	public CellCollection getGrid() {
		CellCollection grid = new CellCollection();

		int gridx = (this.x - 1) / 3;
		int gridy = (this.y - 1) / 3;

		for (int x = 1; x <= 3; x++) {
			for (int y = 1; y <= 3; y++) {
				int relx = (gridx * 3) + x;
				int rely = (gridy * 3) + y;

				Cell cell = new Cell(this.puzzle, relx, rely);

				grid.add(cell);
			}
		}

		return grid;
	}

	public Integer getValue() {
		return this.puzzle.getCell(this.x, this.y);
	}

	public String getValueString() {
		return this.puzzle.getCellString(this.x, this.y);
	}

	public boolean isEmpty() {
		return this.getValue() == null;
	}

	public void set(int value) {
		this.puzzle.setPuzzle(this.x, this.y, value);
	}
}
