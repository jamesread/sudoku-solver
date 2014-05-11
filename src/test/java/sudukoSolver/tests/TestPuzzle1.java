package sudukoSolver.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import sudukoSolver.model.Cell;
import sudukoSolver.model.CellCollection;
import sudukoSolver.model.Puzzle;
import sudukoSolver.model.Puzzle.PuzzleFormatException;
import sudukoSolver.solver.BruteForceSolver;

public class TestPuzzle1 {
	@Test
	public void test1() throws PuzzleFormatException, IOException {
		Puzzle p1 = new Puzzle("src/test/resources/1.puzzle");

		p1.setPuzzle("  9   463" + "  634 529" + "234569718" + " 67   34 " + " 4  3 29 " + " 2    68 " + "  2  1934" + "493825176" + " 7 493852");

		Assert.assertEquals(0, p1.humanToOffset(1, 1));
		Assert.assertEquals(1, p1.humanToOffset(1, 2));
		Assert.assertEquals(2, p1.humanToOffset(1, 3));
		Assert.assertEquals(80, p1.humanToOffset(9, 9));
		Assert.assertEquals(9, (int) p1.getCell(1, 3));
		Assert.assertNull(p1.getCell(1, 1));

		System.out.println(p1);

		Assert.assertEquals("  9   463", p1.getRow(1).toString());

		BruteForceSolver solver = new BruteForceSolver(p1);
		solver.solve();

		System.out.println("solved.\n");

		System.out.println(p1);
	}

	@Test
	public void testGetGrid() throws PuzzleFormatException {
		Puzzle puzzle = new Puzzle();
		puzzle.setPuzzle("010000000000000000000000000000000000000000000000000000000000000000000000000000000");

		CellCollection cells = new Cell(puzzle, 1, 1).getGrid();

		System.out.println(cells);
	}
}
