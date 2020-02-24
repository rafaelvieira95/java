package ufc.crateus.dynamicprogramming;

public class Algorithms {

	private int M[][] = new int[1000][1000];
	private int S[] = new int[1000];

	public int minCoins(int coins[], int V) {
		int n = coins.length - 1;

		for (int p = 0; p < 1000; p++) {
			for (int k = 0; k < 1000; k++) {
				M[p][k] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 0; i <= n; i++) // o valor 0 ¢ nao tem representacao, caso base
			M[0][i] = 0;

		for(int v = 1; v <= V; v++) { // testa todo valor v <= V com a primeira moeda do conjunto
			if (coins[0] == v) {
				M[v][0] = 1;
			}
		} 

		int a = 0, b = 0;

		for (int v = 1; v <= V; v++) {

			for (int k = 1; k <= n; k++) {

				b = M[v][k - 1];
				
				if ((v - coins[k]) >= 0) {
					a = 1 + M[v - coins[k]][k - 1];
				} else {
					a = Integer.MAX_VALUE - 1;
				}

				M[v][k] = Math.min(a, b);
			}

		}
		return M[V][n] == Integer.MAX_VALUE - 1 ? 0 : M[V][n];
	}

	public void printSolutionCoins(int coins[], int value) {
		if (S[value] == 0)
			return;

		System.out.print("[" + S[value] + "] ");
		printSolutionCoins(coins, value - S[value]);

	}

}
