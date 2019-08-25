public class Main {

    public static void main(String[] args) {

        /** Linear Probing */
        LinearProbing hashtable = new LinearProbing(10);
        hashtable.add(1, "Orange");
        hashtable.add(12, "Apple");
        hashtable.add(54, "Melon");
        hashtable.add(6, "Banana");
        hashtable.add(6, "Apple");

        /** Output */
        System.out.println("Print array: ");
        hashtable.printArray();
        // System.out.println(hashtable.getValue(6));
        // System.out.println(hashtable.getValue(54));
        System.out.println();

        /** Add elements from another array */
        LinearProbing hashtable1 = new LinearProbing(10);
        hashtable1.add(11, "Apple");
        hashtable1.add(65, "Lemon");
        hashtable.addAll(hashtable1);
        System.out.println("Add Apple and Lemon: ");
        hashtable.printArray();
        System.out.println();

        /** Check if new elements exist in array*/
        LinearProbing hashtable2 = new LinearProbing(10);
        hashtable2.add(6, "Kiwi");
        hashtable2.add(68, "Melon");
        System.out.println("Contains Kiwi and Melon?: ");
        System.out.println(hashtable.containsAll(hashtable2));
        System.out.println();

        /** Remove elements that was added from hashtable1 */
        hashtable.removeAll(hashtable1);
        System.out.println("Remove Apple and Lemon: ");
        hashtable.printArray();
        System.out.println();


//        /** Separate Chaining - example */
//        SeparateChaining hash = new SeparateChaining(10);
//        hash.add(11, "Alpha");
//        hash.add(4, "Beta");
//        hash.add(1, "Gamma");
//        hash.add(15, "Delta");
//        hash.add(9, "Omega");
//        hash.add(5, "Pi");
//
//        /** Output */
//        // System.out.println("Key=5, Value=" + hash.getValue(5));
//        // System.out.println("Key=9, Value=" + hash.getValue(9));
//        System.out.print("Print array:");
//        hash.printArray();
//        System.out.println();
//
//        /** Add elements from another array */
//        SeparateChaining hash1 = new SeparateChaining(10);
//        hash1.add(5, "Kappa");
//        hash1.add(4, "Sigma");
//        hash.addAll(hash1);
//        System.out.println();
//        System.out.print("Add all: ");
//        hash.printArray();
//        System.out.println();
//
//        /** Check if new values added exist */
//        SeparateChaining hash2 = new SeparateChaining(10);
//        hash2.add(2, "Alpha");
//        hash2.add(117, "Pi");
//        System.out.println();
//        System.out.println("Contain Alpha and Pi?: ");
//        System.out.println(hash.containsAll(hash2));
//        System.out.println();
//
//        /** Remove elements that exist in the other array */
//        hash.removeAll(hash2);
//        System.out.print("Remove existing values: ");
//        hash.printArray();
//        System.out.println();

    }
}
