## How to update the listings vote number and keep them in order by vote
Note: "listing" means the same thing as "post". I always called them "posts" but in the video and I guess internally reddit calls them "listings".
One big question to answer when designing reddit is "how do you update votes on posts, and still maintain some sort
of ordered list of posts?" Neil Williams discusses how reddit does it [starting here](https://youtu.be/nUcO7n4hek4?t=356).

Initially they would just keep the listings in a relational database table and query them, like 
SELECT * from listings ORDER BY hot(up, down). So then they started caching this list. Then they would have to invalidate
the caches a lot since the posts were voted on all the time, so they began keeping the sort info like the vote number
in the cached list as well. Then when
there is a new vote, a task will be created in a queue to update the vote number. When the worker updates the votes,
it will read the whole ordered list, update the vote in a way that makes sure the list retains the correct order, then
write back the whole list to memcache. For concurrency this requires locking, which, as you can imagine, has caused
some problems. 

They solved some of the problems related to locking by sending the task to "update vote count" to specific
workers based on which subreddit needs to be updated. They have an ID for each subreddit and then take the ID mod the
number of workers and send it to the worker it matches (he said they take the ID mod 10, but I think they just use the 
number of workers in reality and he was giving an example number of workers).

They eventually had to further partition based on domain and profile and other stuff since I guess they also keep
ordered lists for when you sort by domain? I'm not sure exactly.