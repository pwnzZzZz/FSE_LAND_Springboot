# FSE_LAND_Springboot

## Dependendy Injection in Spring Boot
Der Application Context erzeugt die Instanzen unserer Klassen.
Dieser wird 1x erzeugt und immer da wo mit @Autowired annotiert ist, die passende Instanz eingefügt. Die Klasse im Application Context nennt man BEAN.
Es muss nichts mit new() deklariert werden!

## Inversion of Control
Wir überlassen die Allokation von Klassen Instanzen iener dritten Partei (dem Spring Aplication Context).

### Weitere Vorteile der Dependendy Injection
* Weniger Abhängigkeiten (Entkopplung)
* Weniger Code
* Testen wird vereinfacht durch "Mocks" (Dummy-Klassen)

