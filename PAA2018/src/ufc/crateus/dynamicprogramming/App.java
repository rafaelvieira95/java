package ufc.crateus.dynamicprogramming;

public class App {

    public static void main(String[] args) {

        Algorithms func = new Algorithms();
        int coins[] ={10,1,5,25,1,1,50,100};
        
         System.out.println(" 36¢ = " +func.minCoins(coins,36)); //3 moedas
         System.out.println(" 78¢ = " +func.minCoins(coins,78)); // 5 moedas
         System.out.println(" 153¢ = " +func.minCoins(coins,153)); // 5 moedas
         System.out.println(" 179¢ = " +func.minCoins(coins,179)); // sem moedas
         System.out.println(" 44¢ = " +func.minCoins(coins,44)); // sem moedas
       
    }
}
