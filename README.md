# jumiaservices

Build the docker image (multi-stage) using the Dockerfile:  
`docker build -t imagename .`  

Then, run the container:  
`docker run imagename --privileged -p <externalport>:<internalport>`

In my case, I used 8081:8080:

`docker run imagename --privileged -p 8081:8080`

## Backend
- Repository: Data access layer
- Service: No need to include an interface, as it's just one implementation, business logic processing on data
- Controllers:
  - API/REST controller
  - Front-end controller, that renders the templates using Thymeleaf
- SQLite dialect helper: To make Spring-Boot and Hibernate understand SQLite
- Small helper class to create a Regex pattern matcher
## API
Navigate to `/api/customers`, `/api/customers/filter?country=Morocco"`, etc. This offers REST service that filters the customers (or display all)

## Frontend
Navigate to `/customers`  A Thymeleaf front-end that gets the data from the SQLite DB and there are hyper-links for the sorting (using a query param)

