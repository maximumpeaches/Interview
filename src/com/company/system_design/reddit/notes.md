# The real Reddit
1. [The Evolution of Reddit.com's Architecture](https://www.youtube.com/watch?v=nUcO7n4hek4&t=1334s)

I'm going to take some notes on #1, mostly from the perspective of trying to learn to answer the question, 
"How would you build reddit?" but also just general notes. Also see summary.md.

In the beginning of #1 he goes over the current architecture. A lot of it is not ideally designed.. it started as a 
monolith. What you might want to copy though is...
they have a frontend service which talks to the API gateway just like it's any other sort of client. The frontend 
service runs node and provides the webpage and stuff.
They have an API Gateway.
They have a CDN which he also really likes because it can    route to different stacks that make up Reddit. Like it can
route if the user is in some experiment bucket, or based on the domain, or a user's cookies even.


Stuff not relevant to answer "How to design reddit?" but still interesting:
* I found it interesting they run the same code on each server for their main monolith r2 but a different part of the 
  code works on each server. So all servers have a job queue on them, but only some of them actually use that code, so it
  remains a monolith but can play different roles.
* The load balancer will send different jobs to different app servers. Like one app server will have comments on it, and
  then another app server will run the front page, and so if there's something going on on the comments page then it won't
  impact people seeing the front page. So overall just splitting things up so they don't impact each other is a good approach.
  This is sort of relevant to question, too. 
* He goes over Thing DB [starting here](https://youtu.be/nUcO7n4hek4?t=862). Thing DB is cool because you can add
  attributes quickly, but it also has performance problems. He explains it really quickly with images but it's not too
  relevant to answering the question of how to design reddit.