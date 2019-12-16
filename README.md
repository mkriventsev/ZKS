# ZKS
### B(E)4M36ZKS - Zajištění kvality software / Software Quality Assurance
https://moodle.fel.cvut.cz/course/view.php?id=4363



## Homework 1: [📂/zks_hw_01](https://github.com/mkriventsev/ZKS/tree/master/zks_hw_01)
**Topic**: Selenium front-end automated testing using Screenplay pattern and Serenity BDD framework

**Task:**
On the eshop engine demo available on <https://demo.arastta.org> create automated tests using Screenplay (Serenity BDD framework):

**TEST STEPS:**

1. Get empty shopping cart (Verify that the shopping cart is really empty)
2. Add 3 different types of items entered as entry parameter of the test to the cart (use search function in the eshop)
3. Verify that the content of the shopping cart matches to the previous steps

**Useful links:**

* <http://testerstories.com/2016/06/screenplay-pattern-with-java-part-1/>
* <http://testerstories.com/2016/06/screenplay-pattern-with-java-part-2/>
* <http://testerstories.com/2016/07/screenplay-pattern-with-java-part-3/>

**Notes:**
IntelliJ IDEA + Java 8. WebDrivers are in [/drivers](https://github.com/mkriventsev/ZKS/tree/master/zks_hw_01/drivers) folder, builded via Gradle
<br/><br/><br/><br/>
## Homework 2: [📂/zks_hw_02](https://github.com/mkriventsev/ZKS/tree/master/zks_hw_02)
**Topic**: Cypress front-end automated testing


**Task:**
Visual test of a [todoMVC site](http://todomvc.com/examples/react/#/) through Cypress. Introductory example of how to test the todoMVC site is in the [Lab 6: Alternative End-to-end automated testing Cypress](https://moodle.fel.cvut.cz/mod/resource/view.php?id=133730).

More information about visual testing is in the article: <https://docs.cypress.io/guides/tooling/visual-testing.html>

**HOMEWORK STEPS:**

1. Install the todoMVC locally or in Docker (for bonus points)
2. Create the “visual” test that will make a snapshot of a page with the list of todo items.
Change the design of a page (e. g. colour or font through CSS)
3. Run the visual test and make a video of it (through Cypress)
4. Upload the project to a new GitLab repository and remove (or add to .gitignore) the cypress/integration/examples directory

**Notes:**
Docker daptin/todomvc-vuejs image runs on port 21095 -> npm install -> `./node_modules/.bin/cypress open` - GUI

⚠️GUI version doesn't create video 🤔, so for it just use CLI version  - `./node_modules/.bin/cypress run`

<br/><br/><br/><br/>
## Homework 3: [📂/zks_hw_03](https://github.com/mkriventsev/ZKS/tree/master/zks_hw_03)
**Topic**: JUnit (advanced features)


**Task:**
Create parameterized tests of an E-shop backend (SUT) using JUnit 5 and data combinations generated using the ACTS tool.

E-shop sources: https://gitlab.fel.cvut.cz/rechtva1/sqa_parametrized_tests
ACTS tool: https://drive.google.com/file/d/1I9w4NhGI3HaMtncMZadYdDsaKAYAdKAt/view

**HOMEWORK STEPS:**
1. Find the equivalence classes for variables in the SUT
2. Model the SUT using the ACTS application
3. Generate the 2-way test combinations
4. Use generated combinations to create the parameterized tests
5. Generate the surefire reports

**Notes:**
**(!)NOTE Downloading the https://gitlab.fel.cvut.cz/rechtva1/sqa_parametrized_tests you will get the problem with running all tests and generating report using Ьaven.**
When you try to run your test from your favourite IDE, your tests will be executed normally.
You need to do couple more things to make it run from commandline.

Maven Surefire and Maven Failsafe provide native support for executing tests on the JUnit Platform.
junit-jupiter-engine dependency required for maven surefire to run any tests

```<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>${junit.jupiter.version}</version>
    <scope>test</scope>
</dependency>

<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.0</version>
        </plugin>
        <plugin>
            <artifactId>maven-failsafe-plugin</artifactId>
            <version>2.22.0</version>
        </plugin>
    </plugins>
</build>
```
To deal with it just follow it: https://java-focus.com/parameterizedtest-junit-5/
