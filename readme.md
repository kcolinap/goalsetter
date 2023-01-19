# Goalsetter exercise

Ejercicio tecnico para entrevista empresa GoalSetter. El proyecto utiliza selenium, TestNG, RestAssured, Appium, entre otras dependencias.

### Requisitos:
java 8 o superior, maven, git

### Descargar el proyecto:
```sh
$ git clone https://github.com/kcolinap/goalsetter.git
```

### Tests:
Se utilizo bdd para la creacion de los escenarios de prueba. Los features file se encuentran en
```sh
.../src/test/java/resources/features
```

### Ejecución:
Ubicarse en el directorio del proyecto y ejecutar el siguiente comando. Se debe tener instalado maven:
```sh
$ mvn clean test
```
#### Nota: Se debe tener instalado el servidor de appium y ejecutandose. Tambien, de momento, solo puede ser seteado el platformVersion y el deviceName.
#### La idea es hacer esto mediante adb. Setear el archivo apk en la ruta: src/main/resources/apk. Esta ruta ya esta establecida en el property.


# Respuestas a las preguntas teoricas:

### 1. How do you identify the test cases which are suitable for automation?: 
#### Generally, I usually saw the needed to automate test scenarios that are been executed very frequently, and that consume a lot of time when are executed manually. For example, in the regressions.

### 2. Can you achieve 100% automation?
#### It is very challenging to achieve the 100% of tests coverage using automation. I would say it is not posible.

### 3. What are the different types of automation tools that you are aware of?
#### Web Automation: Selenium webdriver, katalon and a little cypress. Backend: Karate framework, restassured, postman. Mobile automation: Appium, katalon.

### 4. Any kind of tests which you think should not be automated?
#### Exploratory testing must be done manually, test scenarios that are so dependent to third party components or data dependent. Tests tha involves GUI and features that have so many changes.

### 5. Given that there is an automation framework already in place, what are the steps you would take to automate a login?
#### At backend sight, you must to be care of the endpoint. Set in the payload the credentials an validate, once yo make the request, the api is responding as expected. Checking to token.
#### On frontend context, you should map the page or screen into a class using the page object model. Once you get all the elements, create some methods to interactive with the elements. Then, set the corresponding credentials in order to execute the scenario and validate the successfully login.