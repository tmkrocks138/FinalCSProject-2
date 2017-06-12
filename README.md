# FinalCSProject-2

Michela Marchini and Tara Khanna's PacMan

Development Log:
In the beginning of the project (end of May/ early June), Michela repurposed the Location class from MazeSolver to fit our needs and started on a Pellet class. Meanwhile Tara started researching the different ghost movement algorithms in pacman as well as how PacMan himself moves.
Tara worked on mainly on ghost algorithms and Michela worked on Location and Pellets properties such as isWall() and eatMe().
Tara wrote PacMan methods and variables to keep track of its location.
Michela figures out how to read in maze file and print out the maze in processing.
Michela figures out how to use user input to move PacMan.
Tara works on draw() and movements of objects.
Michela finalizes setup() and how to make pacman/ghost icons move with their respective objects.

Important things to know:
Our PacMan uses the keys "wasd" to move (upper or lowercase works) and our ghosts aim to either catch pacman or escape superPacMan (theorhetically).
The score prints in the sketch whenever you eat another pellet.

Bugs:
You cannot go around the side through the tunnel.
The ghosts do not move as they are supposed to and, though they begin by following their public algorithms they don't move more than about two spaces before stopping.


