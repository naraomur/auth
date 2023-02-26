# Auth App
Authorization with Spring Security
- Role based access control (RBAC) applied to this API as it is used for any service especially admin web service.
- Object relation mapping (ORM) based on ManyToMany relationship between User and Role entities (Hibernate's trick to build tables in database)
- Token validation via the Web Security Configuration

### Implementation
 - By using the Git Bash clone the project
 - You will need: JDK 11 or later, Postman(or just any regular Browser), PGAdmin(For PostgreSql)
 
 - Address for sign-up and sign-in and sign-up:
   http://localhost:8080/api/auth/signin
   http://localhost:8080/api/auth/signup
 - Request Body for signup:
   ```
   { 
    "username": "user",
    "email": "user@gmail.com",
    "password": "12345678",   
    "roles": ["user"]
   }
   ```
 - Request Body for sign-in:
   ```
   {
   "username": "user",
   "password": "12345678"
   } 
   ```
 - Address for test role access:
   localhost: GET http://localhost:8080/api/test/
   
   - The logic of the test is to check if the role-based access works with tokens.

   1. After you've signed up several users with different roles, sign in using the body request for sign-in
   2. Then, you'll see the token code in the response to the sign-in request as below
      ```
       {
         "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjc3Mzk4MjA2LCJleHAiOjE2Nzc0ODQ2MDZ9.Xx_-ZbkQIDuVn8h9mgvpRndCIF2C8NsxQgLH05iYUFzM5gM9QJSfawpVsQiNGWC78sE_CwlUpFnzSeEYQVXxGQ",
         "type": "Bearer",
         "id": 3,
         "username": "user",
         "email": "user@gmail.com",
         "roles": ["ROLE_USER"]
       }
      ```
   3. Copy that token code and go to the test sign-in request and choose the Authorization tab in your Postman
   4. Then choose the Type of authorization as Bearer Token after which on the right side will appear Token bar
   5. Paste your copied token code into that bar. 
   6. Should get the response as in the below picture after all above steps
   
   ![img_1.png](img_1.png)
  - if you will change the address from user to admin in the test api with the same token and credentials of user 
    you will get 403 Forbidden response as user has no access to the admin address 
       
### Cautions
 - Important to use in JSON requests the same field names as in model User. Otherwise, you will get "Bad request" or "Bad credentials" response

:globe_with_meridians: Used tutorials
- [Why JWT is not safe to use and why](https://betterprogramming.pub/stop-using-json-web-tokens-for-authentication-use-stateful-sessions-instead-c0a803931a5d)
- [Whole project credit on this YouTube tutorial](https://www.youtube.com/watch?v=m5FAo5Oa6ag)
- [Test-based development](https://medium.com/@kumarprabhashanand/tdd-simple-rest-api-with-test-driven-development-using-java-spring-boot-and-junit-40a34dec1999)