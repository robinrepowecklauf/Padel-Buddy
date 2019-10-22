# Meeting Agenda
Group: Padel Buddy  
Date: 22/10-19 13:15-14:15  
Chair: Carl-Johan Björnson  
Participants: Marcus Axelsson, Robin Repo Wecklauf, Daniel Karlkvist, Fredrik Lilliecreutz & Carl-Johan Björnson

## Objectives (5 min)


## Reports (15 min) from previous meeting

Robin: 
- Skivit JUnittest för metoden getUpComingGames()
- Uppdaterat Model-paketets UML
- GUI-tester funkar nu med LoginActivity-klassen som startsida.
- Refaktorerat i modellen

Daniel:

Marcus & Daniel:
- Tog bort CircleImageView ifrån spelare, detta resulterade i en hel del refaktorering. Nu skickas en Context runt för för att få en bitmap av en drawable bild. Detta skapar en del beroenden till till Context i olika filer, vilket är en code smell.

Marcus & Robin:
- Uppdaterade User stories i RAD: Flikar, Design, Min profil, Se matchannons, Hårdkodade spel & spelare, Skapa matchannons.
- Skrev in fler User stories i RAD: “Kommande matcher”-flik, “Tidigare matcher”-flik, Gå med i matchannons, Utbyggbar, Factory pattern, Välj användare, Iterator pattern, “Förfrågningar”-flik, “Turneringar”-flik, Turnering, “Vänner”-flik, Chatt


Fredrik:

Carl-Johan: 
- Fixat så att feeden med available Games endast innehåller matcher vars datum är efter dagens datum. Detta genom att jämföra matchens datum med dagens datum. 
- Upcoming samt playedgames sorteras även dom nu efter datum.
- Kortet för en spelad match innhåller nu en knapp för att rapportera in resultat för matchen. 
- I fliken för att skapa annons visas nu bilden på den aktiva användaren, istället för en hårdkodad bild. 
- Nu kan en användare alltså både gå med och lämna en match samt att matchen då visas i rätt flik. 
 
## Discussion items (35 min)

## Outcomes and assignments (5 min)


## Wrap up
- Nästa möte: Torsdag 24/10 08:15-09:15.
