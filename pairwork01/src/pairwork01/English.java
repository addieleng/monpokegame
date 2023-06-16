package pairwork01;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Keiko
 * @author Marius
 *
 */
public class English {

	public static void main(String[] args) throws Exception {
		Scanner int_scanner = new Scanner(System.in);
		Scanner str_scanner = new Scanner(System.in);
		Random num = new Random();

		String[] elements = { "FIRE", "WATER", "GRASS" };
		String[] elementsEmoji = { "🔥", "💦", "🍁" };
		String title = "🌟MONPOKéééé———🌟";

		int length = title.length();
		int borderLength = length;

		printBorder(borderLength);
		System.out.println(title);
		printBorder(borderLength);
		System.out.println();

		Thread.sleep(1000);
		System.out.println("BGM: 🎵～Pokémon Opening～🎵 (There's no music, so let's imagine it.)");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("👨🏻‍ OAK: Hello there! Welcome to the world of POKéMON!");
		Thread.sleep(2000);
		System.out.println("👨🏻‍ OAK: First, what is your name?");

		String playerName = str_scanner.nextLine();

		System.out.println();
		System.out.println("👨🏻‍ OAK: " + playerName + ", there are 3 POKéMON here!");
		Thread.sleep(2000);
		System.out.println("👨🏻‍ OAK: I have only 3 left, but you can have one!");
		Thread.sleep(2000);
		System.out.println("👨🏻‍ OAK: Choose!");
		System.out.println();
		Thread.sleep(2000);

		// Choose your Pokémon!
		for (int i = 0; i < elements.length; i++) {
			System.out.println((i + 1) + ". " + elements[i]);
		}

		int playerPoke = int_scanner.nextInt();

		String selectedType = "";
		String pokeName = "";
		String wildSelected = "";
		String wildPokeName = "";
		String pokeEmoji = "";
		String elementIcon = "";

		boolean isValidChoice = false;
		while (!isValidChoice) {
			switch (playerPoke) {
			case 1:
				selectedType = "FIRE";
				pokeName = "CHARMANDER";
				pokeEmoji = "🦎";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			case 2:
				selectedType = "WATER";
				pokeName = "SQUIRTLE";
				pokeEmoji = "🐢";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			case 3:
				selectedType = "GRASS";
				pokeName = "BULBASAUR";
				pokeEmoji = "🐸";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				playerPoke = int_scanner.nextInt();
				break;
			}
		}
		Thread.sleep(1000);

		// Display the player's selection.
		System.out.println(playerName + ": " + pokeName + " " + pokeEmoji + "! I choose you!");
		Thread.sleep(1000);

		// A wild pokémon appears!
		int wildPokeIndex = num.nextInt(elements.length);
		wildSelected = elements[wildPokeIndex];
		String[] wildEmoji = { "🐕‍🦺", "🌟", "🌱" };

		String[] wildPokeNames = { "GROWLITHE", "STARMIE", "ODDISH" };
		wildPokeName = wildPokeNames[wildPokeIndex];
		String wildPokeEmoji = wildEmoji[wildPokeIndex];
		String wildPokeElements = elementsEmoji[wildPokeIndex];

		for (int i = 0; i < 7; i++) {
			System.out.println();
			for (int k = 0; k < 10; k++) {
				System.out.print("■ ");
				Thread.sleep(10);
			}
			System.out.print("■ ");
			Thread.sleep(10);
		}
		System.out.println();
		System.out.println();

		System.out.println("A wild " + wildPokeName + " " + wildPokeEmoji + " appeared!");
		Thread.sleep(2000);
		System.out.println("Go! " + pokeName + " " + pokeEmoji + "!");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("What will you do?");
		System.out.println("1. FIGHT");
		System.out.println("2. RUN (game over)");

		boolean continueBattle = true;
		int HP = 100;
		int healCount = 2;
		int enemyHP = 100;
		int enemyHealCount = 2;
		int pokeballCount = 2;

		isValidChoice = false;
		while (!isValidChoice) {
			// What will you do? Fight, or run?
			int playerAction = int_scanner.nextInt();

			if (playerAction == 1 || playerAction == 2) {
				isValidChoice = true;

				// You chose to run away.
				if (playerAction == 2) {
					Thread.sleep(1000);
					System.out.println("You got away safely, but it's game over…");

					// You chose to fight.
				} else if (playerAction == 1) {

					while (continueBattle) {
						Thread.sleep(1000);
						if (pokeName.equals("CHARMANDER") || pokeName.equals("BULBASAUR")) {
							System.out
									.println(
											pokeName + " " + pokeEmoji + "\t " + "Enemy " + wildPokeName + " "
													+ wildPokeEmoji);
						} else {
							System.out
									.println(pokeName + " " + pokeEmoji + "\t\t " + "Enemy " + wildPokeName + " "
											+ wildPokeEmoji);
						}
						System.out.println("HP: " + HP + "/100. \t HP: " + enemyHP + "/100.");
						System.out.println();
						Thread.sleep(1000);
						System.out.println("What will " + pokeName + " do?");
						Thread.sleep(1000);

						// Battle menu.
						if (enemyHP <= 30) {
							System.out.println("1: PHYSICAL ATTACK");
							System.out.println("2: ELEMENTAL ATTACK");
							System.out.println("3: POTION (" + healCount + " left)");
							System.out.println("4: POKé BALL (" + pokeballCount + " left)");
							System.out.println("5: RUN");
						} else {
							System.out.println("1: PHYSICAL ATTACK");
							System.out.println("2: ELEMENTAL ATTACK");
							System.out.println("3: POTION (" + healCount + " left)");
							System.out.println("4: RUN");
						}
						
						int battleDecision = int_scanner.nextInt();

						// Attack state, player.
						// Physical attack.
						if (battleDecision == 1) {
							int hitMiss = num.nextInt(10);
							
							// Attack hits.
							if (hitMiss < 9) {
								int baseDamage = 10;
								int damageRange = 3;
								int damage = num.nextInt(damageRange * 2 + 1) - damageRange + baseDamage;
								enemyHP -= damage;
								System.out.print(pokeName + " used PHYSICAL ATTACK! ");
								Thread.sleep(2000);
								System.out.println("Enemy " + wildPokeName + " takes " + damage + " damage!");
								System.out.println();
								
								// Attack misses.
							} else if (hitMiss == 9) {
								System.out.print(pokeName + " used PHYSICAL ATTACK!");
								Thread.sleep(2000);
								System.out.println(" But it missed!");
								System.out.println();
							}

							// Elemental effectiveness and weakness logic.
						} else if (battleDecision == 2) {
							int hitMiss = num.nextInt(10);

							// Attack hits.
							if (hitMiss < 9) {
								int baseDamage = 10;
								int damageRange = 3;
								int damage = num.nextInt(damageRange * 2 + 1) - damageRange + baseDamage;

								// Super effective.
								if (selectedType.equals("GRASS") && wildSelected.equals("WATER")
										|| selectedType.equals("WATER") && wildSelected.equals("FIRE")
										|| selectedType.equals("FIRE") && wildSelected.equals("GRASS")) {
									damage *= 1.5;
									enemyHP -= damage;
									System.out.print(pokeName + " used ELEMENTAL ATTACK!" + elementIcon);
									Thread.sleep(2000);
									System.out.println(" Enemy " + wildPokeName + " takes " + damage + " damage!");
									Thread.sleep(2000);
									System.out.println("It's super effective!");
									System.out.println();

									// Not so effective…
								} else if (selectedType.equals("FIRE") && wildSelected.equals("WATER")
										|| selectedType.equals("WATER") && wildSelected.equals("GRASS")
										|| selectedType.equals("GRASS") && wildSelected.equals("FIRE")) {
									damage *= 0.5;
									enemyHP -= damage;
									System.out.print(pokeName + " used ELEMENTAL ATTACK!" + elementIcon);
									Thread.sleep(2000);
									System.out.println(" Enemy " + wildPokeName + " takes " + damage + " damage!");
									Thread.sleep(2000);
									System.out.println("It's not very effective…");
									System.out.println();

									// Normal (same element).
								} else {
									enemyHP -= damage;
									System.out.print(pokeName + " used ELEMENTAL ATTACK!" + elementIcon);
									Thread.sleep(2000);
									System.out.println(" Enemy " + wildPokeName + " takes " + damage + " damage!");
									System.out.println();
								}
								
								// Attack misses.
							} else if (hitMiss == 9) {
								System.out.print(pokeName + " used ELEMENTAL ATTACK!" + elementIcon);
								Thread.sleep(2000);
								System.out.println(" But it missed!");
								System.out.println();
							}

							// Heal.
						} else if (battleDecision == 3 && healCount > 0) {
							System.out.println("You used a Potion!");
							Thread.sleep(2000);
							HP += 15;
							if (HP > 100) {
								int heal = 15 - (HP - 100);
								HP = 100;
								System.out.println(pokeName + "'s HP was restored by " + heal + " point(s).");
								System.out.println();
							} else {
								System.out.println(pokeName + "'s HP was restored by 15 points.");
								System.out.println();
							}
							healCount--;

							// There are no Potions left!
						} else if (battleDecision == 3 && healCount == 0) {
							System.out.println("There are no Potions left!");
							continue;

							// Trying to catch the Pokémon!
						} else if (battleDecision == 4) {
							Thread.sleep(1000);
							System.out.println(playerName + " used POKé BALL!");
							pokeballCount--;
							Thread.sleep(1000);

							for (int i = 0; i < 2; i++) {
								for (int j = 0; j < 10; j++) {
									System.out.print("■ ");
									Thread.sleep(100);
								}
								System.out.println();
							}
							System.out.println();
							
							// Generate a random number between 0 and 2.
							int catchPoke = num.nextInt(3);

							// Successful catch!
							if (catchPoke == 0) {
								System.out.print("All right!");
								Thread.sleep(1000);
								System.out.println(wildPokeName + " was caught!");
								System.out.println("New POKéDEX data will be added for " + wildPokeName + "!");
								continueBattle = false;
								break;
								
								// Unsuccessful catch…
							} else {
								System.out.println("Aww! It appeared to be caught!");
								Thread.sleep(1000);
							}

							// There are no Poké Balls left!
						} else if (battleDecision == 4 && pokeballCount == 0) {
							System.out.println("There are no POKé BALLs left!");
							continue;

							// Run away.
						} else if (battleDecision == 5) {
							Thread.sleep(1000);
							System.out.println("You got away safely, but it's game over……");
							continueBattle = false;
							break;
							
							// Invalid battle menu input.
						} else {
							System.out.println("Invalid choice. Please try again.");
							continue;
						}

						// Win condition. Player defeats enemy.
						if (enemyHP <= 0) {
							Thread.sleep(2000);
							System.out.println("Enemy " + wildPokeName + " fainted!");
							Thread.sleep(2000);
							System.out.println("Hooray!");
							Thread.sleep(2000);
							System.out.println(
									pokeName + " gained " + (num.nextInt(50 * 2 + 1) - 50 + 300) + " EXP. Points!");
							continueBattle = false;
							break;
						}

						Thread.sleep(2000);

						// Attack state, enemy.
						// Heal.
						if (enemyHP <= 20 && enemyHealCount > 0) {
							enemyHP += 15;
							enemyHealCount--;
							System.out.println("Enemy " + wildPokeName + " ate an Orus Berry!");
							Thread.sleep(2000);
							System.out.println("Its HP was restored by 15 points.");
							System.out.println();

							// Attack.
						} else {
							int enemyAttack = num.nextInt(2);

							// Physical attack.
							if (enemyAttack == 0) {
								int hitMiss = num.nextInt(10);
								
								// Attack hits.
								if (hitMiss < 9) {
									int baseDamage = 10;
									int damageRange = 3;
									int enemyDamage = num.nextInt(damageRange * 2 + 1) - damageRange + baseDamage;
									HP -= enemyDamage;
									System.out.print("Enemy " + wildPokeName + " used PHYSICAL ATTACK!");
									Thread.sleep(2000);
									System.out.println(" " + pokeName + " takes " + enemyDamage + " damage!");
									System.out.println();
									
									// Attack misses.
								} else if (hitMiss == 9) {
									System.out.print("Enemy " + wildPokeName + " used PHYSICAL ATTACK!");
									Thread.sleep(2000);
									System.out.println(" But it missed!");
									System.out.println();
								}

								// Elemental effectiveness and weakness logic.
							} else if (enemyAttack == 1) {
								int hitMiss = num.nextInt(10);
								
								// Attack hits.
								if (hitMiss < 9) {
									int baseDamage = 10;
									int damageRange = 3;
									int enemyDamage = num.nextInt(damageRange * 2 + 1) - damageRange + baseDamage;

									// Super effective
									if (wildSelected.equals("GRASS") && selectedType.equals("WATER")
											|| wildSelected.equals("WATER") && selectedType.equals("FIRE")
											|| wildSelected.equals("FIRE") && selectedType.equals("GRASS")) {
										enemyDamage *= 1.5;
										HP -= enemyDamage;
										System.out
												.print("Enemy " + wildPokeName + " used ELEMENTAL ATTACK!"
														+ wildPokeElements);
										Thread.sleep(2000);
										System.out.println(" " + pokeName + " takes " + enemyDamage + " damage!");
										Thread.sleep(2000);
										System.out.println("It's super effective!");
										System.out.println();

										// Not so effective…
									} else if (wildSelected.equals("FIRE") && selectedType.equals("WATER")
											|| wildSelected.equals("WATER") && selectedType.equals("GRASS")
											|| wildSelected.equals("GRASS") && selectedType.equals("FIRE")) {
										enemyDamage *= 0.5;
										HP -= enemyDamage;
										System.out
												.print("Enemy " + wildPokeName + " used ELEMENTAL ATTACK!"
														+ wildPokeElements);
										Thread.sleep(2000);
										System.out.println(" " + pokeName + " takes " + enemyDamage + " damage!");
										Thread.sleep(2000);
										System.out.println("It's not very effective…");
										System.out.println();

										// Normal (same element).
									} else {
										HP -= enemyDamage;
										System.out
												.print("Enemy " + wildPokeName + " used ELEMENTAL ATTACK!"
														+ wildPokeElements);
										Thread.sleep(2000);
										System.out.println(" " + pokeName + " takes " + enemyDamage + " damage!");
										Thread.sleep(2000);
										System.out.println();
									}
									
									// Attack misses.
								} else if (hitMiss == 9) {
									System.out
											.print("Enemy " + wildPokeName + " used ELEMENTAL ATTACK!"
													+ wildPokeElements);
									Thread.sleep(2000);
									System.out.println(" But it missed!");
									Thread.sleep(2000);
									System.out.println();
								}
							}
						}

						// Lose condition. Enemy defeats player.
						if (HP <= 0) {
							System.out.println(pokeName + " fainted. Game over…");
							continueBattle = false;
							break;
						}

					}

				}

				// Invalid fight or flight input.
			} else {
				System.out.println("Invalid choice. Please try again.");
			}

		}

	}

	public static void printBorder(int length) throws Exception {

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < length; i++) {
				System.out.print("+");
				Thread.sleep(10); // Delay between characters
			}
			System.out.println();
		}
	}
}