# builder image
FROM node:18.14.2 AS builder

WORKDIR /app
# RUN export NODE_OPTIONS="--max-old-space-size=30720"
COPY package*.json /app/
RUN npm install -g npm
# RUN npm i webpack@4.42.0 --force
RUN npm cache clear --force
RUN npm install --force
COPY ./ /app/
RUN npm cache clear --force
RUN npm run build

# Main Image 
FROM nginx:latest
                                                                                                  
ENV USERNAME = api-connect
ENV PASSWORD = fQx35X5FZUJ7bYSjPTDjn9Zj

RUN echo $USERNAME
RUN echo $PASSWORD

#Adding document root and nginx file
COPY --from=builder /app/build/ /usr/share/nginx/html/build
COPY --from=builder /app/nginx.conf /etc/nginx/conf.d/default.conf

# ADD ./app/build /usr/share/nginx/html/build
# COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
