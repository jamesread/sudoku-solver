package sudokuSolver.solver;

import java.util.Iterator;

import sudokuSolver.model.Cell;
import sudokuSolver.model.CellCollection;
import sudokuSolver.model.Puzzle;

public class BruteForceSolver {
	private final Puzzle puzzle;

	public BruteForceSolver(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	public void solve() {
		while (this.puzzle.hasUnsolvedCells()) {
			for (Cell unsolvedCell : this.puzzle.getUnsolvedCells()) {
				for (int possibleNumber = 1; possibleNumber <= 9; possibleNumber++) {
					CellCollection emptyCells = unsolvedCell.getGrid().getEmptyCells();

					Iterator<Cell> it = emptyCells.iterator();

					while (it.hasNext()) {
						Cell emptyCell = it.next();

						if (!emptyCell.fits(possibleNumber)) {
							it.remove();
						}
					}

					if (emptyCells.size() == 1) {
						emptyCells.firstElement().set(possibleNumber);
					}
				}
			}

			System.out.println(this.puzzle);
		}
	}
}
