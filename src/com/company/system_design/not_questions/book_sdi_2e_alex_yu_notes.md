# Chapter 1: Scale from Zero to Millions
* One way to back up databases in case of failure is promote the read slave to a new master if the master fails. If you
  do this you need data replication scripts to run. Other methods of backing up the master, like master-master or circular
  replication are also possible but may be more complicated.
* If your data is more write heavy, then a cache is less useful.
* Consider if your cache will use LRU or FIFO for cache eviction depending on your use case.
* You can use object versioning with CDNs so that when you update an object, the old version in the CDN is immediately invalidated.
* Stateless architecture means you can still have state, but it is stored in shared database, and at least the web server
  layer doesn't have state, and you don't keep track of users outside the shared database (i.e. don't use sticky sessions in the load balancer).
* If you have multiple data centers you also likely need to route traffic to the one closest to them.
* The book references [this article](https://netflixtechblog.com/active-active-for-multi-regional-resiliency-c47719f6685b)
  by Netflix on how they deploy across multiple regions. They replicate data asynchronously so it doesn't slow down user's
  requests. They have some extra DNS tools so they can use geo-DNS and everything to route traffic in the event of a region-wide
  failure. They rely on Cassandra to replicate data asynchronously. They didn't want to rely on latency-based routing, and
  generally use geo-DNS instead, because latency based routing has weird unexpected effects potentially.
* 