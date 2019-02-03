# Kotlin Multiplatform seed
Developed by Sergio Casero Hernández and Daniel Llanos Muñoz

## Project description
Kotlin multiplatform is a reality. This repo has a seed with our multiplatform architecture. You can see a example project using this seed  [here](https://github.com/sergiocasero/votlin-app).

## Frameworks
This seed contains these frameworks:
* Android
* iOS
* Web - React
* Desktop - TornadoFx
* Backend - Ktor

All frameworks use a common module with all presentation, bussisnes and data logic.

### Installation
This project is prepared to be used as seed. Clone the repo and change the packages if you want.

To add a new screen:
- Add the presentation logic using MVP pattern.
- If It has some bussisnes and data logic add the use case and necessary repository methods.
- Each framework handle the dependency injection. (Android template is using KodeIn)
- Implement the diferents views each framework.
- Instantiate the presenter previously created.
- Implement view interface associated.

Look the splash screen as example

### TODO
- [ ] Common local persistence using: [Kissme](https://github.com/netguru/Kissme)
- [ ] Add tests
- [ ] Error handler.
- [ ] Use Arrow to improve the exception raising


___

You can see more information about this project using [this slides](https://docs.google.com/presentation/d/1meSPq-IWo68w1yHoisDp6JTVi9Jwr7MVCOG6WNQ7cmM/edit#slide=id.p).

