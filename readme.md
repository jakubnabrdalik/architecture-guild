## Purpose of this repo

This is an example of an Architecture Guild repository.

If you want to create (or re-organise) an Architecture Guild, I recommend reading [Architecture with 800 of My Closest Friends: The Evolution of Comcast’s Architecture Guild](https://www.infoq.com/articles/architecture-guild-800-friends/) by Jon Moore first, to see how it can be organized at scale. Then you need to decide how you want the guild to work, and write it down.

Not everyone is a good writer, so since we (me, @adamkulawik and others) managed to create and organise an Architectute Guild for our client, here is an example to get you started.

It's not a blueprint, it's not a tutorial, but it's better to have an example than not.

This example is composed of:
- the document describing how the guild works (this document below)
- an example of a C4 model using Structurizr (/diagrams)
- example template for decision log and action points (more can be found in [here](https://github.com/joelparkerhenderson/architecture_decision_record))

# Architecture guild overview

- [Architecture guild overview](#architecture-guild-overview)
  * [Motivation](#motivation)
  * [Role and responsibility of the guild](#role-and-responsibility-of-the-guild)
    + [Align the architecture of the system to the business goals](#align-the-architecture-of-the-system-to-the-business-goals)
    + [Find and recommend solutions to shared problems](#find-and-recommend-solutions-to-shared-problems)
    + [Share architecture and technical knowledge](#share-architecture-and-technical-knowledge)
  * [How the guild works](#how-the-guild-works)
    + [Who is responsible](#who-is-responsible)
    + [RFC](#rfc)
    + [Decision making & Architecture Decision Record](#decision-making---architecture-decision-record)
    + [Architecture diagrams (C4 model)](#architecture-diagrams--c4-model-)
  * [How the guild cooperates with others](#how-the-guild-cooperates-with-others)
    + [Business](#business)
    + [Developers](#developers)
    + [Management](#management)
  * [Benefits](#benefits)
    + [Example achievements](#example-achievements)
  * [Who else works this way (industry examples)](#who-else-works-this-way--industry-examples-)
  * [Contact](#contact)

## Motivation

Not that long ago, it was common to find centralized architecture review boards in large technical organizations, that would review all designs to ensure their consistency with a grand vision. When IT was primarily viewed as a cost center, this made eminent sense, as standardization and consistency are a wonderful way to contain maintenance costs.
These centralization was required, due to the monolithic and slow-moving nature of the system in development.

Now, however, we find more value in allowing teams to move fast, by giving them more options and decision making power. The distributed nature of a cloud based system, allows us to use the technologies and methods fitting the problem of a team, without impacting everyone else. Thus we follow the principles of Agile Manifesto:

"Build projects around motivated individuals. Give them the environment and support they need and trust them to get the job done."

and:

“The best architectures, requirements, and designs emerge from self-organizing teams."

“The Universal Scalability Law predicts that the maximum throughput that systems -- including organizational systems of cooperating people -- can achieve is bounded by the amount of contention for shared resources and the amount coherence overhead needed to keep everyone up to date about what's going on. As technical organizations and the business appetite for their services have grown [..] it's only natural that the centralized architecture review boards were discarded as bottlenecks, or that an emphasis was placed on minimizing team size and striving to enable teams to work independently.”

We embrace this approach, by introducing the DevOps culture (developers operating their system on production), and product based teams.

This however, still requires some coordination and guidance, to align the decisions made by teams, with the main goals of the organization.

This is the role of the Architecture Guild, a common pattern of aligning the IT with the business, providing guidance to less experienced developers and bringing down the cost of shared solutions.

## Role and responsibility of the guild

The guild has 3 responsibilities

### Align the architecture of the system to the business goals

When the architecture does not correspond to the goals of the organisation, implementing each new feature takes longer with time, or even becomes impossible. The old monolithic backend system is a good example of architecture that went in the opposite direction.
The guild holds the responsibility of keeping the architecture clean and aligned with the business.

### Find and recommend solutions to shared problems

Infrastructure and cross cutting concerns are shared between teams, so it makes sense to share the solutions to common problems among the organisation. The architecture guild is responsible for recommendations to issues that have long lasting consequences or a high cost of change.
This is especially important if a decision by one team, influences other teams.
Examples: using Apache Kafka for messaging and stream processing. Building Tailored Service Templates for teams to jumpstart new services. Providing required cost-effective Databases for common topologies (key-value, document, relational. etc.).

### Share architecture and technical knowledge 

The guild is also responsible for making sure that all the teams have necessary architecture vision and knowledge, with good visibility into how the system works, and where it is heading.
This is achieved by providing architecture diagrams, consulting all decision with people that have to work with its consequences, and involving all the business and IT in the aligning process.

## How the guild works

The guild meets regularly once per 2 weeks, but also has meetings ad-hoc to address urgent issues when they arise.
When the guild meets, it discusses the problems and work required, invites all the relevant people (outside of the guild), schedule the necessary research, creates an RFC document to gather all possible input from people with the knowledge on the issue matter, chooses the person responsible for getting the decision done.

### Who is responsible

Every 2 weeks one person from the guild is chosen as an acting Speaker of the guild.
That person holds personal responsibility, for making sure, that the guild makes the decision in efficient manner.
For every issue discussed by the guild, a person responsible will be chosen. If there are no volunteers, the Speaker of the guild is responsible.
The Speaker is also on an on-duty of the architecture guild, where she is responsible for answering all the questions from outside of the guild.

### RFC

RFC (Request for Comments) is a technique of efficient meeting-less communication and decision making. The goal is to allow the people with the knowledge to express their opinion, so that the final decision is well informed. 
Authors propose solution in an on-line doc (in git repository), where anyone interested can add their comments or suggestion.  

These documents capture:
- Context: what information did we consider while making this decision?
- Considered alternatives: what options did we see
- Decision: what do we recommend?
- Rationale: why did we make that recommendation?
- Consequences: what are the known drawbacks? 

After the document is created, the guild publishes it on the mailing list and guild chat channel. It usually takes 1 week to get all the needed input, but that depends on the urgency of the issue.
After all the input is gathered, the guild meets again, to make the final recommendation/decision.

### Decision making & Architecture Decision Record

The decision/recommendation is done after all the comments from RFC are gathered, on a separate meeting. The guild makes the decision together. If the people on the meeting cannot agree, the final decision is up to the Speaker.

Architecture Decision Record is a way of documenting architectural and technical decisions. These documents are created after the final meeting on the issue, and capture:
- Context: what information did we consider while making this decision?
- Considered alternatives: what options did we see
- Research outcomes: what did we learn out of researching this problem and discussing it.
- Decision: what do we recommend?
- Rationale: why did we make that recommendation?
- Consequences: what are the known drawbacks? 

### Architecture diagrams (C4 model)

We chose C4 model (https://c4model.com) as a formal notation for software architecture diagrams.

C4 notation is a lightweight approach to visualize architecture. It presents an architecture on four different levels, provides a map to the system, and allow for collaboration (developers use Pull Requests to keep diagrams up to date).

Benefits of the approach:
 - ability to define and modify diagrams as a code (with structurizr tool), allowing very easy work defining for developers and allowing every member of any team to update it when any change take place
 - specific levels of diagrams can be used by different audience, e.g. context diagram by business people while code diagram are intended for developers of specific team
 - a simple formal notation makes it easy to comprehend and discuss the diagram and its consequences

Diagrams with no formal notation should not be used as they are unprofessional and create confusion.

## How the guild cooperates with others

### Business

The Speaker of the guild is available during work hours at “Software Architecture [ENG]” Ms Teams channel - no need to check or remember who is on duty from the business perspective. She will answer all the questions, and take all the required steps in case of an issues.
The guild has an also email address: (redacted)

The guild will also facilitate meetings with business to gather the required knowledge, learn the business direction and to align the IT architecture with the goals of our company, using methods like Event Storming and Value-Stream mapping.

### Developers

All developers are welcome to join the guild and the meetings if their current tasks allow.
The guild is inclusive, that means it accepts new all members by default.
Everyone can report an issue to the guild and request for help, or provide insight into the problem.
People who join the guild will be held accountable for their input and may be requested to do the research, Proof-of-concepts etc. on the best-effort basis. 

### Management

The guild is held accountable for the architecture of the system, and reports all organizational problems to the corresponding managers, in case of an misalignment of the organization and architecture (team’s composition and responsibility).

## Benefits

The decisions/recommendations made by the guild are well informed. No decision is made by a person who does not have the required architecture knowledge.
Because the decision making process is inclusive, no decision is made without the input of the people who have to live with the consequences of that decision.
A single person cannot have enough visibility into a large distributed system, to make sensible decision. Because the guild is composed of many people, from all sides of the system, decision take into account all the perspectives on the system we build.
Because the guild is inclusive, it shares the knowledge and improves the cooperation in IT, and with the business.

This approach is proven by several large organizations (see next chapter).

### Example achievements

- The people included in the guild created the architecture diagrams representing current architecture and the future 
approach used by developers and business to implement further changes.
- Defining Tailored Service Template allowing rapid set up of new microservices.
- The guild defined architecture evolution roadmap based on identified bounded contexts, and keeps validating it.
- The guild recommended a DB for cloud-based applications based on possible options and taking into account cost, maintainability and performance.
- Suggested split of responsibilities between scrum teams.
- Running two TDD/OOP workshops.

## Who else works this way (industry examples)

There are several organizations working this way. Some large examples:
- Comcast: https://www.infoq.com/articles/architecture-guild-800-friends/
- Internet Engineering Task Force (IETF)
- Java Community Process
- World Wide Web Consortium

## Contact

One can contact guild on MS Teams channel "Software Architecture [ENG]" , or with 
[guild's e-mail](mailto:example.com)