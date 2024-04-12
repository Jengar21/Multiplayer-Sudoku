# Multiplayer-Sudoku


## Dscription
A Java application that allows multiple users to play a Sudoku game.

Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9-by-9 grid with digits so that each column, each row, and each of the nine 3-by-3 sub-grids that compose the grid contains every digit from 1 to 9.

A server hosts a randomly generated Sudoku board that contains 25 empty spots and keeps track of the progress; a Sudoku board is represented as an object of Sudoku class (provided in Sudoku.java).

A client connects to the server through a TCP/IP connection and sends a message to the server to update a Sudoku board; the server either accepts the message to update the board or rejects the message to return the error back to the client.

## Documentation

[Documentation Link ](https://docs.google.com/document/d/1IMZiSSNvdeWkz-Sjnrok5zAOy7YefjzIazWtc_k3HL4/edit?usp=sharing)