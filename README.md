NOTE: It is required to have Processing IDE installed from processing.org or processing library itself to run this code.

To give a quick recap of how this code works:
1) It creates two 2D arrays (for new and old cells).

2) It fills them randomly with 0s, 1s according to the random number picked by the computer and whether or not it suits the conditions set in code.

3) It then scans through the array (old) and draws squares on a canvas according to positions of 1s, 0s, where 1 is a living cell, 0 is a dead cell.

4) It then scans the old array again and checks for each cell's neighbors, counting them (1 above, 1 below, 1 right, 1 left of the cell, 1 to the upper left, 1 upper right, 1 down left, 1 down right of the cell).

5) It then checks whether the number of neighbors corresponds to the rules of the game and changes the cells in the new array.

6) The old array is then rewritten using the new array.

7) The old array is drawn on canvas and the loop repeats.

The new array is necessary to keep the old array from changing while the code counts the neighbors.

The arrays are slightly bigger than the have to be, as they are wrapped in a frame full of 0s, so as not to get exception errors when trying to check for elements outside of arrays' length. 

The canvas is a 600 by 600 window, each square is 20 by 20.

The function that prints the array is not used in the actual code and is just there to see how the actual arrays are changing when the code runs. Can be useful to gain a bit more insight in how it runs, but you can delete it if you wish, nothing will change.

Feel free to use the code for your own projects, no licenses or mentions of the author are needed.
