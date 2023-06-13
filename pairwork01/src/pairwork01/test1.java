package pairwork01;

import java.util.Random;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String pokemon = "pokemon";
		String enemyPokemon = "enemyPokemon";

		boolean continueBattle = true;
		String playerType = "G";
		String enemyType = "W";
		int HP = 100;
		int healCount = 2;
		int enemyHP = 100;
		int enemyHealCount = 2;

		Thread.sleep(1000);
		System.out.println("あ！野生の" + enemyPokemon + "が飛びだしてきた！");
		Thread.sleep(1000);
		System.out.println("ゆけっ！" + pokemon + "！");
		Thread.sleep(1000);
		System.out.println();
		System.out.println("どうする？");
		Thread.sleep(1000);
		System.out.println("1: たたかう 2: にげる（ゲームオーバー）");

		int fightRun = sc.nextInt();

		// Initial battle state. Fight, or run?
		if (fightRun == 2) {
			Thread.sleep(1000);
			System.out.println("うまく逃げ切れたが、ゲームオーバーだ……");
		} else if (fightRun == 1) {

			while (continueBattle) {
				Thread.sleep(1000);
				System.out.println(pokemon + "\t\t\t " + "適の" + enemyPokemon);
				System.out.println("HP: " + HP + "/100. \t HP: " + enemyHP + "/100.");
				System.out.println();
				Thread.sleep(1000);
				System.out.println(pokemon + "はどうする?");
				Thread.sleep(1000);
				System.out.println("1: 物理技 2: 特殊技 3: キズぐずり (残り" + healCount + "個) 4: にげる");
				int battleDecision = sc.nextInt();

				// Attack state, player.
				// Physical attack.
				if (battleDecision == 1) {
					int damage = r.nextInt(3 * 2 + 1) - 3 + 10;
					enemyHP -= damage;
					System.out.println(pokemon + "の物理技！" + damage + "ダメージをあたえた！");
					System.out.println();

					// Elemental effectiveness and weakness logic.
				} else if (battleDecision == 2) {
					int damage = r.nextInt(3 * 2 + 1) - 3 + 10;

					// Super effective.
					if (playerType.equals("G") && enemyType.equals("W")
							|| playerType.equals("W") && enemyType.equals("F")
							|| playerType.equals("F") && enemyType.equals("G")) {
						damage *= 1.5;
						enemyHP -= damage;
						System.out.println(pokemon + "の特殊技！" + damage + "ダメージをあたえた！");
						Thread.sleep(1000);
						System.out.println("効果はバツグンだ！");
						System.out.println();

						// Not so effective…
					} else if (playerType.equals("F") && enemyType.equals("W")
							|| playerType.equals("W") && enemyType.equals("G")
							|| playerType.equals("G") && enemyType.equals("F")) {
						damage *= 0.5;
						enemyHP -= damage;
						System.out.println(pokemon + "の特殊技！" + damage + "ダメージをあたえた！");
						Thread.sleep(1000);
						System.out.println("効果は今ひとつのようだ……");
						System.out.println();
					}

					// Heal.
				} else if (battleDecision == 3 && healCount > 0) {
					System.out.println("キズぐずりを使った！");
					HP += 15;
					if (HP > 100) {
						int heal = 15 - (HP - 100);
						HP = 100;
						System.out.println(pokemon + "の体力が" + heal + "HP回復した！");
						System.out.println();
					} else {
						System.out.println(pokemon + "の体力が15HP回復した！");
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
					System.out.println("適の" + enemyPokemon + "はたおれた！");
					Thread.sleep(1000);
					System.out.println("やった～！");
					break;
				}

				Thread.sleep(2000);

				// Attack state, enemy.
				// Heal.
				if (enemyHP <= 20 && enemyHealCount > 0) {
					enemyHP += 15;
					enemyHealCount--;
					System.out.println("適の" + enemyPokemon + "はオラスベリーを食べた！");
					System.out.println("体力が15HP回復した！");
					System.out.println();

				} else {
					int enemyAttack = r.nextInt(2);

					// Physical attack.
					if (enemyAttack == 0) {
						int enemyDamage = r.nextInt(3 * 2 + 1) - 3 + 10;
						HP -= enemyDamage;
						System.out.println("適の" + enemyPokemon + "の物理技！" + enemyDamage + "ダメージをうけた！");
						System.out.println();

					} else if (enemyAttack == 1) {
						int enemyDamage = r.nextInt(3 * 2 + 1) - 3 + 10;

						// Elemental effectiveness and weakness logic.
						// Super effective
						if (enemyType.equals("G") && playerType.equals("W")
								|| enemyType.equals("W") && playerType.equals("F")
								|| enemyType.equals("F") && playerType.equals("G")) {
							enemyDamage *= 1.5;
							HP -= enemyDamage;
							System.out.println("適の" + enemyPokemon + "の特殊技！" + enemyDamage + "ダメージをうけた！");
							Thread.sleep(1000);
							System.out.println("効果はバツグンだ！");
							System.out.println();

							// Not so effective…
						} else if (enemyType.equals("F") && playerType.equals("W")
								|| enemyType.equals("W") && playerType.equals("G")
								|| enemyType.equals("G") && playerType.equals("F")) {
							enemyDamage *= 0.5;
							HP -= enemyDamage;
							System.out.println("適の" + enemyPokemon + "の特殊技！" + enemyDamage + "ダメージをうけた！");
							Thread.sleep(1000);
							System.out.println("効果は今ひとつのようだ……");
							System.out.println();
						}
					}
				}

				if (HP <= 0) {
					System.out.println(pokemon + "はたおれた。 ゲームオーバーだ……");
					continueBattle = false;
					break;
				}

			}

		}

	}
}
