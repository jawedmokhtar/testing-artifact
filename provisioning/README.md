# Docker usages

build the docker image

```
docker build .
```

run the docker image

```
docker run -it -v /Users/jawedmokhtar/maven/testingArtifact:/testingArtifact --rm XXXXX
```


List all the previouly running Containers
```aidl
docker ps -a
```

remove the a container
 ```aidl
docker rm {CONTAINER_ID}
```

List all the build images

```aidl
docker images
```

remove an Image

```aidl
docker rmi {IMAGE_ID}
```