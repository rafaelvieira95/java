package ufc.crateus.dynamicprogramming;

public class App {

    public static void main(String[] args) {

        Algorithms func = new Algorithms();
        int coins[] ={10,5,25,50,100,1};
        System.out.println(func.minCoins(coins,49,0));
        func.printSolutionCoins(coins,49);
    }
}
