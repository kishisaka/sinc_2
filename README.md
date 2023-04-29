<pre>

Given a 2 dimensional array AxB of any size as input.
Implement a solution to flip all islands of 0’s to 1’s and display the result
An island is defined as any region of one or more connected 0’s, 
surrounded by 1’s on all FOUR sides (Up, Down, Left and Right). 

Example input and output as follows:

Input 1    0utput 1
[1,1,0,1]  [1,1,0,1]
[1,1,0,1]  [1,1,0,1]
[1,0,1,1]  [1,1,1,1]
[1,1,1,1]  [1,1,1,1]

Input 2   0utput 2
[1,1,1,1]  [1,1,1,1]
[1,1,0,1]  [1,1,1,1]
[1,0,0,1]  [1,1,1,1]
[1,1,1,1]  [1,1,1,1]

Input 3   0utput 3
[1,1,0,1]  [1,1,0,1]
[1,0,0,1]  [1,0,0,1]
[1,0,1,1]  [1,0,1,1]
[1,1,1,1]  [1,1,1,1]

This will have a time complexity of N x K. In the worst case, we have to iterate over every N cell in the world and 
for each world cell, we then have to check K world cells at that point to fill the island. 
Space complexity is 3N -> N for holding the visited cells, our stack holding the current cells to check and the areas to paint.  

input
1101
1101
1011
1111
---------------------------
output
1101
1101
1111
1111
---------------------------
input
1111
1101
1001
1111
---------------------------
output
1111
1111
1111
1111
---------------------------
input
1101
1001
1011
1111
---------------------------
output
1101
1001
1011
1111
---------------------------
input
110111111111
100100010110
101101001001
011011001011
111001011011
111011111011
---------------------------
output
110111111111
100111111110
101111111001
011011111011
111001111011
111011111011
---------------------------

Process finished with exit code 0

</pre>
