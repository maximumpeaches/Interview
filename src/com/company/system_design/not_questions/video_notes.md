# Scaling Pinterest
[Scaling Pinterest video](https://www.youtube.com/watch?v=jQNCuD_hxdQ)
Points made in the video that are relevant to system design interview:
He goes over the fundamental architecture starting [here](https://youtu.be/jQNCuD_hxdQ?t=678).
The first ten minutes of the video are not relevant for system design.
* Their overall structure is not too surprising... the flow of data is from ELB->API Gateway->Web Server (if coming from
  web browser)->API server->service discovery->send to the appropriate service. I describe each of these in detail below.
* They have another layer behind AWS elastic load balancer service (ELB). It's basically their API Gateway, he refers to
  it as "Routing and Filtering" service.
* They put all their images on S3 and the front it with a CDN.
* They have a web app service which then sends requests to an API service. The API service is also contacted by mobile
  devices, or whatever else besides the web.
* He suggests not using a load balancer in the middle. They use ZooKeeper for service discovery instead. He says the
  intermediate load balancers are just a huge hassle and nightmare.
* Their MySQL database is hidden behind a service. The purpose of the service is just to handle MySQL.
  They used to let different services access the MySQL database, and then would run into issues where one service would
  read from one shard and write to another. By having one service that interfaces with the MySQL database, other services
  can't make mistakes, and they have to go through the team of MySQL experts to access it.
* Their data pipeline is centered around Kafka. After Kafka they store stuff in S3, and then from there put everything
  into S3 so it's permanent, and then send it to Redshift or wherever.
* Redis is a key-value store which you can persist, and comes with data structures like sets and sorted sets. A problem
  with redis, though, is that everything has to store in RAM.
* Redis allows you either not persist data, like memcache, or store data permanently, like MySQL, and has snapshot mode
  where it persists data every once in a while. They use snapshot to store their equivalent of the user's "news feed" so
  because it can be restored from disk if it needs to be, but it saves a lot of resources to only store every once in a
  while using snapshot (which I found an interesting use case for this).
* MySQL is slower sometimes because under the hood it's basically a tree structure. HBase has an append to the end O(1)
  append which has been really helpful for them.
* You get a lot of subtle bugs when you have read copies of databases. They happen when you put new data in, clear the cache,
  and someone gets old data before the new data is replicated to the read slaves.
* He suggests adding MySQL sharding earlier. It's hard to migrate to shards because you're doing everything while you have
  a live site. As soon as you add the first read slave, he suggests thinking about sharding, because there is already a
  time bomb ticking where you'll *need* sharding.


Points made in the video that are interesting but not necessarily relevant to system design:
* Advantage of using microservices (or medium-services) is faster deployment.
* Suggests using language which your devs are fastest with. If they know ruby, use that. If they know python, use that.
  He does like python. They are now running into some issues, but it has served them well. And they're using Java or Go
  now for computationally intense services where python would be too slow.
* He suggests adopting mature technologies, like MySQL, have good documentation online so you can find solutions to 
  your issues. Plus you can hire people who know how to use it. They also have the bugs worked out. They adopted this
  new technology, membase, but hated it because there weren't good debugging tools and little online documentation b/c
  it was so immature.
* He suggested logging all your data so that if your database is corrupted somehow you can recover the last day or two
  of data from there.
