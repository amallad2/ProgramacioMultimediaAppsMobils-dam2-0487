# Pràctica de BlackJack

[Enunciat de la pràctica](BlackJackFase1y2.odt)

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