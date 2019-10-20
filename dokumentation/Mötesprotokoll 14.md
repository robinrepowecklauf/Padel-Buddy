# Meeting Agenda
Group: Padel Buddy  
Date: 20/10-19 12:00-13:00  
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
 
## Discussion items (35 min)

## Outcomes and assignments (5 min)

## Wrap up
- Nästa möte: Måndag 21/10 08:00-09:00.
