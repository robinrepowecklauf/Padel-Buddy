# Meeting Agenda
Group: Padel Buddy  
Date: 20/10-19 19:00-20:00  
Chair: Carl-Johan Björnson  
Participants: Marcus Axelsson, Robin Repo Wecklauf, Daniel Karlkvist, Fredrik Lilliecreutz & Carl-Johan Björnson

## Objectives (5 min)
1. Man ska kunna skapa en annons.
2. Man ska kunna gå med i en annons och se denna i upcoming games. 
3. Man ska kunna gå ur en annons. 

- Iterator pattern

## Reports (15 min) from previous meeting
Robin, Marcus:
- Tog bort static från testplayers-listan för att det inte behövdes längre. Ändrade från ArrayList till List överallt. Fixade till TestFactory så att inga objekt skapas i modellen.

Robin, Marcus, Daniel:
- Gjorde så Factory följer Interface Segregation Principle genom att ta bort klassen TestDataPlayers och tog dess funktionalitet till TestDataGames. En test_login_screen.xml lades även till - vilket representerar startsidan för varje användare där man i nuläget väljer vilken profil som programmet ska startas med. Skapade en Activity vid namn LoginActivity som sköter vyn och funktionaliteten kring vilken profil som väljs. 

Robin, Daniel:
- Fick bort CircleImageView från player genom att skapa en klass PlayerImageBinder som binder en Player till en bild. 

Robin:
- Uppdaterat UI-paketets UML.

Fredrik & Marcus:
- Refaktoriserade testerna. Ändrade metoden som räknar ut genomsnittlig skicklighetsnivå (getAverageSkillLevel), istället för att varje player har en enum som skillLevel används nu en double. Ändrade alla hårdkodade användares skillLevel, så att den nya metoden kan användas.

Fredrik, Marcus & Daniel:
- Refatoriserade Factoryn så att den hanterar IGames istället för Games.

Marcus & Daniel:
- Skapade en static PadelBuddy och IPlayer i TestFactory för att koppla hårdkodade testanvändare till applikationen.

Carl-Johan: 
- I klassen PadelBuddy finns nu metoderna leaveGame() & joinGame() som antingen lägger till eller tar bort user från en match.
- GameRecyclerViewFragment har nu attributet boolean joinable, vilekt avgör vilken knapp som ska synas på matchannonsen. Antingen "Gå med" eller "lämna match". 
- TestDataGames skapar nu games där användaren inte är en utav spelarna. Detta för att det ska finnas matcher att gå med i. 
- La till metoden checkInputValues i CreateAdFragment.java, som kollar om användaren har valt en tid och längd för match innan annonsen skapas. Skapade även metoden stringToDate(), som tar in en String och retunerar ett Date med datument som strängen representerar.
- Skapade Interfacet ICreate som implementeras av klassen Padelbuddy.java. Detta gör att man från klassen CreateAdFragment.java kan tycka på en knapp som kallar på metoden createAd() i Padelbuddy.java. 
- Ändrade så att LoginActivity har en statisk padelbuddy, istället för att applikationen ska hämta ett PadelBuddy-objekt från Service-paketet. Hämtar nu endast en user. 

Carl-Johan och Fredrik: 
- La in passande ikoner i game_item.xml
- Skapade interfacet IGame som är en abstraktion av klassen games. 
- Försökt implementer pliancy på knappar. 
- Carl-Johan skrev metoden getAvailableGames() i klassen PadelBuddy.java. Fredrik hittade buggar i denna metod och åtgärdade detta med den nuvarande versionen av metoden, som nu faktiskt fungerar. 

Fredrik && Daniel Ändrat Game till en abstract klass och skapat subklassen PadelGame och refaktorerat efter denna ändring. Ändrat listorna som används från ArrayList till List. Vi har även kollat på användandet av generiska listor. 

Fredrik: Gjort tester för addPlayer, joingame, leavegame, upcomingGame och getAvailablegames för olika scenarion och felsökt buggar för dessa metoder. 

 
## Discussion items (35 min)
- Tider för veckan.
- Spintplanering, vad ska göras under sista veckan?
## Outcomes and assignments (5 min)

Tider för veckan.
- Fullbokat med grupprum. Arbetstider finns i kalendern. 
Sprintplanering.
- Iterator pattern. 
- Skriva klart RAD, SDD och Rapporten.
- Implemetera förslag från peer review. 
- Skapa en presentation för redovisning. 
- Skriva kommentarer i kodbasen samt tester.
- Refaktorera. 


## Wrap up
- Nästa möte: Tisdag 22/10 08:15-09:15.
