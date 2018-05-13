import java.util.Scanner;
/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
    public static void jeu_naive(int a)
    {
	GameState 		currentGame;
	HumanPlayer		Player1;
		
	Board			table;
	int				i;
	Scanner sc;
	int iA;
	int compt;
	int[] tab;
	boolean bwantToPlayAgain;
	boolean winsIa;
	boolean winsPlayer;
	boolean ends;
	int ask;
	int res1, res2;

        
	res1 = 0;
	res2 = 0;
	bwantToPlayAgain = true;
	currentGame = new GameState();
	while(bwantToPlayAgain)
	{
	    
	    sc = new Scanner(System.in);
	    Console.script(0);
	    ask = 0;
	    Console.script(1);
	    table = new Board();
	    tab = table.getBoard();
	    IA_naive Bot;   
	    Bot = new IA_naive(tab); 
	    Player1 = Console.getName1();
	    i = 0;
	    Console.clear_term();
	    ends = false;
	    winsIa = false;
	    winsPlayer = false;
	    while (table.getNbMatchLeft() > 1 || ends == false)
		{
		    Console.ShowBoard(table.getBoard());
		    compt = 0;
		    while(compt < 2)
		    {
			
			if(compt == 0)
			{
			        
			    if (table.setBoard(Console.getMove(Bot.getName(), Bot.iaPlays(table.getBoard()))))
			    {
				currentGame.setNbMove();
			    }
				
			        
			    System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
			    compt++;

			    if(table.getNbMatchLeft() == 0 && winsPlayer == false)
			    {
				winsPlayer = true;
				compt = 3;
			    }
			    else  if(table.getNbMatchLeft() == 1 && winsPlayer == false)
			    {
				winsIa = true;
				compt = 3;
			    }
			}
			else if(compt == 1)
			{
			    Console.ShowBoard(table.getBoard());
			    if(table.setBoard(Console.getMove(Player1.getName(),table.getBoard())))
			    {
				currentGame.setNbMove();
			    }
			    Console.clear_term();
			    System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
			    compt++;

			    if(table.getNbMatchLeft() == 0 && winsIa == false)
				winsIa = true;
			    else  if(table.getNbMatchLeft() == 1 && winsIa == false)
				winsPlayer = true;
			}

			if(winsIa == true || winsPlayer == true)
			    ends = true;  
			    
		    }

		}
		if(winsIa)
		{
		    Console.showWinner(Bot.getName());
		    Bot.setNbWin();
		}
		else if (winsPlayer)
		{
		    Console.showWinner(Player1.getName());
		    Player1.setNbWins();
		}
		   
		System.out.println("Voulez-vous rejouer la partie?");
		ask = sc.nextInt();

		if(ask == 1)
		    bwantToPlayAgain = true;
		else if(ask ==0)
		    bwantToPlayAgain = false;

		if(winsIa)
		    res2++; 
		else
		    res1++;
		System.out.println("Nombre de victoire : \n"+ "Player : "+ res1+ "\n"+ "IA naive : "+ res2);
	
	}
	currentGame.setState(false);
    }

    public static void jeu_intel(int b)
    {
	GameState 		currentGame;
	HumanPlayer		Player1;
	Ia_intel Bot;
	Board			table;
	int				i;
	Scanner sc;
	int compt;
	int[] tab;
	boolean bwantToPlayAgain;
	boolean winsIa;
	boolean winsPlayer;
	boolean ends;
	int ask;
	int res1, res2;

	res1 = 0;
	res2 = 0;
	bwantToPlayAgain = true;
	currentGame = new GameState();

	while(bwantToPlayAgain)
	{
		sc = new Scanner(System.in);
		    
		Console.script(0);
	    
		ask = 0;
		    
		Console.script(1);
		table = new Board();

		tab = table.getBoard();
		Bot = new Ia_intel(tab);
		Player1 = Console.getName1();
		i = 0;
		Console.clear_term();
		ends = false;
		winsIa = false;
		winsPlayer = false;
		while (table.getNbMatchLeft() > 1 || ends == false)
		{
		    Console.ShowBoard(table.getBoard());
		    compt = 0;
		    while(compt < 2)
		    {
			if(compt == 0)
			{
			    if (table.setBoard(Console.getMove(Bot.getName(), Bot.SmartChoice(table.getBoard(), table.getNbMatchLeft()))))
			    {
				currentGame.setNbMove();
			    }
			    System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
			    compt++;

			    if(table.getNbMatchLeft() == 0 && winsPlayer == false)
			    {
				winsPlayer = true;
				compt = 3;
			    }
			    else  if(table.getNbMatchLeft() == 1 && winsPlayer == false)
			    {
				winsIa = true;
				compt = 3;
			    }
			}
			else if(compt == 1)
			{
			    Console.ShowBoard(table.getBoard());
			    if (table.setBoard(Console.getMove(Player1.getName(), table.getBoard())))
			    {
				currentGame.setNbMove();
			    }
			    Console.clear_term();
			    System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
			    compt++;

			    if(table.getNbMatchLeft() == 0 && winsIa == false)
				winsIa = true;
			    else  if(table.getNbMatchLeft() == 1 && winsIa == false)
				winsPlayer = true;
			}

			    
			    
		    }
		    
		    if(winsIa == true || winsPlayer == true)
			ends = true;
			
		}
		if(winsIa)
		{
		    Console.showWinner(Bot.getName());
		    Bot.setNbWin();
		}
		else if (winsPlayer)
		{
		    Console.showWinner(Player1.getName());
		    Player1.setNbWins();
		}

		System.out.println("Voulez-vous rejouer la partie?");
		ask = sc.nextInt();

		if(ask == 1)
		    bwantToPlayAgain = true;
		else if(ask ==0)
		    bwantToPlayAgain = false;
		
		if(winsIa)
		    res2++; 
		else
		    res1++;
		System.out.println("Nombre de victoire : \n"+ "Player : "+ res1+ "\n"+ "IA naive : "+ res2);
		    
	}
	currentGame.setState(false);
    }
	
   
	public static void main(String[] args)
	{
    	    Scanner as;
	    int difficulty, play;
	    boolean rePlay;

	    rePlay = true;
	    as = new Scanner(System.in);

	    System.out.println("*** JEU NIM ***");
	    while(rePlay)
	    {
		play = -1;
		difficulty = 0;
		System.out.println("Choississez la difficulté de l'IA  (1 --> facile, 2 --> difficile) :");
		while(difficulty != 1 && difficulty != 2)
		{
			difficulty = as.nextInt();
			if(difficulty != 1 && difficulty != 2)
			    System.out.println(" Retaper 1 ou 2 pour choisir la diificulté de l IA :");
		}

		if(difficulty == 1)
		    jeu_naive(difficulty);
		else if(difficulty == 2)
		    jeu_intel(difficulty);

		System.out.println("Voulez-vous rejouer ou quitter le jeu ? : (0 --> oui, 1 --> non)");
		while(play != 0 && play != 1)
		{
		    play = as.nextInt();
		    if(play != 0 && play != 1)
			System.out.println(" Retaper 0 ou 1 pour faire votre choix :");
		}

		if(play == 0)
		    rePlay = false;
	    }
	    
			
	}

	
	
		
}

