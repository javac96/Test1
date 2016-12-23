// File name: ~ftp/pub/class/cplusplus/Reference/RefSimple.cpp
// Purpose:   A simple program demonstrating the use of reference

#include <iostream>
using namespace std;

int main()
{
	int Len, Wid;     // declare int variables

	// Create references to int variables.
        // Now rLen and Len are aliases to each other,
        // and rWid and Wid are also aliases to each other.
	int &rLen = Len;
	int &rWid = Wid;

	// Initialized the two int variables
	Len = 10;         // rLen is also initialized to be 10
	Wid = 20;         // rWid is also initialized to be 20

	// Printing out the values for int and int references
	cout << "Len is: " << Len << ", and  Wid is: " << Wid << endl;
	cout << "rLen is: " << rLen << ", and rWid is: " << rWid << endl;
	cout << endl;

	// Printing out the address of int and references to int
	cout << "Address of Len is: " << &Len << endl;
	cout << "Address of rLen is: "  << &rLen << endl;
	if(&Len == &rLen)
	{
		cout << "Address of Len is equal to address of rLen!" << endl;
	}
	cout << "Address of Wid is: " << &Wid << endl;
	cout << "Address of rWid is: "  << &rWid << endl;
	if(&Wid == &Wid)
	{
		cout << "Address of Wid is equal to address of rWid!" << endl;
	}

	return 0;
}

