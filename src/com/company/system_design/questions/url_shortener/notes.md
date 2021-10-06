# System Design Primer
[Design Pastebin.com (or Bit.ly)](https://github.com/donnemartin/system-design-primer/blob/master/solutions/system_design/pastebin/README.md)
I think the idea of generating the new URL using the MD5 algorithm is fine, but they don't mention you also need
to check for hash collisions, which is very important in practice.

# Manhattan at Twitter
From [this article](https://blog.twitter.com/engineering/en_us/a/2016/strong-consistency-in-manhattan),
"We considered two options for the scope of our strong consistency support. We could have done either full distributed 
transactions (where operations can span any number of keys in our system) or addressed a simpler scenario (where strong 
consistency applies per key). After talking to our internal customers and reviewing the use cases, we decided that 
starting with the latter model satisfied a majority of use cases. Because each key belongs to a single shard, we don’t 
have to pay a performance penalty of coordinating a multi-key distributed transaction.

In our design, to provide strong order of updates for each key, all strongly consistent operations go through a 
per-shard log. A typical system has tens of thousands of shards and a large number of logs (we support multiplexing 
multiple shards on the same log). Each shard is independent from others, so when Twitter engineers design their 
applications, they must choose their keys in a way that strongly consistent operations are confined to individual 
partitioning keys and don’t span multiple keys."

I think this applies to checking if the generated URL exists, before creating a new one. You can shard to improve
performance, so you don't have to lock on the whole thing. Reddit did something similar when they shard the updates
to votes, as described in notes.md in the reddit package.