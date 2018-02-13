/*
    Assignment 2
    CIS 232 / Cuesta College
    Spring 2015 / R. Scovil
    Nathan Bebout <nathan_bebout@my.cuesta.edu>
*/

package cis232.A2;

class A2232NBebListNode<AnyType extends Comparable<? super AnyType>>
{

    AnyType data;
    A2232NBebListNode<AnyType> next;


    //Constructor that creates a node that has no nodes after it.
    public A2232NBebListNode()
    {
        next = null;
    }

    //Constructor that takes in an item and a node reference and then sets them in the fields that match.
    public A2232NBebListNode(AnyType d, A2232NBebListNode<AnyType> n)
    {
        data = d;
        next = n;
    }

}
