#依赖的镜像
FROM daocloud.io/node:0.10-onbuild

WORKDIR /app

COPY package.json .

RUN npm i

COPY . .

EXPOSE 3000

CMD ["npm", "start"]