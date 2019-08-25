import java.util.ArrayList;

/**
 * HashTable using linear probing e.g.:
 * i: 0 | o: null
 * i: 1 | k: 1 v: lenovo
 * i: 2 | k: 12 v: hp
 * i: 3 | o: null
 * i: 4 | k: 54 v: dell
 * i: 5 | o: null
 * i: 6 | k: 6 v: asus
 * i: 7 | k: 6 v: acer
 * i: 8 | o: null
 * i: 9 | o: null
 */

public class LinearProbing
{

    private Node[] array;

    public LinearProbing(int size)
    {
        array = new Node[size];
    }

    /**
     * add to array using linear probing
     *
     * @param number
     * @param value
     */
    public void add(int number, String value)
    {
        Node node = new Node(number, value);
        int mod = modulo(number);

        if (array[mod] == null)
        {
            array[mod] = node;
        }
        else
        {
            for (int i = mod; i < array.length; i++)
            {
                if (array[i] == null)
                {
                    array[i] = node;
                    break;
                }
            }
        }
    }

    /**
     * return the first node if same key is found
     *
     * @param key
     * @return
     */
    public String getValue(int key)
    {
        int mod = modulo(key);
        String val = "";
        for (int i = mod; i < array.length; i++)
        {
            if (array[i].getKey() == key)
            {
                System.out.println("index: " + i);
                return array[i].getValue();
            }
        }
        return val;
    }

    /**
     * return hashcode using modulo of array length
     *
     * @param number
     * @return
     */
    private int modulo(int number)
    {
        return number % array.length;
    }

    public void printArray()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("i: " + i + " | ");
            if (array[i] != null)
            {
                System.out.print("k: " + array[i].getKey() + " ");
                System.out.print("v: " + array[i].getValue());
            }
            else System.out.print(array[i]);
            System.out.println();
        }
    }

    public Node[] getArray()
    {
        return array;
    }

    public void addAll(LinearProbing anotherLP)
    {
        Node[] array = anotherLP.getArray();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                add(array[i].getKey(), array[i].getValue());
            }
        }
    }

    public boolean containsAll(LinearProbing anotherLP)
    {
        ArrayList<String> valuesFromArray = new ArrayList<>();
        for (int a = 0; a < this.array.length; a++)
        {
            if (this.array[a] != null)
            {
                valuesFromArray.add(this.array[a].getValue());
            }
        }

        Node[] anotherArray = anotherLP.getArray();
        for (int i = 0; i < anotherArray.length; i++)
        {
            // as long as the index contains a node
            if (anotherArray[i] != null)
            {
                // find the modulo of the node's key
                String val = anotherArray[i].getValue();
                int key = anotherArray[i].getKey();
                int mod = modulo(key);

                // start from the index mod(key)
                for (int j = mod; j < this.array.length; j++)
                {
                    if (this.array[j] != null)
                    {
                        if (!valuesFromArray.contains(val))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void removeAll(LinearProbing anotherLP)
    {
        Node[] anotherArray = anotherLP.getArray();
        for (int i = 0; i < anotherArray.length; i++)
        {
            if (anotherArray[i] != null)
            {
                // find the modulo of the node's key
                int key = anotherArray[i].getKey();
                int mod = modulo(key);

                // start from the index mod(key)
                for (int j = mod; j < this.array.length; j++)
                {
                    if (this.array[j] != null)
                    {
                        if (this.array[j].getValue().equals(anotherArray[i].getValue()))
                        {
                            this.array[j] = null;
                        }
                    }
                }
            }
        }
    }
}
