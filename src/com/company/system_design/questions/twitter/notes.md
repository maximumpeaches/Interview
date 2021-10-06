# Designing Data Intensive Applications
As an example, DDIA discusses Twitter's fan out problem. I copied the full text to ddia.md in this folder. Basically 
they describe how Twitter can either post new posts to follows after they're made, on write, or they can wait until 
followers look up their home view and load them then. Nowadays Twitter does a hybrid approach where they push posts on 
write to a pre computed home view except for celebreties who have a large number of followers and would overwhelm the 
system if they did so, whose posts they populate on read time. This hybird approach is also suggested by SDI, 2e book

One important thing to note is that the reason it makes sense for Twitter to push on write is that there are an order
of 2 magnitude more reads than writes. Which makes sense... I log into Facebook more often than I post something on there.