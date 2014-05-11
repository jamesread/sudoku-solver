package sudokuSolver.model;

import java.io.IOException;

import sudokuSolver.Util;

public class Puzzle {
	public class PuzzleFormatException extends Exception {

		public PuzzleFormatException(String string) {
			super(string);
		}
	}

	public Integer[] cells = new Integer[81];

	private final CellCollection unsolvedCells = new CellCollection();

	public Puzzle() {
	}

	public Puzzle(String path) throws IOException, PuzzleFormatException {
		String content = Util.fullyReadfile(path);

		this.setPuzzle(content);
	}

	public void findUnsolvedCells() {
		this.unsolvedCells.clear();

		for (int x = 1; x <= 9; x++) {
			for (int y = 1; y <= 9; y++) {
				if (this.cells[this.humanToOffset(x, y)] == null) {
					this.unsolvedCells.add(new Cell(this, x, y));
				}
			}
		}

		System.out.println("There are " + this.unsolvedCells.size() + " unsolved cells remaining.");
	}

	public Integer getCell(int i, int j) {
		return this.cells[this.humanToOffset(i, j)];
	}

	public String getCellString(int x, int y) {
		Integer i = this.getCell(x, y);

		if (i == null) {
			return " ";
		} else {
			return i.toString();
		}
	}

	public CellCollection getCol(int y) {
		CellCollection col = new CellCollection();

		for (int i = 1; i <= 9; i++) {
			col.add(new Cell(this, i, y));
		}

		return col;
	}

	public CellCollection getRow(int x) {
		CellCollection row = new CellCollection();

		for (int i = 1; i <= 9; i++) {
			row.add(new Cell(this, x, i));
		}

		return row;
	}

	public CellCollection getUnsolvedCells() {
		return this.unsolvedCells;
	}

	public boolean hasUnsolvedCells() {
		this.findUnsolvedCells();

		return !this.unsolvedCells.isEmpty();
	}

	public int humanToOffset(int x, int y) {
		int ret = ((x - 1) * 9) + (y - 1);

		return ret;
	}

	public void setPuzzle(int x, int y, int value) {
		this.cells[this.humanToOffset(x, y)] = value;
	}

	public void setPuzzle(String cellString) throws PuzzleFormatException {
		if (cellString.length() != 81) {
			throw new PuzzleFormatException("Puzzle with length: " + cellString.length());
		}

		for (int i = 0; i < 81; i++) {
			String valueString = cellString.substring(i, i + 1);

			if (valueString.equals(" ")) {
				this.cells[i] = null;
			} else {
				Integer v = Integer.parseInt(valueString);

				this.cells[i] = v;
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";

		for (int x = 1; x <= 9; x++) {
			for (int y = 1; y <= 9; y++) {
				Integer v = this.getCell(x, y);

				if (v == null) {
					ret += " ";
				} else {
					ret += v;
				}

				if (((y % 3) == 0) && (y != 9)) {
					ret += " | ";
				}
			}

			ret += "\n";

			if (((x % 3) == 0) && (x != 9)) {
				ret += "----------------\n";
			}
		}

		return ret;
	}

}
