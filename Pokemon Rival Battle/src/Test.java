import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Driver {
//https://manytools.org/hacker-tools/convert-images-to-ascii-art/

	public static void main(String[] args) {
	Random Chance = new Random();
	Scanner scan = new Scanner (System.in);
	
	System.out.println("Justin Truong Pokemon Rival Battle Project 2022\nI use this website for the art and Google images https://manytools.org/hacker-tools/convert-images-to-ascii-art/ \n"
			+ "All rights go to Pokemon, this is just an replicate I try to create: \n\n\n\n");

	//intro
	System.out.println("Hello there! Weclome to the World of Pokemon! \nMy name is Professor Justin! This world is inhabited by creatures called POKEMON! \nFor some people, POKEMON are pets. "
			+ "Others use them for fights. Myself...I study POKEMON as a profession. ");
			
	//Name
	System.out.print("\nFirst, what is your name? :");
	String Trainer_name = scan.nextLine();
	
	//Gender
	System.out.print("\nSecond, Are you a boy or a girl? b or g :");
	String Trainer_gender = scan.nextLine().toUpperCase();
	
	while( !(Trainer_gender.equals("B")) && !(Trainer_gender.equals("G")) ){
		System.out.println("unvaild letter, Please try again");
		Trainer_gender = scan.nextLine().toUpperCase();
	}
	
	if(Trainer_gender.equals("B")) {
		Trainer_gender = "boy";
	}
	else {
		Trainer_gender = "girl";
	}
	
	//Rival
	System.out.println("Right! So your name is " + Trainer_name + "! This is my grandson. He's been your rival since you were a baby \n. ...Erm, what is his name again?: ");
	String Rival_name = scan.nextLine();
	
	System.out.println("\nThat's right! I remember now! His name is " + Rival_name  + "! " + Trainer_name +  "! Your very own POKEMON legend is about to unfold! \nA world of dreams and adventures with POKEMON awaits! Let's go!");
	
	//Picking Pokemon
	System.out.println("Before you go, you must pick your starter Pokemon.\n");
	
	System.out.println("We got Bulbasaur\n");
	Pokemon.printpokemon("Bulbasaur");
	
	System.out.println("We got Squirtle\n");
	Pokemon.printpokemon("Squirtle");
	
	
	System.out.println("We got Charmander\n");
	Pokemon.printpokemon("Charmander");
	
	System.out.println("Please type B for Bulbasaur, S for Squirtle, C for Charmander: ");
	String Trainer_Pokemon = scan.nextLine().toUpperCase();
	
	
	
	while(  !(Trainer_Pokemon.equals("B")) && !(Trainer_Pokemon.equals("S")) && !(Trainer_Pokemon.equals("C")) ){
		System.out.println("unvaild letter, Please try again");
		Trainer_Pokemon = scan.nextLine().toUpperCase();
	}
	
	//Rival Pokemon getting pick
	String Rival_Pokemon;
	if(Trainer_Pokemon.equals("B")){
		Trainer_Pokemon = "Bulbasaur";
		Rival_Pokemon = "Charmander";
	}
	else if(Trainer_Pokemon.equals("S")) {
		Trainer_Pokemon = "Squirtle";
		Rival_Pokemon = "Bulbasaur";
	}
	else {
		Trainer_Pokemon = "Charmander";
		Rival_Pokemon = "Squirtle";
	}
	
	
	System.out.println("You pick "+ Trainer_Pokemon);
	System.out.println("You rival pick "+ Rival_Pokemon);
	
	
	//menu
	System.out.println("\n\n1. Battle your rival \n2. look at your Pokemon stats\n3. Look at your win to lose ratio\n4. quit");
	int wins=0;
	int loses=0;
	
	
	int play = scan.nextInt();
	while(play != 4){
		//Create the Pokemon and Trainer stats
		Pokemon Starter = new Pokemon(Trainer_Pokemon);
		Pokemon Rival_Starter = new Pokemon(Rival_Pokemon);
		Trainer Player_1 = new Trainer(Trainer_name,Trainer_gender, Starter);
		Trainer Rival = new Trainer(Rival_name, "boy", Rival_Starter);
		
		//battle rival
		if(play == 1) {
			Pokemon.Rival_battle(Trainer_Pokemon, Rival_Pokemon, Rival_name, Trainer_name, Starter, Rival_Starter);
			while(Starter.health>0 && Rival_Starter.health>0 ){
				Starter.print_moves(Trainer_Pokemon);
				System.out.println("Please choose a move, 1 or 2:");
				int attack_use = scan.nextInt();
				System.out.println("");
				
				//Attack move attack does damage depend on the difference of your Pokemon attack the enemy difference
					if(attack_use == 1) {
						if(Trainer_Pokemon.equals("Charmander")) {
							System.out.println(Trainer_Pokemon + " use Scratch ");
							Starter.moves_count[0]-=1;
						}
						else {
							System.out.println(Trainer_Pokemon + " use Tackle ");
							Starter.moves_count[0]-=1;
						}
						if(Starter.attack <= Rival_Starter.defense) {
							Rival_Starter.health -=3;
						}
						else {
							Rival_Starter.health -= (Starter.attack-Rival_Starter.defense);
						}
					}
					//Status move
					else if(attack_use == 2) {
						if(Trainer_Pokemon.equals("Squirtle")) {
							System.out.println(Trainer_Pokemon + " use Tail Whip");
							Starter.moves_count[1]-=1;
							if(Rival_Starter.defense <5) {
								System.out.println("Defense can't go lower");
							}
							else {
								Rival_Starter.defense -=1; 
							} 
							}
						else {
							System.out.println(Trainer_Pokemon + " use Growl ");
							Starter.moves_count[1]--;
							if(Starter.attack <= Rival_Starter.defense) {
								System.out.println("Attack can't go lower");
							}
							else {
								Rival_Starter.attack -=1;
							}
							}
						}
					else {
						System.out.println("unvaild number, Please try again");
						attack_use = scan.nextInt();
					}
					
					//Rival random attack/status
					int rival_attack_use= Chance.nextInt(2);
					if(rival_attack_use == 1) {
						if(Rival_Pokemon.equals("Charmander")) {
							System.out.println(Rival_Pokemon + " use Scratch ");
						}
						else {
							System.out.println(Rival_Pokemon + " use Tackle ");
						}
						if(Rival_Starter.attack <= Starter.defense) {
							Starter.health -=3;
						}
						else {
							Starter.health -= (Rival_Starter.attack-Starter.defense);
						}
					}
					else {
						if(Rival_Pokemon.equals("Squirtle")) {
							System.out.println(Rival_Pokemon + " use Tail Whip");
							if(Starter.defense <5) {
								System.out.println("Defense can't go lower");
							}
							else {
								Starter.defense -= 1; 
							} 
							}
						else {
							System.out.println(Rival_Pokemon + " use Growl ");
							if(Rival_Starter.attack <= Starter.defense) {
								System.out.println("Attack can't go lower");
							}
							else {
								Starter.attack -=1;
							}
						}
					}
				
				//decide who win or lose
				if(Starter.health <=0 && Rival_Starter.health <=0) {
					System.out.println("Both Pokemon has fainted! \n It's a Draw");
					System.out.println("\n\n1. Battle your rival \n2. look at your Pokemon stats\n3. Look at your win to lose ratio\n4. quit");
					break;
				}
				if(Starter.health<=0) {
							System.out.println(Trainer_Pokemon + " has fainted! \n You Lose");
							loses++;
							System.out.println("\n\n1. Battle your rival \n2. look at your Pokemon stats\n3. Look at your win to lose ratio\n4. quit");	
				}
				else if(Rival_Starter.health<=0) {
							System.out.println(Rival_Pokemon + " has fainted! \n You Win");
							wins++;
							System.out.println("\n\n1. Battle your rival \n2. look at your Pokemon stats\n3. Look at your win to lose ratio\n4. quit");						}
				else {
					System.out.println(Trainer_Pokemon + " has " + Starter.health + " health");
					System.out.println(Rival_Pokemon + " has " + Rival_Starter.health + " health\n");	
				}
		  }
		}
		
		//Stats display
		else if(play == 2) {
			System.out.println(Player_1.toString());
			System.out.println(Rival.toString());
		}
		
		//Win to lose ratio
		else if(play == 3) {
			System.out.println("You win " + wins + " games and you lose " + loses + " games");
			System.out.println("\n\n1. Battle your rival \n2. look at your Pokemon stats\n3. Look at your win to lose ratio\n4. quit");		}
		else {
			System.out.println("unvaild letter, Please try again");
			play = scan.nextInt();
		}
		
		play = scan.nextInt();
	}
	
	
	
	
	}

	
	
	
}
