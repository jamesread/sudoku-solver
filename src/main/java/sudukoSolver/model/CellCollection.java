package sudukoSolver.model;

import java.util.Vector;

public class CellCollection extends Vector<Cell> {

	public CellCollection getEmptyCells() {
		CellCollection empties = new CellCollection();

		for (Cell cell : this) {
			if (cell.isEmpty()) {
				empties.add(cell);
			}
		}

		return empties;
	}

	public boolean hasValue(int possibleNumber) {
		for (Cell cell : this) {
			if (cell.isEmpty()) {
				continue;
			}

			if (cell.getValue() == possibleNumber) {
				return true;
			}
		}

		return false;
	}

	@Override
	public synchronized String toString() {
		String ret = "";

		for (Cell c : this) {
			ret += c.getValueString();
		}

		return ret;
	}

}
