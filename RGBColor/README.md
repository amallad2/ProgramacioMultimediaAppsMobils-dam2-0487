# RGB Color amb SeekBar

# layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:text="RGB Color"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:textStyle="bold"
            android:layout_marginBottom="16dp" />

        <SeekBar
            android:id="@+id/seekBarRed"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:max="255"
            android:progress="0" />


        <TextView
            android:id="@+id/tvcolor"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:layout_gravity="center"
            android:text=""
            android:textSize="40sp" />



    </LinearLayout>
</ScrollView>

```


### Code Activity

```kotlin
   package org.proven.formularis

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.proven.formularis.ui.theme.FormularisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_layout)
        val seekBarRed = findViewById<SeekBar>(R.id.seekBarRed)
        val tvValue = findViewById<TextView>(R.id.tvcolor)
        seekBarRed.max=255
        seekBarRed.progress=0
        tvValue.setBackgroundColor(Color.rgb(0, 0, 0))


        // Escoltem els canvis del SeekBar
        seekBarRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvValue.text = "Valor: $progress"
                tvValue.setBackgroundColor(Color.rgb(progress, 0, 0))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Opcional: pots mostrar algun missatge
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Opcional: pots fer alguna acció quan l’usuari deixa anar el dit
            }
        })


    }
}
```