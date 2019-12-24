rm project/build.properties
docker build -t dadbasic .
mkdir tmp
rm tmp/*
docker run --rm -v $(pwd)/tmp:/tmp dadbasic sh -c "cp /root/target/scala-2.11/* /tmp"
