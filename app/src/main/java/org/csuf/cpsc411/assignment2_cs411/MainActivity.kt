package org.csuf.cpsc411.assignment2_cs411

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //refresh the screen
    fun refreshScreen(message : String){
        var titleView : EditText = findViewById(R.id.claim_name)
        var dateView : EditText = findViewById(R.id.date_name)
        var StatusView : TextView = findViewById(R.id.status_message)

        //Clear the title and date text on the edit view
        titleView.getText().clear()
        dateView.getText().clear()

        //Display the status
        StatusView.setText(message)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)

        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{
            var titleView : EditText = findViewById(R.id.claim_name)
            var dateView : EditText = findViewById(R.id.date_name)

            var titleInput = titleView.text.toString()
            var dateInput = dateView.text.toString()

            //Create claim object
            var cObj = Claim(title = titleInput, date = dateInput)

            //add the Claim input object into the Database
            var Service = ClaimService(this)
            Service.addClaim(cObj)

            var message : String

            message = if(Service.success){
                "Claim (${cObj.title}) successfully created."
            }
            else{
                "Claim (${cObj.title}) failed to be created."
            }
            refreshScreen(message)
        }
    }
}