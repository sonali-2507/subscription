# Getting Started

### Cricbuzz subscription
For further reference, please consider the following sections:
Software required:
* Java 17 or higher
* Maven 3.6.3 or higher
* MySQL 8.0.26 or higher
* Postman

### Added dependencies
* Spring Boot DevTools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Spring boot starter test
* Lombok
* Spring configuration processor

### Guides
The following guides illustrate how to use some features concretely:

* [GitHub repository link](https://github.com/sonali-2507/subscription.git)
* Set up the database in application.properties file


    ### End points
1. GET localhost:8080/plans/1
* We can put any plan id in place of 1 to get the details of that plan.
* for 1 will get below response
  response body:
```json
{
  "id": 1,
  "name": "Cricbuzz Plus",
  "description": "Annual Plan",
  "price": 399.0,
  "validityInMonths": 12,
  "features": [
    {
      "id": 1,
      "name": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide",
      "description": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide"
    },
    {
      "id": 3,
      "name": "Enjoy an ad-free experience on the platform",
      "description": "Enjoy an ad-free experience on the platform"
    },
    {
      "id": 2,
      "name": "Exclusive access to premium editorial content and Cricbuzz Originals",
      "description": "Exclusive access to premium editorial content and Cricbuzz Originals"
    }
  ]
}
```
2. GET localhost:8080/plans
* This will give the list of all the plans available.
 
```json
[
  {
    "id": 1,
    "name": "Cricbuzz Plus",
    "description": "Annual Plan",
    "price": 399.0,
    "validityInMonths": 12,
    "features": [
      {
        "id": 1,
        "name": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide",
        "description": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide"
      },
      {
        "id": 2,
        "name": "Exclusive access to premium editorial content and Cricbuzz Originals",
        "description": "Exclusive access to premium editorial content and Cricbuzz Originals"
      },
      {
        "id": 3,
        "name": "Enjoy an ad-free experience on the platform",
        "description": "Enjoy an ad-free experience on the platform"
      }
    ]
  },
  {
    "id": 2,
    "name": "Cricbuzz Plus Times Prime",
    "description": "Annual Combo Plan",
    "price": 999.0,
    "validityInMonths": 12,
    "features": [
      {
        "id": 1,
        "name": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide",
        "description": "Avail Fantasy Handbook : Comprehensive Fantasy Cricket Guide"
      },
      {
        "id": 4,
        "name": "Access to 23 premium subscriptions, spanning popular platforms like YouTube, Hotstar, Sony Liv, Lenskart, Gaana, and more",
        "description": "Access to 23 premium subscriptions, spanning popular platforms like YouTube, Hotstar, Sony Liv, Lenskart, Gaana, and more"
      },
      {
        "id": 5,
        "name": "Enjoy an ad-free experience on Cricbuzz",
        "description": "Enjoy an ad-free experience on Cricbuzz"
      }
    ]
  },
  {
    "id": 3,
    "name": "Demo plan 3",
    "description": "Demo plan",
    "price": 499.0,
    "validityInMonths": 6,
    "features": [
      {
        "id": 9,
        "name": "demo feature",
        "description": "demo feature"
      }
    ]
  }
]
```
3. GET localhost:8080/features/8
* We can put any feature id in place of 8 to get the details of that feature.

```json
{
  "id": 8,
  "name": "feature 6",
  "description": "feature 6"
}
```
4. POST localhost:8080/plans
* This will create plan
* request body:
```json
{
  "name": "Cricbuzz Plus",
  "description": "Annual Plan",
  "price": 399.0,
  "validityInMonths": 12
  
}
```
5. PUT localhost:8080/plans/3/features
* This will add feature to the plan
* request body:
```json
{
  "name":"demo test feature",
  "description":"demo test feature"
}
```
6. DELETE localhost:8080/plans/3/features/11
* This will delete the feature from the plan 3(u can put any plan id), in place of 11 can put any feature is, n this case 11 is the feature id.
* request body:

7. DELETE localhost:8080/plans/4
* This will delete the plan 4(u can put any plan id), in this case 4 is the plan id.

8. POST localhost:8080/features
* This will create feature
* request body:
```json
{
  "name":"demo test feature",
  "description":"demo test feature"
}
```
9. PUT localhost:8080/features/3
* This will update the feature 3(u can put any feature id), in this case 3 is the feature id.
* request body:
```json
{
  "name":"demo test feature",
  "description":"demo test feature"
}
```



### Challenge faced
* I have faced challenge in writing query based on date interval bcause of conflict between java date library and sql date library.
* I have faced challenge in mapping the fetch data from weather & distance API to java object.
* I have faced challenge to map the page fetch from database to the response object page.
* Also reduced response time by using pagination and sorting and also by using indexing on database.

### Achievements
* Reduced response time from 19s to 5s by following approaches.
* Created index on date column of table location_info
* Applied pagination and sorting.

### Note
I Used Java, Spring Boot, Hibernate and MYSQL as I am more efficient with these technologies.


