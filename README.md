## Maze Generator Program
The Maze Generator Program is a program that allows users to create a Maze using different algorithms. The maze has a 
starting point and an end point. The user is prompted to enter a number of rows and a number of columns for the maze.
The maze is then generated according to the rows and columns inputted by the user. After this input, the program 
outputs the randomly generated maze with the rows and columns specified if it is successful. If it is unsuccessful, it 
will notify the user, and they must run the program again. Currently, there is only one algorithm that creates the maze,
it uses the depth-first-search algorithm to create the maze and create the path. In the future, adding more algorithms
would allow to create mazes using different path creations algorithms.

### User Stories
#### Generate Maze User Story
As a user, I want to generate a maze of specified dimensions to explore and navigate. It should have a starting point 
and an end point. 

### Use Cases
#### Generate Maze Use case
The interactor will first make sure that the rows and columns are valid numbers. If they are not valid, it will notify 
the user. If successful, it will create a default maze through a maze factory in which all walls are present. The 
interactor will then call on the generator to generate the maze that was just created. The generator will remove walls
according to some algorithm and modify the maze. After this, the interactor will call on the presenter to build and 
display a maze representation that corresponds to the maze. The presenter will then output this maze representation 
to the user.

### Design Patterns
1. Strategy Design Pattern <br><br>
   <p style="text-align: center;width: 100%"><img src="images/strategy_design_pattern.jpg" alt="strategy_UML"></p><br>
   A strategy design pattern is implemented in this program through the use of a generator interface. The 
   MazeGeneratorInteractor has a reference to a Generator object through the generator interface, this allows 
   the interactor to generate and modify the created maze using an object which implements the generator. Using 
   different generation algorithms, it is possible to generate mazes differently. Currently, there is only one 
   generator implemented, which uses the depth-first-search algorithm to generate the maze recursively. This design 
   pattern was used so that further generation algorithms could be used to generate the maze. <br><br>
2. Iterator Design Pattern <br><br>
   <p style="text-align: center;width: 100%"><img src="images/iterator_design_pattern.jpg" alt="strategy_UML"></p><br>
   An iterator design pattern is implemented in this program. The Maze class implements the Iterable interface such
   that it is able to iterate through its rows. A MazeIterator class implements the Iterator interface by keeping track
   of the current row and moving onto the next row. This is done so that it is easier to iterate through the maze as
   the generator assigns values to certain cells in the maze. <br><br>

### Usage
Below is an image of example usage of this program. Upon running the program, the user will be prompted with the rows 
and columns, then the maze generated will be displayed to the user.
<p style="text-align: center;width: 100%"><img src="images/random_maze.jpg" alt="random_maze"></p>


### Additional Information
JDKS: Corretto-11 <br>
Testing: JUnit4

#### Violations
There are no current code smells, SOLID violations, or CA violations.
