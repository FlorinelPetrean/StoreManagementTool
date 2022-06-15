This application is simply a demo for REST APIs and Spring Boot.
We have 2 classes: User and Product. Both have the basic CRUD methods. The following endpoints are accessible, each having a suggesting name:

POST: /{className}/create

PUT: /{className}/modify/{id}

DELETE: /{className}/delete

GET: /{className}/all

GET: /{className}/{id}

* className = [user, product]

Note: In order to make any request, you need to add the Authorization header to the request with your credentials as value in this format : "your_username:your_password".

Basic users can only make GET requests, while ADMIN users can make any request they want.

The /user/create and /user/login endpoints are not filtered in order for the user of this application to be able to create their user, login with their account or make requests.
