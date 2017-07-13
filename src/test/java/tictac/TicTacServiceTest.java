package tictac;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacServiceTest {

	private TicTacService ticTacService;
	@Before
	public void setUp() throws Exception {
		ticTacService = new TicTacService();
	}

	@Test
	public void testBadMoveParams() {
		try {
	        ticTacService.move("", 3, 'X', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("Bad move parameters"));
	    }
	}

	@Test
	public void testBadSizeParams() {
		try {
	        ticTacService.move("12345678", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("Position must be 9 characters long"));
	    }
	}
	
	@Test
	public void testBadChar() {
		try {
	        ticTacService.move("XX10XX00 ", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("Bad character at position 2"));
	    }
	}
	
	@Test
	public void testBadMoves() {
		try {
	        ticTacService.move("XXXXX  00", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	    		//System.out.println(e.getMessage());
	        assertTrue(e.getMessage().contains("Illegal position: bad number of moves made"));
	    }
	}
	
	@Test
	public void testFullBoard() {
		try {
	        ticTacService.move("XXXXX0000", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("Full board, cannot make move"));
	    }
	}
	
	@Test
	public void testHorWin() {
		try {
	        ticTacService.move("   XXX00 ", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("The position already has a winner"));
	    }
	}
	
	@Test
	public void testVertWin() {
		try {
	        ticTacService.move("X  X00X  ", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("The position already has a winner"));
	    }
	}
	
	@Test
	public void testDiag1Win() {
		try {
	        ticTacService.move("X  0X0  X", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("The position already has a winner"));
	    }
	}
	
	@Test
	public void testDiag2Win() {
		try {
	        ticTacService.move("  X0X0X  ", 3, '0', 'X');
	        fail("Expected Exception to be thrown");
	    } catch (Exception e) {
	        assertTrue(e.getMessage().contains("The position already has a winner"));
	    }
	}
	
	@Test
	public void testNormalMove() throws Exception {
		
	    String pos = ticTacService.move("X0X      ", 3, '0', 'X');
	   
	    assertEquals(pos, "X0X0     ");
	}
}
