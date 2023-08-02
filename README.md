## Maze Generator Program
The Maze Generator Program is a program that allows users to create a Maze using different algorithms. The maze has a 
starting point and an end point. The user is prompted to enter a number of rows and a number of columns for the maze.
The maze is then generated according to the rows and columns inputted by the user. After this input, the program 
outputs the randomly generated maze with the rows and columns specified if it is successful. If it is unsuccessful, it 
will notify the user, and they must run the program again. 

### User Stories
Generate Maze User Story

### Use Cases
#### Generate Maze Use case
The interactor will first make sure that the rows and columns are valid numbers. If they are not valid, it will notify 
the user. If successful, it will create a default maze through a maze factory in which all walls are present. The 
interactor will then call on the generator to generate the maze that was just created. The generator will remove walls
according to some algorithm and modify the maze. After this, the interactor will call on the presenter to build and 
display a maze representation that corresponds to the maze. The presenter will then output this maze representation 
to the user.

### Design Patterns
1. Strategy Design Pattern \
   ![Alt text](/images/strategy_design_pattern.jpg "Iterator")
   <p align="center"><img src="images/strategy_design_pattern.jpg" width="300" alt="strategy_UML"></p>
   A strategy design pattern is implemented in this program through the use of a generator interface. This allows for 
   different generation algorithms. The MazeGeneratorInteractor has a reference to a Generator (which is an interface), 
   the generator allows the interactor to generate and modify the created maze. Using different generation algorithms,
   it is possible to generate mazes differently. Currently, there is only one generator implemented, which uses the 
   depth-first-search algorithm to generate the maze recursively.
2. Iterator Design Pattern \
   ![Alt text](/images/iterator_design_pattern.jpg "Iterator") \
   An iterator design pattern is implemented in this program. The Maze class implements the Iterable interface such
   that it is able to iterate through its rows. A MazeIterator class implements the Iterator interface by keeping track
   of the current row and moving onto the next row.
3. Simple Factory Design Pattern
