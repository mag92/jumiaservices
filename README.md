# jumiaservices

Build the docker image (multi-stage) using the Dockerfile:  
`docker build -t imagename .`  

Then, run the container:  
docker run imagename --privileged -p <externalport>:<internalport>

In my case, I used 8081:8080:

docker run imagename --privileged -p 8081:8080

# API
Navigate to `/api/customers`, `/api/customers/filter?country=Morocco"`, etc. This offers REST service that filters the customers (or display all)

# Frontend
Navigate to `/customers`  A Thymeleaf front-end that gets the data from the SQLite DB and there are hyper-links for the sorting (using a query param)

