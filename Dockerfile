#依赖的镜像
FROM daocloud.io/node:0.10-onbuild
#执行mkdir helloDocker创建一个helloDocker文件夹
RUN mkdir helloDocker
#将app.js添加到helloDocker文件夹中
ADD app.js  helloDocker
#容器运行时启动的命令，下面命令等价于 CMD node /helloDocker/app.js
CMD ["node","/helloDocker/app.js"]