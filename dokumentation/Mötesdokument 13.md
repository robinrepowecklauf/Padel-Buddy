# Meeting Agenda
Group: Padel Buddy  
Date: 16/10-19 10:30-11:30  
Chair: Carl-Johan Björnson  
Participants: Marcus Axelsson, Robin Repo Wecklauf, Daniel Karlkvist, Fredrik Lilliecreutz & Carl-Johan Björnson

## Objectives (5 min)

## Reports (15 min) from previous meeting

Alla: Skrivit peer-review, alltså analyserat en annan grupps kodbas. Haft möte med Gerdes, och fått bra feedback på vår nuvarande kodbas. Refaktorerat samtliga klasser som använde en Player till att istället använda ett interface IPlayer. Detta minskar exponering av Player i modellen. Börjat implementera en Factory ITestFactory som genererar testdata för att inte skapa objekt i modellen.

Robin: Fixade så GUI-testerna funkar nu när PadelBuddy inte är en Singleton längre.
 
## Discussion items (35 min)
- Vad som ska implementeras utifrån råd från Gerdes.
- User Stories för implementering av ny struktur i kodbasen.
- Komma i tid till möten.
- Börja kolla på betygskriterier och vad som ska vara klart tills nästa vecka.
- Sätta en deadline för projektet.

## Outcomes and assignments (5 min)
Vad som ska implementeras utifrån råd från Gerdes.
- Få bort hårdkodade värden från modellen. Implementera Service. 
- Iterator pattern, Skicka iväg en iterator till vyn istället för en ArrayList för att hindra vyn att ändra på modellen. 
- Skapa en abstrakt klass Game och en klass padelgame som extendar Game för att göra applikationen mer utbyggbart. 
- Få bort CirecleImageview från player. HashMap? 
- Se över användingnen av eunm i skicklighetsnivå. 
- Städa upp klassen Padelbuddy.
- Observerpattern. 

User Stories för implementering av ny struktur i kodbasen
- Som utvecklare vill jag kunna testa funktionallitet med hjälp av påhittade användare som är avskilda från modellen 
för att se att logiken fungerar.
- Som en utvecklare vill jag implementera iterator pattern för att inte vyn ska ha möjlighet att modifiera data. 
- Som produktägare vill jag att appen ska vara utbyggbar med flera sporter för att nå ut till fler möjliga användare. 

Börja kolla på betygskriterier och vad som ska vara klart tills nästa vecka.
1. Man ska kunna välja bland olika användare. 
2. Man ska kunna skapa en annons.
3. Man ska kunna gå med i en annons och se denna i upcoming games. 
4. Man ska kunna gå ur en annons. 
5. Man ska kunna ändra sin profil. 

Sätta en deadline för projektet.
- Fredag 25e. 

## Wrap up
- Nästa möte: Fredag 18/10 10:00-11:00.
