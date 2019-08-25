import java.util.ArrayList;
import java.util.LinkedList;

/**
 * HashTable using separate chaining e.g.:
 * i: 0 = null
 * i: 1 = [1, lenovo]-
 * i: 2 = [2, hp]-
 * i: 3 = null
 * i: 4 = null
 * i: 5 = [5, asus]-[5, acer]-
 * i: 6 = null
 * i: 7 = [7, apple]-
 * i: 8 = null
 * i: 9 = [9, samsung]-
 */

public class SeparateChaining
{

    private LinkedList<Node>[] array;

    public SeparateChaining(int size)
    {
        array = new LinkedList[size];
    }

    /**
     * Add node
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
            array[mod] = new LinkedList<>();
        }
        array[mod].add(node);
    }

    public void printArray()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("\ni: " + i + " = ");
            if (array[i] == null) System.out.print(array[i]);
            else
            {
                for (int j = 0; j < array[i].size(); j++)
                {
                    System.out.print("[" + array[i].get(j).getKey() + ", ");
                    System.out.print(array[i].get(j).getValue() + "]");
                    System.out.print("-");
                }
            }
        }
    }

    /**
     * Return value of given key
     *
     * @param key
     * @return
     */
    public String getValue(int key)
    {
        int mod = modulo(key);
        String val = "";

        for (int i = 0; i < array[mod].size(); i++)
        {
            if (array[mod].get(i).getKey() == key)
            {
                val = array[mod].get(i).getValue();
            }
        }
        return val;
    }

    /**
     * return "hashcode" using modulo
     *
     * @param number
     * @return
     */
    private int modulo(int number)
    {
        return number % array.length;
    }

    public LinkedList<Node>[] getArray()
    {
        return array;
    }

    public void addAll(SeparateChaining anotherSC)
    {
        LinkedList<Node>[] array = anotherSC.getArray();

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {

                for (int j = 0; j < array[i].size(); j++)
                {
                    add(array[i].get(j).getKey(), array[i].get(j).getValue());
                }

            }
        }
    }

    /**
     * check if this array contains values from another array
     *
     * @param anotherSC
     * @return
     */
    public boolean containsAll(SeparateChaining anotherSC)
    {
        LinkedList<Node>[] anotherArray = anotherSC.getArray();
        ArrayList<String> valuesFromArray = new ArrayList<>();
        // copy every elements from this array to array of values
        for (int a = 0; a < this.array.length; a++)
        {
            if (this.array[a] != null)
            {
                for (int b = 0; b < this.array[a].size(); b++)
                {
                    valuesFromArray.add(this.array[a].get(b).getValue());
                }
            }
        }

        // compare the values to anotherArray values
        for (int i = 0; i < anotherArray.length; i++)
        {
            // as long as there is a list of values
            if (anotherArray[i] != null)
            {
                for (int j = 0; j < anotherArray[i].size(); j++)
                {
                    String anotherValue = anotherArray[i].get(j).getValue();
                    if (!valuesFromArray.contains(anotherValue)) return false;
                }
            }
        }
        return true;
    }

    public void removeAll(SeparateChaining anotherSC)
    {
        LinkedList<Node>[] anotherArray = anotherSC.getArray();
        String thisValue;
        String anotherValue;

        for (int i = 0; i < this.array.length; i++)
        {
            if (this.array[i] != null)
            {
                for (int j = 0; j < this.array[i].size(); j++)
                {
                    thisValue = this.array[i].get(j).getValue();
                    for (int k = 0; k < anotherArray.length; k++)
                    {
                        if (anotherArray[k] != null)
                        {
                            for (int l = 0; l < anotherArray[k].size(); l++)
                            {
                                anotherValue = anotherArray[k].get(l).getValue();
                                if (thisValue.equals(anotherValue))
                                {
                                    this.array[i].remove(j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
