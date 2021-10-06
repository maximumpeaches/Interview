Below is text from Designing Data Intensive Applications about Twitter,
Two of Twitter’s main operations are:

Post tweet
A user can publish a new message to their followers (4.6k requests/sec on average, over 12k requests/sec at peak).

Home timeline
A user can view tweets posted by the people they follow (300k requests/sec).

Simply handling 12,000 writes per second (the peak rate for posting tweets) would be fairly easy. However, Twitter’s
scaling challenge is not primarily due to tweet volume, but due to fan-outii—each user follows many people, and each user
is followed by many people. There are broadly two ways of implementing these two operations:

Option 1) Posting a tweet simply inserts the new tweet into a global collection of tweets. When a user requests their
home timeline, look up all the people they follow, find all the tweets for each of those users, and merge them (sorted by time).
In a relational database like in Figure 1-2, you could write a query such as:

SELECT tweets.*, users.* FROM tweets
JOIN users   ON tweets.sender_id    = users.id
JOIN follows ON follows.followee_id = users.id
WHERE follows.follower_id = current_user

Option 2) Maintain a cache for each user’s home timeline—like a mailbox of tweets for each recipient user.
When a user posts a tweet, look up all the people who follow that user, and insert the new tweet into each of their home
timeline caches. The request to read the home timeline is then cheap, because its result has been computed ahead of time.

The first version of Twitter used approach 1, but the systems struggled to keep up with the load of home timeline
queries, so the company switched to approach 2. This works better because the average rate of published tweets is
almost two orders of magnitude lower than the rate of home timeline reads, and so in this case it’s preferable to
do more work at write time and less at read time.
However, the downside of approach 2 is that posting a tweet now requires a lot of extra work. On average, a tweet
is delivered to about 75 followers, so 4.6k tweets per second become 345k writes per second to the home timeline caches.
But this average hides the fact that the number of followers per user varies wildly, and some users have over 30 million followers. This means that a single tweet may result in over 30 million writes to home timelines! Doing this in a timely manner—Twitter tries to deliver tweets to followers within five seconds—is a significant challenge.
In the example of Twitter, the distribution of followers per user (maybe weighted by how often those users tweet)
is a key load parameter for discussing scalability, since it determines the fan-out load. Your application may have
very different characteristics, but you can apply similar principles to reasoning about its load.

The final twist of the Twitter anecdote: now that approach 2 is robustly implemented, Twitter is moving to a hybrid of
both approaches. Most users’ tweets continue to be fanned out to home timelines at the time when they are posted, but
a small number of users with a very large number of followers (i.e., celebrities) are excepted from this fan-out.
Tweets from any celebrities that a user may follow are fetched separately and merged with that user’s home timeline
when it is read, like in approach 1. This hybrid approach is able to deliver consistently good performance. We will
revisit this example in Chapter 12 after we have covered some more technical ground.”