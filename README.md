✨ Application Name : "Seasajob"

✔️ Version : "1.0.0"

✔️ Version JAVA : "17.0.4"

✔️ Version jdk : "corretto-17"

✔️ Version Spring Boot : "2.7.6"

✔️ Gradle : "Groovy"

🔗 URL du dépôt : https://github.com/AaronLaz/ig5-iwa-service-applications

📜 Description et objectif 📜

Ceci est le micro-service de gestion des candidatures et avis sur les candidatures de l'application Seasajob. Seasajob est une application pour la gestion des candidatures et offres d'emploi à des jobs saisonniers.

Voici le schéma de l'architecture de l'application : 
![image](https://user-images.githubusercontent.com/55982726/205261418-72003e4d-debb-4027-9d3b-ac30e7e037d0.png)

Les fonctionnalités de ce micro-service sont les suivantes :

Candidatures: 

• Créer une candidature 

• Récupérer toutes les candidatures 

• Récupérer une candidature avec son id 

• Mettre à jour une candidature avec son id 

• Supprimer une candidature 

Avis sur les candidatures par les recruteurs et candidats:

• Créer un avis sur une candidature

• Récupérer toutes les avis

• Récupérer un avis avec son id

• Mettre à jour un avis avec son id

• Supprimer un avis


Vous trouverez les deux autres micro-services ici :

Gestion des utilisateurs & mailing, réalisé par Joan TERIIHOANIA : https://github.com/joan-teriihoania/iwa2-rest-api
Gestion des offres, réalisé par Tiffany DUMAIRE : https://github.com/tiffany-dumaire/ig5-iwa-service-offers

🖋️ Auteurs 🖋️

Application Seasajob
Ce projet a été réalisée par Tiffany DUMAIRE, Aaron LAZAROO & Joan TERIIHOANIA (IG5 - 2022/2023) dans le cadre du cours d'Ingénierie des Applications Web du semestre 9.

Micro-service de gestion des candidatures et des avis
Réalisé par Aaron LAZAROO

📟 Lancer l'application 📟

💻 En local 💻

Après avoir clôné les fichiers sur votre PC, ouvrez l'application sur IntelliJ IDEA.
Aller dans le fichier build.gradle et assurer vous d'avoir bien synchronisé les dépendances. Si vous n'avez pas de fichier build.gradle vous pouvez utiliser celui-ci: https://drive.google.com/file/d/1geTjzEUjoHGCmM5WDs0phjz7ibgk08WA/view?usp=sharing.
Vous devrez également avoir installé PostgreSQL sur votre machine ! A l'aide de PG Admin, vous pourrez facilement importer le fichier pour la création de la BDD: https://drive.google.com/file/d/1Vv2rTY6dMCuca6Abd1lpYBUHkyDAkZ-n/view?usp=sharing.
Dans le fichier : src/main/resources/application.properties , pensez à bien modifier les informations données avec les informations de connexion à votre BDD nouvellement créé !

❌ Hébergé ❌

Ce micro-service n'a pas été hébergé et se lancera automatiquement sur l'adresse suivante : http://localhost:8080 
La base de données n'a pas été hébergée, mais une fois créée elle devrait se lancer automatiquement sur l'adresse suivante : http://localhost:5432
