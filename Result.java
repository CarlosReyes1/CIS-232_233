/*
    Assignment 2
    CIS 232 / Cuesta College
    Spring 2015 / R. Scovil
    Nathan Bebout <nathan_bebout@my.cuesta.edu>
*/

package cis232.A2;

//Interface for my mode item and mode occurrence container class
public interface Result<AnyType>
{
    //Will be implement in my container class and this method returns an item, which
    //should be the item that occurred most in the array.
    public AnyType mode();

    //Will be implement in my container class and this method returns an int, which
    //should be the number of times the mode item was seen.
    public int count();

}
