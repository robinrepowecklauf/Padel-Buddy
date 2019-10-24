# Meeting Agenda
Group: Padel Buddy  
Date: 24/10-19 18:30-19:30  
Chair: Carl-Johan Björnson  
Participants: Marcus Axelsson, Robin Repo Wecklauf, Daniel Karlkvist, Fredrik Lilliecreutz & Carl-Johan Björnson

## Objectives (5 min)


## Reports (15 min) from previous meeting

Robin, Fredrik och Daniel: 
- Försök till implementation av Iterator-pattern, men beslutet togs efter 4h att det skulle ta för lång tid att implementera det med den kodbas vi har nu, så vi körde på mutate-by-copy istället för listan med games i Padel Buddy.
- Ändrat i getGames-metoden i PadelBuddy så den returnerar en kopia av listan, istället för listan i PadelBuddy(mutate-by-copy).

Robin:
- Uppdaterat UML för paketet UI, och lade till den delen i SDD. Har även varit med och uppdaterat en stor del av avsnitt 3 i SDD och RAD (där macish får skriva exakt vad).

- Hjälpt Fredrik att fixa till testerna nu när vi kör mutate-by-copy med listan av games i Padel Buddy.

Daniel: 
- Skapade en PlayerFactory för att kunna göra Player till en package-private klass.
- Skrivit klart nya testgames och testplayers i services-paketet som ska ge fler varianter av games som man kan testa med. Tidigare har det endast funnits games med ett hårdkodat antal(2 eller 3) spelare i.
- Formatterat filer och rensat onödiga beroenden.
- Bytt namn på hasNoPlayers-metoden till hasPlayers och även ändrat logiken i den för att passa namnet.
- Ändrat addPlayer-metoden så en spelare inte kan gå med i samma match flera gånger.
- Lade till en isFilled-metod i Game som kollar om en match har fyllt alla sina platser.
- Ändrat getJoinableGames-metoden så den kollar om en match är fylld med spelare.
- Skrivit i SDD och RAD.
- Skrivit JavaDoc.

Daniel & Carl-Johan:
- Flyttade på det statiska PadelBuddy-objektet från LoginActivity till MainActivity som tog bort beroendet mellan UI och Services paketen.

Fredrik: 
- Skrivit SDD. 
- Anpassat tester efter ändringar i kod. 

Carl-Johan: 
- Skrivit på SDD.

Marcus:
- Skapat test för getDateAsString()
- Lagt till en ny icon för fliken spel
- Lagt till all implementerad design i RAD och skrivit om dessa vyer
- Uppdaterat beskrivning av skissvyerna
- Beskrivit klassernas ansvarsområden i domänmodellen (RAD)

 
## Discussion items (35 min)
- Vad finns kvar att göra innan inläming. 

## Outcomes and assignments (5 min)
Vad finns kvar att göra innan inlämning:
- Kodbasen fin-fin-slipas på fredag.
- Dokumenten ska färdigställas.
- Förberedelse av presentation.

## Wrap up
Nu kör vi!
