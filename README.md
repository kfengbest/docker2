# docker2

git clone https://github.com/kfengbest/docker2.git

cd docker2

docker build -t nodejs-docker .

docker run -p 3000:3000 nodejs-docker

chrome:  http://xxxx:3000

Run jenkins with docker:
docker build -t kfengbest/jenkins:v1
docker run -p 8080:8080 kfengbest/jenkins:v1

Jenkins jobs mapping with branch:
dev -> /master
stg -> /staging
prd -> /production

