package valenzuela.carlos.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FilmDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details)

        var bundle: Bundle? = intent.extras

        var title: String? = bundle!!.getString("title")
        var image: Int? = bundle!!.getInt("image")
        var header: Int? = bundle!!.getInt("header")
        var sinopsis: String? = bundle!!.getString("sinopsis")
        var availableSeats: Int? = bundle!!.getInt("seats")
        var id: Int = -1

        var descriptionTitle: TextView = findViewById(R.id.FilmNameDescription)
        var descriptionHeader: ImageView = findViewById(R.id.FilmImageDescription)
        var descriptionSinopsis: TextView = findViewById(R.id.FilmSinopsisDescription)
        var seatsLeft: TextView = findViewById(R.id.leftSeats)
        var buyTicketsButton: Button = findViewById(R.id.buyTickets)

        if (bundle != null) {
            descriptionTitle.text = (title)
            if (header != null) {
                descriptionHeader.setImageResource(header)
            }
            descriptionSinopsis.text = (sinopsis)
            seatsLeft.text = ("  $availableSeats")
        }



        if(availableSeats == 0){
            buyTicketsButton.isEnabled = false
        }else{
            buyTicketsButton.isEnabled = true
            buyTicketsButton.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)
                intent.putExtra("image", header)

                this.startActivity(intent)
            }
        }
    }
}