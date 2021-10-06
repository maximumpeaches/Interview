# Exponent
[Design Facebook Messenger](https://www.tryexponent.com/courses/system-design-interview/system-design/facebook-messenger-whatsapp)
Mentions that there's about 65k TCP connections per server (and websockets is based on TCP), so we will have a limit 
on how many connections we can keep per server.
Discusses WebSockets / long polling similar to Grokking and SDI2e.
Has idea for a queue to handle incoming messages, similar to SDE2e.
He drew all the tables for the database.

# Algoexpert
[Design Slack](https://www.algoexpert.io/systems/workspace/Design%20Slack)
My notes here are based on reading the solution because I haven't watched the video (yet).
I wasn't super impressed with this solution.
Mentioned sharding database by org, then topic. Rationale is that the tables will grow very large, so we can reduce 
their size by sharding them (his design is to create a table with all messages, so it would grow very large).

# Grokking
[Designing Facebook Messenger](https://www.educative.io/courses/grokking-the-system-design-interview/B8R22v0wqJo)
Mentions WebSockets vs Long Polling as well.
Suggests chat server keep a mapping from userId to open connection (which yeah that's kind of obvious, but true).
Suggests "sticky servers" mapping each user to a specific chat server. This is different from Exponent's solution of 
having the server subscribe to a messaging queue for updates.
Suggests using HBase instead of SQL or MongoDB. The rationale for not using SQL is we can't read and write to a row 
each time a user sends or receives a message. The rationale for using HBase is that it can write lots of small data 
quickly because it groups data together with a key before dumping it to disk. I did not fully understand the 
rationale, but according to SDI2e, Facebook does use HBase for storing messages (Discord uses Cassandra btw).

# System Design Interview 2e
One thing the book does a good job of is going over pros and cons of polling vs long polling vs websockets. What can 
you think of? If you don't remember, you can reference the book.
Good answer overall.
I didn't fully understand the decision to use a Key-Value store for messages. Here are the reasons,
"• Key-value stores allow easy horizontal scaling.
• Key-value stores provide very low latency to access data.
• Relational databases do not handle long tail [3] of data well. When the indexes grow large, random access is expensive."
I also don't understand how it intends to store the data inside the database. Like what format will it have?

# Real products
## The real Facebook Messenger
1) [Migrating Messenger storage to optimize performance](https://engineering.fb.com/2018/06/26/core-data/migrating-messenger-storage-to-optimize-performance/)
2) [Building Mobile-First Infrastructure for Messenger](https://engineering.fb.com/2014/10/09/production-engineering/building-mobile-first-infrastructure-for-messenger/)
3) [The Underlying Technology of Messages](https://engineering.fb.com/2010/11/15/core-data/the-underlying-technology-of-messages/)

From #1, "The original monolithic service was separated into a read-through caching service for queries; Iris to queue 
writes to subscribers (such as the storage service and devices); and a storage service to retain message history."

In #2 they say they actually use an initial HTTPS request to get the full message history, then after that they use 
MQTT to listen for updates (not WebSockets). I think the rationale is that MQTT is low bandwidth and low power 
compared to WebSockets.

In #2 they describe Iris, which is a queue that can have multiple subscribers. Subscribers are both user devices and
the long term message storage service. Look at iris_demonstration.png in this folder to see an example of how it works.
The cool thing about Iris is it can have multiple pointers, so the storage service can be full caught up on incoming
messages, while if the user's device is offline, the pointer for it will remain behind, so that when the device comes
back online it will get everything it has missed since then.

For the storage service, Facebook writes in #3 that they tested MySQL, Cassandra and HBase. They found, 
"MySQL proved to not handle the long tail of data well; as indexes and data sets grew 
large, performance suffered. We found Cassandra’s eventual consistency model to be a difficult pattern to reconcile for 
our new Messages infrastructure. HBase comes with very good scalability and performance for this workload and a simpler 
consistency model than Cassandra." So at least one big reason is that MySQL doesn't handle big data loads like HBase
does. HBase is designed on HDFS, so it's designed to handle big data. And I think tables grow huge in MySQL, because
Messenger has so many messages to store, and that really slows down MySQL. You may find 
[this link](http://highscalability.com/blog/2010/11/16/facebooks-new-real-time-messaging-system-hbase-to-store-135.html) 
interesting, as it's about the same topic, but has some other info too.

There is also [this talk](https://www.youtube.com/watch?v=5hUmdoMOrpo) which does look informative, but I haven't gone
through it yet.

## The real WhatsApp
Not much is known about it. You can read a little [here](http://highscalability.com/blog/2014/2/26/the-whatsapp-architecture-facebook-bought-for-19-billion.html).




