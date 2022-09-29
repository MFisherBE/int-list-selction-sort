// Michael Fisher
// x500: fishe816
// CSCI1913
// ***Test results from driver at bottom of file


//  INTY SORTY LIST. A linear singly linked list of INTs which can be sorted by
//  Selection Sort.
class IntySortyList
{

//  NODE. A node in a singly linked linear list of INT's.
    private class Node
    {
        private int  key;   //  The key at this NODE
        private Node next;  //  The next NODE in the list, or NULL.

//  Constructor. Initialize a new NODE with KEY and NEXT.
        private Node(int key, Node next)
        {
            this.key  = key;
            this.next = next;
        }
    }

    private Node first;  //  Head node.

//  Constructor. Let FIRST be a singly linked linear list of the INT's in KEYS,
//  with a head node.
    public IntySortyList(int ... keys)
    {
        first = new Node(0, null);
        Node last = first;
        for (int key: keys)
        {
            last.next = new Node(key, null);
            last = last.next;
        }
    }

//  SORT. Sort FIRST using Selection Sort.
    public void sort()
    {
        boolean NextLarger = false;
        Node unsorted = new Node(0,first);
        Node sorted = new Node(0,first);

        // Array used to store keys and compare them
        // for later storing in "sorted" list in
        // ascending order.
        int[] getMin;

        // Int used to get the size of the array to store keys
        int size = 0;

        // declare and initialize the current largest key found
        int curlargest = unsorted.key;

        // Declare and initialize the last iteration's largest key found
        int lastlargest = 0;

        // If unsorted list is empty, stop
        if(unsorted == null)
        {
            throw new IllegalArgumentException();
        }

        // Else if unsorted list has keys in it
        else
        {
            while(unsorted.next != null)
            {

                // If the current key (head node key) is less than the next key
                if(unsorted.next.key > unsorted.key)
                {
                    // Store next key value in current largest key found
                    curlargest = unsorted.next.key;

                    // Set comparison flag for (NEXT KEY = LARGER) to true for later comparisons
                    // that were not used...
                    NextLarger = true;
                }

                // Else if curruent unsorted key is larger than next key
                else if(unsorted.key > unsorted.next.key)
                {
                    // store current key in current largest key
                    curlargest = unsorted.key;

                    // Flag set flase (CURRENT LEY = LARGER)
                    NextLarger = false;
                }

//  TO STRING. Convert FIRST to a STRING, for printing.
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Node temp = first.next;
        if (temp != null)
        {
            builder.append(temp.key);
            temp = temp.next;
            while (temp != null)
            {
                builder.append(',');
                builder.append(' ');
                builder.append(temp.key);
                temp = temp.next;
            }
        }
        builder.append(']');
        return builder.toString();
    }
}

//  INTY SORTY DRIVER. Test INTY SORTY LIST. The comments show what is printed.
//  Numbers at the ends of some comments show how many points a test is worth,
//  for a total of 30 points.

class IntySortyDriver
{

//  MAIN. Run the tests.
    public static void main(String [] args)
    {

//  Sort an empty list.

        IntySortyList empty = new IntySortyList();
        System.out.println(empty);                       //  []
        empty.sort();
        System.out.println(empty);                       //  []                  5.

//  Sort a list with one element.

        IntySortyList one = new IntySortyList(1);
        System.out.println(one);                         //  [1]
        one.sort();
        System.out.println(one);                         //  [1]                 5.

//  Sort a list with two elements.

        IntySortyList two = new IntySortyList(2, 1);
        System.out.println(two);                         //  [2, 1]
        two.sort();
        System.out.println(two);                         //  [1, 2]              5.

//  Sort a list with random non-negative elements.

        IntySortyList positives = new IntySortyList(5, 2, 1, 3, 4);
        System.out.println(positives);                   //  [5, 2, 1, 3, 4]
        positives.sort();
        System.out.println(positives);                   //  [1, 2, 3, 4, 5]     5.

//  Sort a list with duplicate non-negative elements.

        IntySortyList duplicates = new IntySortyList(3, 2, 1, 2, 3);
        System.out.println(duplicates);                  //  [3, 2, 1, 2, 3]
        duplicates.sort();
        System.out.println(duplicates);                  //  [1, 2, 2, 3, 3]     5.

//  The big finish. Sort a list with negative and non-negative elements.

        IntySortyList finish = new IntySortyList(2, -1, 0, -2, 1);
        System.out.println(finish);                      //  [2, -1, 0, -2, 1]
        finish.sort();
        System.out.println(finish);                      //  [-2, -1, 0, 1, 2]   5.
    }
}


// TEST RESULTS
//
//"C:\Program Files\AdoptOpenJDK\jdk-14.0.2.12-hotspot\bin\java.exe" "-javaagent:C:\Users\micha\AppData\Local\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\lib\idea_rt.jar=65327:C:\Users\micha\AppData\Local\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\micha\IdeaProjects\IntySortyList.Lab12\out\production\IntySortyList.Lab12 IntySortyDriver
//        []
//        []
//        [1]
//        [1]
//        [2, 1]
//        [2, 1]
//        [5, 2, 1, 3, 4]
//        [5, 2, 1, 3, 4]
//        [3, 2, 1, 2, 3]
//        [3, 2, 1, 2, 3]
//        [2, -1, 0, -2, 1]
//        [2, -1, 0, -2, 1]
//
//        Process finished with exit code 0