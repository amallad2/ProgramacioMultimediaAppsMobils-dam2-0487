# Pràctica: Joc de cartes "7 i mig"

Volem implementar un joc de cartes anomenat **«7 i mig»**.  
L'objectiu del joc és donar voltes a una sèrie de cartes fins a aconseguir el valor indicat.  

Les cartes les trobareu al fitxer [`cartes.zip`](https://github.com/amallad2/ProgramacioMultimediaAppsMobils-dam2-0487/tree/main/Joc7iMig) i són cartes de **5 valors diferents (de l'1 al 5)** i una carta **especial (amb el signe +)** que puntua com a **0.5**.

Els **pals** de les cartes els podrem simplificar per la inicial del seu color en anglès:  
`b = blue`, `y = yellow`, `g = green`, `r = red`, `p = purple`, `d = dragon`.

---

## 1. Disseny del Layout

Dibuixa un layout com el que es veu a la imatge següent:

![Exemple de layout](https://github.com/amallad2/ProgramacioMultimediaAppsMobils-dam2-0487/blob/main/Joc7iMig/layout.png?raw=true)

Les cartes les podem considerar com a **Buttons** o bé com a **ImageView**.

### Apunts

- Les cartes han d'ocupar **l'ample de la pantalla**, deixant un petit marge entre elles.  
- L'alçada de les cartes serà d'uns **130dp**.  
- Les lletres hauran d'estar **totes en majúscula**.  
- El **títol** de la part superior tindrà una mida de lletra més gran.

---

## 2. Funcionament

Cada cop que fem **clic sobre una de les cartes**, aquesta es **donarà la volta**, mostrant el seu valor i:

- **Sumarà +1** al número de cartes utilitzades.  
- **Incrementarà** el valor total de la puntuació de les cartes aixecades.

Si tornem a clicar la carta, **tornar-se a donar la volta**.

---

## 3. Annexes

Per realitzar la pràctica, necessitarem crear un nou objecte anomenat **`Carta`**, amb el codi següent (que haureu d’afegir al mateix directori on es troba el `Main.java`):

### `Carta.java`

```java
package com.example.mon.sumacartas;

/**
 * Created by mon on 13/10/15.
 */

public class Carta {
    // Atributs
    boolean visible;
    int valor;
    String pal = "";

    // Constructor
    public Carta(int v, String p) {
        valor = v;
        pal = p;
        visible = false;
    }

    // Getters i setters
    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
