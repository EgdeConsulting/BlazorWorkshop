# Egde - Blazor Workshop @ UiA 02.09-03.09
Først og fremst, velkommen til Egdes Blazor Workshop. Det fiktive biblioteket "Egdes Library 4 Dummies" ønsker seg et 
brukergrensesnitt for utlån av bøker. Ett annet firma har allerede laget ett API som håndterer innlevering og utlevering av bøker.
Din jobb vil være å lage ett brukergrensesnitt som gir bibliotekaren et verktøy til sin daglige jobb.

Har du spørsmål, rekk bare opp hånden og vi vil hjelpe deg så fort vi kan! :)

### Forutsetninger
For å kunne kjøre applikasjonen, krever det at du har docker installert.
For mer info se: https://docs.docker.com/docker-for-windows/install/

### Oppstart av applikasjonen
Når/hvis docker er installert, kan du starte applikasjonen ved å gå inn i et terminal vindu (eks. git bash) og skrive
følgende kommando:
```bash
$ docker run -p 8000:8080 egder/blazorworkshop
```

Verifiser at applikasjonen har startet opp ved å gå inn på `localhost:8000` i din nettleser, dersom du får en
Whitelabel Error Page, vil det si at du når API'et, men ikke får noe svar på endepunktet. Med andre ord, applikasjonen
kjører, og er klar til bruk.

### Endepunkter
Nå som applikasjonen, altså API'et, kjører så kommer denne med dokumentasjon om hvilke endepunkter vi kan bruke for å
hente informasjon eller oppdatere bøkene i biblioteket. 
<br />
<br />
Dokumentasjonen på hvilke restkall du kan gjøre finner du ved å gå til endepunktet `localhost:8000/swagger-ui.html`
i din nettleser når du har applikasjonen kjørende.
