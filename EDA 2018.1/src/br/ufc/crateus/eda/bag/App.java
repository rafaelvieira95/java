package br.ufc.crateus.eda.bag;


public class App{

    public static void main(String[] args) {


        LinkedListBag ll = new LinkedListBag();
        ll.add("rafael");
        ll.add(123);
        ll.add(4.867);
        ll.add("ufc crateus");
        ll.add("joao");
        ll.add(10);

        ArrayListBag bag = new ArrayListBag();

        bag.add("rafael");
        bag.add(123);
        bag.add(4.867);
        bag.add("ufc crateus");
        bag.add("joao");
        bag.add(10);
        bag.add("ufc russas");
        bag.add("carlos");
        bag.add("pedro");
        bag.add("Alana");
        bag.add("Luiz");
        bag.add("henrique");
        bag.add('A');
        bag.add('B');
        bag.add(15);
        bag.add(14);
        bag.add(89.9);
        bag.add(25);
        bag.add("F B I");
        bag.add(5.000);

        bag.remove("rafael");
        bag.remove("Luiz");
        bag.remove("henrique");
         AbstractListBag sub = bag.subList(1,5);

      //  System.out.println(sub.isEmpty());


       // bag.retainAll(ll);
         //bag.removeAll(bag);

        for(Object e: sub){

            System.out.println(e);
        }

       // System.out.println(bag.printer());




    }

}
