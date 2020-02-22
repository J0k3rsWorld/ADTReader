README is currently worked on, wip atm.

# ADTReader

## Introduction
This Project was used to learn how WoW MapFiles (adt, terrain) are structured. It was the first contact with binary files and it is still not 100% finished. Currently only WoW Version 3.3.5 is supported. Support for newer versions might be added but are not the focus of the project.

## Classes

### ADT335
As the name suggest this is the class which represents a adt file in this java project. Furthermore it is only for WoW Version 3.3.5.
It is just an object for programatic representation of a adt file. It contains no logic.

###Chunks
In here are all the classes which represent the data chunks found in an adt. They only contain the data which is read from the file in the filesystem into an Object.
