# congenial-dollop
Spring Boot Web App test

### Tag image:
```
docker tag dollop-server:latest dollop-server:x.x.x
```

### Transfer image to server:

```
docker save dollop-server:0.0.1 | bzip2 | ssh debian@135.125.206.251 -p 9260 docker load
```