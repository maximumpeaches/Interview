I'm not an expert on preparing for interviews, and this list doesn't encapsulate everything I know. So it may not help you much.
That said, below are my tips on preparing for system design and algorithmic sections of tech interviews.

How to prepare for algorithms:
* One thing I think helps a lot is to review problems conceptually rather than implement everything. You can read a
  problem, then try to say out loud the algorithm, then check your answer. I did this with problems in Elements of Programming
  Interviews and Cracking the Coding Interview, and am now doing it with Leetcode. I implement problems I think I need practice
  with, but a lot of problems are easy to implement once you know the idea so I don't implement them and it saves time I can spend
  working on problems I otherwise wouldn't get to.
* Generally you should prepare for algorithmic questions by doing lots of questions on Leetcode or EPI or CTCI. Then when
  you schedule interviews with a company (or as soon as you know you will interview with some company) you should do the
  problems on Leetcode for that specific company, and not just do random problems from Leetcode any more until after your interview.
* I like to walk while reviewing problems conceptually (or implementing them if I have a walking desk). I just like walking in general, and it makes me happy.
* You can take notes in Leetcode that will be saved to the cloud. You can also group questions into lists. I have a list "Done"
  for questions I don't need to practice again, another list "Need Implement" to implement, another list, "Review Conceptually"
  and so on. I also have notes for problems like "Look at the solution before implementing" or "try implementing in O(1) time"
  or just if I implemented it successfully, "implemented quickly. no need to practice again." Anyways the notes and lists
  features in Leetcode can help a lot. Note however that Leetcode does not save your code to the cloud after you submit.
  It only saves it locally in your browser. So if you want to save your code you need to save it elsewhere.
* It's really important to begin algorithmic questions by asking clarifying questions and then coming up with examples to clarify.
  This is something you don't necessarily get practice with using Leetcode, and I found interviewing.io useful for. I liked
  both the peer mock interviews and the paid mock interviews on interviewing.io (although they are pricey). [This Leetcode problem](https://leetcode.com/problems/powx-n/)
  is good practice for clarifying different potential inputs before you begin.
* You also need to practice walking through a problem and debugging it by hand, as in most interviews you won't be able to compile and run code. 
  Although in a few interviews so far they've asked me to compile and run the code. To debug by hand, work through an 
  example, and write down the variables and update their state as you go along.
* To be honest on Leetcode I don't clarify every problem before I begin, or debug by hand, because it would take too long.
  It seems to be okay, but I just have practiced that way a few times and would do so in a real interview.
* When preparing for specific companies, be sure to access the list of questions for that company here: https://leetcode.com/company/google/
  rather than by going to the main problemset page and selecting the Google tag like this: https://leetcode.com/problemset/all/?companySlugs=google&page=1&sorting=W3sic29ydE9yZGVyIjoiREVTQ0VORElORyIsIm9yZGVyQnkiOiJGUkVRVUVOQ1kifV0%3D
  The reason is that when you do the latter, the frequency ranking is frequency across all companies, whereas you want
  the frequency across just the specific company you're preparing for. This is tricky so be careful!
* I didn't pass my Facebook phone screen. I got the optimal solution, but I made one or two small mistakes. In my binary search
  I had lower < higher rather than lower <= higher. I don't know why I was rejected but this may have been why, since it's the
  only flaw in my solution really. We had time for some verbal follow up afterwards, too.
  My point in bringing this up is that I think there are a couple goals in an interview. One is to come up with an optimal solution.
  The other is to flush out all the edge cases, and point out any potential problems like int overflow or stack overflow.
  The other goal is to test enough inputs that you make sure there are no bugs at all in your code. Sometimes the interviewer
  will not point out if you miss a test case, or if you have a bug. They may act like everything is fine, and that can throw you off.
  However it's important to be rigorous, and kind of cold hearted about the whole thing and not trust your interviewer.
  Anyways, I can say with confidence that one goal is to make sure you have no bugs. The right idea is important but you
  should also have good manual testing skills.
  Along this line of thinking I think it's better to do a couple medium leetcode problems rather than a lot, and the couple
  medium problems you do, you should thoroughly do them. Come up with example inputs and test them manually, and make sure
  there are no bugs. I think it's good to do some problems like this, especially in the days leading up to interviews,
  in order to get in the habit of manually debugging your code and thinking through different edge cases and inputs. Implementing
  a lot of medium level problems is not important when you get to the point where you understand how to do most medium level problems. 
  It is more effective to just do a small amount with good form, and then solve Medium or Hard problems conceptually without implementing.
  At least hopefully you get my gist, that it's good to practice some Medium problems with good form. That's all Facebook and
  several other companies really ask anyways is just Medium, but they want to see very good form.

How to prepare for system design:
* System design is actually pretty easy to prep for, even though people often make it sound challenging to prepare for.
  System Design Interview by Alex Yu and Web Scalability for Startup Engineers are the two books I'd recommend for beginners.
  After those books, Designing-data Intensive Applications (DDIA) and Designing Microservices are great. DDIA also has a good audiobook version on Audible.
  The new version of the Grokking the System Design course is pretty good too, although I think a lot of their 
  "How would you design X?" questions have worse answers than the answer for that question in System Design Interview. 
  System Design Interview is well-researched on what real-world systems look like and cites references. You can download
  books at gen.lib.rus.ec [System Design Primer](https://github.com/donnemartin/system-design-primer) is another resource
  although I would recommend the other resources before it, and it contains a lot of overlapping info with the other resources.
* I suggest watching this video for system design to get an idea what you should know: [Prepare for Your Google Interview: Systems Design](https://youtu.be/Gg318hR5JY0)
* For system design you can also research how the real company has designed their system. Take notes when you research.
  I think it would be cool to have a group of friends who all research system designs in the real world and then present
  (informally) what they find to each other. However researching how companies are built is slower than reading the resources
  I mentioned previously, so I would do it after reading those books and Grokking.

How to find good companies and apply:
* I got a ton of interviews simply by applying on company's websites. This was also when the job market was red hot, sometime
  after the covid vaccine came out, and demand was high, so I may have just gotten lucky in timing. I also got referrals where I could and some recruiters
  (like Google, Facebook, Microsoft and Salesforce) reached out to me through LinkedIn. I found other good companies to work
  for by looking at the top-paying companies on www.levels.fyi. The tech companies in the top 100 companies list by Glassdoor
  also had some good options, although most of those I already knew about. In the end I had more companies to interview with
  than I really needed, so I didn't have to find other ways to find interviews. I ignored mostly the random recruiters on LinkedIn,
  especially when they didn't work directly for a company but worked for a recruiting agency.
* I have a good video on how to write your resume for tech that I can share with you if you message me.
* I looked up the work life balance ratings of companies on teamblind.com and the pay of companies on www.levels.fyi to
  figure out if I wanted to interview with them.
* It always helps to have multiple offers to negotiate a good deal. You can also just ask for more money and a lot of time they'll give
  you an additional 7-12% just because you asked. Always ask for more by saying "I'll accept the offer if I can get X".
  Some companies (like Google) can't budge on offers without a higher offer from another company as rationale.
