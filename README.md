# congenial-dollop
Spring Boot Web App test

### Tag image:
```
docker tag dollop-server:latest dollop-server:x.x.x
```

### Transfer image to server:

```
docker save dollop-server:x.x.x | bzip2 | ssh <server> docker load
```
