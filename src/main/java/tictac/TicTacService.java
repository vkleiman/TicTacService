package tictac;


public class TicTacService {

	public String move(String pos, int sz, char comp, char user) throws Exception {
		
		if(comp==user || comp==' ' || user==' ')
			throw new Exception("Bad move parameters");
		
		int boardsz = sz*sz;
		if(pos.length() != boardsz)
			throw new Exception("Position must be " + boardsz + " characters long");
		
		checkChars(pos, comp, user);
		
		//calculate number of moves comp, user, empty
		int compMoves = getChars(pos, comp);
		int userMoves = getChars(pos, user);
		int empty = getChars(pos, ' ');
		assert(boardsz == empty+compMoves+userMoves);
		
		//check within 1 of each other, else bad pos
		if(!(userMoves==compMoves || userMoves==compMoves+1))
			throw new Exception("Illegal position: bad number of moves made");
		
		if(empty==0)
			throw new Exception("Full board, cannot make move");
		
		if(haveWinner(pos, sz))
			throw new Exception("The position already has a winner");
		
		return pos.replaceFirst(" ", Character.toString(comp));
	}
	
	private void checkChars(String pos, char comp, char user) throws Exception {
		
		for(int i=0; i<pos.length(); i++) {
			
			char ch = pos.charAt(i);
			if(ch !=' ' && ch != comp && ch != user)
				throw new Exception("Bad character at position " + i);
		}
	}
	
	private int getChars(String pos, char checkChar) {
		
		int count=0;
		for(int i=0; i<pos.length(); i++) {
			char ch = pos.charAt(i);
			if(ch== checkChar)
				count++;
		}		
		return count;
	}
	
    private boolean haveWinner(String pos, int sz) {
    	
    		char board[][] = new char[sz][sz];
    		
    		for(int r=0; r<sz; r++) {
    			for(int c=0; c<sz; c++) {
    				board[r][c] = pos.charAt(r*sz + c);
    			}
    		}
    		
    		//horizontal winner
    		for(int r=0; r<sz; r++) {
    			char ch = board[r][0];
    			if(ch == ' ')
    				continue;
    			boolean allsame=true;
    			for(int c=1; c<sz; c++) {
    				if(ch!=board[r][c]) {
    					allsame = false;
    					break;
    				}
    			}
    			if(allsame)
    				return true;
    		}
    		//System.out.println("111");
    		
    		//vert winner
    		for(int c=0; c<sz; c++) {
    			char ch = board[0][c];
    			if(ch == ' ')
    				continue;
    			boolean allsame = true;
    			for(int r=1; r<sz; r++) {
    				if(ch!=board[r][c]) {
    					allsame = false;
    					break;
    				}
    			}
    			if(allsame)
    				return true;
    		}
    		//System.out.println("222");
    		
    		//diag 1 winner
    		if(board[0][0] != ' ') {
    			for(int i=1; i<sz; i++) {
    				if(board[i][i]!=board[0][0])
    					break;
    				if(i==sz-1)
    					return true;
    			}
    		}
    		
    		//diag 2 winner
    		if(board[0][sz-1] != ' ') {
    			for(int i=1, j=sz-2; i<sz; i++, j--) {
    				if(board[i][j]!=board[0][sz-1])
    					break;
    				if(i==sz-1)
    					return true;
    			}
    		}
    		
    		return false;
    }
}
