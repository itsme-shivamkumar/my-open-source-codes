# LLD 

## 🧭 Problem Classification

All problems are grouped into **logical categories**, because interviewers often reuse **the same underlying patterns**.

---

## 1️⃣ CRUD + Search Heavy Systems

*(Focus: entities, indexing, extensibility)*

| Problem                             | Links                                                                                                         | Company   |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------- | --------- |
| **Contact Management System**       | In-repo                                                                                                       | Common    |
| **Library Management System**       | In-repo                                                                                                       | Common    |
| **Property Listing / PropertyHunt** | [Repo](https://github.com/kumaransg/LLD/tree/main/PropertyHunt)                                               | Cleartrip |
| **Basic JIRA Backend**              | [Doc](https://docs.google.com/document/d/1FrUU7ROZTNCgQKeel6Eh9bLhZtRX43r9IE8xoGEYOhY/edit)                   | Common    |
| **Event Calendar**                  | [PDF](https://github.com/kumaransg/LLD/blob/main/Event_calendar_flipkart/Event%20Calendar.pdf)                | Flipkart  |
| **Leetcode-like Coding Platform**   | [PDF](https://github.com/kumaransg/LLD/blob/main/leetcode-lld-flipkart-coding-blox/SDE2-%20MC%20Question.pdf) | Flipkart  |

📌 **Patterns tested**:

* Search optimization
* Object relationships
* Open-Closed Principle
* In-memory indexing

---

## 2️⃣ Booking, Allocation & Scheduling Systems

*(Focus: state transitions, availability, concurrency thinking)*

| Problem                             | Links                                                                                                                  | Company     |
| ----------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ----------- |
| **Ride Sharing System**             | [Repo](https://github.com/kumaransg/LLD/tree/main/Ride%20Sharing%20)                                                   | Very Common |
| **Lift / Elevator System**          | [Solution](https://lldcoding.com/design-lld-lift-machine-coding)                                                       | Very Common |
| **Food Ordering System (FoodKart)** | [Doc](https://docs.google.com/document/d/1Bmkz9omByHqVvwU45cvkBRSwJAPKw9yaDsRlEnCg_lg/edit#)                           | Flipkart    |
| **Food Delivery App (Zomato-like)** | [Solution](https://lldcoding.com/design-lld-a-system-for-online-food-ordering-and-delivery-like-zomato-machine-coding) | Common      |
| **Event Calendar (Scheduling)**     | Same as above                                                                                                          | Flipkart    |

📌 **Patterns tested**:

* State machines
* Availability tracking
* Slot allocation
* Command / Strategy patterns

---

## 3️⃣ Financial, Ledger & Trading Systems

*(Focus: correctness, consistency, extensibility)*

| Problem                     | Links                                                                                          | Company     |
| --------------------------- | ---------------------------------------------------------------------------------------------- | ----------- |
| **Ledger Company**          | [GeekTrust](https://www.geektrust.in/coding-problem/backend/ledger-co)                         | Navi        |
| **Stock Exchange System**   | [Repo](https://github.com/kumaransg/LLD/tree/main/StockExchange)                               | Navi        |
| **Splitwise**               | [Solution](https://lldcoding.com/design-lld-splitwise-application-machine-coding)              | Very Common |
| **Cryptocurrency Exchange** | [Solution](https://lldcoding.com/design-lld-a-cryptocurrency-exchange-platform-machine-coding) | Common      |
| **Blockchain**              | [Solution](https://lldcoding.com/design-lld-blockchain-machine-coding)                         | Common      |

📌 **Patterns tested**:

* Transaction modeling
* Precision & correctness
* Immutable records
* Aggregation logic

---

## 4️⃣ Games & Simulations

*(Focus: game loop, rules engine, state modeling)*

| Problem                       | Links                                                                               |
| ----------------------------- | ----------------------------------------------------------------------------------- |
| **2048 Game**                 | [Solution](https://lldcoding.com/design-lld-2048-game-machine-coding)               |
| **Snakes & Ladders**          | In-repo                                                                             |
| **Game Engine (Unreal-like)** | [Solution](https://lldcoding.com/design-lld-game-engine-like-unreal-machine-coding) |

📌 **Patterns tested**:

* Rule engines
* State transitions
* Strategy & Observer patterns

---

## 5️⃣ Messaging, Collaboration & Real-Time Systems

*(Focus: extensibility, entities, scalability awareness)*

| Problem                         | Links                                                                                                                            |
| ------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **WhatsApp / Chat System**      | [Solution](https://lldcoding.com/design-lld-whatsapp-messenger-machine-coding)                                                   |
| **Gmail**                       | [Solution](https://lldcoding.com/design-lld-gmail-machine-coding)                                                                |
| **Google Docs (Collaboration)** | [Solution](https://lldcoding.com/design-lld-a-real-time-collaborative-document-editing-platform-like-google-docs-machine-coding) |
| **Zoom (Video Conferencing)**   | [Solution](https://lldcoding.com/design-lld-a-video-conferencing-application-like-zoom-machine-coding)                           |
| **Newsletter Service**          | [Solution](https://lldcoding.com/design-lld-newsletter-service-machine-coding)                                                   |

📌 **Patterns tested**:

* Publisher-Subscriber
* Notification systems
* Role-based access

---

## 6️⃣ Media, Streaming & File Systems

*(Focus: abstraction, hierarchy, metadata modeling)*

| Problem                       | Links                                                                                                             |
| ----------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| **Spotify (Music Streaming)** | [Solution](https://lldcoding.com/implement-a-music-streaming-service-like-spotify-machine-coding)                 |
| **Video Streaming Platform**  | [Solution](https://lldcoding.com/design-lld-video-streaming-platform-machine-coding)                              |
| **Dropbox (File Sharing)**    | [Solution](https://lldcoding.com/design-lld-a-file-sharing-system-like-dropbox-machine-coding)                    |
| **BitTorrent (P2P)**          | [Solution](https://lldcoding.com/design-lld-a-peer-to-peer-file-sharing-system-like-bittorrent-machine-coding)    |
| **Music Recognition System**  | [Solution](https://lldcoding.com/design-lld-a-music-recognition-system-using-audio-fingerprinting-machine-coding) |

---

## 7️⃣ Large Information & Analytics Systems

*(Focus: domain modeling, data relationships)*

| Problem                       | Links                                                                                                       | Company |
| ----------------------------- | ----------------------------------------------------------------------------------------------------------- | ------- |
| **Cricket Match Dashboard**   | [Leetcode](https://leetcode.com/discuss/interview-question/990227/udaan-assignment-cricket-match-dashboard) | Udaan   |
| **Cricinfo System**           | In-repo                                                                                                     | Common  |
| **Twitter / X**               | [Solution](https://lldcoding.com/design-lld-twitter-machine-coding)                                         |         |
| **Google Maps**               | [Solution](https://lldcoding.com/design-lld-google-maps-machine-coding)                                     |         |
| **Distributed Search Engine** | [Solution](https://lldcoding.com/design-lld-distributed-search-engine-machine-coding)                       |         |

📌 **Patterns tested**:

* Hierarchical data modeling
* Query optimization
* Read-heavy systems

---

## 8️⃣ Core System Design Utilities

*(Frequently used as sub-components in interviews)*

| Problem                            | Links                                                                                                          |
| ---------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **LRU Cache**                      | [YouTube](https://www.youtube.com/watch?v=iuqZvajTOyA)                                                         |
| **AWS Lambda (Function Platform)** | [Solution](https://lldcoding.com/design-lld-aws-lambda-machine-coding)                                         |
| **Mentorship Platform**            | [Solution](https://lldcoding.com/design-lld-mentorship-platform-like-preplaced-machine-coding)                 |
| **CodePair Platform**              | [Solution](https://lldcoding.com/design-lld-pair-programming-platform-like-hackerrank-codepair-machine-coding) |
