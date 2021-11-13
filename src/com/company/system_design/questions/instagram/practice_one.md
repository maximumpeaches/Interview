This file is just me practicing.
What features to implement? User can upload an image. All users can friend each other and see each other's posts.
Each user has a home screen. No messaging. Each user can also see their own home screen.
Also users can comment on photos.
Read to write ratio? 1:100 on average up to 1:1,000,000 for more popular users.
Let's say we have 500,000 new posts per day.
Each image is (this is just a guess) 300KB on average.
We're gonna have a write image API that looks something like this:
POST /api/v1/data/image
and accepts the image
The read API for a user's news feed could look like
GET /api/v1/newsFeed
and it accepts something like {userId:maximumpeaches} as a query parameter.
We can also think of keeping a WebSocket or SSE (or that low battery one that FB uses) connection open with the device.

Ok so I'm going to struggle with the database choice. I know we can use object storage for the images, and store
the location of the image in some other database. I could propose using a relational database for all this b/c
I don't know any better.
So let's say we need to store the userId, the locations of the user's images, and the user's friends.
UserId let's say is 50 bytes. Each user image location is another 50 bytes.
So we have 50*500,000 bytes per day, which is 25,000,000 bytes per day, or 25 MBs per day only in the database.
This is like 100 MBs per year, so we can store all this in memory if we want for like 100 years.

For the database we can have something like this:
table users:
int userId
int friendId
and also store the reverse
int friendId
int userId
for each pair of users.

We could also have a table with each image location like this:
varchar image_location
int userId
long timestamp (time it's saved)

Let's discuss the news feed API now.
Broadly there are two ways we can create the news feed API. One is we cache the news feed and then whenever there is a
post from a friend we update the news feed. The alternative is we generate the news feed on the fly when the user requests
it. Each puts a different kind of load on the system. A middle ground I'd suggest is to cache the news feed for users
that have logged in sorta recently, but delete it if they haven't logged in in like a year or more. But if we cache the
news feeds for most users then this means they can read their news feed very quickly, which is important, and we don't
have a huge load on the databases all at once when users start logging in. However this creates a new problem where
a very popular user may post to millions of people. In that case we want to delay loading those posts until the user
actually requests their news feed.

I'm thinking this problem lends itself towards a queue. When there is a new post, we want to immediately write the post
to the user's home page, and then add it to a queue. When it's in the queue, it'll be pulled off at some point and put into
the user's individual news feeds. The user's news feeds can be stored as a list. We can store the top X items in the news
feed in memory somewhere. 

So there are some interesting other things about this problem. Grokking suggests having a table with the photo ID as
the key, and the photo creation time, photo location etc as sorta the value. They suggest having this as a relational database
and then having an index on (PhotoID, CreationTime) since we often need to get photos by time they were created.

They also suggest using a wide column storage for UserId which contains all the PhotoIDs that correspond to that user.
Do they suggest wide column storage b/c it will not contain