# What to do when there is a cache miss because a value is created that wasn't there before?
There can be a "thundering herd" when a cache miss occurs, where all cache servers hit the backend at the same time. 
[This article](https://instagram-engineering.com/thundering-herds-promises-82191c8af57d) goes into it. One solution
is to send *one* request, and let all the servers wait for that one request to the backend to return. They use JavaScript
promises to implement this.