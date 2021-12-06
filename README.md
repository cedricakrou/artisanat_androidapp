# artisanattestcinetpay_androidapp

Cette application permet aux clients de s'inscrire et de se connecter à plateforme ARTISAN.
* Elle permet aux clients de créeer des annonces et des voir les annonces des autres utilisateeurs

# ARCHITECTURE DE CODE

Pour ce projet, nous utilisons l'architecture hexagonale autrement clean architecture.
(https://netsharpdev.com/2019/12/04/clean-architecture/)

A cette architecture nous couplons l'architecture MVI (MODEL VIEW INTENT) pour organiser la couche présentation.
(https://medium.com/swlh/mvi-architecture-with-android-fcde123e3c4a) |  (https://www.raywenderlich.com/817602-mvi-architecture-for-android-tutorial-getting-started)


Le projet est composé de 5 couches principales:
* [La couche Application](): Elle contient toutes fonctionnalités directement à application à savoir:
    * DI( Dependency Injection ) : Les injections de dépendance
    * Les configurations
    * les controllers
    * lees gateways
* [La couche Data](): est la couche d'accès aux données persistence. Elle est composée de :
    * Repositories ou managers
* [La couche Domain](): Elle repose sur les entités et les dto de l'application.
* [La couche Infrastructure](): Elle contient:
    * remote: les API distants
    * les librairies
    * les services externes à l'application.

[La couche Presentation](): elles presentent les écrans (interfaces graphiques) et les communications entre elles.
* Common: Les Classes communes à toutes les écrans.
* Features: represente les fonctionnalités de l'application par écran
  **Par exemple**:
    * Home
        * HomeIntent: Une classe fermée (sealed) où l'on enumérés les differentes actions que l'utilisateur peut faire sur la vue
        * HomeAction: Classe fermée qui contient les differentes actions à executer selon l'intent du user
        * HomeState: Classe fermée qui regorge tous les états que l'ecran peut presenter
        * HomeViewModel: est le viewModel qui interprete les actions effectuées par l'user sur l'ecran et lui retourne un état.


# LIBRAIRIES UTILISÉES

* [Dagger2](https://dagger.dev/users-guide) | [](https://developer.android.com/codelabs/android-dagger) Pour l'injection de dépendance.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Coroutines](https://developer.android.com/kotlin/coroutines) Pour la programmation asychrone
* [Coroutines-flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) Pour la programmation asychrone
* [Retrofit2](https://square.github.io/retrofit/)  Pour la connexion HTTP.
