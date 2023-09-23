package edu.ncsu.monopoly;

public class JailCell extends Cell {
	public static int BAIL = 50;
	
	public JailCell() {
		setName("Jail");
	}
	
	public void playAction(){
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(!currentPlayer.isInJail()) {
				if(currentPlayer.getMoney() >= BAIL) {
					currentPlayer.payRentTo(null, BAIL);
					currentPlayer.setInJail(false);
				}
			}
		}
	}
}
