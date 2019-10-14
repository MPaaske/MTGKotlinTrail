package com.fotl.development.mtgkotlintrail.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.fotl.development.mtgkotlintrail.Model.Player
import com.fotl.development.mtgkotlintrail.Model.PlayerJ
import com.fotl.development.mtgkotlintrail.R

class PlayerLayout4Activity : AppCompatActivity() {

    // Members / Fields
    private var fm: FragmentManager? = null
    private var cmdL: CmdLayer? = null
    private var ft: FragmentTransaction? = null

    // Var vs Val declaration:
    // Var is known as a mutable variable
    // Val is like Final
    private var tw_p1: TextView? = null
    private var tw_p2: TextView? = null
    private var tw_p3: TextView? = null
    private var tw_p4: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_layout4)

        fm = supportFragmentManager
        cmdL = CmdLayer()       // Kotlin --- Class initialization


        ft = fm!!.beginTransaction()
        ft!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft!!.add(android.R.id.content, cmdL!!).commit()


        // Java vs Kotlin --- PlayerJ pj1 = new PlayerJ("P1", 30, 0, 0);
        val pj1 = PlayerJ("P1", 30, 0, 0)
        val pj2 = PlayerJ("P2", 30, 0, 0)
        val pj3 = Player("P3", 30, 0, 0)
        val pj4 = Player("P4", 30, 0, 0)


        // The !! operator is used for Null safety, when some data is inconsistent with regard to initialization
        tw_p1 = findViewById(R.id.p1_lifeTotal)
        tw_p1!!.text = pj1._lifeTotal.toString()

        tw_p2 = findViewById(R.id.p2_lifeTotal)
        tw_p2!!.text = pj2._lifeTotal.toString()

        tw_p3 = findViewById(R.id.p3_lifeTotal)
        tw_p3!!.text = pj3._lifeTotal.toString()

        tw_p4 = findViewById(R.id.p4_lifeTotal)
        tw_p4!!.text = pj4._lifeTotal.toString()
    }

    fun clickedFrag(view: View){

        var liTl_Id: String = view.getTag().toString().substring(view.getTag().toString().length - 1)
        var v_Id = 0

        // Kotlin Switch
        // Determine the ID of the clicked players LifeTotal
        when(liTl_Id){
            "1" -> v_Id = tw_p1!!.id
            "2" -> v_Id = tw_p2!!.id
            "3" -> v_Id = tw_p3!!.id
            "4" -> v_Id = tw_p4!!.id
        }

        // Call Fragment method and pass the Clicked Fragment UI-Element along with the Int id of the underlying player
        cmdL!!.changeLife(view.getTag().toString(), v_Id)
    }
}
