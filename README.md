sudoku-solver
=============

## This project is now archived. Here is the [TURTLES checklist :turtle:](TURTLES.md) 

A simple sudoku model, with a brute force solver I wrote for a competition with my little brother!

This model could save somebody some time if they wanted to write more sophisticated solvers in Java. The solver implementation in this project is brute-force, which means is wasn't coded for efficiency, but as a simple demonstration that a sudoku solver can be exceedingly simple and can be solved totaly via logic - the solver does not use any guessing and completes cells correctly the first time, it just iterates, a heck of a lot!

On a Intel Core i5, quad core at 2.6Ghz, it solves a puzzles in about 0.06 seconds and some of this time is probably due to JUnit bootstrapping.

The project is built using Maven (simply, `mvn clean test`) and uses JUnit to achieve good test coverage. 

It is exceedingly unlikely that I'll do anything more to this project (it's only taken about 2 hours so far, while I was watching a film!) as I don't have much interest in suduko or writing complex solvers, but I may use it as a small standalone simple Java project for bits and pieces. 

Running it
==========

I implemented this as a library, there is no Main-Class attribute so you cannot run it directly. To test functionality, the aforementioned JUnit tests are used. When you run the test, it looks something like this;

      9 |     | 463
      6 | 34  | 529
    234 | 569 | 718
    ----------------
     67 |     | 34 
     4  |  3  | 29 
     2  |     | 68 
    ----------------
      2 |   1 | 934
    493 | 825 | 176
     7  | 493 | 852

    There are 30 unsolved cells remaining.
    
    There are 22 unsolved cells remaining.
    
    ...
    
    There are 0 unsolved cells remaining.

    759 | 182 | 463
    816 | 347 | 529
    234 | 569 | 718
    ----------------
    967 | 258 | 341
    148 | 736 | 295
    325 | 914 | 687
    ----------------
    582 | 671 | 934
    493 | 825 | 176
    671 | 493 | 852
