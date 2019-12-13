package Control;

import Logic.Game;

public class BuyCommand extends Command{

	public BuyCommand() {
		super("buy", "b", "buy", "Buy supermisil");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		boolean buy = false;
		
		if(game.getPoints() >= 20) {
			buy =  true;
			game.buyMisil();
		}
		else {
			System.out.println("No tienes puntos suficientes, no puedes comprar super misil");
			buy = true;
		}
		
		return buy;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (!(commandWords.length > 1)) {
			if (matchCommandName(commandWords[0])) {
				command = new BuyCommand();
			}
		}
		return command;
	}

}
