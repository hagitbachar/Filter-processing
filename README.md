# Filter-processing
This program filters the files in a given directory according to various conditions, and order the filenames that passed the filtering according to various properties.


DirectoryProcessor.java
This is the main class, she has a main function that get 2 arguments from the user:
a path of a directory that contains files, and a path of a file. It is a text file that contains
sections, wherein each section contains a FILTER and an ORDER subsections.
commandLineAnalyzer function creates a list of all the files in the directory, and she call to
readFileLines function.
readFileLines read the text file, and print the relevant files by the given filter and order.

FileException.java
this class is the main class of the errors, she extend Exception class.

Type1Error.java
This class responsible to some different error, in this type the program will print a warning and continue
normally. those error are implement in the following classes:

BadNameException.java
this calss's goal is handling errors in the FILTER and ORDER description.

BadParameterException.java
this class's goal is handling errors in the parameters given to filter

Type2Error.java
This class responsible to some different error, in this type the program will print an Error message
and the program closed. those error are implement in the following classes:

SubSectionException.java
This class for error in the sub-section name in the given file

CommandFileException.java
this class's goal is handling errors in occurring while accessing the Commands File.

CommandLineException.java
this class's goal is handling errors in the command line.

All.java
filter class,returns all files.

Between.java
filter class,returns  files which their size is between the two double numbers that were given as a
parameter.

Contains.java
filter calss,returns files which their name contains the value that was given as a parameter.

Executable.java
filter calss,returns files which has execution premission.

FileName.java
filter calss,returns files which their name is the value that was given as a parameter.

GreaterThan.java
filter class,returns files which their size is greater than the double number that was given as a
parameter.

Hidden.java
filter calss,returns files which are hidden.

Prefix.java
filter calss,returns files which their prefix is the value that was given as a parameter.

SmallerThan.java
filter class,returns files which their size is smaller than the double number that was given as a
parameter.

Suffix.java
filter calss,returns files which their suffix is the value that was given as a parameter.

Writable.java
filter calss,returns files which has write premission.

Abs.java
abs is a type of an order, he sort files by absolute name, going from  to 

Size.java
size is a type of an order, he sort files by file size, going from smallest to largest

Type.java
type is a type of an order, he sort files by file type, going from  to 


Design:
Our main class is DirectoryProcessor,it handles all the program.
meanwhile there are three other packages,exception,filter and order-each one contains classes
as described before.
we used inheritance in our program.
our program design has modularity and extesability,one may add classes to this (exception,order and filter).
may all not calsses were necessary ,but we designed our program with thought for future.


Implementation Issues:
we decided to built class for each filter, that because we want to create a specific filter object when it
needed. we  built all the order classes at the same way.
In this excersice we have 2 different type of errors, that's why we built 2 classes, one of each type,
they both extend the main exception class that she extend java class exception.
