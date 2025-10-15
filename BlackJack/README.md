# Pràctica de BlackJack

[Enunciat de la pràctica](BlackJackFase1y2.odt)

## Regles del joc

L’objectiu principal del BlakcJack és sumar 21 punts o el més a prop possible amb les cartes, sense passar-se. Cada jugador compiteix només contra el crupier, tractant de tindre una ma millor que la seva.
•	Les cartes del 2 al 10 tenen el seu valor nominal
•	L’As pot tindre el valor d’ 1 o 11
•	Les figures (J, Q, K) valen 10

Al principi de cada ma es reparteixen dues cartes pel jugador i pel crupier. De les cartes del crupier només es veurà el valor de la primera i la segona estara cap per avall.

El torn sempre comença pel jugador, que demanarà cartes d’una en una  fins a que es planti o arribi a 21. Si el jugador es passa perd la ma directament sense necessitat que jugui el crupier.

Un cop el jugador acaba (es planta, arriba a 21 o es passa) serà el torn del crupier, que sempre juga de la mateixa forma:
•	demanarà cartes sempre que la seva ma sumi 16 o menys.
 
El jugador decidirà la quantitat a apostar abans de començar la ma.
•	Si el jugador guanya (té mes punts que el crupier) guanyarà la quantitat apostada.
•	Si empaten es retornen els diners
•	Si el jugador aconsegueix BlackJack (21 amb només dues cartes, és a dir una figura i un As) guanyarà la quantitat apostada multiplicada per 1,5.



### Merge Images Kotlin

```kotlin
    private fun imatgeCard() {
       val bmFrontCard = BitmapFactory.decodeResource(resources, R.drawable.front)
       val bmDiamond = BitmapFactory.decodeResource(resources, R.drawable.spades)

       var mergedImages = combineImages(bmFrontCard, bmDiamond, bmFrontCard.width / 4, bmFrontCard.height / 2 - 250)
       ivCard.setImageBitmap(mergedImages)

    }

    fun combineImages(backgroundImage: Bitmap, frontImage: Bitmap, left: Int, top: Int): Bitmap {
        val config = backgroundImage.config ?: Bitmap.Config.ARGB_8888 // Provide a default
        val overlay = Bitmap.createBitmap(backgroundImage.width, backgroundImage.height, config)
        val canvas = Canvas(overlay)
        canvas.drawBitmap(backgroundImage, Matrix(), null)
        canvas.drawBitmap(frontImage, left.toFloat(), top.toFloat(), null)
        return overlay
    }
```

### Add Elements to Layout

Afegim elements a un layout.

```kotlin
fun addElementLayout() {
        val imRef: ImageView = findViewById(R.id.ivref)  // Imatge de referència per agafar els paràmetres
        val iv = ImageView(this)
        // Ús de la sintaxi de propietats per a 'layoutParams'.
        iv.layoutParams = imRef.layoutParams // Equivalent a iv.setLayoutParams(imCard.getLayoutParams())
        iv.setImageResource(R.drawable.image)
        val l: LinearLayout = findViewById(R.id.layoutsecondary) // Instanciem el layout on volem afegir la imatge o element
        l.addView(iv, iv.layoutParams)  // add iv to layoutsecondary
    }
```