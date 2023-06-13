package pairwork01;

import java.util.Random;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) throws Exception {

		String[] elements = { "Fire", "Water", "Grass" };
		String[] elementsEmoji = { "🔥", "💦", "🍁" };

		System.out.println("オーキド博士： 「そこに3匹ポケモンがいるじゃろう。」");
		Thread.sleep(1000);
		System.out.println("オーキド博士： 「3匹しかのこっとらんがおまえに1匹やろう！」");
		Thread.sleep(1000);
		System.out.println("オーキド博士： 「さ！選べ！」");
		for (int i = 0; i < elements.length; i++) {
			System.out.println((i + 1) + ". " + elements[i]);
		}

		Scanner str_scanner = new Scanner(System.in);
		System.out.println();
		System.out.println();
		int playerPoke = str_scanner.nextInt();

		String selectedType;
		String pokeName;
		String wildSelected;
		String wildPokeName;
		String pokeEmoji;
		String elementIcon;

		switch (playerPoke) {
		case 1:
			selectedType = "Fire";
			pokeName = "ヒトカゲ";
			pokeEmoji = "🦎";
			elementIcon = elementsEmoji[playerPoke - 1];

			break;
		case 2:
			selectedType = "Water";
			pokeName = "ゼニガメ";
			pokeEmoji = "🐢";
			elementIcon = elementsEmoji[playerPoke - 1];

			break;
		case 3:
			selectedType = "Grass";
			pokeName = "フシギダネ";
			pokeEmoji = "🐸";
			elementIcon = elementsEmoji[playerPoke - 1];
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
			return;
		}

		// Display the player's selection
		System.out.println(pokeName + " " + pokeEmoji + "！君にきめた！");

		Random num = new Random();
		int wildPokeIndex = num.nextInt(elements.length);
		wildSelected = elements[wildPokeIndex];
		String[] wildEmoji = { "🐕‍🦺", "🌟", "🌱" };

		String[] wildPokeNames = { "ガーディ", "スターミー", "ナゾノクサ" };
		wildPokeName = wildPokeNames[wildPokeIndex];
		String wildPokeEmoji = wildEmoji[wildPokeIndex];
		String wildPokeElements = elementsEmoji[wildPokeIndex];

		Thread.sleep(1000);
		System.out.println("あ！野生の" + wildPokeName + " " + wildPokeEmoji + " が飛びだしてきた！");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("ゆけっ！" + pokeName + " " + pokeEmoji + "！");
		Thread.sleep(1000);
		System.out.println("どうする？");
		System.out.println("1.  たたかう");
		System.out.println("2. にげる（ゲームオーバー）");
		System.out.println();
		System.out.println();

		Scanner int_scanner = new Scanner(System.in);
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
					System.out.println(pokeName + "の物理技！" + damage + "ダメージをあたえた！");
					System.out.println();

					// Elemental effectiveness and weakness logic.
				} else if (battleDecision == 2) {
					int damage = num.nextInt(3 * 2 + 1) - 3 + 10;

					// Super effective.
					if (selectedType.equals("Grass") && wildSelected.equals("Water")
							|| selectedType.equals("Water") && wildSelected.equals("Fire")
							|| selectedType.equals("Fire") && wildSelected.equals("Grass")) {
						damage *= 1.5;
						enemyHP -= damage;
						System.out.println(pokeName + "の特殊技！" + elementIcon + " " + damage + "ダメージをあたえた！");
						Thread.sleep(1000);
						System.out.println("効果はバツグンだ！");
						System.out.println();

						// Not so effective…
					} else if (selectedType.equals("Fire") && wildSelected.equals("Water")
							|| selectedType.equals("Water") && wildSelected.equals("Grass")
							|| selectedType.equals("Grass") && wildSelected.equals("Fire")) {
						damage *= 0.5;
						enemyHP -= damage;
						System.out.println(pokeName + "の特殊技！" + elementIcon + " " + damage + "ダメージをあたえた！");
						Thread.sleep(1000);
						System.out.println("効果は今ひとつのようだ……");
						System.out.println();

						// Normal..(Same element)
					} else {

						enemyHP -= damage;
						System.out.println(pokeName + "の特殊技！" + elementIcon + " " + damage + "ダメージをあたえた！");
						System.out.println();

					}

					// Heal.
				} else if (battleDecision == 3 && healCount > 0) {
					System.out.println("キズぐずりを使った！");
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

					// Run away.
				} else if (battleDecision == 4) {
					Thread.sleep(1000);
					System.out.println("うまく逃げ切れたが、ゲームオーバーだ……");
					continueBattle = false;
					break;
				}

				if (enemyHP <= 0) {
					System.out.println("敵の" + wildPokeName + "はたおれた！");
					Thread.sleep(1000);
					System.out.println("やった～！");
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
					System.out.println("体力が15HP回復した！");
					System.out.println();

				} else {
					int enemyAttack = num.nextInt(2);

					// Physical attack.
					if (enemyAttack == 0) {
						int enemyDamage = num.nextInt(3 * 2 + 1) - 3 + 10;
						HP -= enemyDamage;
						System.out.println("敵の" + wildPokeName + "の物理技！" + enemyDamage + "ダメージをうけた！");
						System.out.println();

					} else if (enemyAttack == 1) {
						int enemyDamage = num.nextInt(3 * 2 + 1) - 3 + 10;

						// Elemental effectiveness and weakness logic.
						// Super effective
						if (wildSelected.equals("Grass") && selectedType.equals("Water")
								|| wildSelected.equals("Water") && selectedType.equals("Fire")
								|| wildSelected.equals("Fire") && selectedType.equals("Grass")) {
							enemyDamage *= 1.5;
							HP -= enemyDamage;
							System.out.println("敵の" + wildPokeName + "の特殊技！" + enemyDamage + "ダメージをうけた！");
							Thread.sleep(1000);
							System.out.println("効果はバツグンだ！");
							System.out.println();

							// Not so effective…
						} else if (wildSelected.equals("Fire") && selectedType.equals("Water")
								|| wildSelected.equals("Water") && selectedType.equals("Grass")
								|| wildSelected.equals("Grass") && selectedType.equals("Fire")) {
							enemyDamage *= 0.5;
							HP -= enemyDamage;
							System.out.println("敵の" + wildPokeName + "の特殊技！" + enemyDamage + "ダメージをうけた！");
							Thread.sleep(1000);
							System.out.println("効果は今ひとつのようだ……");
							System.out.println();
						}
					}
				}

				if (HP <= 0) {
					System.out.println(pokeName + "はたおれた。 ゲームオーバーだ……");
					continueBattle = false;
					break;
				}

			}

		}

	}

}
