package ufc.crateus.dynamicprogramming;

public class Algorithms {

    private int S[][] = new int[1000][1000];
    private int V[] = new int [1000];

    public int minCoins(int coins[], int value,int i){

        if(value > 1000) return 0;
        if(value == 0) return 0;
        if(value < 0) return Integer.MAX_VALUE/2;
        if(i == coins.length) return Integer.MAX_VALUE/2;

        if(S[value][i] == 0){
             int getCoin = 1 + minCoins(coins,value - coins[i],i);
             int nextCoin = minCoins(coins,value,i + 1);

             if(getCoin < nextCoin) {
                 S[value][i] = getCoin;
                 V[value]= coins[i];
             }else{
                 S[value][i] = nextCoin;
             }
        }
        return S[value][i];
    }

   public void printSolutionCoins(int coins[],int value){
        if(V[value] == 0) return;

        System.out.print("["+V[value]+"] ");
       printSolutionCoins(coins,value - V[value]);

   }

}
