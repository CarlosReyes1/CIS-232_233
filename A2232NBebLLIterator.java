/*
    Assignment 2
    CIS 232 / Cuesta College
    Spring 2015 / R. Scovil
    Nathan Bebout <nathan_bebout@my.cuesta.edu>
*/

package cis232.A2;

public class A2232NBebLLIterator<AnyType extends Comparable<? super AnyType>>
{

    A2232NBebListNode<AnyType> current;

    //Constructor for an iterator for my custom linked list that will start at the node that was passed as
    //a parameter.
    A2232NBebLLIterator(A2232NBebListNode<AnyType> startNode)
    {
        current = startNode;
    }

    //A method that will check to see if the current node of the lhs iterator exists.
    public boolean isValid()
    {
        return current != null;
    }

    //A method that will check to see if the node we are currently looking at isValid() and if true return
    //the item at the current node. Returns false if the node isn't valid.
    public AnyType retrieve()
    {
        if(isValid())
        {
            return current.data;
        }

        return null;
    }

    //A method that will check to see if the node we are currently looking at isValid() and if true will
    //move to the next node in the list. If current is null or not valid then this method will do nothing.
    public void advance()
    {
        if(isValid())
        {
            current = current.next;
        }
    }

}
