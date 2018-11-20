package br.ufc.crateus.eda.heaps;

public class AppHeaps {

    public static void main(String[] args) {

        // DWayHeap<Integer> h1 = new DWayHeap<>(3, 32);
        // DWayHeap<Integer> h2 = new DWayHeap<>(3, 32);
        LeftistHeap<Integer> h1 = new LeftistHeap<Integer>();
        LeftistHeap<Integer> h2 = new LeftistHeap<Integer>();
        //BinaryHeap<Integer> h1 = new BinaryHeap<>();
        //BinaryHeap<Integer> h2 = new BinaryHeap<>();

        // LeftistHeap<Integer> h3;
        h2.insert(h2, 24);
        h2.insert(h2, 6);
        h2.insert(h2, 20);
        h2.insert(h2, 94);
        h2.insert(h2, 5);
        h2.insert(h2, 63);

        h1.insert(h1, 4);
        h1.insert(h1, 18);
        h1.insert(h1, 8);
        h1.insert(h1, 28);
        h1.insert(h1, 19);
        h1.insert(h1, 17);
        h1.insert(h1, 25);
        h1.insert(h1, 26);

//h1.insert(h1, 17);
//h1.insert(h1, 19);
//h1.delete(hp, 6);
//h1.meld(h2, h1).Keys();
//System.out.println(h1.isEmpty(h1));
//System.out.println(h1.extractMin(h1));
//h1.delete(h1, 19);
//h1.decreaseKey(h1, 10, 4);
//System.out.println(h2.extractMin(h2));
//System.out.println(h2.findMin(h2));
        // h3 = h1.meld(h1, h2);
        // System.out.println(h3.extractMin(h3));
        // System.out.println(h3.findMin(h3));
//h2.decreaseKey(h2,90);
        h1.meld(h1, h2).Keys();
        // h1.Keys();
        // h2.Keys();

    }

}
