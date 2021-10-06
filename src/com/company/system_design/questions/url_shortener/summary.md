# How to select a URL
One key point in answering this problem is, how do you create a new URL?
We could take a MD5 hash of the provided URL, write it in hexadecimal, chop off part of it, and then use the rest as a new URL.
You can see some examples of MD5 written in hexadecimal [here](https://en.wikipedia.org/wiki/MD5#MD5_hashes).
You also have to deal with hash collisions. 
Adding the hash to the database is tricky because you have to check if a hash already exists then if not add it before 
another server checks if it exists, too. You [can do this in SQL](https://stackoverflow.com/a/20971775/4630491) but
it requires locking, which could cause a bottleneck in the system. One improvement for this is you shard the database
based on the hash, so that there is less to lock onto. See notes.md for how Twitter does this sharding based on partitioning
key in Manhattan.


