# OpenPressing

Application mobile de gestion de pressing (nettoyage à sec et blanchisserie) : les clients consultent
les services et les offres, passent leurs commandes et suivent leur traitement, et les agences gèrent
leurs services, leur linge et leurs promotions.

> Projet d'équipe réalisé en 2023 dans le cadre de ma formation en programmation et applications
> mobiles (CCNB, en partenariat avec l'IUC, Douala).


## Fonctionnalités

- **Connexion et inscription** des utilisateurs (Firebase Authentication)
- **Accueil** : présentation des services et des offres du pressing
- **Commandes** : consultation des commandes et de leur état
- **Offres et besoins** : consultation des offres et création d'un besoin par le client
- **Gestion d'agence** : services et types de linge, avec ajout depuis une fenêtre modale
- **Promotions** : création de promotions par l'agence

## Technologies

| Partie | Technologies |
|---|---|
| Application Android (`android_part/`) | Kotlin, Jetpack Compose, Navigation Compose, Dagger Hilt, Retrofit, Coil, Accompanist |
| Données et authentification | Firebase Authentication, Cloud Firestore |
| Back-end (`open_pressing/`) | Strapi 4 (Node.js), SQLite |

- Android : SDK minimum 24 (Android 7.0), SDK cible 33
- Architecture : organisation par modules fonctionnels (par exemple `client_module/presentation`),
  injection de dépendances avec Hilt

## Structure du dépôt

```
OpenPressing/
├── android_part/     # Application Android (Kotlin, Jetpack Compose)
└── open_pressing/    # API back-end Strapi (Node.js, SQLite)
```

## Lancer le projet

### Application Android

1. Ouvrir le dossier `android_part/` dans **Android Studio**.
2. Ajouter votre propre fichier `google-services.json` (projet Firebase) dans `android_part/app/`.
3. Synchroniser Gradle, puis lancer l'application sur un émulateur ou un appareil (Android 7.0 ou plus).

### Back-end Strapi

Prérequis : Node.js 14 à 18.

```bash
cd open_pressing
cp .env.example .env   # puis compléter les valeurs
npm install
npm run develop        # interface d'administration : http://localhost:1337/admin
```

## Ma contribution

- Intégration de Firebase Authentication et Firestore
- Écran de consultation des commandes
- Coordination de l'équipe et gestion du dépôt GitHub
- Création du backend
- Modélisation de la structure de données

## Équipe

Projet réalisé en équipe de 7 personnes :
Danela Mouofo ([@MouofoKayouDanela](https://github.com/MouofoKayouDanela)), @JOSEPHTIAM, @KengniJohan,
@AuroreNiki, @TedongmoKanouoValdez, @Rayan-dev et @Fossa-DevOps.
