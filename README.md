sudoku-solver
=============

A simple sudoku model, with a brute force solver I wrote for a competition with my little brother!

This model could save somebody some time if they wanted to write more sophisticated solvers in Java. The solver implementation in this project is brute-force, which means is wasn't coded for efficiency, but as a simple demonstration that a sudoku solver can be exceedingly simple and can be solved totaly via logic - the solver does not use any guessing and completes cells correctly the first time, it just iterates, a heck of a lot!

On a Intel Core i5, quad core at 2.6Ghz, it solves a puzzles in about 0.06 seconds and some of this time is probably due to JUnit bootstrapping.

The project is built using Maven (simply, `mvn clean test`) and uses JUnit to achieve good test coverage. 

It is exceedingly unlikely that I'll do anything more to this project (it's only taken about 2 hours so far, while I was watching a film!) as I don't have much interest in suduko or writing complex solvers, but I may use it as a small standalone simple Java project for bits and pieces. 
