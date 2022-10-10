# Should review
Below is a list of problems from Leetcode or topics which I'd like to review. Most of them have an associated date, 
which means I should come back to them not before, and ideally at, that date (I leave a date in the future so I am 
taking advantage of [distributed learning](https://en.wikipedia.org/wiki/Distributed_practice)).


- [Segment tree](https://leetcode.com/tag/segment-tree/) actually has a number of problems related to it.
- after/on Aug 31 do other LCA of binary tree problems. One every other day or so. After you've done them a couple 
ways, review the Solution tab here: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ You can 
also use that link to find the similar problems.
- 128 try it
- 200 try it
- 785 try it
- 287 around Sept 1st. Try reviewing conceptually first.
- 581 on/after Sept 1 (see readme.md file)
- Practice 323 sometime after Sept 3rd or so.
- p1143 practice after Sept 4th.
- p41 practice after Sept 7th
- 560 really good to practice
- p99 really good one. on/after Sept 9th
- p29 really good one. on/after Sept 9th. See readme.md first.
- 856 on/after Sept 10th
- 1526 on/after Sept 10th
- 23 on/after Sept 11th. Try conceptually going over it, and coming up with time and space complexities of different 
solutions, first.
- 142 on/after Sept 11th (just the O(1) space solution)
- 77 after Sept 12
- p1041 review after September 16th or so
- p46 review after Sept 19th
- 215 on/after September 19. See readme.md
- 857 on/after Sept 19th just review conceptually for now. Can you remember both solutions, the okay one and the 
optimized one?
- 92 on/after Sept 20th.
- 280 on/after Sept 20th
- 96 on/after Sept 20th
- p1072 on/after Sept 20th, review (at least conceptually, implement if have time but not sure it is the most popular 
question to ask)
- 126 on/after Sept 20
- 694 on/after Sept 20th need to review conceptually first
- 399 on/after Sept 21
- 239 on/after Sept 21. Shoot for O(n) time complexity
- p122 - review after/on Sept 21
- 252 on/after Sept 23 - try it to practice Java API
- 489 on/after Sept 23
- 729 on/after October 1st - good to practice implementation
- 123 on/after Oct 5th. then try 188. (this whole series is interesting to review)
- 871 on/after Oct 10 th just review conceptually
- review 272 on/after Oct 15th
- Leetcide 299 is good to review
- Leetcode 1548 I came up with soln I think should work but this kind of problem is good for dp implementation practice sometime too.

- 523 Oct 20
- 72 November 22nd
- 981 November 20th
- 124 between December 1st and March 1st
- Review how to generate the hashCode (you can see how IntelliJ implements it using the Objects.hash method if a class 
has for instance a String and an integer as fields). I didn't remember this when I went to go use it.
- 297 try implementing
- 65 try implementing
- 621 try implementing
- 689 try implementing

Notes:
p45 is really good practice in coming up with the corner cases *first* before running through the algorithm. 
Conceptually I got it, but it's easy to miss corner cases or miss errors that can come up when implementing it.
Also a more natural way to write code in an interview is to write a little and then walk through it, rather than 
walking through the whole thing at the end. This also seems easier for the interviewer.
Review Collections.cop
- Remember to come up with space and time complexity when you do a problem, and then verify they are correct when you 
look at the answer.
- One really important thing to remember is that some companies, such as Facebook as of 2021, have pretty predictable
interview questions. So you can just do everything tagged for that company. You can tell which companies are more pre-
dictable in Leetcode because those questions will be asked a ton in the recent past. Dropbox is another company that's
pretty predictable, and you can see on the Interview section of Dropbox's Glassdoor page recent questions.
- arrays can often be used in place of Java's HashMap, and you can see [here](https://github.com/vavr-io/vavr/issues/571) how HashMaps are often slow

## Leetcode lists
### List descriptions
* "Problems with Solutions" list now has all the problems with Solutions numbered #1600 to #2030 (of course it's possible several more problems
  in this range have solutions added, though). It is current as of Oct 6th (so you can see updates on leetcode.com and 
  if new solutions were added since Oct 6th).
* "Frequently asked Do Soon" includes yellow category of frequently asked from past 6 months at Google, past 6 months at
  Microsoft, and past year at Snap Inc., last 6 months at LinkedIn.
### Creating the lists
I tried to make a list of problems that I could then review while walking or something. My idea was to add all the
problems with a Solution tab to the list. I looked at some automated ways to do this... 
Beautiful Soup isn't a good option because it's more designed to just parse a webpage, not act on it. 
I think it's possible to automate this with Selenium and Python. 
I also looked at several "leetcode cli" projects on GitHub including [this one](https://github.com/skygragon/leetcode-cli)
and [this one](https://github.com/realVEct0r/leetcode-api). I wasn't able to login to Leetcode using either, and I
saw many people have the same issue. The reason is that Leetcode now uses Captcha, I think. There were some workarounds
where you get the cookie using Chrome dev tools, but I also didn't get this to work. Maybe it's possible and how I was
doing it wasn't successful, but I am not sure it's possible since I think I followed the instructions from other people
who have solved it pretty closely.
I think it's still a good idea to make a list of questions that you want to look at while walking, and maybe have lists
for questions you think you need to implement. You may just find it easier to add these questions manually, although
Selenium is still an option. The nice thing about adding them manually is you just add 100 problems in 10 minutes, and if
you go through all 100 then you can add more, otherwise you didn't spend a bunch of time automating the process of adding
1000 problems. I mean, you may not even use the list after all, and adding manually has much less up-front cost. If you
end up using the list all the time then you can always automate it later.

Problems from Curated Google List on Leetcode which I haven't done / I don't know the answer to:
- Missing Ranges
- Expressive Words
