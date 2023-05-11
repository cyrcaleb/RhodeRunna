# RhodeRunna
Top Down car game that was created using recursive backtracking, a three by three grid of cells, and the JavaFX framework. The user uses WASD to move from the starting point to the ending point and each time they make it to the end a new grid is generated. If the entire vehicle is touching the grass, the Game Over screen will appear and the user can restart by pressing the Start/Restart Button.

### Challenges:
This project was mainly done by me and two of my friends. One of them focused on the main screen and music, the other did car movement, and I did the grid generation and collision. A major challenge was combining the grid generation feature and the car feature at the same time. 

This was the first time I have worked with the JavaFX framework and JavaScript, it was a little tricky but I see the power of frameworks and why they are essential to game creation. I also now have a much greater appreciation for Unity as I see how many things in the background it manages so that we as programmers do not have to worry about them. 

### Fun/Interesting Parts (To me atleast):
The whole grid generation I find super interesting as the grid is made up of a 2D ArrayList of type Road. In our program we have 7 Roads that are made with just these three images and a rotation value:
![](https://cdn.discordapp.com/attachments/768196064276119582/1106240333282558013/image.png)

The RoadArray class is a Data Transfer Object where we have 7 total roads that cover every possible connection from one direction to another including one for a blank road which is there to show that no roads exist in that cell. Each of the two directions a road connects to is a base 2 value where North = 8, South = 4, East = 2, and West = 1. Using connection values of base 2 allows no two roads to have the same value. Ex: If instead we had North = 4, South = 3, East = 2, and West = 1:  The SouthEast Road would be 5 since 3+2=5 and the NorthWest Road would also be 5 since 4+1=5.

![](https://cdn.discordapp.com/attachments/768196064276119582/1106239551170691113/image.png)

This all works brilliantly together since the grid generation process works like this:
- A random Starting Cell of the 3 by 3 grid is chosen (Can be any cell besided the middle)
- A starting connection values chosen (N,S,E,W Base 2) 
- All roads have two connections, if one of those connections is the same value as the starting cell, it can be placed in that location
- To get our next connection value we simply take the value of our current road, and subtract the starting connection value as this will give us the remaining value
- Ex: The starting cell is First Column, Second Row, and the connection value is 1 for West.  The three possible Roads are NorthWest(9), SouthWest(5), and EastWest(3). If we randomly select the SouthWest Road our new connection value will be 4 since value of the road (5), minus the value of the west connetion (1) = 5-1 = 4. This represents a South Connection.
- This process is repeated using backtracking to ensure no impossible grids are generated (Tracks that end in the center, Tracks that create a circle, or tracks that intersect one another)


## Main Menu
![RhodeRunnaMainScreen](https://github.com/cyrcaleb/RhodeRunna/assets/90429575/c8c66acb-2c7c-4fa4-8aff-3c53cca1d355)


## Play Screen
![](https://cdn.discordapp.com/attachments/768196064276119582/1106235333395361933/image.png)
