package pairwork01;

import java.util.Random;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) throws Exception {
		Scanner int_scanner = new Scanner(System.in);
		Random num = new Random();

		String[] elements = { "ほのお", "みず", "くさ" };
		String[] elementsEmoji = { "🔥", "💦", "🍁" };

		System.out.println("オーキド博士：「そこに3匹ポケモンがいるじゃろう！」");
		Thread.sleep(2000);
		System.out.println("オーキド博士：「3匹しかのこっとらんがおまえに1匹やろう！」");
		Thread.sleep(2000);
		System.out.println("オーキド博士：「さ！選べ！」");
		System.out.println();
		Thread.sleep(2000);
		for (int i = 0; i < elements.length; i++) {
			System.out.println((i + 1) + ". " + elements[i]);
		}

		// Choose your Pokémon!
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
				selectedType = "ほのお";
				pokeName = "ヒトカゲ";
				pokeEmoji = "🦎";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			case 2:
				selectedType = "みず";
				pokeName = "ゼニガメ";
				pokeEmoji = "🐢";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			case 3:
				selectedType = "くさ";
				pokeName = "フシギダネ";
				pokeEmoji = "🐸";
				elementIcon = elementsEmoji[playerPoke - 1];
				isValidChoice = true;
				break;
			default:
				System.out.println("無効な選択肢です。もう一度やり直してください。");
				playerPoke = int_scanner.nextInt();
				break;
			}
		}
		Thread.sleep(1000);

		// Display the player's selection.
		System.out.println(pokeName + " " + pokeEmoji + "！キミにきめた！");
		System.out.println();
		Thread.sleep(1000);

		int wildPokeIndex = num.nextInt(elements.length);
		wildSelected = elements[wildPokeIndex];
		String[] wildEmoji = { "🐕‍🦺", "🌟", "🌱" };

		String[] wildPokeNames = { "ガーディ", "スターミー", "ナゾノクサ" };
		wildPokeName = wildPokeNames[wildPokeIndex];
		String wildPokeEmoji = wildEmoji[wildPokeIndex];
		String wildPokeElements = elementsEmoji[wildPokeIndex];

		for (int i = 0; i < 10; i++) {
			System.out.print("■ ");
			Thread.sleep(500);
		}
		System.out.println();

		System.out.println("あ！野生の" + wildPokeName + " " + wildPokeEmoji + " が飛びだしてきた！");
		Thread.sleep(2000);
		System.out.println("ゆけっ！" + pokeName + " " + pokeEmoji + "！");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("どうする？");
		System.out.println("1. たたかう");
		System.out.println("2. にげる（ゲームオーバー）");

		int playerAction = int_scanner.nextInt();

		boolean continueBattle = true;
		int HP = 100;
		int healCount = 2;
		int enemyHP = 100;
		int enemyHealCount = 2;

		if (playerAction == 2) {
			Thread.sleep(1000);
			System.out.println("うまく逃げ切れたが、ゲームオーバーだ……");

		} else if (playerAction == 1) {

			while (continueBattle) {
				Thread.sleep(1000);
				System.out.println(pokeName + " " + pokeEmoji + "\t\t " + "敵の" + wildPokeName + " " + wildPokeEmoji);
				System.out.println("HP: " + HP + "/100. \t HP: " + enemyHP + "/100.");
				System.out.println();
				Thread.sleep(1000);
				System.out.println(pokeName + "はどうする?");
				Thread.sleep(1000);
				System.out.println("1: 物理技 2: 特殊技 3: キズぐずり (残り" + healCount + "個) 4: にげる");
				int battleDecision = int_scanner.nextInt();

				// Attack state, player.
				// Physical attack.
				if (battleDecision == 1) {
					int damage = num.nextInt(3 * 2 + 1) - 3 + 10;
					enemyHP -= damage;
					System.out.print(pokeName + "の物理技！");
					Thread.sleep(2000);
					System.out.println(damage + "ダメージをあたえた！");
					System.out.println();

					// Elemental effectiveness and weakness logic.
				} else if (battleDecision == 2) {
					int damage = num.nextInt(3 * 2 + 1) - 3 + 10;

					// Super effective.
					if (selectedType.equals("くさ") && wildSelected.equals("みず")
							|| selectedType.equals("みず") && wildSelected.equals("ほのお")
							|| selectedType.equals("ほのお") && wildSelected.equals("くさ")) {
						damage *= 1.5;
						enemyHP -= damage;
						System.out.print(pokeName + "の特殊技！" + elementIcon);
						Thread.sleep(2000);
						System.out.println(" " + damage + "ダメージをあたえた！");
						Thread.sleep(2000);
						System.out.println("効果はバツグンだ！");
						System.out.println();

						// Not so effective…
					} else if (selectedType.equals("ほのお") && wildSelected.equals("みず")
							|| selectedType.equals("みず") && wildSelected.equals("くさ")
							|| selectedType.equals("くさ") && wildSelected.equals("ほのお")) {
						damage *= 0.5;
						enemyHP -= damage;
						System.out.print(pokeName + "の特殊技！" + elementIcon);
						Thread.sleep(2000);
						System.out.println(" " + damage + "ダメージをあたえた！");
						Thread.sleep(2000);
						System.out.println("効果は今ひとつのようだ……");
						System.out.println();

						// Normal (same element).
					} else {
						enemyHP -= damage;
						System.out.print(pokeName + "の特殊技！" + elementIcon);
						Thread.sleep(2000);
						System.out.println(" " + damage + "ダメージをあたえた！");
						System.out.println();
					}

					// Heal.
				} else if (battleDecision == 3 && healCount > 0) {
					System.out.println("キズぐずりを使った！");
					Thread.sleep(2000);
					HP += 15;
					if (HP > 100) {
						int heal = 15 - (HP - 100);
						HP = 100;
						System.out.println(pokeName + "の体力が" + heal + "HP回復した！");
						System.out.println();
					} else {
						System.out.println(pokeName + "の体力が15HP回復した！");
						System.out.println();
					}
					healCount--;

				} else if (battleDecision == 3 && healCount == 0) {
					System.out.println("キズぐずりはもうない！");
					continue;

					// Run away.
				} else if (battleDecision == 4) {
					Thread.sleep(1000);
					System.out.println("うまく逃げ切れたが、ゲームオーバーだ……");
					continueBattle = false;
					break;
				}

				// Win condition. Player defeats enemy.
				if (enemyHP <= 0) {
					Thread.sleep(2000);
					System.out.println("敵の" + wildPokeName + "はたおれた！");
					Thread.sleep(2000);
					System.out.println("やった～！");
					Thread.sleep(2000);
					System.out.println(pokeName + "は" + (num.nextInt(50 * 2 + 1) - 50 + 300) + "経験値をもらった！");
					continueBattle = false;
					break;
				}

				Thread.sleep(2000);

				// Attack state, enemy.
				// Heal.
				if (enemyHP <= 20 && enemyHealCount > 0) {
					enemyHP += 15;
					enemyHealCount--;
					System.out.println("敵の" + wildPokeName + "はオラスベリーを食べた！");
					Thread.sleep(2000);
					System.out.println("体力が15HP回復した！");
					System.out.println();

				} else {
					int enemyAttack = num.nextInt(2);

					// Physical attack.
					if (enemyAttack == 0) {
						int enemyDamage = num.nextInt(3 * 2 + 1) - 3 + 10;
						HP -= enemyDamage;
						System.out.print("敵の" + wildPokeName + "の物理技！");
						Thread.sleep(2000);
						System.out.println(enemyDamage + "ダメージをうけた！");
						System.out.println();

					} else if (enemyAttack == 1) {
						int enemyDamage = num.nextInt(3 * 2 + 1) - 3 + 10;

						// Elemental effectiveness and weakness logic.
						// Super effective
						if (wildSelected.equals("くさ") && selectedType.equals("みず")
								|| wildSelected.equals("みず") && selectedType.equals("ほのお")
								|| wildSelected.equals("ほのお") && selectedType.equals("くさ")) {
							enemyDamage *= 1.5;
							HP -= enemyDamage;
							System.out.print("敵の" + wildPokeName + "の特殊技！" + wildPokeElements);
							Thread.sleep(2000);
							System.out.println(" " + enemyDamage + "ダメージをうけた！");
							Thread.sleep(2000);
							System.out.println("効果はバツグンだ！");
							System.out.println();

							// Not so effective…
						} else if (wildSelected.equals("ほのお") && selectedType.equals("みず")
								|| wildSelected.equals("みず") && selectedType.equals("くさ")
								|| wildSelected.equals("くさ") && selectedType.equals("ほのお")) {
							enemyDamage *= 0.5;
							HP -= enemyDamage;
							System.out.print("敵の" + wildPokeName + "の特殊技！" + wildPokeElements);
							Thread.sleep(2000);
							System.out.println(" " + enemyDamage + "ダメージをうけた！");
							Thread.sleep(2000);
							System.out.println("効果は今ひとつのようだ……");
							System.out.println();

							// Normal (same element).
						} else {
							HP -= enemyDamage;
							System.out.print("敵の" + wildPokeName + "の特殊技！" + wildPokeElements);
							Thread.sleep(2000);
							System.out.println(" " + enemyDamage + "ダメージをうけた！");
							Thread.sleep(2000);
							System.out.println();
						}
					}
				}

				// Lose condition. Enemy defeats player.
				if (HP <= 0) {
					System.out.println(pokeName + "はたおれた。 ゲームオーバーだ……");
					continueBattle = false;
					break;
				}

			}

		}

	}

}
