describe('ToDo list items', function () {
    let items = {
        ONE: 'make PAL.3',
        TWO: 'prepare PUR D2 homeword',
        THREE: 'make skype call with Anna',
        FOUR: 'prepare hw02 ZKS'
    }

    const selectors = {
        html: 'html',
        body: 'body',
        pageTitle: 'h1',
        totoapp: '.todoapp',
        newTodoField: '.new-todo',
        todoList: '.todo-list',
        todoItems: '.todo-list li',
        competeButton: '.toggle'
    }

    before(() => {
        cy.visit('/')
        cy.wait(200)
        cy.get(selectors.todoItems).should('have.length', 0)
        cy.screenshot()
    })

    beforeEach(() => {
        cy.wait(1000)
        cy.contains(selectors.pageTitle, 'todos').should('be.visible')
        cy.get('html').toMatchImageSnapshot({
            threshold: 0.05,
        })
    })

    afterEach(() =>{
        cy.screenshot()
        cy.wait(500)
    })

    it('Enter Items to ToDo list', function () {

        cy.get(selectors.newTodoField)
            .type(`${items.ONE} {enter}`)
            .type(`${items.TWO} {enter}`)
            .type(`${items.THREE} {enter}`)
            .type(`${items.FOUR} {enter}`)
    })
    it('Select 4th element as completed', function () {

        cy.contains(selectors.todoItems, items.FOUR)
            .find(selectors.competeButton).check()
        cy.contains(selectors.todoItems, items.FOUR)
            .should('have.class', 'completed')
    })

    it('change some css properties and complete 3rd item', function () {

        cy.contains(selectors.todoItems, items.THREE)
            .find(selectors.competeButton).check()

        cy.get(selectors.body)
            .invoke('css', 'background-color', 'black')
            .should('have.css', 'background-color', 'rgb(0, 0, 0)')

        cy.get(selectors.pageTitle)
            .invoke('css', 'color', 'rgb(0, 241, 63)')
            .should('have.css', 'color', 'rgb(0, 241, 63)')

        cy.get(selectors.totoapp)
            .invoke('css', 'background-color', 'rgb(247, 240, 11)')
            .should('have.css', 'background-color', 'rgb(247, 240, 11)')

        cy.get(selectors.totoapp)
            .invoke('css', 'font-family', 'cursive')
            .should('have.css', 'font-family', 'cursive')

        cy.get(selectors.html).toMatchImageSnapshot({
            threshold: 0.01,
            name: 'ToDo list items  change some css properties and complete 3rd item'
        })
    })
})
