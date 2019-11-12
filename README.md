# HugeInteger-Class
Implements an integer class in java for which the size of the integer is limited only by memory. This is accomplished by storing the integer in array form. All integer operations had to be coded in accordance with this new storage protocol.

Huge Integer class contains public methods add(), subtract(), mutiply(), divide(), compareTo(), and toString().
add(), subtract(), compareTo(), and toString() runtime analysis is on the order T(n)=O(n).
multiply() and divide() are of the order T(n)=O(10^n). 

This is the trade off for the unrestricted size of the integer.

The additional timing class is used for runtime analysis.
