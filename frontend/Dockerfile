FROM node:lts-alpine
RUN mkdir /frontend
WORKDIR /frontend
COPY . .
RUN npm install
EXPOSE 4200
CMD ["npm", "run", "build", "--", "--deploy-url=/d.altenhofer/"]
CMD ["npx", "serve", "./dist/pickngo-angular", "-p", "4200"]