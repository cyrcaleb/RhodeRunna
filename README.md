# RhodeRunna
Top Down car game that was created using recursive backtracking and using the JavaFX framework. The user uses WASD to move from the starting point to the ending point and each time they make it to the end a new grid is generated. If the entire vehicle is touching the grass, the Game Over screen will appear and the user can restart by pressing the Start/Restart Button.

### Challenges:
This project was mainly done by me and two of my friends. One of them focused on the main screen and music, the other did car movement, and I did the grid generation and collision. A major challenge was combining the grid generation feature and the car feature at the same time. 

This was the first time I have worked with the JavaFX framework and JavaScript, it was a little tricky but I see the power of frameworks and why they are essential to game creation. I also now have a much greater appreciation for Unity as I see how many things in the background it manages so that we as programmers do not have to worry about them. 

### Fun/Interesting Parts(To me atleast):
The whole grid generation I find super interesting as the grid is made up of a 2D ArrayList of type Road. In our program we have 7 Roads that are made with just these three pictures and base 2 connection values where North = 8, South = 4, East = 2, and West = 1:
![](https://cdn.discordapp.com/attachments/768196064276119582/1106240333282558013/image.png)

The RoadArray class is a Data Transfer Object. In total we have 7 total roads which covers every possible connection from one direction to another including one for a blank road which is there to show that no roads exist in that cell. Using connection values of base 2 allows no two roads to have the same value.

![](https://cdn.discordapp.com/attachments/768196064276119582/1106239551170691113/image.png)

## Main Menu
![RhodeRunnaMainScreen](https://github.com/cyrcaleb/RhodeRunna/assets/90429575/c8c66acb-2c7c-4fa4-8aff-3c53cca1d355)


## Play Screen
![](https://cdn.discordapp.com/attachments/768196064276119582/1106235333395361933/image.png)
