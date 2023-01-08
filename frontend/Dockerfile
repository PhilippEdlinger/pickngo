FROM node:lts-alpine
RUN mkdir /frontend
WORKDIR /frontend
COPY . .
RUN npm install
RUN npm run build
EXPOSE 4200
CMD ["npm", "start", "--", "--host", "0.0.0.0"]