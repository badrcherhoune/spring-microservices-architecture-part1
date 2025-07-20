# 🧠 Objectif général de l’architecture  
C’est une architecture microservices basée sur Spring Boot, où chaque service est indépendant et communique avec les autres via HTTP. Les services sont découverts dynamiquement grâce à un service de découverte, les configurations sont centralisées, les accès sont dirigés via une API Gateway, et l’observabilité est assurée via Zipkin.  

## 📌 Les composants principaux  

### 1. � API Gateway  
**Rôle** : Point d'entrée unique dans l'architecture.  

**Fonction** : Reçoit toutes les requêtes HTTP externes (comme `/students` ou `/schools`) et les redirige vers le bon microservice.  

**Avantages** :  
- Centralise les appels.  
- Applique des règles globales (authentification, rate-limiting...).  
- Masque la complexité des microservices aux clients.  

### 2. 📚 Service Discovery (Eureka Server)  
**Rôle** : Permet aux microservices de s'enregistrer et de se découvrir automatiquement.  

**Fonction** :  
- Le service `Student` et `School` s’enregistrent dans Eureka.  
- L’API Gateway peut les retrouver dynamiquement sans IP fixe.  

**Avantage** :  
- Pas besoin de configurer manuellement les adresses.  
- Permet le load balancing et la scalabilité horizontale.  

### 3. ⚙️ Config Server (Centralized Configuration)  
**Rôle** : Centralise les fichiers de configuration (comme `application.yml`).  

**Fonction** :  
- Chaque microservice tire (pull) sa config au démarrage depuis le config server.  
- Le config server lit les fichiers depuis GitHub ou un repo Git local.  

**Avantage** :  
- Plus besoin de copier/coller les mêmes fichiers config.  
- Facilité à modifier à chaud les configurations.  

### 4. 🧩 Microservices (School & Student)  
- Ce sont les services métiers :  
  - `School` gère les écoles.  
  - `Student` gère les étudiants.  
- **Communication** : Ils communiquent entre eux par HTTP (REST).  
- **Base de données** : Chaque service a sa propre base de données (PostgreSQL dans Docker).  

### 5. 🕵️‍♂️ Zipkin (Distributed Tracing)  
**Rôle** : Observabilité, permet de suivre le chemin complet d’une requête entre les microservices.  

**Fonction** :  
- Trace les appels entre l’API Gateway, `School` et `Student`.  
- Utile pour débuguer les performances et trouver les points de lenteur.  

### 6. 🐳 Docker  
Utilisé ici pour PostgreSQL : chaque service a une base Postgres isolée, exécutée dans Docker.  

**Avantage** : Facilite l’environnement de dev/déploiement.  

## 🔁 Flux de fonctionnement simplifié  
1. Un utilisateur envoie une requête via internet, ex. `/students`.  
2. L’API Gateway reçoit cette requête et la redirige vers le service `Student`.  
3. Le service `Student` peut appeler `School` (ex : pour obtenir des infos d’école).  
4. Tous les appels sont tracés par Zipkin.  
5. Chaque service s’est enregistré dans Eureka.  
6. Chaque service a chargé sa config depuis le Config Server au démarrage.
##  Application:

### 🧠 Objectif général de l’architecture  
C’est une architecture microservices basée sur Spring Boot, où chaque service est indépendant et communique avec les autres via HTTP. Les services sont découverts dynamiquement grâce à un service de découverte, les configurations sont centralisées, les accès sont dirigés via une API Gateway, et l’observabilité est assurée via Zipkin.  

### 📌 Les composants principaux  

#### 1. � API Gateway  
**Rôle** : Point d'entrée unique dans l'architecture.  

**Fonction** : Reçoit toutes les requêtes HTTP externes (comme `/students` ou `/schools`) et les redirige vers le bon microservice.  

**Avantages** :  
- Centralise les appels.  
- Applique des règles globales (authentification, rate-limiting...).  
- Masque la complexité des microservices aux clients.  

#### 2. 📚 Service Discovery (Eureka Server)  
**Rôle** : Permet aux microservices de s'enregistrer et de se découvrir automatiquement.  

**Fonction** :  
- Le service `Student` et `School` s’enregistrent dans Eureka.  
- L’API Gateway peut les retrouver dynamiquement sans IP fixe.  

**Avantage** :  
- Pas besoin de configurer manuellement les adresses.  
- Permet le load balancing et la scalabilité horizontale.  

#### 3. ⚙️ Config Server (Centralized Configuration)  
**Rôle** : Centralise les fichiers de configuration (comme `application.yml`).  

**Fonction** :  
- Chaque microservice tire (pull) sa config au démarrage depuis le config server.  
- Le config server lit les fichiers depuis GitHub ou un repo Git local.  

**Avantage** :  
- Plus besoin de copier/coller les mêmes fichiers config.  
- Facilité à modifier à chaud les configurations.  

#### 4. 🧩 Microservices (School & Student)  
- Ce sont les services métiers :  
  - `School` gère les écoles.  
  - `Student` gère les étudiants.  
- **Communication** : Ils communiquent entre eux par HTTP (REST).  
- **Base de données** : Chaque service a sa propre base de données (PostgreSQL dans Docker).  

#### 5. 🕵️‍♂️ Zipkin (Distributed Tracing)  
**Rôle** : Observabilité, permet de suivre le chemin complet d’une requête entre les microservices.  

**Fonction** :  
- Trace les appels entre l’API Gateway, `School` et `Student`.  
- Utile pour débuguer les performances et trouver les points de lenteur.  

#### 6. 🐳 Docker  
Utilisé ici pour PostgreSQL : chaque service a une base Postgres isolée, exécutée dans Docker.  

**Avantage** : Facilite l’environnement de dev/déploiement.  

### 🔁 Flux de fonctionnement simplifié  
1. Un utilisateur envoie une requête via internet, ex. `/students`.  
2. L’API Gateway reçoit cette requête et la redirige vers le service `Student`.  
3. Le service `Student` peut appeler `School` (ex : pour obtenir des infos d’école).  
4. Tous les appels sont tracés par Zipkin.  
5. Chaque service s’est enregistré dans Eureka.  
6. Chaque service a chargé sa config depuis le Config Server au démarrage.  
