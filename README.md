# Test AirFrance

Test technique AirFrance pour Axileo

Vous y retrouverez ci joint les différentes feature demandé.

Le projet est sous une architecture monolithe réalisée sous Spring 2.5.5
En y exploitant une base de donnée H2.

## Information Base de données
Pour lancer le projet il vous suffit de lancer le serveur spring sous le port 8081.
Pour accéder à la console H2 le lien est :

http://localhost:8081/h2-console/

credentials : sa | ""

Lors du lancement du programme des utilisateurs sont créé pour y tester directement les routes.

## Documentation
Vous disposez également d'une d'une documentation swagger pour consulter les routes.

http://localhost:8081/swagger-ui.html#/

Le projet respecte toutes les contraintes demandées, 
vous y retrouverez également la partie AOP pour y analyser le temps d'execution des requettes HTTP.

Une fonction des gestions d'erreur est également implémenté avec un ErrorHandler adapté.

## Contact 
Autor : John ALLOU.
Email : jonhn.allou@axileo.fr

