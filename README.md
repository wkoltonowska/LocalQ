# LocalQ – Aplikacja Quiz

**LocalQ** to interaktywny quiz, który dostosowuje pytania do aktualnej lokalizacji użytkownika. Dzięki wykorzystaniu technologii GPS aplikacja prezentuje zagadnienia związane z województwem, w którym znajduje się użytkownik.  
Nazwa **LocalQ** łączy w sobie dwa kluczowe elementy – lokalność i quiz. Aplikacja została zaprojektowana z myślą o mieszkańcach różnych regionów, umożliwiając im sprawdzenie swojej wiedzy na temat najbliższego otoczenia w angażującej i edukacyjnej formie.

## Funkcje

- **Mapa Google** – wyświetlanie lokalizacji użytkownika  
- **Quiz** – zestaw pytań z wieloma odpowiedziami  
- **Interaktywność** – dynamiczne sprawdzanie odpowiedzi i podsumowanie wyników  
- **Nawigacja** – przechodzenie między ekranami aplikacji  

## Struktura projektu

### Główne pliki Kotlin

- **MainActivity.kt** – inicjalizacja aplikacji i obsługa uprawnień mapy  
- **Start.kt** – ekran startowy aplikacji  
- **Maps.kt** – obsługa mapy Google i lokalizacji użytkownika  
- **QuestionsPzn.kt** – logika quizu, wyświetlanie pytań i sprawdzanie odpowiedzi  
- **End.kt** – ekran podsumowania quizu  

### Manifest Androida

- **AndroidManifest.xml** – deklaracja uprawnień do lokalizacji i konfiguracja aplikacji  

## Instalacja i uruchomienie

1. Sklonuj repozytorium:
   ```sh
   git clone https://github.com/twoj-repo/localq.git
2. Otwórz projekt w Android Studio

3. Dodaj klucz API dla Map Google

4. W pliku AndroidManifest.xml, znajdź:
```
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="TWÓJ_KLUCZ_API" />
```
    
5. Wpisz swój klucz API zamiast "TWÓJ_KLUCZ_API".

6. Uruchom aplikację na emulatorze lub urządzeniu z Androidem.

7. Wymagania

- Android 6.0+
- Klucz API Google Maps
- Uprawnienia do lokalizacji

