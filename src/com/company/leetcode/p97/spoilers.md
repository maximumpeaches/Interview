## Categories



## Observations
### Feb 24th 2021
I have two tips for solving a dynamic programming problem like this:
1) Solve the recursive step first. It's easy for me to identify that this problem will require dynamic programming 
   approach. After that insight, think of what the recursive helper function will need as input and what it will 
   call for subroutines, and what it will return. Then write the helper function. After the helper function is 
   complete, it's easier to go back and write the main function which starts the helper function.
   Along the way of course you'll think of the base case for the helper function.
2) Go back and add caching at the end. It's sooo easy to add caching at the end, but complicates the problem a lot 
   to add it while you're solving it.
Both of these points were also realized while doing problem #1072, and I just practiced them on this problem, since 
   it is also dynamic programming. Any dynamic programming problem can use these same points.


## Journal (don’t need to rewrite / organize this)
