FROM node:lts-alpine
ENV BASE_URL="/"
RUN mkdir /frontend
WORKDIR /frontend
COPY . .
RUN npm install
EXPOSE 4200
CMD ["npm", "run", "build", "--base-href=$BASE_URL"]
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--disable-host-check"]