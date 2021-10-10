package valenzuela.carlos.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startButton: Button = findViewById(R.id.buttonStart)

        startButton.setOnClickListener{
            var intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
        }
    }
}