## Categories
This is a good dynamic programming problem.


## Observations
### Feb 23rd 2021
This problem becomes a lot easier when you think of each additional column as either being flipped or not flipped. Then if you can precalculate everything up to that point, when you add a column, it’s just a matter of computing the two additional states. Without that realization this problem is really hard (do you flip every row and calculate the combination with every other row? that would be really hard to think about.)

In general it's better to wait to cache until the end of the problem. Even if you think you can do it first time around.
This problem was trivial to add a cache to at the end, but I remember problems where I got lost while adding caching
in the first go around, and interviewer wasn't impressed because never solved the problem!

At some point would be good to try the iterative solution.

I used some of these ideas in problem 97. You can see the spoilers.md file for that problem for more insight.


## Journal (don’t need to rewrite / organize this):
### Feb 23rd 2021
I think I didn’t plan out my approach early enough. I got the gist, but then *I didn’t think through each recursive step*. I got the idea of “this is what happens if I add an additional column”, but I didn’t then think “okay what happens when I go from recursive step one to recursive step two”. So I’m rewriting the whole thing, which is not good.

Took 2hrs to solve this one… and still getting time limit exceeded (haha). However, good news is that I learned a lot (see earlier reflection) plus how to use debugger which I didn’t know before.