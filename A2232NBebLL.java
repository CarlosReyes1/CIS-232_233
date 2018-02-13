/*
    Assignment 2
    CIS 232 / Cuesta College
    Spring 2015 / R. Scovil
    Nathan Bebout <nathan_bebout@my.cuesta.edu>
*/

package cis232.A2;

public class A2232NBebLL<AnyType extends Comparable<? super AnyType>>
{

    //Creates a header node.
    private A2232NBebListNode<AnyType> headerNode;

    //Constructor for a linked list with a header node of null.
    public A2232NBebLL()
    {
        headerNode = new A2232NBebListNode<AnyType>();
    }

    //Looks if the first item is null by using the node.
    //Returns true if the node on the first item links to another node.
    //Returns false if the node is null meaning there isn't anything after the header.
    public boolean isEmpty()
    {
        return headerNode.next == null;
    }

    //Makes the the node that links to the first node null. Which will destroy all the items that used to be there.
    public void makeEmpty()
    {
        headerNode.next = null;
    }

    //Creates a new custom linked list iterator with the current position being the header node.
    //Which means it is before the list starts.
    public A2232NBebLLIterator<AnyType> zeroth()
    {
        return new A2232NBebLLIterator<AnyType>(headerNode);
    }

    //Creates a new custom linked list iterator with the current postion being at the first item's node.
    //Which means it is at the first item.
    public A2232NBebLLIterator<AnyType> first()
    {
        return new A2232NBebLLIterator<AnyType>(headerNode.next);
    }

    //Creates a reference to the first item's node and then goes through the nodes after the first
    //till it finds the node that references the item you passed.
    //Returns a new custom linked list iterator with it currently being at the position of the item
    //that was passed. Which can be null if no item was found.
    public A2232NBebLLIterator<AnyType> find(AnyType dataToFind)
    {

        A2232NBebListNode<AnyType> itrPositionNode = headerNode.next;

        while(itrPositionNode != null && !itrPositionNode.data.equals(dataToFind))
        {
            itrPositionNode = itrPositionNode.next;
        }

        return new A2232NBebLLIterator<AnyType>(itrPositionNode);

    }

    //Creates a reference to the header node and then goes through the nodes starting at the first
    //till it finds the node that references the item you passed.
    //Returns a new custom linked list iterator with it currently being at the position before the item
    //that was passed. Which can be null if no item was found.
    public A2232NBebLLIterator<AnyType> findPrevious(AnyType dataToFind)
    {

        A2232NBebListNode<AnyType> itrPrevPositionNode = headerNode;

        while(itrPrevPositionNode.next != null && !itrPrevPositionNode.next.data.equals(dataToFind))
        {
            itrPrevPositionNode = itrPrevPositionNode.next;
        }

        return new A2232NBebLLIterator<AnyType>(itrPrevPositionNode);

    }

    //Pass the item you want to insert and the position you want it in for parameters then the previous
    //position of the iterator will then reference the node of the item you passed instead of the item
    //that it used to reference. After that the reference that was replaced is now going to be referenced
    //from the inserted data's node. This method is private so that you can't access it unless you call add().
    private void insert(AnyType data, A2232NBebLLIterator<AnyType> itr)
    {

        if(itr != null && itr.isValid())
        {
            itr.current.next = new A2232NBebListNode<AnyType>(data, itr.current.next);
        }

    }

    //Pass a data point you want to remove from the list and then a reference to my custom linked list
    //iterator will be at the position before the data you want to remove, thanks to the findPrevious()
    //method, It then checks to see if the item you want to remove exists and then makes the node previous
    //the item you want to delete bypass that node and reference the node after the item you want to remove.
    //This bypass will end up deleting the removed node's item permanently.
    public void remove(AnyType dataToRemove)
    {

        A2232NBebLLIterator<AnyType> positionRemoveData = findPrevious(dataToRemove);

        if(positionRemoveData.current.next != null)
        {
            positionRemoveData.current.next = positionRemoveData.current.next.next;
        }

    }

    //This method will pass a custom linked list in and then it will check to make sure the list isn't empty
    //then creates an custom iterator to run through the list and print out all the items separated by a space.
    //If list is empty will print out a message saying so.
    public static <AnyType extends Comparable<? super AnyType>> void printList(A2232NBebLL<AnyType> theLinkedList)
    {

        if(theLinkedList.isEmpty())
        {
            System.out.print("This list is empty.");
        }

        else
        {
            A2232NBebLLIterator<AnyType> tempItr = theLinkedList.first();

            for(; tempItr.isValid(); tempItr.advance())
            {
                System.out.print(tempItr.retrieve() + "  ");
            }
        }

        System.out.println();

    }

    //This method will get a reference to the first item in the list and then will run through the list and
    //will insert the item in ascending order.
    public void add(AnyType dataToAdd)
    {

        A2232NBebLLIterator<AnyType> tempItr = first();

        for(; tempItr.isValid(); tempItr.advance())
        {

            if (dataToAdd.compareTo(tempItr.current.data) < 0)
            {
                A2232NBebLLIterator<AnyType> preItemItr = findPrevious(tempItr.current.data);
                insert(dataToAdd, preItemItr);
                break;
            }

        }
    }

    //Pass two items, the first is the item you want to find and be replaced and the second one is the one you
    //want to insert into the replaced items spot. Returns false if the item you want to be replaced isn't in
    //the list. Returns true when the item to be replaced is there and is replaced with the new item in
    //ascending order.
    public boolean replace(AnyType dataToReplace, AnyType dataToInsert)
    {

        if(find(dataToReplace) == null)
        {
            return false;
        }

        else
        {
            remove(dataToReplace);
            add(dataToInsert);
            return true;
        }

    }

    //Will printout the linked list on the lhs of the . and will do so with each item one per line.
    //Checks to see if the list that is provided is empty and if so prints out a message saying that it is.
    public void showList()
    {
        int numOfDataItems = 0;
        A2232NBebLLIterator lhslinkedListItr = first();

        if(isEmpty())
        {
            System.out.println("The list is currently empty.");
        }

        else
        {

            System.out.println("The lhs list's items will be displayed one per line: ");

            for (; lhslinkedListItr.isValid(); lhslinkedListItr.advance()) {

                System.out.println(lhslinkedListItr.current.data);
                numOfDataItems++;

            }

            System.out.println("The number of items in this list is: " + numOfDataItems);

        }

    }

    //An overloaded method of showList() that will take in a integer parameter that will tell the method how
    //many items to print out on a line. Will do the same things as showList() but will only have the number
    //of items on a line be equal to the int passed, instead of defaulting to one like showList().
    public void showList(int numOfItemsOnLine)
    {

        int numOfDataItems = 0;
        int perLineCount = 0;
        A2232NBebLLIterator lhslinkedListItr = first();

        if(lhslinkedListItr != null)
        {
            throw new NullPointerException();
        }

        else if(isEmpty())
        {
            System.out.println("The list is currently empty.");
        }

        else
        {

            System.out.println("The lhs list's items will be displayed " + numOfItemsOnLine + " per line: ");

            for (; lhslinkedListItr.isValid(); lhslinkedListItr.advance()) {

                System.out.print(lhslinkedListItr.current.data + "  ");
                numOfDataItems++;
                perLineCount++;

                if(perLineCount == numOfItemsOnLine)
                {
                    System.out.println();
                    perLineCount = 0;
                }

            }

            System.out.println("The number of items in this list is: " + numOfDataItems);

        }

    }

    //Will get passed a custom linked list reference and then will check to see if it is empty and if it is
    //a message saying that it is empty and has no mode will printout. Also it will return a modeResult
    //of the item as null and frequency of null being 0. If the list isn't empty it will find the mode item
    // and number of times it occurs and then will return that information into the modeResult container.
    public modeResult getMode(A2232NBebLL<AnyType> theLinkedList)
    {

        int modeFreq = 0;
        AnyType modeItem = null;
        A2232NBebLLIterator<AnyType> itr = first();

        if(theLinkedList.isEmpty())
        {
            System.out.println("The list is empty so there is no Mode.");
        }

        else
        {
            for(; itr.isValid(); itr.advance())
            {
                int freq = 0;
                A2232NBebLLIterator<AnyType> tempItr = new A2232NBebLLIterator<AnyType>(itr.current.next);

                if(!tempItr.isValid())
                {
                    return new modeResult(itr.current.data, modeFreq);
                }
                else
                {
                    for(; tempItr.isValid(); tempItr.advance())
                    {
                        if(itr.current.data.compareTo(tempItr.current.data) == 0)
                        {
                            freq++;
                        }
                    }

                    if(freq > modeFreq)
                    {
                        modeFreq = freq;
                        modeItem = itr.current.data;
                    }
                }

            }

        }

        return new modeResult(modeItem, modeFreq);

    }

    //A custom container class that will store the item that was the mode of some list and the number of time
    //that item occured. Has getters and a constructor for setters.
    public class modeResult implements Result<AnyType>
    {

        AnyType typeResult;
        int countResult;

        //Constructor that will take in the mode item and its frequency of occurrence.
        public modeResult(AnyType type, int occur)
        {
            typeResult = type;
            countResult = occur;
        }

        //Will get the item that was mode of some list of items
        public AnyType mode()
        {
            return typeResult;
        }

        //Will get the int for number of times the item occurred in the list of items.
        public int count()
        {
            return countResult;
        }

    }

}