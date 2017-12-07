#依赖的镜像
FROM daocloud.io/node:0.10-onbuild

WORKDIR /app

ADD . /app

CMD ["node","app.js"]