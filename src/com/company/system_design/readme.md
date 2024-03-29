Each of the sub-folders in this folder are meant to answer one design question.
For example the folder named "chat" contains notes and answers to the question, "How would you design a chat system?"
Within these folders there are files. My current schema is that files named "notes.md" are meant for raw, unpolished notes,
and my files named "summary.md" are more polished and attempt to answer key points in how to design the system.

Overall it is great to read engineering blogs, and about real world architectures. You can learn a lot. That being said,
if your goal is to prepare for system design interview, I think it's best to start out by reading some ready-made resources,
like System Design Interview by Alex Hu, or Exponent's course on System Design. The reason is that it's hard to find
resources on how real world architectures are made. It may take hours, so I would do that *after* going through System
Design Interview books and courses.

There is a helpful list of architectures for real-world companies [here](https://github.com/donnemartin/system-design-primer#company-architectures).
I read about WhatsApp architecture through the article linked there, and it wasn't very insightful though. Sometimes
it is hit and miss.

Things to learn:
* BEGIN TRANSACTION; in SQL means?
* [This guy](https://youtu.be/9N2S3JZffeg) has I think good advice that System Design Interview by Alex Xu and
  Web Scalability for Startup Engineers are both good books for beginner system design, and then Building Microservices and
  Designing Data-Intensive Applications are good for intermediate system design.
* Relational databases don't handle tail data well. Like that's why Facebook said they didn't choose a relational database
  for storing all their messages in Messenger. Why doesn't it work well? Is it because you have to do a query of the
  entire table and then parse it find the result? And performance goes down when you have a huge index? I don't
  fully understand the rationale and should for an interview.
* Write ahead logging. It is mentioned by [Prepare for Your Google Interview: Systems Design](https://youtu.be/Gg318hR5JY0)
  as good to know. Write ahead logging is also described in the advanced version of system design course from Educative.io
* How to connect estimates in system design to actual choices? Like, if I know I need to store X Petabytes, can I use a
  relational database? Where’s the cutoff?
Notes:
* There is another System Design Interview book you can find on gen.lib.rus.ec if you search "System Design Interview".
I'm not sure how useful it is.
* Advanced Grokking looks useful https://www.educative.io/courses/grokking-adv-system-design-intvw
* Creating a basic API is important, like in this video: [Amazon System Design Preparation (SIP)](https://youtu.be/gf8R7sgme6o) before system design interview. That video@was good overview@of whays expected. Also need to practice writing out the dayabase
  Getting hands-on practice creating this kind of API would be ideal.
* Practicing coming up with size estimates is one of the simplest ways to improve your system design skill. I faltered
  often in interviews where I just didn't know how to estimate the size of a 100 character string or something easy like that.
* Pramp has system design questions. They're not ideal, obviously, since they're only 30 minutes with a junior engineer, but still.


Helpful resources:
* https://www.youtube.com/watch?v=VYuToviSx5Q
* Leetcode has some system design question & answers https://leetcode.com/discuss/interview-question/system-design?currentPage=1&orderBy=most_votes&query=
* this looks useful, but I haven't looked through it. It was popular on Hackernews: https://www.notion.so/blog/sharding-postgres-at-notion
* If you want to find some good design questions for practice, you can always look at Glassdoor Interviews for a specific company,
  or at Leetcode forum, to see what kinds of questions companies are asking.
* I created [this playlist of System Design videos (most of real companies / products) on YouTube](https://www.youtube.com/playlist?list=PLBKfy-EgQMy3qe-QdcUe7rXwwYTeo2TjQ)
* I have a similar [playlist of System Design videos I've already watched](https://www.youtube.com/playlist?list=PLBKfy-EgQMy3qe-QdcUe7rXwwYTeo2TjQ).

Here are the resources Microsoft shares for candidates who are interviewing to prepare for system design:
* https://www.youtube.com/watch?v=tndzLznxq40
* https://www.youtube.com/watch?v=CtmBGH8MkX4&t=224s
* https://github.com/checkcheckzz/system-design-interview
* https://github.com/donnemartin/system-design-primer