# Meeting Agenda
Group: Padel Buddy  
Date: 13/10-19 15:15-16:15  
Chair: Carl-Johan Björnson  
Participants: Marcus Axelsson, Robin Repo Wecklauf, Daniel Karlkvist, Fredrik Lilliecreutz & Carl-Johan Björnson

## Objectives (5 min)

## Reports (15 min) from previous meeting

Alla: Refaktorerat. Skapat UML-diagram för nuvarande kodbas.

Robin: Möjliggjort att skriva instrumental tests för Fragment. Skrivit samtliga JUNIT+Espresso (GUI) tester på ProfileFragment. Fyllt i samtliga User Stories och lagt till User Story "Filtrering" i RAD. Uppdaterat Introduktionen och skrivit programmets livscykel i SDD. Merge med master-branch. Uppdaterat JavaDoc för samtliga .java klasser. 

Robin, Daniel: Rektorerat följande: Tog bort "Controller" från samtliga klasser i Controller-paketet. Slog samman history_item.xml och upcoming_games_item.xml till game_item.xml. Tog bort GamesAdapter. Lade till konstruktor till GameRecyclerViewFragment för att slippa beroende. Dessvärre inträffade en merge-konflikt som gjorde att samtliga ändringar inte implementerades, utan Daniel, Marcus och Fredrik implementerade detta istället.

Marcus: Implementerade metoden scrollToTop i GamesFragment, där funktionaliteten fungerar oavsett vilken flik man är inne på. Ändrade även metoden createRandomGames i MainActivity där den nu kan skapa hur många games man vill. Fixade även så att spelare läggs in i dessa spel, på olika ställen. Lade till så att spelare utan profilbild har en standard bild och de platser i en annons som är lediga har ett frågetecken som profilbild.

Marcus, Daniel: Skapade en metod för att räkna ut genomsnittlig skicklighetsnivå, som sedan används i produktkorten.

Marcus, Daniel, Fredik: Implementerade det som försvann för Robin och Daniel vid en merge i git. Ändrade om PadelBuddy klassen så att den inte är en singelton, och istället använder vi ett objekt av PadelBuddy i MainActivity. Ändrade om UpComingGames till en gemensam klass som kan återanvändas (GameRecyclerViewFragment). Refaktoriserade GameAdFragment och ProfileFragment, ändrade namn och snyggade upp koden. Lade även till funktionalitet för att ändra profilbild, som sedan även länkas ihop med produktkorten i flödet. 

Fredrik: Utöver ovan: Skapat tester för addPlayer, GetAverageSkillevel, isFinishedGame i GameTest. Skapat tester för createAd, removeAd i PadelBuddyTest. Ändrat metoden för att räkna ut genomsnittlig skicklighetsnivå. 

Daniel & Fredrik:
Skapat metoderna upcoming games och history games i Padelbuddy. 

Carl-Johan: Utvecklat fliken för att skapa matchannons; Skapat två dialoger för att välja datum samt tid för match. Skapat en Spinner för att välja Padel anläggningar. Skrivit JavaDoc för olika kontroller samt deras metoder. Skrivit kommentarer i xml-filer. 
 
## Discussion items (35 min)
- Frågor till Gerdes.
- Sprintplanering.
- Tider för veckan.

## Outcomes and assignments (5 min)
Frågor till Gerdes:
- Frågona finns sammanställda i separatdokument.

Sprintplanering:
- Peer Review Måndag förmiddag 14/10.
- Fortsätta strukturera upp kodbasen, implementera designmönster samt följa designprinciper. 
- I mån om tid: Skapa user stories för att implementera databas och flera användare. 

Tider för veckan:
- Handledningsmöte torsdag 15:15.
- Arbetstider inlagt i kalender. 

## Wrap up

- Nästa möte: Onsdag 16/10 10:00-11:00.
