# My Dealer Statistics Project

### Description of the project:
The goal of the project is to give an independent rating to traders of in-game items (CS: GO, Fifa, Dota, Team Fortress, etc.). The rating is based on reviews that are offered by everyone, while reviews are thoroughly checked by trusted persons.

### Usage scenarios:
A trader goes to the site, fills out a questionnaire to create his own page on the site. After approving account by email trader can create Game objects with items he wants to trade. Trader can also leave comments to other traders. An Anonymous comes to the site, finds the trader's page, leaves a comment.
An Administrator goes to the site, finds new reviews or Game Objects and approvs or declines them.

## REST Endpoints

### Activation
Account activation : 
> GET http://localhost:8080/activate/{email}/{code}

Sending an email to a user to recover a password
> GET http://localhost:8080/auth/forgot_password/{email}

Checking the activation code for correctness and setting a new password
> POST http://localhost:8080/auth/reset

### Rating
Rating of Game Object
> GET http://localhost:8080/rating/object/{id}

### Game
Show game list
> GET http://localhost:8080/games

Add new game
> POST http://localhost:8080/games

Update the game
> PUT http://localhost:8080/games/{id}

### Game Object
Show all approved Game Objects
> GET http://localhost:8080/object

Show all Game Objects for admin
> GET http://localhost:8080/object/admin/object

Add new Game Object
> POST http://localhost:8080/object

Delete Game Object
> DELETE http://localhost:8080/object/{id}

Update Game Object
> PUT http://localhost:8080/object/{id}

List of Game Objects of an authorized user
> GET http://localhost:8080/my

Approve Game Object
> PUT http://localhost:8080/object/approve/{id}

### Comment
Show all aproved comments for Game Object's id
> GET http://localhost:8080/users/{id}/comments

Show all comments for Game Object's id (for admins)
> GET http://localhost:8080/admin/users/{id}/comments

Show comment
> GET http://localhost:8080/users/comments/{id}

Add new comment for Game Object
> POST http://localhost:8080/articles/{id}/comments

Delete comment
> DELETE http://localhost:8080/comments/{id}

Update comment
> PUT http://localhost:8080/articles/{id}/comments

Approve comment
> PUT http://localhost:8080/comment/approve/{id}
