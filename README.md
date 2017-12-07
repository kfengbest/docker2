# docker2

git clone https://github.com/kfengbest/docker2.git

cd docker2

docker build -t nodejs-docker .

docker run -p 3000:3000 nodejs-docker

chrome:  http://xxxx:3000
