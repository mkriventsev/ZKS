# zks__hw02


To setup project clone this repo:

```git clone```

```cd zks__hw02/```

Run composer with todomvc on board 

```docker-compose up -d```



Then ToDoMVC app will be available by adress

```localhost:21095```
 
Next, install npm:

```npm install```

Now you make a cup of coffee, it will take couple of minutes

After completed installing all packages you may run cypress in 2 modes:
 
```./node_modules/.bin/cypress run``` - via CLI

```./node_modules/.bin/cypress open``` - GUI will
 
 In case of any troubles at BEFORE ALL step at first test, try to remove all screenshots inside the **cypress/integration/\_\_image_snapshots\_\_** folder
_______________
Screenshots are in following folders:

- **cypress/integration/\__image_snapshots\__**
- **cypress/screenshots**

Video is here:
**cypress/videos/**


To stop server

```docker-compose down```
